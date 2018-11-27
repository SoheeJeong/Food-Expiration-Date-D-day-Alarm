import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class StartMenu extends JFrame{
	public static JTextField tfgaro=new JTextField(20);
	public static JTextField tfsero=new JTextField(20);
	public static JTextField tfnopi=new JTextField(20);
	public static String refgaro=tfgaro.getText(); //����� ����ĭ��
	public static String refsero=tfsero.getText(); //����
	public static String refnopi=tfnopi.getText(); //����
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
				
		JLabel inst=new JLabel("������� ������ �� ���� ����, ���� ĭ ���� �Է��ϼ���.");
		JLabel garo=new JLabel("���� ĭ ��");
		JLabel sero=new JLabel("���� ĭ ��");
		JLabel nopi=new JLabel("���� �� ��");
		
		JButton Done=new JButton("�ۼ� �Ϸ�");
				
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
		
		inst.setFont(new Font("�������",Font.BOLD,20));
		garo.setFont(new Font("�������",Font.BOLD,18));
		sero.setFont(new Font("�������",Font.BOLD,18));
		nopi.setFont(new Font("�������",Font.BOLD,18));
		Done.setFont(new Font("�������",Font.BOLD,18));
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
			dispose(); //���� â ����...�̰Ÿ��� �� ��������ȯ ����
			new InitialMenu().setVisible(true);
		}
	}
	public static void main(String[]args) {
		new StartMenu();		
	}
}
