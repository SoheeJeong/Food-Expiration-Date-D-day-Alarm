import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("unused")
public class refregerator extends JFrame{
		public refregerator(){
		//층수->객체배열만들기
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
			setTitle(floor+"층에 오신 것을 환영합니다!");
			//냉장고 가로세로 받아서 grid 생성 코드
			//사용자가 데이터 입력하는 코드
		}

	}

}
