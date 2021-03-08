package SlimeGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.sound.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.*;
import  sun.audio.*;  
import  java.io.*;


public class SlimeGui extends JFrame implements ActionListener{
	
		public static JTextField fullness;
		public static JTextField sleepness;
		public static JTextField cleanness;
		 Image bg =new ImageIcon(SlimeGui.class.getResource("bg.jpg")).getImage();
		 Image slime =new ImageIcon(SlimeGui.class.getResource("slime.png")).getImage();
		 Image king =new ImageIcon(SlimeGui.class.getResource("king.png")).getImage();
		 Image die =new ImageIcon(SlimeGui.class.getResource("die.png")).getImage();
		 Image pig =new ImageIcon(SlimeGui.class.getResource("pig.png")).getImage();
		public JButton btn1;
		public JButton btn2;
		public JButton btn3;
		public JButton btn4;
		public static int full = 0;
		public static int sleep = 0;
		public static int clean = 0;
		public int kingNum =1 ; 
		public 	 File bella = new File("bella.wav");
		public JMenuBar mb; 
		public JMenu m1 ; 
		public JMenu m2; 
	
	
		public JMenuItem i1;
		public JMenuItem i2;
		public JMenuItem i3;
		public static boolean ifWaterCatch =false;
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==i1) {
				System.out.println("This is the menu item 1.");
				SlimeGui. full=0;
				SlimeGui. sleep=0;
				SlimeGui. clean=0;
				 
				SlimeGui. fullness.setText("포만감 : 0");
				 SlimeGui. sleepness.setText("컨디션 : 0");
				 SlimeGui. cleanness.setText("청결도 : 0");
				 repaint();
			 }
			
			if(e.getSource()==btn1) {
				new Feed();
			}
			if(e.getSource()==btn2) {
				new Sleep();
			} if(e.getSource()==btn3) {
				new Wash();
			}
			 if(e.getSource()==btn4) 
				 
			{
				kingNum =1 ; 
				
				 if((SlimeGui.full >1)&& (SlimeGui.sleep >1)&&(SlimeGui.clean>1)==true) { 
					
					kingNum= kingNum+1;
						
					
				repaint();
				JOptionPane.showMessageDialog(null, "슬라임은 킹슬라임이 되었습니다!");
				
				repaint();
				}
				 else if((SlimeGui.full<=0)&&(SlimeGui.sleep<=0)&&(SlimeGui.clean<=0)==true) {
				
						kingNum= kingNum+2;
						
					repaint();
					JOptionPane.showMessageDialog(null, "안타깝지만 슬라임이 죽었습니다 ");
				
					repaint();
					
				}
				 else  if((SlimeGui.full>=20)&&(SlimeGui.sleep==0)&&(SlimeGui.clean==0)==true) {
						kingNum= kingNum+3;
						
					repaint();
					JOptionPane.showMessageDialog(null, "먹기만 하면 돼지가 됩니다.");
				
					repaint();
				}
				 else { repaint(); }
				
			}
			
			 
			 
		}
				
	
		public void paint(Graphics g) {
			g.drawImage(bg, 0, 0, null);
		
				
			
			g.drawImage(slime,120,120,150+(Feed.full*3), 150+(Feed.full*3) ,null);
		 
			
				if(kingNum ==2) {
						g.drawImage(king, 20, 20, 450, 450 , null);

						
				}
				if(kingNum== 3) {
					g.drawImage(die,0,0,650,650,null);{
					
						
					}
				}
				if(kingNum==4) {
					g.drawImage(pig,20,20,450,450,null);
				}
					
	}
		
		
		public static void Count1() {
			fullness.setText("포만감 : "+full);
			
		}
		
		



		public SlimeGui() {
		
	
			 
			 mb = new JMenuBar(); 
			 m1 = new JMenu("HELP"); 
			 m2 = new JMenu("INFO"); 
			
		
			 i1=new JMenuItem("RESET");
			 i2=new JMenuItem("TIP");
			 i3=new JMenuItem("TIP");
			mb.add(m1);
			mb.add(m2);
			m1.add(i1);
			m1.add(i2);
			m2.add(i3);
			i1.addActionListener(this);
			this.setJMenuBar(mb);
			mb.setVisible(true);
		JPanel panel=new JPanel();
		panel.setLayout(null);
		this.add(panel);

		
		
	
		
		this.setTitle("슬라임 키우기");
		this.setSize(600,600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		
		
		fullness = new JTextField("포만감 :");
		panel.add(fullness);
		fullness.setBounds(120, 30, 70, 30);
		Feed.full=SlimeGui.full;
		fullness.setText("포만감 :"+SlimeGui.full);
		
		sleepness = new JTextField("컨디션 :");
		panel.add(sleepness);
		sleepness.setBounds(200, 30, 70, 30);
		sleepness.setText("컨디션 :"+SlimeGui.sleep);
		
		cleanness = new JTextField("청결도 :");
		panel.add(cleanness);
		cleanness.setBounds(280, 30, 70, 30);
		cleanness.setText("청결도 :"+SlimeGui.clean);

		
		
		btn1 = new JButton("밥주기");
		panel.add(btn1);
		btn1.setBounds(20, 440, 80, 80);
		btn1.addActionListener(this);
	
		
		
		 btn2 = new JButton("잠자기");
		panel.add(btn2);
		btn2.setBounds(120, 440, 80, 80);
		btn2.addActionListener(this);
		
		 btn3 = new JButton("씻기");
		panel.add(btn3);
		btn3.setBounds(220, 440, 80, 80);
		btn3.addActionListener(this);
		
		btn4 = new JButton("갱신");
		panel.add(btn4);
		btn4.setBounds(320, 440, 80, 80);
		btn4.addActionListener(this);
		
	
		Sound();

}
		


	public static void Sound() {
			try {
				 File bella = new File("bella.wav");
				 
		        
		            Clip clip = AudioSystem.getClip();
		            
		            clip.open(AudioSystem.getAudioInputStream(bella)); 
		             clip.loop(Clip.LOOP_CONTINUOUSLY);
		             clip.start();

		       
			}
		catch(Exception ex) {			System.out.println("음악재생 에러");
		}
		}


		
		
		
		
		
	public static void main (String []args) {
		new SlimeGui();
		
	}

}
class Feed extends JDialog implements ActionListener{
public static int full=0;


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 if(e.getSource()==meatBtn) {
			 Feed.full++;
			 SlimeGui.full++;
			 fullness.setText("포만감 :"+full);
			 SlimeGui.Count1();
			 repaint();
			 
			 
		 }else {
			 System.out.println();
		 }
	}

	public static JTextField fullness;
	Image slime =new ImageIcon(Feed.class.getResource("slime.png")).getImage();
	 Image dinningRoom =new ImageIcon(SlimeGui.class.getResource("dinningRoom.png")).getImage();
	 Image meat =new ImageIcon(SlimeGui.class.getResource("meat.png")).getImage();
	 JButton meatBtn = new JButton("고기주기1번");
	 int imgX = 200;
	 int imgY = 200;
	 
	 JLabel l1 = new JLabel();
	 
	 
	Feed() {
		try {
			meat = ImageIO.read(new File("meat.png"));
		}catch (IOException e) {
			
			
		}
		
		
		
		
        setTitle("밥주기");  
        JPanel feed = new JPanel();
        this.add(feed); 
        
        setLayout(null);      
        setSize(450,450);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        
       
        meatBtn = new JButton("고기주기1번");
            meatBtn.setBounds(150, 300, 180, 30);
        meatBtn.addActionListener(this);
        this.add(meatBtn);
        

		fullness = new JTextField("포만감 :");
		this.add(fullness);
		fullness.setBounds(120, 30, 80, 40);
		fullness.setText("포만감 :"+full);
        
    }
	
	
	
	public void paint(Graphics g) {
	
		
		g.drawImage(dinningRoom, 0, 0, 450, 450, null);
		g.drawImage(slime,100,100,150+(full*2), 150+(full*2) ,null);
		g.drawImage(meat,imgX,imgY,200-(full*2),200-(full*2),null);
		
}

	
}
 

