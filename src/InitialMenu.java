import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.time.*;
import java.util.*;

public class InitialMenu extends JFrame{
	public static JLabel[]label=new JLabel[100];
	public static int arrYEAR[]=new int[100];
	public static int arrMONTH[]=new int[100];
	public static int arrDAY[]=new int[100];

	public static JTextField name;
	public static JTextField pobu;
	public static JButton Done;
	public static int refgaro;
	public static int refsero;
	public static int refnopi;
	public static Panel1 panel1;
	public static Panel2 panel2;
	private String key;

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
		JMenuItem HowtoMenu=new JMenuItem("�����");
		JMenuItem clearMenu=new JMenuItem("���ΰ�ħ");
		JMenuItem exitMenu=new JMenuItem("�����ϱ�");

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
		Panel1(){	//���� ���������� �ǳ� ������
			setBackground(new Color(0xE7E5FD));
			setLayout(null);
			//����� ���� �Է��ϱ�
			String name=JOptionPane.showInputDialog("�̸��� �Է��ϼ���.");
			JLabel greet=new JLabel(name+"�� �ȳ��ϼ���.");
			JLabel inst1=new JLabel("��� ���: �ƹ� �׸�ĭ�̳� ������ ��������� �Է��մϴ�.");
			JLabel inst2=new JLabel("��¥�� �ӹ��ϸ� ������ �ٲ�ϴ�.");
			JLabel inst3=new JLabel("�ڼ��� ������ \"��� ���\"�޴��� �����ϼ���.");
			JLabel inst4=new JLabel("�����Ϸ��� ��ư�� Ŭ���ϼ���!");

			ImageIcon image=new ImageIcon("push.png");
			Image img=image.getImage();
			Image changedImg=img.getScaledInstance(350,350, Image.SCALE_SMOOTH);
			ImageIcon Icon=new ImageIcon(changedImg);
			JLabel imageLabel=new JLabel(Icon);

			add(greet);add(inst1);add(inst2);add(inst3);add(inst4);add(imageLabel);

			greet.setFont(new Font("�������",Font.BOLD,30));
			inst1.setFont(new Font("�������",Font.BOLD,30));
			inst2.setFont(new Font("�������",Font.BOLD,30));
			inst3.setFont(new Font("�������",Font.BOLD,30));
			inst4.setFont(new Font("�������",Font.BOLD,30));

			greet.setBounds(20, 40, 1000, 30);
			inst1.setBounds(20, 100, 1000, 30);
			inst2.setBounds(20, 160, 1000, 30);
			inst3.setBounds(20, 220, 1000, 30);
			inst4.setBounds(20, 280, 1500, 30);
			imageLabel.setBounds(10,330,400,400);
			imageLabel.addMouseListener(new MyMouseListener());
			setVisible(true);
		}
		Panel1(Color color){	//����� ������ �ǳ� ������
			setBackground(color);
			setLayout(null);
			setSize(1500,850);
		}
	}
	class MyMouseListener extends MouseAdapter{ //Panel1�� ��ư �̹��� Ŭ���Ҷ�
		public void mouseClicked(MouseEvent e) { 
			createMenu(); //�޴��� �����
			panel2=new Panel2();
			setContentPane(panel2); //������ǳڷ� �ٲٱ�
			key=JOptionPane.showInputDialog("��й�ȣ�� �����ϼ���.");
		}
	}
	class Panel2 extends JPanel{//����� �ǳ�
		Panel2(){ //���� �迭�� �ֱ�...���߿� �����ϰ�!!
			setSize(1500,830);
			setBackground(Color.BLACK);
			setLayout(new GridLayout(10,10,1,1));
			for(int i=0;i<100;i++) {
				label[i]=new JLabel();
				label[i].setOpaque(true);
				add(label[i]);
				label[i].setBackground(new Color(0xF5F6F6));
				label[i].setFont(new Font("�������",Font.BOLD,25));
				label[i].addMouseListener(new MyMouseListener2());
			}
			setVisible(true);
		}
	}
	class MyMouseListener2 extends MouseAdapter{//////////
		public void mouseClicked(MouseEvent e) {//Panel2�� �� �� ���� ��
			JLabel la=(JLabel)e.getSource();
			la.setFont(new Font("�������",Font.BOLD,30));
			String foodname = null;
			String expdate=null;
			String year=null;
			String month=null;
			String day=null;
			foodname=JOptionPane.showInputDialog("���� �̸��� �Է��ϼ���.");
			if(foodname!=null) {
				la.setText(foodname);
				year=JOptionPane.showInputDialog("������� [yyyy��](year)�� ���ڸ� �Է��ϼ���.");
				month=JOptionPane.showInputDialog("������� [MM��](month)�� ���ڸ� �Է��ϼ���.");
				day=JOptionPane.showInputDialog("������� [dd��](date)�� ���ڸ� �Է��ϼ���.");

				for(int i=0;i<100;i++) {
					if(InitialMenu.label[i]==la) {
						//�迭�� ������� �����Ͱ� �ֱ�
						arrYEAR[i]=Integer.parseInt(year); 
						arrMONTH[i]=Integer.parseInt(month);
						arrDAY[i]=Integer.parseInt(day);
						//���� �ٲٱ�
						label[i].setBackground(SetColor(timecalculate(arrYEAR[i],arrMONTH[i],arrDAY[i])));
						label[i].setOpaque(true);
					}
				}
			}
			else {}
		}
	}

	public int timecalculate(int year,int month, int day){ //dday ����
		try {
			TimeZone tz=TimeZone.getTimeZone("Asia/Seoul");
			Calendar today=Calendar.getInstance(tz);
			Calendar dday = Calendar.getInstance(tz);
			dday.set(year, month-1,day); ///�������� �𸣰ڴµ� ���⼭ 1 ���ߵ�...����..?;;
			long ddday=dday.getTimeInMillis()/(24*60*60*1000);
			long tday=today.getTimeInMillis()/(24*60*60*1000);
			long count=ddday-tday;
			return (int)count;
		}
		catch(Exception f) {
			f.printStackTrace();
			return -1;
		}
	}

	public Color SetColor(int ddaycount) {
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

	class InstructionPanel extends JPanel{ //�����
		InstructionPanel(){
			setSize(1500,850);
			ImageIcon image=new ImageIcon("�����.png");
			Image img=image.getImage();
			Image changedImg=img.getScaledInstance(1500, 800, Image.SCALE_SMOOTH);
			ImageIcon Icon=new ImageIcon(changedImg);
			JLabel imge=new JLabel(Icon);
			setLayout(new FlowLayout());
			add(imge);		
			imge.setVisible(true);
			imge.setOpaque(true);
			setVisible(true);
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
				String answer=JOptionPane.showInputDialog("��й�ȣ�� �Է��ϼ���.");
				if(answer.equals(key)) {
					setContentPane(panel2);
				}
				else {
					JOptionPane.showMessageDialog(null, "Ʋ�Ƚ��ϴ�", "WRONG", JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "�����ϱ�":
				int result=JOptionPane.showConfirmDialog(null, "���� �����Ͻðڽ��ϱ�?","����",JOptionPane.YES_NO_OPTION);
				if(result==JOptionPane.CLOSED_OPTION) {
					setContentPane(panel2);
				}
				else if(result==JOptionPane.YES_OPTION) {
					dispose();
				}
				else {} 
				break;
			case "�����":
				setContentPane(new InstructionPanel());
				break;
			case "���ΰ�ħ":
				for(int i=0;i<100;i++) {
					//���� �ٲٱ�
					if(!label[i].getText().isEmpty()) {
						label[i].setBackground(SetColor(timecalculate(arrYEAR[i],arrMONTH[i],arrDAY[i])));
						label[i].setOpaque(true);
					}
				}
				break;
			}
		}
	}
}

