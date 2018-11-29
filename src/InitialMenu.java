import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InitialMenu extends JFrame{
	public static JButton Done;
	public static int refgaro;
	public static int refsero;
	public static int refnopi;
	JLabel la;
	
	public InitialMenu() {
		setTitle("�޴�ȭ��");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1500,850);
		setLocationRelativeTo(null); 
		setLayout(new BorderLayout());
		setLayout(new FlowLayout());
		setSize(1500,850); //â ũ��
		setResizable(false);
		setLayout(null);
		getContentPane().setBackground(StartMenu.color);
		getContentPane().addMouseListener(new MyMouseListener());
		//����� ���� �Է��ϱ�
		JLabel inst1=new JLabel("��� ���: �ƹ� �׸�ĭ�̳� ������ ��������� �Է��մϴ�.");
		JLabel inst2=new JLabel("��¥�� �ӹ��ϸ� ������ �ٲ�ϴ�.");
		JLabel inst3=new JLabel("�ڼ��� ������ \"��� ���\"�޴��� �����ϼ���.");
		JLabel inst4=new JLabel("�����Ϸ��� �ƹ� ���̳� Ŭ���ϼ���!");
		add(inst1);add(inst2);add(inst3);add(inst4);
		
		inst1.setFont(new Font("�������",Font.BOLD,30));
		inst2.setFont(new Font("�������",Font.BOLD,30));
		inst3.setFont(new Font("�������",Font.BOLD,30));
		inst4.setFont(new Font("�������",Font.BOLD,30));
		
		inst1.setBounds(20, 20, 1000, 30);
		inst2.setBounds(20, 80, 1000, 30);
		inst3.setBounds(20, 140, 1000, 30);
		inst4.setBounds(20, 200, 1000, 30);
		
		setVisible(true);
	}
	private void createMenu() {
		JMenuBar mb=new JMenuBar();
		JMenu refMenu=new JMenu("���� �����");
		JMenu HowtoMenu=new JMenu("��� ���");
		JMenu clearMenu=new JMenu("�ʱ�ȭ");
		JMenu exitMenu=new JMenu("����");

		mb.add(refMenu);
		mb.add(HowtoMenu);
		mb.add(clearMenu);
		mb.add(exitMenu);
		setJMenuBar(mb);
		mb.setSize(1500,200);
		setVisible(true);
	}

	class MyMouseListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
				createMenu(); //�޴��� �����
		}
	}

	class MenuActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String cmd=e.getActionCommand();
			switch(cmd) {
			case "���� �����": 
				new Menu���ǳ����();
			case "��� ���":
				new Menu���򺸱�();
			case "�ʱ�ȭ":
				new Menu�ʱ�ȭ();
			case "����":
				new Menu����();
			}
		}
	}
}
