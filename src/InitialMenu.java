import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InitialMenu extends JFrame{
	public static JButton Done;
	public static int refgaro;
	public static int refsero;
	public static int refnopi;
	
	public InitialMenu() {
		setTitle("�޴�ȭ��");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1500,850);
		setLocationRelativeTo(null); 
		setLayout(null);
		Component c=getContentPane();
		c.setBackground(StartMenu.color);
	
		//����� ���� �Է��ϱ�
		JLabel inst=new JLabel("������� ������ �� ���� ����, ���� ĭ ���� �Է��ϼ���.");
		JLabel garo=new JLabel("���� ĭ ��");
		JLabel sero=new JLabel("���� ĭ ��");
		JLabel nopi=new JLabel("���� �� ��");
		JButton Done=new JButton("�ۼ� �Ϸ�");

		inst.setBackground(StartMenu.color);
		garo.setBackground(StartMenu.color);
		sero.setBackground(StartMenu.color);
		nopi.setBackground(StartMenu.color);

		IntegerField tfgaro=new IntegerField(20);
		IntegerField tfsero=new IntegerField(20);
		IntegerField tfnopi=new IntegerField(20);
		int refgaro=tfgaro.getInt(); //����� ����ĭ��
		int refsero=tfsero.getInt(); //����
		int refnopi=tfnopi.getInt(); //����
		
		//����ó���ϱ�

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
	private void createMenu() {
		JMenuBar mb=new JMenuBar();
		JMenu refMenu=new JMenu("���� �����");
		JMenu todayMenu=new JMenu("������ ��¥");
		JMenu clearMenu=new JMenu("�ʱ�ȭ");

		int num=refnopi;
		for(int i=1;i<=num;i++) {
			String menu=Integer.toString(i)+"��";
			JMenuItem item=new JMenuItem(menu);
			item.addActionListener(new MenuActionListener());
			refMenu.add(item);
		}
		mb.add(refMenu);
		mb.add(todayMenu);
		mb.add(clearMenu);
		setJMenuBar(mb);
		mb.setSize(1500,200);
		setVisible(true);
	}
	
	class MyMouseListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			JButton btn=(JButton)e.getSource();
			if(btn.getText().equals("�ۼ� �Ϸ�")) {
				//�޴��� �����
				createMenu();
			}
		}
	}
	
	class MenuActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JMenuItem item=(JMenuItem)e.getSource();
			for(int i=0;i<refnopi;i++) {
			if(item.getText().equals(i+"��")) {
				
			}
			}
		}
	}

	public static void main(String[]args) {
		new InitialMenu();
	}
}
