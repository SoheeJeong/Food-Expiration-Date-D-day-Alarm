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
		JMenuItem HowtoMenu=new JMenuItem("사용방법");
		JMenuItem clearMenu=new JMenuItem("새로고침");
		JMenuItem exitMenu=new JMenuItem("종료하기");

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
		Panel1(){	//완전 시작페이지 판넬 생성자
			setBackground(new Color(0xE7E5FD));
			setLayout(null);
			//냉장고 정보 입력하기
			String name=JOptionPane.showInputDialog("이름을 입력하세요.");
			JLabel greet=new JLabel(name+"님 안녕하세요.");
			JLabel inst1=new JLabel("사용 방법: 아무 네모칸이나 눌러서 유통기한을 입력합니다.");
			JLabel inst2=new JLabel("날짜가 임박하면 색깔이 바뀝니다.");
			JLabel inst3=new JLabel("자세한 설명은 \"사용 방법\"메뉴를 참고하세요.");
			JLabel inst4=new JLabel("시작하려면 버튼을 클릭하세요!");

			ImageIcon image=new ImageIcon("push.png");
			Image img=image.getImage();
			Image changedImg=img.getScaledInstance(350,350, Image.SCALE_SMOOTH);
			ImageIcon Icon=new ImageIcon(changedImg);
			JLabel imageLabel=new JLabel(Icon);

			add(greet);add(inst1);add(inst2);add(inst3);add(inst4);add(imageLabel);

			greet.setFont(new Font("맑은고딕",Font.BOLD,30));
			inst1.setFont(new Font("맑은고딕",Font.BOLD,30));
			inst2.setFont(new Font("맑은고딕",Font.BOLD,30));
			inst3.setFont(new Font("맑은고딕",Font.BOLD,30));
			inst4.setFont(new Font("맑은고딕",Font.BOLD,30));

			greet.setBounds(20, 40, 1000, 30);
			inst1.setBounds(20, 100, 1000, 30);
			inst2.setBounds(20, 160, 1000, 30);
			inst3.setBounds(20, 220, 1000, 30);
			inst4.setBounds(20, 280, 1500, 30);
			imageLabel.setBounds(10,330,400,400);
			imageLabel.addMouseListener(new MyMouseListener());
			setVisible(true);
		}
		Panel1(Color color){	//숨기기 했을때 판넬 생성자
			setBackground(color);
			setLayout(null);
			setSize(1500,850);
		}
	}
	class MyMouseListener extends MouseAdapter{ //Panel1의 버튼 이미지 클릭할때
		public void mouseClicked(MouseEvent e) { 
			createMenu(); //메뉴바 만들기
			panel2=new Panel2();
			setContentPane(panel2); //냉장고판넬로 바꾸기
			key=JOptionPane.showInputDialog("비밀번호를 설정하세요.");
		}
	}
	class Panel2 extends JPanel{//냉장고 판넬
		Panel2(){ //라벨을 배열에 넣기...나중에 참조하게!!
			setSize(1500,830);
			setBackground(Color.BLACK);
			setLayout(new GridLayout(10,10,1,1));
			for(int i=0;i<100;i++) {
				label[i]=new JLabel();
				label[i].setOpaque(true);
				add(label[i]);
				label[i].setBackground(new Color(0xF5F6F6));
				label[i].setFont(new Font("맑은고딕",Font.BOLD,25));
				label[i].addMouseListener(new MyMouseListener2());
			}
			setVisible(true);
		}
	}
	class MyMouseListener2 extends MouseAdapter{//////////
		public void mouseClicked(MouseEvent e) {//Panel2의 각 라벨 누를 때
			JLabel la=(JLabel)e.getSource();
			la.setFont(new Font("맑은고딕",Font.BOLD,30));
			String foodname = null;
			String expdate=null;
			String year=null;
			String month=null;
			String day=null;
			foodname=JOptionPane.showInputDialog("음식 이름을 입력하세요.");
			if(foodname!=null) {
				la.setText(foodname);
				year=JOptionPane.showInputDialog("유통기한 [yyyy년](year)을 숫자만 입력하세요.");
				month=JOptionPane.showInputDialog("유통기한 [MM월](month)을 숫자만 입력하세요.");
				day=JOptionPane.showInputDialog("유통기한 [dd일](date)을 숫자만 입력하세요.");

				for(int i=0;i<100;i++) {
					if(InitialMenu.label[i]==la) {
						//배열에 유통기한 데이터값 넣기
						arrYEAR[i]=Integer.parseInt(year); 
						arrMONTH[i]=Integer.parseInt(month);
						arrDAY[i]=Integer.parseInt(day);
						//배경색 바꾸기
						label[i].setBackground(SetColor(timecalculate(arrYEAR[i],arrMONTH[i],arrDAY[i])));
						label[i].setOpaque(true);
					}
				}
			}
			else {}
		}
	}

	public int timecalculate(int year,int month, int day){ //dday 계산기
		try {
			TimeZone tz=TimeZone.getTimeZone("Asia/Seoul");
			Calendar today=Calendar.getInstance(tz);
			Calendar dday = Calendar.getInstance(tz);
			dday.set(year, month-1,day); ///왜인지는 모르겠는데 여기서 1 뺴야됨...왜지..?;;
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

	class InstructionPanel extends JPanel{ //사용방법
		InstructionPanel(){
			setSize(1500,850);
			ImageIcon image=new ImageIcon("사용방법.png");
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

	class MenuActionListener implements ActionListener{ //메뉴 클릭했을 때
		public void actionPerformed(ActionEvent e) {
			String cmd=e.getActionCommand();
			switch(cmd) {
			case "숨기기": 
				setContentPane(new Panel1(new Color(0xF5F6F6)));
				break;
			case "보기":
				String answer=JOptionPane.showInputDialog("비밀번호를 입력하세요.");
				if(answer.equals(key)) {
					setContentPane(panel2);
				}
				else {
					JOptionPane.showMessageDialog(null, "틀렸습니다", "WRONG", JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "종료하기":
				int result=JOptionPane.showConfirmDialog(null, "정말 종료하시겠습니까?","종료",JOptionPane.YES_NO_OPTION);
				if(result==JOptionPane.CLOSED_OPTION) {
					setContentPane(panel2);
				}
				else if(result==JOptionPane.YES_OPTION) {
					dispose();
				}
				else {} 
				break;
			case "사용방법":
				setContentPane(new InstructionPanel());
				break;
			case "새로고침":
				for(int i=0;i<100;i++) {
					//배경색 바꾸기
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

