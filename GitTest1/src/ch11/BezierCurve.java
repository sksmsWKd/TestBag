package ch11;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.GeneralPath;

public class BezierCurve extends JPanel implements MouseListener,MouseMotionListener{
	
	JFrame frame;
	private int[]xs ={50,150,400,450};
	private int[]ys ={200,50,300,200};
	
	private int drageIndex  =-1;

	@Override
	public void mouseMoved(MouseEvent e) {}
	
	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}
	
	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		drageIndex  = -1;
		e.getX();
		e.getY();
		for(int i =0 ; i<4; i++) {
			Rectangle rect  = new Rectangle(xs[i]-4,ys[i]-4,20,20);
			
			if(rect.contains(e.getX(),e.getY())) {
				drageIndex = i;
				
		
				
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		drageIndex=-1;
		frame.repaint();  //놓을때 frame을 repaint합니다.
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if(drageIndex != -1) {
			xs[drageIndex]  =e.getX();
			ys[drageIndex]	=e.getY();
			
			
		}	
	
	}

	
	@Override
	public void paintComponent(Graphics g) {
		
		
		g.setColor(Color.blue);
		g.fillRect(xs[0], ys[0], 16, 16);
		g.fillRect(xs[2], ys[2], 16, 16);
		
		g.setColor(Color.red);

		g.fillRect(xs[1], ys[1], 16, 16);
		g.fillRect(xs[3], ys[3], 16, 16);
		
		Graphics2D gp2 = (Graphics2D)g;
		gp2.setColor(Color.black);
		GeneralPath path= new GeneralPath();
		path.moveTo(xs[0], ys[0]);
		path.curveTo(xs[1], ys[1], xs[2], ys[2], xs[3], ys[3]);
		gp2.draw(path);
		
	}

	
	
	public BezierCurve(){
		frame = new JFrame();
		frame.add(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		frame.repaint();
		frame.setSize(600,600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
		
	
	}

public static void main (String[]args) {
	new BezierCurve();
}
}
//mouse adapter class
//markdown cheat sheet
