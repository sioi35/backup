package Game;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;  // 마우스 이벤트관련 라이브러리
import java.net.URL;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Sgame  {
	ImageIcon gameimage= new ImageIcon("게임.png");
	ImageIcon peopleimage= new ImageIcon("캐릭터1.png");
	ImageIcon peopleimage2= new ImageIcon("캐릭터2.PNG");
	ImageIcon leftD1=new ImageIcon("왼화살표 회색.png");
	ImageIcon leftD2=new ImageIcon("왼화살표노랑.png");
	ImageIcon rightD1=new ImageIcon("오화살표회색.png");
	ImageIcon rightD2=new ImageIcon("오화살표노랑.png");
	
	gamePanel gp=new gamePanel();
	
	private Timer timer;//메인 타이머
	
	int DELAY=100;
	int reset=0;
	int y=0;
	int click=0;
	int score=0;
	
	AudioClip gameSound;
	JLabel scoreLabel=new JLabel();                            
	ArrayList<Integer> catchs=new ArrayList<Integer>(); 
	Catch key; 
	Font font=new Font("Courier",Font.BOLD,30); //이름, 스타일, 크기
	
	/*이 클래스의 생성자(구성자) ==> 객체화될때 자동으로 실행이 되는 메소드*/
	public Sgame() {
		
		gp.setLayout(null);
		gp.setBounds(0, 0, 1000, 1000);
		
		
		timer = new Timer(DELAY, new TimerListener());   // 타이머 설정
		timer.start();
		
		
		scoreLabel.setFont(font);
		scoreLabel.setBounds(440,0,200,50);
		scoreLabel.setText("Score : "+score);
		
		gp.add(scoreLabel);
		gp.addKeyListener(new Catch());
		
		
		try {                           //오디오 재생
	         URL url;
	         url = new URL ("file", "localhost", "1.wav");//url 객체생성
	         gameSound = JApplet.newAudioClip (url);
	      }
	      catch (Exception exception) {
	         System.out.println("던질때 오디오 파일이 없습니다.");
	      }
		Smain.mainPanel.add(gp);
		gameSound.play();
		
	}

	class TimerListener implements ActionListener {
		public void actionPerformed (ActionEvent event) {
			reset++;
			if(reset==1){
				double random=Math.random();
				int value=(int)(random*2);

				catchs.add(value);
				y=0;

			}
			else if(reset==5){
				reset=0;
			}
			if(y==60){
				click=0;
			}
						
			y=y+20;
			
			gp.repaint();
		}//액션퍼폼
	}
	
	public class gamePanel extends JPanel{
		public void paintComponent(Graphics g) {
			Graphics2D g2d = (Graphics2D) g;
			gp.setLayout(null);//배치관리자 해제 
			
			g2d.drawImage(gameimage.getImage(), 0, 0,600,700, this);			//게임배경
			
			//키보드가 안 눌리면 화살표를 회색으로 그리기 위한 부분
			if(click==0){   													//click을 체크할 변수	
				g2d.drawImage(leftD1.getImage(),25,525,120,120, this);
				g2d.drawImage(rightD1.getImage(),455,530,120,120, this);
			}else if(click==1){  												//클릭한 화살표 노란색으로 바뀜
				g2d.drawImage(leftD1.getImage(),25,525,120,120, this);
				g2d.drawImage(rightD2.getImage(),455,530,120,120, this);		//오른쪽화살표 노란색으로
			}else{
				g2d.drawImage(rightD1.getImage(),455,530,120,120, this);
				g2d.drawImage(leftD2.getImage(),25,525,120,120, this);			//왼쪽화살표 노란색으로
			}
			
			int i=0;
			for(int j=0;j<catchs.size();j++){

				if(catchs.get(j)==0){
					g2d.drawImage(peopleimage.getImage(),250,(catchs.size()-j-1)*100+y+90,100,100, this);//이미지내려오는거

				}else{
					g2d.drawImage(peopleimage2.getImage(),250,(catchs.size()-j-1)*100+y+90,100,100, this);
				}

				if((catchs.size()-j-1)*100+y>500){//네모상자안에들어오면 키보드누르기
					gp.setVisible(false);  
					Smain end=new Smain();
					Smain.frame.setVisible(false);
					timer.stop();   
					
					end.go();
				}
			} 
		}
	}
	public class Catch implements KeyListener{

		@Override
		public void keyPressed(KeyEvent e) {

			switch(e.getKeyCode()){

			case KeyEvent.VK_LEFT:
				
				if(((catchs.size()-1)*100+y)<500&&((catchs.size()-1)*100+y)>390&&(catchs.get(0)==0)){
					click=2;
					catchs.remove(0);
					score=score+10;
					scoreLabel.setText("Scroe : "+score);
				}else{       // 네모상자안에 들어왔을때 못누르면 게임 종료
					gp.setVisible(false);
					timer.stop();
					gameSound.stop();
					Smain end=new Smain();
					Smain.frame.setVisible(false);
					JOptionPane.showMessageDialog(null, "게임 종료 점수 : "+score, "INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
					//옵션창 
					end.go();
					
				}
				
				gp.repaint();
				break;

			case KeyEvent.VK_RIGHT:
				if(((catchs.size()-1)*100+y)<500&&((catchs.size()-1)*100+y)>390&&catchs.get(0)==1){
					click=1;
					catchs.remove(0);
					score=score+10;
					scoreLabel.setText("Scroe : "+score);
				}else{
					gp.setVisible(false);
					timer.stop();
					gameSound.stop();
					Smain end=new Smain();
					Smain.frame.setVisible(false);
					JOptionPane.showMessageDialog(null, "게임 종료 점수 : "+score, "INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
					end.go();
				}
				gp.repaint();
				break;
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

	}
}
