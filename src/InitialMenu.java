import javax.swing.*;
import java.awt.*;

public class InitialMenu extends JFrame{
	public InitialMenu() {
		setTitle("�޴�ȭ��");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1500,850);
		Component c=getContentPane();
		c.setBackground(StartMenu.color);
		
		JMenuBar mb=new JMenuBar();
		
		setVisible(true);
	}



	public static void main(String[]args) {
		new InitialMenu();
	}
}
