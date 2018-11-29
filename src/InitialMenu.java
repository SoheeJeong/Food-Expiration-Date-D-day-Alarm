import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InitialMenu extends JFrame{
	public static JButton Done;
	public static int refgaro;
	public static int refsero;
	public static int refnopi;
	public static Panel1 panel1;
	public static Panel2 panel2;
	public InitialMenu() {
		setTitle("메뉴화면");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1500,850);
		setLocationRelativeTo(null); 
		setLayout(new FlowLayout());
		setSize(1500,850); //창 크기
		setResizable(false);
		setLayout(null);
		Container c=getContentPane();
		panel1=new Panel1(); //설명 판넬 붙이기
		setContentPane(panel1); //panel1을 판넬로 사용
		setVisible(true);
	}
	private void createMenu() {//메뉴 만들기
		JMenuBar mb=new JMenuBar();
		JMenu refMenu=new JMenu("나의 냉장고");
		JMenu HowtoMenu=new JMenu("사용 방법");
		JMenu clearMenu=new JMenu("초기화하기");
		JMenu exitMenu=new JMenu("종료하기");

		mb.add(refMenu);
		mb.add(HowtoMenu);
		mb.add(clearMenu);
		mb.add(exitMenu);
		JMenuItem hide=new JMenuItem("숨기기");
		JMenuItem show=new JMenuItem("보기");
		refMenu.add(hide);
		refMenu.add(show);

		HowtoMenu.addActionListener(new MenuActionListener());
		clearMenu.addActionListener(new MenuActionListener());
		exitMenu.addActionListener(new MenuActionListener());
		hide.addActionListener(new MenuActionListener());
		show.addActionListener(new MenuActionListener());

		setJMenuBar(mb);
		mb.setSize(1500,200);
		setVisible(true);
	}
	class Panel1 extends JPanel{//설명창 판넬
		Panel1(){
			setBackground(StartMenu.color);
			setLayout(null);
			//냉장고 정보 입력하기
			JLabel greet=new JLabel(StartMenu.Lastname+StartMenu.Firstname+"님 안녕하세요.");
			JLabel inst1=new JLabel("사용 방법: 아무 네모칸이나 눌러서 유통기한을 입력합니다.");
			JLabel inst2=new JLabel("날짜가 임박하면 색깔이 바뀝니다.");
			JLabel inst3=new JLabel("자세한 설명은 \"사용 방법\"메뉴를 참고하세요.");
			JLabel inst4=new JLabel(StartMenu.Yourpobu+" 시작하려면 버튼을 클릭하세요!");
			JLabel imageLabel=new JLabel(new ImageIcon("버튼2.png"));
			//버튼이미지 넣기
			add(greet);add(inst1);add(inst2);add(inst3);add(inst4);add(imageLabel);

			greet.setFont(new Font("맑은고딕",Font.BOLD,30));
			inst1.setFont(new Font("맑은고딕",Font.BOLD,30));
			inst2.setFont(new Font("맑은고딕",Font.BOLD,30));
			inst3.setFont(new Font("맑은고딕",Font.BOLD,30));
			inst4.setFont(new Font("맑은고딕",Font.BOLD,30));

			greet.setBounds(20, 20, 1000, 30);
			inst1.setBounds(20, 80, 1000, 30);
			inst2.setBounds(20, 140, 1000, 30);
			inst3.setBounds(20, 200, 1000, 30);
			inst4.setBounds(20, 260, 1500, 30);
			imageLabel.setBounds(20,340,550,550);
			imageLabel.addMouseListener(new MyMouseListener());
			setVisible(true);
		}
	}
	class MyMouseListener extends MouseAdapter{ //버튼 이미지 클릭할때
		public void mouseClicked(MouseEvent e) { 
			createMenu(); //메뉴바 만들기
			panel2=new Panel2();
			setContentPane(panel2); //냉장고판넬로 바꾸기
		}
	}
	class Panel2 extends JPanel{//냉장고 판넬
		Panel2(){
			JLabel label;
			setSize(1500,850);
			setLayout(new GridLayout(10,10));
			for(int i=0;i<100;i++) {
				int num=i+1;
				label=new JLabel(Integer.toString(num));
				label.setOpaque(true);
				add(label);
				label.setBackground(Color.WHITE);
				//구분선 추가
				label.setFont(new Font("맑은고딕",Font.BOLD,25));
				label.addMouseListener(new MyMouseListener2());
			}
			setVisible(true);
		}
	}
	class MyMouseListener2 extends MouseAdapter{//냉장고의 각 라벨 누를 때
		public void mouseClicked(MouseEvent e) {
			JLabel la=(JLabel)e.getSource();
			//팝업창
			//음식 이름이랑 유통기한 받기
			//라벨 setText(음식이름)
			//
		}
		//	public void timecalculate(유통기한날짜){
		//			
		//}
		class MenuActionListener implements ActionListener{ //메뉴 클릭했을 때
			public void actionPerformed(ActionEvent e) {
				String cmd=e.getActionCommand();
				switch(cmd) {
				case "숨기기": 
					getContentPane().setVisible(false);
					break;
				case "보기":
					getContentPane().setVisible(true);
					setContentPane(panel2);
					break;
					//p.420참고
				case "사용 방법":
					getContentPane().setVisible(true);
					new Menu사용방법();
					break;
				case "초기화":
					getContentPane().setVisible(true);
					new Menu초기화();
					break;
				case "종료":
					getContentPane().setVisible(true);
					new Menu종료();
				}
			}
		}

	}
