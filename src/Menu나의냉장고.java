import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu���ǳ���� extends JPanel{
	JLabel label;
	public Menu���ǳ����() {
		//MouseEvent�� �ѹ� ������ �����, �ٽ� ������ ��Ÿ����
		setSize(1500,800);
		MyPanel p=new MyPanel();
		p.setSize(1500,800);
		p.setLayout(new GridLayout(10,10));
		p.setBackground(Color.WHITE);

		for(int i=0;i<100;i++) {
			int num=i;
			label=new JLabel(Integer.toString(num));
			label.setOpaque(true);
			p.add(label);
			label.setBackground(Color.LIGHT_GRAY);
			label.setFont(new Font("�������",Font.BOLD,25));
			label.addMouseListener(new MyMouseListener());
			setVisible(true);

		}
		setVisible(true);
	}
	class MyPanel extends JPanel{
		public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.LIGHT_GRAY);
		}
	}
	class MyMouseListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			JLabel la=(JLabel)e.getSource();
			//�˾�â
		}
	}
}


