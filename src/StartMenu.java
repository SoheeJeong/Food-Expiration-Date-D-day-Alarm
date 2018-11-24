import javax.swing.*;
import java.awt.*;

public class StartMenu extends JFrame{
	public StartMenu(){
		setTitle("시작화면");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1500,850);
		setLocationRelativeTo(null); //이건 뭔의미지
		setLayout(new BorderLayout());
		setContentPane(new JLabel(new ImageIcon("시작화면4.png")));
		setLayout(new FlowLayout());
		JLabel wc=new JLabel("Welcome!");
		add(wc);
		setSize(999,849);
		setSize(1500,850);
		setResizable(false);
		setLayout(null);
		Color color=new Color(0xE1F5A9);
		
		
		JLabel inst=new JLabel("냉장고의 층수와 각 층의 가로, 세로 칸 수를 입력하세요.");
		JLabel garo=new JLabel("가로 칸 수");
		JLabel sero=new JLabel("세로 칸 수");
		JLabel nopi=new JLabel("높이 층 수");
		JTextField tfgaro=new JTextField(20);
		JTextField tfsero=new JTextField(20);
		JTextField tfnopi=new JTextField(20);
		JButton Done=new JButton("작성 완료");
		
		inst.setBackground(color);
		garo.setBackground(color);
		sero.setBackground(color);
		nopi.setBackground(color);
		
		inst.setBounds(150,340,700,30);
		garo.setBounds(200,400,100,30);
		sero.setBounds(200,440,100,30);
		nopi.setBounds(200,480,100,30);
		
		tfgaro.setBounds(350,400,150,30);
		tfsero.setBounds(350,440,150,30);
		tfnopi.setBounds(350,480,150,30);
		Done.setBounds(280,550,150,30);
		
		inst.setFont(new Font("HY엽서L",Font.BOLD,20));
		garo.setFont(new Font("HY엽서L",Font.BOLD,18));
		sero.setFont(new Font("HY엽서L",Font.BOLD,18));
		nopi.setFont(new Font("HY엽서L",Font.BOLD,18));
		Done.setFont(new Font("HY엽서L",Font.BOLD,18));
		
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
	public static void main(String[]args) {
		new StartMenu();		
	}
}
