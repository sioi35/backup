package Game;

import java.io.*;


import java.net.*;
import java.util.*;

import javax.swing.*;



import java.awt.*;
import java.awt.event.*;

public class Smain {

	String text = "";
	static JFrame frame;
	String frameTitle = "Game";
	startPanel startP;
	JButton startbutton;			// 토글이 되는 로그인/로그아웃 버튼
	boolean ing=false;
	Font font =new Font("", 1, 30);

	static JPanel mainPanel = new JPanel();

	int right;

	/*프로그램의 main method 실행 파트*/
	public static void main(String[] args) {
		Smain start=new Smain();		//객체화
		start.go();						//생성자 기능을 맡은 초기화를 담당한 go 메소드 실행
	}
	
	/*생성자처럼 초기화를 담당하는 메소드*/
	public void go(){
		frame = new JFrame(frameTitle);		//프레임 객체화
		mainPanel.setLayout(null);			//mainPanel은 레이아웃을 null 아무것도 설정하지 않음
		frame.setLayout(null);				//frame도 레이아웃을 설정하지 않음
		// 메시지 전송을 위한 버튼
		startP =new startPanel();			//시작하는 화면을 그려낼 스타트패널을 객체화
		startP.setBounds(0, 0, 600, 700);	//스타프패널의 크기 및 모양의 위치를 설정
		mainPanel.setBounds(0, 0, 800, 800); //메인패널의 크기 및 발생위치를 설정
		mainPanel.add(startP);				//메인패널에 스타트패널을 add
		
		frame.add(mainPanel);				//mainpanel을 프레임에 추가
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//프레임에서 닫기 버튼을 누르면 프로그램 종료
		frame.setVisible(true);		//보이게
		frame.setSize(610,740);		//프레임 사이즈 설정
	}
	
	/*버튼에 붙여줄 이벤트 처리기*/
	public class Button implements ActionListener{

		@Override
		//이벤트를 감지하였을 때 무슨일을할것인지 정하는 메소드 파트
		// 이 actionlistener는 시작버튼에 붙였으므로 시작버튼이 눌리면 일어날일설정
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Sgame game = new Sgame();		//게임을 관장하는 클래스를 객체화
			game.gp.setFocusable(true);		//game 클래스에 있는 gamepanel에 focus를 옮기는 세팅 메소드
			startP.setVisible(false);		//start패널이 보이지 않도록 한다
			mainPanel.repaint();			//mainpanel을 리페인트해서 보여지도록 한다.
			//결과적으로 mainpanel에 add했던 startpanel은 setvisible이 false로 보이지 않게 됐기 때문에
			//mainpanel에는 startpanel이 보이지 않는다
		}
	}
	/*시작화면을 그려낼 jpanel 상속받은 패널 클래스*/
	public class startPanel extends JPanel{
		
		//jpanel을 상속받으면 그림을 그릴 수있는 메소드가 있는데 그게 여기
		//이 메소드는 패널이 존재하는 한 계속 그림을 그려내는 메소드
		public void paintComponent (Graphics g) {
			Graphics2D g2d = (Graphics2D) g;

			ImageIcon mainimage= new ImageIcon("메인.jpg");	//바깥에 저장된 jpg파일을 자바로 옮기기 위해서 imageicon 클래스를 하나 객체화해서 이미지를 넣음

			//mainimage 변수는 imgaeicon 클래스를 가리키는 변수인데 이걸 객체화했으니 객체화된 imageicon클래스에서 getimage하면 넣었던 그림파일을 꺼내옴
			g2d.drawImage(mainimage.getImage(), 0, 0,600,700, this);  //배경을 그리는 메소드
			
			startP.setLayout(null);
			startbutton = new JButton(new ImageIcon("start.PNG"));
			startbutton.addActionListener(new Button());
			startbutton.setBounds(120,440,150,120);
			startbutton.setBorderPainted(false);
			startbutton.setContentAreaFilled(false);
			startP.add(startbutton);

		}
	}

} 
