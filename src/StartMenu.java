import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartMenu extends JFrame{
	public static Color color=new Color(0xE1F5A9);
	public StartMenu(){ //StartMenu��� ������
		setTitle("����ȭ��");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1500,850);
		setLocationRelativeTo(null); 
		setLayout(new BorderLayout());
		setContentPane(new JLabel(new ImageIcon("����ȭ��4.png")));
		setLayout(new FlowLayout());
		setSize(1500,850); //â ũ��
		setResizable(false);
		setLayout(null);

		JLabel start=new JLabel("ȯ���մϴ�! Hello!");
		JButton Go=new JButton("�����ϱ�");
		start.setBackground(color);
		start.setBounds(200,400,700,30);
		Go.setBounds(200,450,200,30);
		start.setFont(new Font("�������",Font.BOLD,23));
		Go.setFont(new Font("�������",Font.BOLD,23));
		Go.addMouseListener(new MyMouseListener());

		add(start);
		add(Go);
		setVisible(true);
	}
	class MyMouseListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			JButton btn=(JButton)e.getSource();
			dispose(); //���� â ����
			new InitialMenu().setVisible(true);
		}
	}

	public static void main(String[]args) {
		new StartMenu();		
	}
}
