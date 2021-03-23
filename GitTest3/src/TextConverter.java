

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.util.*;

public class TextConverter extends JFrame implements ActionListener{

	private JButton convertBtn;
	private JButton cancelBtn;
	private JTextArea textIn;
	private JTextArea textOut;
		private final String CLIENT_ID= "";
	private final String CLIENT_SECRET= "";
	private ButtonGroup bg1 ;
	private JRadioButton eng ;
	private JRadioButton kor ;
	private JRadioButton jp ;
	private ButtonGroup bg2 ;
	private JRadioButton eng1; 
	private JRadioButton kor1 ;
	private JRadioButton jp1;
   private String input;
   private String output;
   private JButton clearBtn;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// 변환 버튼이 클릭되었다면 좌측 텍스트에리어의 텍스트를 읽어서 영어로 ㅂ꾸고, 그 변환된결과를 오른쪽에..
		//취소누르면 왼쪽을 빈칸으로
		if (e.getSource()==convertBtn) {
			String str = textIn.getText();
			String convertResult=toEnglish(str);
			textOut.setText(convertResult);
		}else if(e.getSource()==cancelBtn) {
			textIn.setText("");
			textOut.setText("");
		}
		
		if(eng.isSelected()) {
			input="en";
		}else if(kor.isSelected()) {
			input="ko";
		}else if(jp.isSelected()) {
			input="ja";
		}
		if(eng1.isSelected()) {
			output="en";
		}else if(kor1.isSelected()) {
			output="ko";
		}else if(jp1.isSelected()) {
			output="ja";
		}
		
		
	}
	
	private String toEnglish(String korean) {
		//korean 문자열을 영어로 변환해서 반환..
		//텍스트 -text
		//영어 -english
		
		String result = korean;
		  String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
	        String text;
	        try {
	            text = URLEncoder.encode(korean, "UTF-8");
	        } catch (UnsupportedEncodingException e) {
	            throw new RuntimeException("인코딩 실패", e);
	        }

	        Map<String, String> requestHeaders = new HashMap<>();
	        requestHeaders.put("X-Naver-Client-Id",CLIENT_ID);
	        requestHeaders.put("X-Naver-Client-Secret",CLIENT_SECRET);

	       result = post(apiURL, requestHeaders, text);
	       System.out.println(result);
	       result = result.substring(result.indexOf("translatedText")+"translatedText".length()+3, result.indexOf("engineType")-3);
	      
	        return result;

	    }

//		result = korean.replace("텍스트", "text");
//		result =result.replace("영어", "english");
//		result =result.replace("예아", "yeah");
		//return result; // 항상 메소드를 쓸떄 주의할점은 원본이 바뀌늦지? 아님 카피본을 리턴해주는지?
		
		
		//String [] result2 = new String[4] ;
		
		 //String[] result2 = {"가","나","다,","라","마"};
	//}
	
	public TextConverter() {
		this.setTitle("텍스트변환");
		textIn = new JTextArea(10,14);
		textOut = new JTextArea(10,14);
		textIn.setLineWrap(true);
		textOut.setLineWrap(true);
		textOut.setEditable(false);
		
		JPanel textAreaPanel = new JPanel(new GridLayout(1,2,20,20));
		textAreaPanel.add(textIn);
		textAreaPanel.add(textOut);
		
		convertBtn = new JButton("변환");
		cancelBtn = new JButton("취소");
		convertBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		
		JPanel btnPanel = new JPanel();
		btnPanel.add(convertBtn);
		btnPanel.add(cancelBtn);
		
		 bg1 = new ButtonGroup();
		 eng = new JRadioButton("영어");
		 kor = new JRadioButton("한글");
		 jp = new JRadioButton("일본어             //");
		 bg2 = new ButtonGroup();
		 eng1 = new JRadioButton("영어");
		 kor1 = new JRadioButton("한글");
		 jp1 = new JRadioButton("일본어");
		
		bg1.add(eng);
		bg1.add(kor);
		bg1.add(jp);
		bg2.add(eng1);
		bg2.add(kor1);
		bg2.add(jp1);
		JLabel lb1 = new JLabel("입력언어");
		btnPanel.add(lb1);
		btnPanel.add(eng);
		btnPanel.add(kor);
		btnPanel.add(jp);
		eng.addActionListener(this);
		kor.addActionListener(this);
		jp.addActionListener(this);
		JLabel lb2 = new JLabel("출력언어");
		btnPanel.add(lb2);
		btnPanel.add(eng1);
		btnPanel.add(kor1);
		btnPanel.add(jp1);
		eng1.addActionListener(this);
		kor1.addActionListener(this);
		jp1.addActionListener(this);
		
		
		JPanel mainPanel = new JPanel (new BorderLayout(10,10));
		mainPanel.add(textAreaPanel,BorderLayout.CENTER);
		mainPanel.add(btnPanel, BorderLayout.SOUTH);
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
		this.add(mainPanel);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
		
	}

    private String post(String apiUrl, Map<String, String> requestHeaders, String text){
        HttpURLConnection con = connect(apiUrl);
        String postParams = "source="+input+"&target="+output+"&text=" + text; //원본언어: 한국어 (ko) -> 목적언어: 영어 (en)
       
        try {
            con.setRequestMethod("POST");
            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }

            con.setDoOutput(true);
            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                wr.write(postParams.getBytes());
                wr.flush();
            }

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 응답
                return readBody(con.getInputStream());
            } else {  // 에러 응답
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {System.out.println(postParams);
            con.disconnect();
        }
        
    }

    private static HttpURLConnection connect(String apiUrl){
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection)url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }

    private static String readBody(InputStream body){
        InputStreamReader streamReader = new InputStreamReader(body);

        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();

            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }

            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
        }
    }

	public static void main(String[]args) {
		new TextConverter();
	}

}
