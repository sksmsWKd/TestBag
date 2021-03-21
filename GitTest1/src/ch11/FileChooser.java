package ch11;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;


public class FileChooser extends JFrame implements ActionListener{

	private JButton openbtn,savebtn;
	JFileChooser fileChooser;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==openbtn) {
			int returnVal = fileChooser.showOpenDialog(this);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				System.out.println("openfile :" + file.getAbsolutePath());
			}else {
				System.out.println("no file selected");
				}
		
			}else if(e.getSource()==savebtn) {
				int returnVal = fileChooser.showOpenDialog(this);
				if(returnVal ==JFileChooser.APPROVE_OPTION);
				File file = fileChooser.getSelectedFile();
				System.out.println("savefile :" + file.getAbsolutePath());
				System.out.println("save canceled");
		}
	}
	public FileChooser() {
		fileChooser =new JFileChooser();
		
		JPanel panel= new JPanel();
		
		
		panel.add(fileChooser);
		
		openbtn = new JButton("파일 오픈");
		savebtn = new JButton("파일 저장");
		
		panel.add(openbtn);
		openbtn.addActionListener(this);
		savebtn.addActionListener(this);
		panel.add(savebtn);
		this.add(panel);
		
		
		this.setSize(500,500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[]args) {
		new FileChooser();
	}
}
