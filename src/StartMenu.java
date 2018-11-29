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
		JLabel lastName=new JLabel("��/Last name");
		JLabel firstName=new JLabel("�̸�/First name");
		JLabel Pobu=new JLabel("���� �Ѹ���!");
		JTextField tfLast=new JTextField(20);
		JTextField tfFirst=new JTextField(20);
		JTextField tfPobu=new JTextField(20);
		JButton Go=new JButton("�����ϱ�");
				
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
		
		start.setFont(new Font("�������",Font.BOLD,20));
		lastName.setFont(new Font("�������",Font.BOLD,18));
		firstName.setFont(new Font("�������",Font.BOLD,18));
		Pobu.setFont(new Font("�������",Font.BOLD,18));
		Go.setFont(new Font("�������",Font.BOLD,18));
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
			dispose(); //���� â ����...�̰Ÿ��� �� ��������ȯ ����
			new InitialMenu().setVisible(true);
		}
	}
	public static void main(String[]args) {
		new StartMenu();		
	}
}
