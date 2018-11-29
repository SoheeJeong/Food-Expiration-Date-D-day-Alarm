import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartMenu extends JFrame{
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
				
		JLabel start=new JLabel("환영합니다! Hello!");
		JLabel lastName=new JLabel("성/Last name");
		JLabel firstName=new JLabel("이름/First name");
		JLabel Pobu=new JLabel("포부 한마디!");
		JTextField tfLast=new JTextField(20);
		JTextField tfFirst=new JTextField(20);
		JTextField tfPobu=new JTextField(20);
		JButton Go=new JButton("시작하기");
				
		start.setBackground(color);
		lastName.setBackground(color);
		firstName.setBackground(color);
		Pobu.setBackground(color);
		
		start.setBounds(150,340,700,30);
		lastName.setBounds(200,400,150,30);
		firstName.setBounds(200,440,150,30);
		Pobu.setBounds(200,480,150,30);
		
		tfLast.setBounds(350,400,150,30);
		tfFirst.setBounds(350,440,150,30);
		tfPobu.setBounds(350,480,150,30);
		Go.setBounds(280,550,150,30);
		
		start.setFont(new Font("맑은고딕",Font.BOLD,20));
		lastName.setFont(new Font("맑은고딕",Font.BOLD,18));
		firstName.setFont(new Font("맑은고딕",Font.BOLD,18));
		Pobu.setFont(new Font("맑은고딕",Font.BOLD,18));
		Go.setFont(new Font("맑은고딕",Font.BOLD,18));
		Go.addMouseListener(new MyMouseListener());
		
		add(start);
		add(lastName);
		add(firstName);
		add(Pobu);
		add(tfLast);
		add(tfFirst);
		add(tfPobu);
		add(Go);
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
