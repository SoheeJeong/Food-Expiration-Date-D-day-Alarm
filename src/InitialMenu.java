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
		JLabel inst=new JLabel("�ƹ� ĭ�̳� Ŭ���ϼ���!");
		
		setVisible(true);

	}
	private void createMenu() {
		JMenuBar mb=new JMenuBar();
		JMenu refMenu=new JMenu("���� �����");
		JMenu showColor=new JMenu("���� ����");
		JMenu clearMenu=new JMenu("�ʱ�ȭ");
		JMenu exitMenu=new JMenu("����");

		mb.add(refMenu);
		mb.add(showColor);
		mb.add(clearMenu);
		mb.add(exitMenu);
		setJMenuBar(mb);
		mb.setSize(1500,200);
		setVisible(true);
	}

	class MyMouseListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			JButton btn=(JButton)e.getSource();
			if(btn.getText().equals("�ۼ� �Ϸ�")) {
				createMenu(); //�޴��� �����
			}
		}
	}

	class MenuActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String cmd=e.getActionCommand();
			switch(cmd) {
			case "���� �����": 
			case "���� ����":
			case "�ʱ�ȭ":
			case "����":
			}
		}
	}
}
