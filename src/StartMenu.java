import javax.swing.*;
import java.awt.*;

public class StartMenu extends JFrame{
	public StartMenu(){
		setTitle("½ÃÀÛÈ­¸é");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1500,850);
		setLocationRelativeTo(null); //ÀÌ°Ç ¹ºÀÇ¹ÌÁö
		setLayout(new BorderLayout());
		setContentPane(new JLabel(new ImageIcon("½ÃÀÛÈ­¸é4.png")));
		setLayout(new FlowLayout());
		JLabel wc=new JLabel("Welcome!");
		add(wc);
		setSize(999,849);
		setSize(1500,850);
		setResizable(false);
		setLayout(null);
		Color color=new Color(0xE1F5A9);
		
		
		JLabel inst=new JLabel("³ÃÀå°íÀÇ Ãþ¼ö¿Í °¢ ÃþÀÇ °¡·Î, ¼¼·Î Ä­ ¼ö¸¦ ÀÔ·ÂÇÏ¼¼¿ä.");
		JLabel garo=new JLabel("°¡·Î Ä­ ¼ö");
		JLabel sero=new JLabel("¼¼·Î Ä­ ¼ö");
		JLabel nopi=new JLabel("³ôÀÌ Ãþ ¼ö");
		JTextField tfgaro=new JTextField(20);
		JTextField tfsero=new JTextField(20);
		JTextField tfnopi=new JTextField(20);
		JButton Done=new JButton("ÀÛ¼º ¿Ï·á");
		
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
		
		inst.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,21));
		garo.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,18));
		sero.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,18));
		nopi.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,18));
		Done.setFont(new Font("¸¼Àº°íµñ",Font.BOLD,18));
		
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
