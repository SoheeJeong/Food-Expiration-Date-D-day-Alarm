import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
		JMenu HowtoMenu=new JMenu("��� ���");
		JMenu clearMenu=new JMenu("�ʱ�ȭ�ϱ�");
		JMenu exitMenu=new JMenu("�����ϱ�");

		mb.add(refMenu);
		mb.add(HowtoMenu);
		mb.add(clearMenu);
		mb.add(exitMenu);
		JMenuItem hide=new JMenuItem("�����");
		JMenuItem show=new JMenuItem("����");
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
			setSize(1500,850);
			setLayout(new GridLayout(10,10));
			for(int i=0;i<100;i++) {
				int num=i+1;
				label=new JLabel(Integer.toString(num));
				label.setOpaque(true);
				add(label);
				label.setBackground(Color.WHITE);
				//���м� �߰�
				label.setFont(new Font("�������",Font.BOLD,25));
				label.addMouseListener(new MyMouseListener2());
			}
			setVisible(true);
		}
	}
	class MyMouseListener2 extends MouseAdapter{//������� �� �� ���� ��
		public void mouseClicked(MouseEvent e) {
			JLabel la=(JLabel)e.getSource();
			//�˾�â
			//���� �̸��̶� ������� �ޱ�
			//�� setText(�����̸�)
			//
		}
		//	public void timecalculate(������ѳ�¥){
		//			
		//}
		class MenuActionListener implements ActionListener{ //�޴� Ŭ������ ��
			public void actionPerformed(ActionEvent e) {
				String cmd=e.getActionCommand();
				switch(cmd) {
				case "�����": 
					getContentPane().setVisible(false);
					break;
				case "����":
					getContentPane().setVisible(true);
					setContentPane(panel2);
					break;
					//p.420����
				case "��� ���":
					getContentPane().setVisible(true);
					new Menu�����();
					break;
				case "�ʱ�ȭ":
					getContentPane().setVisible(true);
					new Menu�ʱ�ȭ();
					break;
				case "����":
					getContentPane().setVisible(true);
					new Menu����();
				}
			}
		}

	}
