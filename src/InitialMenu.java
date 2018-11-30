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
		setTitle("메뉴화면");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1500,850);
		setLocationRelativeTo(null); 
		setLayout(new FlowLayout());
		setSize(1500,850); //창 크기
		setResizable(false);
		setLayout(null);
		Container c=getContentPane();
		panel1=new Panel1(); //설명 판넬 붙이기
		setContentPane(panel1); //panel1을 판넬로 사용
		setVisible(true);
	}
	private void createMenu() {//메뉴 만들기
		JMenuBar mb=new JMenuBar();
		JMenu refMenu=new JMenu("나의 냉장고");
		JMenu setting=new JMenu("설정");

		mb.add(refMenu);
		mb.add(setting);

		JMenuItem hide=new JMenuItem("숨기기");
		JMenuItem show=new JMenuItem("보기");
		JMenuItem HowtoMenu=new JMenu("사용방법");
		JMenuItem clearMenu=new JMenu("새로고침");
		JMenuItem exitMenu=new JMenu("종료하기");

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
	class Panel1 extends JPanel{//설명창 판넬
		Panel1(){
			setBackground(StartMenu.color);
			setLayout(null);
			//냉장고 정보 입력하기
			JTextField name=new JTextField();
			System.out.print(StartMenu.Lastname+StartMenu.Firstname);
			//name.setText(StartMenu.Lastname+StartMenu.Firstname);
			JLabel greet=new JLabel("님 안녕하세요.");
			JLabel inst1=new JLabel("사용 방법: 아무 네모칸이나 눌러서 유통기한을 입력합니다.");
			JLabel inst2=new JLabel("날짜가 임박하면 색깔이 바뀝니다.");
			JLabel inst3=new JLabel("자세한 설명은 \"사용 방법\"메뉴를 참고하세요.");
			JLabel inst4=new JLabel("시작하려면 버튼을 클릭하세요!");
			JTextField pobu=new JTextField();
			System.out.print(StartMenu.Yourpobu);
			//pobu.setText(StartMenu.Yourpobu);
			JLabel imageLabel=new JLabel(new ImageIcon("버튼2.png"));
			//버튼이미지 넣기
			add(name);add(greet);add(inst1);add(inst2);add(inst3);add(inst4);add(imageLabel);add(pobu);

			name.setFont(new Font("맑은고딕",Font.BOLD,30));
			greet.setFont(new Font("맑은고딕",Font.BOLD,30));
			inst1.setFont(new Font("맑은고딕",Font.BOLD,30));
			inst2.setFont(new Font("맑은고딕",Font.BOLD,30));
			inst3.setFont(new Font("맑은고딕",Font.BOLD,30));
			inst4.setFont(new Font("맑은고딕",Font.BOLD,30));
			pobu.setFont(new Font("맑은고딕",Font.BOLD,30));

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
			JLabel hey=new JLabel("다시 보려면 '나의 냉장고' > '보기' 를 클릭하세요.");
			add(hey);
			hey.setFont(new Font("맑은고딕",Font.BOLD,30));
			hey.setBounds(20, 400, 1000, 30);
		}
	}
	class MyMouseListener extends MouseAdapter{ //버튼 이미지 클릭할때
		public void mouseClicked(MouseEvent e) { 
			createMenu(); //메뉴바 만들기
			panel2=new Panel2();
			setContentPane(panel2); //냉장고판넬로 바꾸기
		}
	}
	class Panel2 extends JPanel{//냉장고 판넬
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
				label.setFont(new Font("맑은고딕",Font.BOLD,25));
				label.addMouseListener(new MyMouseListener2());
			}
			setVisible(true);
		}
	}
	class MyMouseListener2 extends MouseAdapter{//냉장고의 각 번호 라벨 누를 때
		public void mouseClicked(MouseEvent e) {
			JLabel la=(JLabel)e.getSource();
			la.setFont(new Font("맑은고딕",Font.BOLD,30));
			if(la.getText().isEmpty()) {
				String foodname=JOptionPane.showInputDialog("음식 이름을 입력하세요.");
				//유통기한 년, 월, 일 입력받기(year,month,date)
				if(foodname!=null) 
					la.setText(foodname);
			}
			else if(!la.getText().isEmpty()){
				//이름 바꾸기or유통기한 바꾸기or<<유통기한 보기->디데이로 보기 or날짜 보기>>or초기화하기 버튼 만들기
				//아니면 새로운 프레임을 띄우던가
			}
			//배경색 바꾸기
			la.setBackground(SetColor(year,month,day));
			la.setOpaque(true);	
		}
	}
	public int timecalculate(int year,int month, int day){ //dday 계산기
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
	class SetColor{ //유통기한별 라벨색깔 세팅하기
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
	class InstructionPanel extends JPanel{ //사용 방법 이미지 만들어야됨
		InstructionPanel(){
			ImageIcon image=new ImageIcon("버튼2.png");
			Image img=image.getImage();
			Image changedImg=img.getScaledInstance(1500, 800, Image.SCALE_SMOOTH);
			ImageIcon Icon=new ImageIcon(changedImg);
			JLabel imge=new JLabel(Icon);
			setLayout(null);
			setSize(1500,850);
			add(imge);			
		}
	}
	class MenuActionListener implements ActionListener{ //메뉴 클릭했을 때
		public void actionPerformed(ActionEvent e) {
			String cmd=e.getActionCommand();
			switch(cmd) {
			case "숨기기": 
				setContentPane(new Panel1(new Color(0xF5F6F6)));
				break;
			case "보기":
				setContentPane(panel2);
				break;
			case "종료하기": //여기 왜안됨..
				int result=JOptionPane.showConfirmDialog(null, "정말 종료하시겠습니까?","종료",JOptionPane.YES_NO_OPTION);
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
			case "사용방법":
				setContentPane(instructionpanel);
				break;
			case "새로고침":
				new Menu초기화();
				break;
			}
			//p.420참고
		}
	}
}

