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
		setLayout(null);
		Component c=getContentPane();
		c.setBackground(StartMenu.color);
	
		//냉장고 정보 입력하기
		JLabel inst=new JLabel("냉장고의 층수와 각 층의 가로, 세로 칸 수를 입력하세요.");
		JLabel garo=new JLabel("가로 칸 수");
		JLabel sero=new JLabel("세로 칸 수");
		JLabel nopi=new JLabel("높이 층 수");
		JButton Done=new JButton("작성 완료");

		inst.setBackground(StartMenu.color);
		garo.setBackground(StartMenu.color);
		sero.setBackground(StartMenu.color);
		nopi.setBackground(StartMenu.color);

		IntegerField tfgaro=new IntegerField(20);
		IntegerField tfsero=new IntegerField(20);
		IntegerField tfnopi=new IntegerField(20);
		int refgaro=tfgaro.getInt(); //냉장고 가로칸수
		int refsero=tfsero.getInt(); //세로
		int refnopi=tfnopi.getInt(); //높이
		
		//예외처리하기

		inst.setBounds(150,340,700,30);
		garo.setBounds(200,400,100,30);
		sero.setBounds(200,440,100,30);
		nopi.setBounds(200,480,100,30);
		tfgaro.setBounds(350,400,150,30);
		tfsero.setBounds(350,440,150,30);
		tfnopi.setBounds(350,480,150,30);
		Done.setBounds(280,550,150,30);

		inst.setFont(new Font("맑은고딕",Font.BOLD,20));
		garo.setFont(new Font("맑은고딕",Font.BOLD,18));
		sero.setFont(new Font("맑은고딕",Font.BOLD,18));
		nopi.setFont(new Font("맑은고딕",Font.BOLD,18));
		Done.setFont(new Font("맑은고딕",Font.BOLD,18));
		Done.addMouseListener(new MyMouseListener());

		add(inst);
		add(garo);
		add(tfgaro);
		add(sero);
		add(tfsero);
		add(nopi);
		add(tfnopi);
		add(Done);
		setVisible(true);

	}
	private void createMenu() {
		JMenuBar mb=new JMenuBar();
		JMenu refMenu=new JMenu("나의 냉장고");
		JMenu todayMenu=new JMenu("오늘의 날짜");
		JMenu clearMenu=new JMenu("초기화");

		int num=refnopi;
		for(int i=1;i<=num;i++) {
			String menu=Integer.toString(i)+"층";
			JMenuItem item=new JMenuItem(menu);
			item.addActionListener(new MenuActionListener());
			refMenu.add(item);
		}
		mb.add(refMenu);
		mb.add(todayMenu);
		mb.add(clearMenu);
		setJMenuBar(mb);
		mb.setSize(1500,200);
		setVisible(true);
	}
	
	class MyMouseListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			JButton btn=(JButton)e.getSource();
			if(btn.getText().equals("작성 완료")) {
				//메뉴바 만들기
				createMenu();
			}
		}
	}
	
	class MenuActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JMenuItem item=(JMenuItem)e.getSource();
			for(int i=0;i<refnopi;i++) {
			if(item.getText().equals(i+"층")) {
				
			}
			}
		}
	}

	public static void main(String[]args) {
		new InitialMenu();
	}
}
