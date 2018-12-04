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
		JButton Go=new JButton("시작하기");
		start.setBackground(color);
		start.setBounds(200,400,700,30);
		Go.setBounds(200,450,200,30);
		start.setFont(new Font("맑은고딕",Font.BOLD,23));
		Go.setFont(new Font("맑은고딕",Font.BOLD,23));
		Go.addMouseListener(new MyMouseListener());

		add(start);
		add(Go);
		setVisible(true);
	}
	class MyMouseListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			JButton btn=(JButton)e.getSource();
			dispose(); //현재 창 닫힘
			new InitialMenu().setVisible(true);
		}
	}

	public static void main(String[]args) {
		new StartMenu();		
	}
}