class Sleep extends JFrame implements ActionListener{
	 Image slime =new ImageIcon(SlimeGui.class.getResource("slime.png")).getImage();
	 Image bedroom =new ImageIcon(SlimeGui.class.getResource("bedroom.png")).getImage();
	
	JButton sleepBtn1 = new JButton();
	JButton sleepBtn2 = new JButton();
	JTextField sleepLabel1;
	JTextField sleepLabel2;
	public static int sleep = 0 ;
	 
	Timer timer = new Timer(1000, this);
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 timer.start();
		 sleepLabel1.setText((sleep++)/4 + "초 동안 자고있습니다");
		 sleepLabel2.setText("컨디션 : "+ (sleep++)/4);
		 SlimeGui.sleepness.setText("컨디션 : "+ ((sleep++)/4));
		 SlimeGui.sleep+=1;
		 Sleep.sleep+=1;
     if(e.getSource()==sleepBtn2) {
    	 timer.stop();
     }
		
	}

	Sleep() {
        setTitle("잠자기");
        
        JPanel sleep = new JPanel();   
        setLayout(null);
        setSize(500,500);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        
        
        sleepBtn1 = new JButton("잠자기 시작 버튼");
        sleepBtn1.addActionListener(this);
        this.add(sleepBtn1);
        sleepBtn1.setBounds(200, 280, 200, 30);
        
        sleepBtn2 = new JButton("잠자기 멈춤 버튼");
        sleepBtn2.addActionListener(this);
        this.add(sleepBtn2);
        sleepBtn2.setBounds(200, 310, 200, 30);
        
        sleepLabel1 = new JTextField();
        this.add(sleepLabel1);
        sleepLabel1.setBounds(200, 350, 150, 30);
        sleepLabel1.setText( " 0 초 동안 자고있습니다");
        
        sleepLabel2 = new JTextField();
        this.add(sleepLabel2);
        sleepLabel2.setBounds(200,400, 150, 30);
        sleepLabel2.setText("컨디션 :");
       
        
        
    }
	public void paint(Graphics g) {
	
		
		g.drawImage(bedroom, 0, 0, 500, 500, null);
		g.drawImage(slime, 120, 160 ,null);
		
}
	
	
}
class Wash extends JFrame implements KeyListener,ActionListener{
	
