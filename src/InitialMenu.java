import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class InitialMenu extends JFrame{
	public static JTextField name;
	public static JTextField pobu;
	public static JButton Done;
	public static int refgaro;
	public static int refsero;
	public static int refnopi;
	public static Panel1 panel1;
	public static Panel2 panel2;
	public static InstructionPanel instructionpanel;
	
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
		JMenuItem HowtoMenu=new JMenu("�����");
		JMenuItem clearMenu=new JMenu("���ΰ�ħ");
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
			JTextField name=new JTextField();
			System.out.print(StartMenu.Lastname+StartMenu.Firstname);
			//name.setText(StartMenu.Lastname+StartMenu.Firstname);
			JLabel greet=new JLabel("�� �ȳ��ϼ���.");
			JLabel inst1=new JLabel("��� ���: �ƹ� �׸�ĭ�̳� ������ ��������� �Է��մϴ�.");
			JLabel inst2=new JLabel("��¥�� �ӹ��ϸ� ������ �ٲ�ϴ�.");
			JLabel inst3=new JLabel("�ڼ��� ������ \"��� ���\"�޴��� �����ϼ���.");
			JLabel inst4=new JLabel("�����Ϸ��� ��ư�� Ŭ���ϼ���!");
			JTextField pobu=new JTextField();
			System.out.print(StartMenu.Yourpobu);
			//pobu.setText(StartMenu.Yourpobu);
			JLabel imageLabel=new JLabel(new ImageIcon("��ư2.png"));
			//��ư�̹��� �ֱ�
			add(name);add(greet);add(inst1);add(inst2);add(inst3);add(inst4);add(imageLabel);add(pobu);

			name.setFont(new Font("�������",Font.BOLD,30));
			greet.setFont(new Font("�������",Font.BOLD,30));
			inst1.setFont(new Font("�������",Font.BOLD,30));
			inst2.setFont(new Font("�������",Font.BOLD,30));
			inst3.setFont(new Font("�������",Font.BOLD,30));
			inst4.setFont(new Font("�������",Font.BOLD,30));
			pobu.setFont(new Font("�������",Font.BOLD,30));

			pobu.setBounds(20, 10, 150, 30);
			name.setBounds(20, 40, 100, 30);
			greet.setBounds(120, 40, 1000, 30);
			inst1.setBounds(20, 100, 1000, 30);
			inst2.setBounds(20, 160, 1000, 30);
			inst3.setBounds(20, 220, 1000, 30);
			inst4.setBounds(20, 280, 1500, 30);
			imageLabel.setBounds(20,360,550,550);
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
			JLabel label = null;
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
			la.setFont(new Font("�������",Font.BOLD,30));
			if(la.getText().isEmpty()) {
				String foodname=JOptionPane.showInputDialog("���� �̸��� �Է��ϼ���.");
				//������� ��, ��, �� �Է¹ޱ�(year,month,date)
				if(foodname!=null) 
					la.setText(foodname);
			}
			else if(!la.getText().isEmpty()){
				//�̸� �ٲٱ�or������� �ٲٱ�or<<������� ����->���̷� ���� or��¥ ����>>or�ʱ�ȭ�ϱ� ��ư �����
				//�ƴϸ� ���ο� �������� ������
			}
			//���� �ٲٱ�
			la.setBackground(SetColor(year,month,day));
			la.setOpaque(true);	
		}
	}
	public int timecalculate(int year,int month, int day){ //dday ����
		try {
			Calendar today=Calendar.getInstance();
			Calendar dday=Calendar.getInstance();
			dday.set(year, month,day);
			long ddday=dday.getTimeInMillis()/(24*60*60*1000);
			long tday=today.getTimeInMillis()/(24*60*60*1000);
			long count=tday-ddday;
			return (int)count+1;
		}
		catch(Exception f) {
			f.printStackTrace();
			return -1;
		}
	}
	class SetColor{ //������Ѻ� �󺧻��� �����ϱ�
		public Color SetColor(int year,int month,int day) {
			int ddaycount=timecalculate(year,month,day);
			Color colors = null;
			if(ddaycount<=1) {
				colors=new Color(0xFC2F2F);
			}
			else if(1<ddaycount&&ddaycount<=4) {
				colors=new Color(0xF99E1E);
			}
			else if(4<ddaycount&&ddaycount<=7) {
				colors= new Color(0xF4E228);
			}
			else if(7<ddaycount&&ddaycount<=14) {
				colors=new Color(0x8BF462);
			}
			else if(14<ddaycount) {
				colors= new Color(0x2FC0F1);
			}
			return colors;
		}
	}
	class InstructionPanel extends JPanel{ //��� ��� �̹��� �����ߵ�
		InstructionPanel(){
			ImageIcon image=new ImageIcon("��ư2.png");
			Image img=image.getImage();
			Image changedImg=img.getScaledInstance(1500, 800, Image.SCALE_SMOOTH);
			ImageIcon Icon=new ImageIcon(changedImg);
			JLabel imge=new JLabel(Icon);
			setLayout(null);
			setSize(1500,850);
			add(imge);			
		}
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
			case "�����ϱ�": //���� �־ȵ�..
				int result=JOptionPane.showConfirmDialog(null, "���� �����Ͻðڽ��ϱ�?","����",JOptionPane.YES_NO_OPTION);
				if(result==JOptionPane.CLOSED_OPTION) {
					setContentPane(panel2);
				}
				else if(result==JOptionPane.YES_OPTION) {
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
				else {
					setContentPane(panel2);
				}
				break;
			case "�����":
				setContentPane(instructionpanel);
				break;
			case "���ΰ�ħ":
				new Menu�ʱ�ȭ();
				break;
			}
			//p.420����
		}
	}
}

