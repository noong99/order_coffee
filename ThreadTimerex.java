import java.awt.*;
import javax.swing.*;
import java.util.*;

public class  ThreadTimerex extends JPanel // Thread Timer 실행
{
	public ThreadTimerex(){
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setLayout(new FlowLayout());
		JLabel timerlb = new JLabel(); // 몇초 지나가고 있는지 표시 
		JLabel timertxt = new JLabel("초동안 주문하고 계십니다."); // 몇초 뒤의 설명 달기
		timerlb.setFont(new Font("Gothic",Font.ITALIC, 20));

		TimerThread tith = new TimerThread(timerlb);
		add(timerlb);
		add(timertxt);

		tith.start();
	}
}
