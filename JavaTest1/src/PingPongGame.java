

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;
public class PingPongGame extends JPanel implements KeyListener{

		private Ball ball;
		protected Racquet racquet1;
		protected Racquet racquet2;
		protected JLabel text1;
		protected JLabel text2;
	
		private  int GAME_WIDTH  =600;
		private  int GAME_HEIGHT  =400;
		protected int player1=0;
		protected int player2=0;
		
		
	
		
	public 	PingPongGame() {
		ball = new Ball(this, Color.yellow);   // f라켓이랑박았는지확인
		this.setBackground(Color.black);
		racquet1 = new Racquet(this, 10, 150 ,Color.blue, 1);
		racquet2 = new Racquet(this, 560, 150 ,Color.red, 2);
		this.setFocusable(true);   // 굳이 한 이유를 찾아보세요. 없으면 이벤트가 발생안하는지??
		this.addKeyListener(this);
		
		
		
	}
		@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		ball.draw(g2d);
		racquet1.draw(g2d);
		racquet2.draw(g2d);
		
		g.setColor(Color.white);
		g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,60));
		g.drawLine(GAME_WIDTH/2, 0, GAME_WIDTH/2, GAME_HEIGHT);
		g.drawString(String.valueOf(player1), GAME_WIDTH/2 -85, 50);
		g.drawString(String.valueOf(player2), GAME_WIDTH/2 + 20, 50);
		

		
		
		
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	racquet1.keyPressed(e);
	racquet2.keyPressed(e);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
		racquet1.keyReleased(e);
		racquet2.keyReleased(e);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	void move() {
		ball.move();
		racquet1.move();
		racquet2.move();
	}
		
	

	class Ball{
		private static final int RADIUS = 20;   //원의반지름
		private int x=300, y=200 ,xSpeed =1 , ySpeed =1; 
		private PingPongGame game;
		private Color color;
		boolean touch  =false;

		protected int t;
		
		 Timer timer = new Timer(t,null);

		 
		
		public Ball (PingPongGame game , Color color) {
			this.game= game;
			this.color = color;
			
			timer.start();
			if(3000<t && t < 10000) {
				xSpeed += 3;
				ySpeed += 3;
			}
			if(10000<t && t < 15000) {
				xSpeed += 10;
				ySpeed += 10;
			}
			
			 
			
		}
		public void draw(Graphics2D g) {
			g.setColor(color);
			g.fillOval(x, y, 2*RADIUS,2*RADIUS);
			
			
		}
		void move () {
			
			
		
			if (x +xSpeed <0)  //if문 4개는 벽에 부딫히면 
				xSpeed += 3;
			System.out.println(t);
		
			if (x +xSpeed >game.getWidth() -2 * RADIUS)  //xy범위를 시작으로해서 그 원도 나가면 안됨.
				xSpeed += -3;
	
		

			if (y +ySpeed <0)
				ySpeed += 3;
		
			
			if (y +ySpeed >game.getHeight()-2*RADIUS)
				ySpeed += -3;
	
		
			if(collision())
				xSpeed = -xSpeed;//부딫힘 감지 양수음수 반전해서 방향 반대로
			
			x += xSpeed;
			y += ySpeed;
				
			if(x<= 5) {
				player2 += 1;
				
				x=300;
				y=200;
				repaint();
			}
			if (x >=530) {
				player1 += 1;
				x=300;
				y=200;
				repaint();
			}
			
			
	
		}
		
		public boolean collision() {
			return game.racquet1.getBounds().intersects(getBounds()) ||   //논리 or
					
					game.racquet2.getBounds().intersects(getBounds());  //intersect 하는지 판단해주는 메소드
			
		
			
//		Rectangle r1 = game.racquet1.getBounds();
//			//
//			Rectangle r2 = game.racquet2.getBounds();
//			Rectangle myr = getBounds();
//			boolean r1c = r1.intersects(myr);
//			boolean r2c = r2.intersects(myr);
//			
//			return r1c || r2c;  // 둘중 하나라도 트루면 트루다
			
		}
		public Rectangle getBounds(){
			return new Rectangle(x , y, 2*RADIUS ,2 * RADIUS);
		}
		
		
		
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if(e.getKeyCode()== KeyEvent.VK_UP) {
				ySpeed = -3;
			}
			else if(e.getKeyCode()== KeyEvent.VK_DOWN) { 
				ySpeed = 3;
			}
			
		}
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			ySpeed = 0;
		}

	}
	class Racquet {
		
		private static final int WIDTH = 10;
		private static final int HEIGHT = 80;
		private int x=0 , y=0;
		protected int xSpeed =0;
		protected int ySpeed =0;
		private PingPongGame game;
		private Color color;
		private int s  ;


		
		
		public Racquet(PingPongGame game, int x, int y, Color color,int s) {
			this.game=game;
			this.x = x;
			this.y= y;
			this.color = color;
			this.s=s;
		}
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		public Rectangle getBounds() {
			
			return new Rectangle (x,y,WIDTH ,HEIGHT);
		}
		public void draw(Graphics2D g) {
			g.setColor(color);
		
			g.fillRect(x, y, WIDTH, HEIGHT);
		}
		public void move() {
			if(y+ySpeed >0 && y + ySpeed <250)//패널의 값 리턴  잘려나가지않기위해서
			y += ySpeed;
		}
		
		
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
			if(s   == 1) {	
				if(y<00) {
				y=0;
			//	ySpeed = 0;
				}else if(y>300) {
				y=300;
			//	ySpeed = -0;
			}
			if(e.getKeyCode()== KeyEvent.VK_W) {
			//	ySpeed =  -3;
				y-=30;
				}
				else if(e.getKeyCode()== KeyEvent.VK_S) {
			//	ySpeed =  3;
					y+=30;
			}
			
			
			}
			
			if(s == 2) {
				if(y<00) {
					y=0;
				//	ySpeed = 0;
					}else if(y>300) {
					y=300;
				//	ySpeed = -0;
				}
				if(e.getKeyCode()== KeyEvent.VK_I) {
				//	ySpeed =  -3;
					y-=30;
					}
					else if(e.getKeyCode()== KeyEvent.VK_K) {
				//	ySpeed =  3;
						y+=30;
				}
				
				
				}
		}
		
	
			

			}
		
			

		
	

public static void main (String [] args) {
	JFrame frame = new JFrame();
	PingPongGame panel = new PingPongGame();
	frame.add(panel);
	frame.setVisible(true);
	frame.setSize(600,400);
	frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	
	while(true) {
		panel.move();
		panel.repaint();
		try {
			Thread.sleep(10);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	}
		}
	



