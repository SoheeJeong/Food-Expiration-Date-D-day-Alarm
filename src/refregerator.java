import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("unused")
public class refregerator extends JFrame{
		public refregerator(){
		//����->��ü�迭�����
		Refre[]r=new Refre[InitialMenu.refnopi];
		for(int i=0;i<r.length;i++) {
			r[i]=new Refre(i+1);
		}
	}
	static class Refre extends JFrame{
		int floor;
		public Refre(int floor) {
			this.floor=floor;
		}
		public void getRefre() {
			setTitle(floor+"���� ���� ���� ȯ���մϴ�!");
			//����� ���μ��� �޾Ƽ� grid ���� �ڵ�
			//����ڰ� ������ �Է��ϴ� �ڵ�
		}

	}

}
