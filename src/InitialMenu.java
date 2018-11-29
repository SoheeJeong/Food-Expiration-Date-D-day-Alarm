import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InitialMenu extends JFrame{
	public static JButton Done;
	public static int refgaro;
	public static int refsero;
	public static int refnopi;

	public InitialMenu() {
		setTitle("메뉴화면");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1500,850);
		setLocationRelativeTo(null); 
		setLayout(null);
		Component c=getContentPane();
		c.setBackground(StartMenu.color);

		//냉장고 정보 입력하기
		JLabel inst=new JLabel("아무 칸이나 클릭하세요!");
		
		setVisible(true);

	}
	private void createMenu() {
		JMenuBar mb=new JMenuBar();
		JMenu refMenu=new JMenu("나의 냉장고");
		JMenu showColor=new JMenu("색깔 보기");
		JMenu clearMenu=new JMenu("초기화");
		JMenu exitMenu=new JMenu("종료");

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
			if(btn.getText().equals("작성 완료")) {
				createMenu(); //메뉴바 만들기
			}
		}
	}

	class MenuActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String cmd=e.getActionCommand();
			switch(cmd) {
			case "나의 냉장고": 
			case "색깔 보기":
			case "초기화":
			case "종료":
			}
		}
	}
}
