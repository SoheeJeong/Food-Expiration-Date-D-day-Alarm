import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu나의냉장고 extends JFrame{
	public Menu나의냉장고() {
		//MouseEvent로 한번 누르면 숨기기, 다시 누르면 나타나기
		setTitle("나의 냉장고");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1500,800);
		setLocationRelativeTo(null);
		setSize(1500,800);
		setResizable(false);
		setLayout(new GridLayout(10,10));
	}

}


