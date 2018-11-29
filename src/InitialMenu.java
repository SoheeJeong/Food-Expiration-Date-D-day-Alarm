import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InitialMenu extends JFrame{
	public static JButton Done;
	public static int refgaro;
	public static int refsero;
	public static int refnopi;

	public InitialMenu() {
		setTitle("메뉴화면");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1500,850);
		setLocationRelativeTo(null); 
		setLayout(new FlowLayout());
		setSize(1500,850); //창 크기
		setResizable(false);
		setLayout(null);
		getContentPane().setBackground(StartMenu.color);
		//마우스리스너가 버튼에 가도록 바꾸기 getContentPane().addMouseListener(new MyMouseListener());
		//냉장고 정보 입력하기
		JLabel inst1=new JLabel("사용 방법: 아무 네모칸이나 눌러서 유통기한을 입력합니다.");
		JLabel inst2=new JLabel("날짜가 임박하면 색깔이 바뀝니다.");
		JLabel inst3=new JLabel("자세한 설명은 \"사용 방법\"메뉴를 참고하세요.");
		JLabel inst4=new JLabel("시작하려면 버튼을 클릭하세요!");
		//버튼이미지 넣기
		add(inst1);add(inst2);add(inst3);add(inst4);//add(이미지);

		inst1.setFont(new Font("맑은고딕",Font.BOLD,30));
		inst2.setFont(new Font("맑은고딕",Font.BOLD,30));
		inst3.setFont(new Font("맑은고딕",Font.BOLD,30));
		inst4.setFont(new Font("맑은고딕",Font.BOLD,30));

		inst1.setBounds(20, 20, 1000, 30);
		inst2.setBounds(20, 80, 1000, 30);
		inst3.setBounds(20, 140, 1000, 30);
		inst4.setBounds(20, 200, 1000, 30);

		setVisible(true);
	}
	private void createMenu() {
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

	class MyMouseListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e) { //버튼 이미지 눌렀을 때!
			createMenu(); //메뉴바 만들기
			
			 //여기서 누를때마다 새로만들기 말고 저장되어있는거 불러오는 방법? ->setvisible로
		}
	}

	class MenuActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String cmd=e.getActionCommand();
			switch(cmd) {
			case "숨기기": 
				getContentPane().setVisible(false);
			case "보기":
				new Menu나의냉장고();
			case "사용 방법":
				new Menu사용방법();
			case "초기화":
				new Menu초기화();
			case "종료":
				new Menu종료();
			}
		}
	}
}