	public static int clean;
	
	 @Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			 ImgAx = ImgAx +1;
			 //System.out.println(ImgAx);
			 repaint();
			 if(ImgAx==ImgBx) {
		        	JOptionPane.showMessageDialog(null, "X좌표가 같아짐");
		        }
		        
		}
		else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			 ImgAx = ImgAx -1;
			// System.out.println(ImgAx);
			 repaint();
			 if(ImgAx==ImgBx) {
		        	JOptionPane.showMessageDialog(null, "X좌표가 같아짐");
		        }
		        
		}
		else if(e.getKeyCode()==KeyEvent.VK_UP) {
			 ImgAy = ImgAy -1;
			//.out.println(ImgAy);
			 repaint();
		}
		else if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			 ImgAy = ImgAy+1 ;
			 System.out.println(ImgAx+ " ." + ImgAy +". "+ImgBx +" ."+ImgBy );
			 repaint();
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	Image slime =new ImageIcon(SlimeGui.class.getResource("slime.png")).getImage();
	 Image wash =new ImageIcon(SlimeGui.class.getResource("wash.png")).getImage();
	 Image water =new ImageIcon(SlimeGui.class.getResource("water.png")).getImage();
	 int ImgAx = (int)(Math.random()*100)*2;
	 int ImgAy = (int)(Math.random()*100)*2;
	 int ImgBx = (int)(Math.random()*150)*2;
	 int ImgBy =  (int)(Math.random()*150)*2;
	 int ImgBax = (int)(Math.random()*150)*2;
	 int ImgBay =  (int)(Math.random()*150)*2;
	
	 
	Wash() {
        setTitle("씻기");
  
        
        JPanel wash = new JPanel();
        JButton washBtn1 = new JButton("물켜기");
   
        	this.setLayout(null);
       
        wash.add(washBtn1);        
        setSize(450,450);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        addKeyListener(this);
        this.addKeyListener(this);
        
        
    }

public void paint(Graphics g) {
	
	
		g.drawImage(wash, 0, 0, 450, 450, null);
		g.drawImage(water,  ImgBx, ImgBy ,100,100, null);
		g.drawImage(slime, ImgAx, ImgAy,100,100,null);
	
		
		for(int i=0; i<999 ; i++) {
		if((ImgAx==ImgBx&&ImgAy==ImgBy)&&SlimeGui.ifWaterCatch==false) {
			int alpha=0;
			 SlimeGui.ifWaterCatch= true;
			ImgBx =ImgBx*((int)(Math.random()*10)/10);
			ImgAy	=ImgAy*((int)(Math.random()*10)/10);
			 SlimeGui.clean+=10;
				Wash.clean+=10;
				SlimeGui.cleanness.setText("청결도 :"+clean);
				
			int ImgBax = (int)(Math.random()*100)*2;
			 int ImgBay =  (int)(Math.random()*100)*2;
		
			 
			 JOptionPane.showMessageDialog(null, "씻기 성공!");
			
			 
				alpha++;
			 
			
			 if(SlimeGui.ifWaterCatch==true){
				 ImgBax = (int)(Math.random()*100)*4;
				  ImgBay =  (int)(Math.random()*100)*4;
				 SlimeGui.ifWaterCatch= false;
				 g.drawImage(water,  (ImgBax*(int)(Math.random()+1*100)), (ImgBay*(int)(Math.random()+1*100)) ,100,100, null);
				 alpha++;
				 if((SlimeGui.clean>=20)&&(alpha==2)) {
					 JOptionPane.showMessageDialog(null, "너무 많이 씻어도 몸에 안좋습니다!");
					 alpha=0;
					 dispose();
				 }
				 
			 }
			 
			 }
		}
}	 
			// 
		
		
			
		}
		

	


