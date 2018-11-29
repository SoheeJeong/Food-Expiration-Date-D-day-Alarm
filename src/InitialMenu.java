import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class InitialMenu extends JFrame{

	public static JButton Done;
	public static int refgaro;
	public static int refsero;
	public static int refnopi;
	public static Panel1 panel1;
	public static Panel2 panel2;

	public InitialMenu() {
		setTitle("�޴�ȭ��");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1500,850);
		setLocationRelativeTo(null); 
		setLayout(new FlowLayout());
		setSize(1500,850); //â ũ��
		setResizable(false);
		setLayout(null);
		Container c=getContentPane();
		panel1=new Panel1(); //���� �ǳ� ���̱�
		setContentPane(panel1); //panel1�� �ǳڷ� ���
		setVisible(true);
	}
	private void createMenu() {//�޴� �����
		JMenuBar mb=new JMenuBar();
		JMenu refMenu=new JMenu("���� �����");
		JMenu setting=new JMenu("����");

		mb.add(refMenu);
		mb.add(setting);

		JMenuItem hide=new JMenuItem("�����");
		JMenuItem show=new JMenuItem("����");
		JMenuItem HowtoMenu=new JMenu("��� ���");
		JMenuItem clearMenu=new JMenu("�ʱ�ȭ�ϱ�");
		JMenuItem exitMenu=new JMenu("�����ϱ�");

		refMenu.add(hide);
		refMenu.add(show);
		setting.add(HowtoMenu);
		setting.add(clearMenu);
		setting.add(exitMenu);

		HowtoMenu.addActionListener(new MenuActionListener());
		clearMenu.addActionListener(new MenuActionListener());
		exitMenu.addActionListener(new MenuActionListener());
		hide.addActionListener(new MenuActionListener());
		show.addActionListener(new MenuActionListener());

		setJMenuBar(mb);
		mb.setSize(1500,100);
		setVisible(true);
	}
	class Panel1 extends JPanel{//����â �ǳ�
		Panel1(){
			setBackground(StartMenu.color);
			setLayout(null);
			//����� ���� �Է��ϱ�
			JLabel greet=new JLabel(StartMenu.Lastname+StartMenu.Firstname+"�� �ȳ��ϼ���.");
			JLabel inst1=new JLabel("��� ���: �ƹ� �׸�ĭ�̳� ������ ��������� �Է��մϴ�.");
			JLabel inst2=new JLabel("��¥�� �ӹ��ϸ� ������ �ٲ�ϴ�.");
			JLabel inst3=new JLabel("�ڼ��� ������ \"��� ���\"�޴��� �����ϼ���.");
			JLabel inst4=new JLabel(StartMenu.Yourpobu+" �����Ϸ��� ��ư�� Ŭ���ϼ���!");
			JLabel imageLabel=new JLabel(new ImageIcon("��ư2.png"));
			//��ư�̹��� �ֱ�
			add(greet);add(inst1);add(inst2);add(inst3);add(inst4);add(imageLabel);

			greet.setFont(new Font("�������",Font.BOLD,30));
			inst1.setFont(new Font("�������",Font.BOLD,30));
			inst2.setFont(new Font("�������",Font.BOLD,30));
			inst3.setFont(new Font("�������",Font.BOLD,30));
			inst4.setFont(new Font("�������",Font.BOLD,30));

			greet.setBounds(20, 20, 1000, 30);
			inst1.setBounds(20, 80, 1000, 30);
			inst2.setBounds(20, 140, 1000, 30);
			inst3.setBounds(20, 200, 1000, 30);
			inst4.setBounds(20, 260, 1500, 30);
			imageLabel.setBounds(20,340,550,550);
			imageLabel.addMouseListener(new MyMouseListener());
			setVisible(true);
		}
		Panel1(Color color){
			setBackground(color);
			setLayout(null);
			setSize(1500,850);
			JLabel hey=new JLabel("�ٽ� ������ '���� �����' > '����' �� Ŭ���ϼ���.");
			add(hey);
			hey.setFont(new Font("�������",Font.BOLD,30));
			hey.setBounds(20, 400, 1000, 30);
		}
	}
	class MyMouseListener extends MouseAdapter{ //��ư �̹��� Ŭ���Ҷ�
		public void mouseClicked(MouseEvent e) { 
			createMenu(); //�޴��� �����
			panel2=new Panel2();
			setContentPane(panel2); //������ǳڷ� �ٲٱ�
		}
	}
	class Panel2 extends JPanel{//����� �ǳ�
		Panel2(){
			JLabel label;
			setSize(1500,830);
			setBackground(Color.BLACK);
			setLayout(new GridLayout(10,10,1,1));
			for(int i=0;i<100;i++) {
				int num=i+1;
				label=new JLabel();
				label.setOpaque(true);
				add(label);
				label.setBackground(new Color(0xF5F6F6));
				label.setFont(new Font("�������",Font.BOLD,25));
				label.addMouseListener(new MyMouseListener2());
			}
			setVisible(true);
		}
	}
	class MyMouseListener2 extends MouseAdapter{//������� �� ��ȣ �� ���� ��
		public void mouseClicked(MouseEvent e) {
			JLabel la=(JLabel)e.getSource();
			String foodname=JOptionPane.showInputDialog("���� �̸��� �Է��ϼ���.");
			if(foodname!=null) 
				la.setText(foodname);
			else {}
			la.setFont(new Font("�������",Font.BOLD,30));
			//�˾�â
			//���� �̸��̶� ������� �ޱ�
			//�� setText(�����̸�)
			//
		}
		//public void timecalculate(������ѳ�¥){
		//LocalDate localDate=LocalDate.now(ZoneId.of("GMT+09:00"));
		//}
	}
	private void MenuExit() {
		int result=JOptionPane.showConfirmDialog(null, "���� �����Ͻðڽ��ϱ�?","����",JOptionPane.YES_NO_OPTION);

		if(result==JOptionPane.CLOSED_OPTION);
		else if(result==JOptionPane.YES_OPTION) {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		else;
	}
	class MenuActionListener implements ActionListener{ //�޴� Ŭ������ ��
		public void actionPerformed(ActionEvent e) {
			String cmd=e.getActionCommand();
			switch(cmd) {
			case "�����": 
				setContentPane(new Panel1(new Color(0xF5F6F6)));
				break;
			case "����":
				setContentPane(panel2);
				break;
			case "�����ϱ�":
				int result=JOptionPane.showConfirmDialog(null, "���� �����Ͻðڽ��ϱ�?","����",JOptionPane.YES_NO_OPTION);
				if(result==JOptionPane.CLOSED_OPTION);
				else if(result==JOptionPane.YES_OPTION) {
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
				else;
				break;
			case "��� ���":
				new Menu�����();
				break;
			case "�ʱ�ȭ":
				new Menu�ʱ�ȭ();
				break;
			}
			//p.420����
		}
	}
}

