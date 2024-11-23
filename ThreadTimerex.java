import java.awt.*;
import javax.swing.*;
import java.util.*;

public class  ThreadTimerex extends JPanel // Thread Timer ����
{
	public ThreadTimerex(){
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setLayout(new FlowLayout());
		JLabel timerlb = new JLabel(); // ���� �������� �ִ��� ǥ�� 
		JLabel timertxt = new JLabel("�ʵ��� �ֹ��ϰ� ��ʴϴ�."); // ���� ���� ���� �ޱ�
		timerlb.setFont(new Font("Gothic",Font.ITALIC, 20));

		TimerThread tith = new TimerThread(timerlb);
		add(timerlb);
		add(timertxt);

		tith.start();
	}
}
