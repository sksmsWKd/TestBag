package ch11;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.io.*;

public class ImagePuzzel extends JFrame implements ActionListener {

	private int pieces = 4;
	private int totalPieces = pieces * pieces;
	private BufferedImage img;
	private ArrayList<Integer> pieceNums =new ArrayList<>();

	
	public ImagePuzzel() {
		this.setTitle("Puzzel Game");
		try {
			img = ImageIO.read(new File("galaxy.jpg"));
		}catch(IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		//shuffle();
		for (int i= 0; i < totalPieces; i++) {
			pieceNums.add(i);
			
		
		this.add(new ImagePanel(),BorderLayout.CENTER);
		JButton divideBtn = new JButton("IMG DEVIDE");
		this.add(divideBtn, BorderLayout.SOUTH);
		
		divideBtn.addActionListener(this);
		this.setSize(img.getWidth(),img.getHeight()+30);
		}
	}
	private void shuffle() {
		for (int i= 0; i < totalPieces; i++) {
			pieceNums.add(i);
			
			Collections.shuffle(pieceNums);
			//¼¯¾îÁÜ
			
			System.out.println(pieceNums);
		}
	}
	class ImagePanel extends JPanel{
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int pieceWidth = img.getWidth() / pieces;
		int pieceHeight = img.getHeight() / pieces;
		int idx=0;
		for(int x=0; x < pieces ; x++) {
			for (int y=0; y<pieces ; y++) {
				int sx = pieceNums.get(idx);
				int dx= x* pieceWidth;
				int dy= y* pieceHeight;
			}
		}
		
	}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
public static void main(String[]args) {
	new ImagePuzzel();
}
	
}
