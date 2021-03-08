package ch11;
import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
public class ColorChooserTest extends JFrame implements ChangeListener,ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==selectButton) {
			selectButton.setText("색상선택하세요.");
		}
	}

	private JColorChooser colorchooser = new JColorChooser();
	private MyDrawingColorPanel MyDrawingColorPanel = new MyDrawingColorPanel();
	private JButton selectButton = new JButton("색상선택완료");
	
	public ColorChooserTest(){
		this.setTitle("테스트");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		colorchooser.getSelectionModel().addChangeListener(this);
		JPanel panel = new JPanel();
		panel.add(colorchooser);
		
		this.add(panel);
		this.setVisible(true);
		this.setSize(500,500);
		this.add(selectButton,BorderLayout.SOUTH);
	
		this.pack();
		this.setVisible(true);
		
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		System.out.println(colorchooser.getColor());
	}
	
	public static void main(String []args) {
		new ColorChooserTest();
	}
	
	class MyDrawingColorPanel extends JPanel implements MouseMotionListener{

		@Override
		public void mouseDragged(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean mouseDown(Event evt, int x, int y) {
			// TODO Auto-generated method stub
			return super.mouseDown(evt, x, y);
		}

		@Override
		public boolean mouseDrag(Event evt, int x, int y) {
			// TODO Auto-generated method stub
			return super.mouseDrag(evt, x, y);
		}

		@Override
		public boolean mouseEnter(Event evt, int x, int y) {
			// TODO Auto-generated method stub
			return super.mouseEnter(evt, x, y);
		}

		@Override
		public boolean mouseExit(Event evt, int x, int y) {
			// TODO Auto-generated method stub
			return super.mouseExit(evt, x, y);
		}

		@Override
		public boolean mouseMove(Event evt, int x, int y) {
			// TODO Auto-generated method stub
			return super.mouseMove(evt, x, y);
		}

		@Override
		public boolean mouseUp(Event evt, int x, int y) {
			// TODO Auto-generated method stub
			return super.mouseUp(evt, x, y);
		}
		
	}
	
}
