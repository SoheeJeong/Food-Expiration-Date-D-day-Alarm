import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class StartMenu extends JFrame{
	public static JTextField tfgaro=new JTextField(20);
	public static JTextField tfsero=new JTextField(20);
	public static JTextField tfnopi=new JTextField(20);
	public static String refgaro=tfgaro.getText(); //냉장고 가로칸수
	public static String refsero=tfsero.getText(); //세로
	public static String refnopi=tfnopi.getText(); //높이
	public static Color color=new Color(0xE1F5A9);
	
	public StartMenu(){ //StartMenu라는 프레임
		setTitle("시작화면");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1500,850);
		setLocationRelativeTo(null); 
		setLayout(new BorderLayout());
		setContentPane(new JLabel(new ImageIcon("시작화면4.png")));
		setLayout(new FlowLayout());
		setSize(1500,850); //창 크기
		setResizable(false);
		setLayout(null);
				
		JLabel inst=new JLabel("냉장고의 층수와 각 층의 가로, 세로 칸 수를 입력하세요.");
		JLabel garo=new JLabel("가로 칸 수");
		JLabel sero=new JLabel("세로 칸 수");
		JLabel nopi=new JLabel("높이 층 수");
		
		JButton Done=new JButton("작성 완료");
				
		inst.setBackground(color);
		garo.setBackground(color);
		sero.setBackground(color);
		nopi.setBackground(color);
		
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
	class MyMouseListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			JButton btn=(JButton)e.getSource();
			dispose(); //현재 창 닫힘...이거말고 걍 프레임전환 없나
			new InitialMenu().setVisible(true);
		}
	}
	public static void main(String[]args) {
		new StartMenu();		
	}
}
