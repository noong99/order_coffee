import javax.swing.*;
import java.awt.event.*;

class OrderCall extends JFrame { // �ֹ��ϸ� �ֹ���Ұ� �Ұ����ϴٴ� �氢���� �ο��ϱ� ���� 
	// �� java������ �⺻ �����̹Ƿ� OrderDialog�� ���� ������ ���� ����������
	OrderDialog dialog;
	JButton btn;
	JFrame jforder = new JFrame("Check again");

	public OrderCall() {
		super("Order");
		jforder.setSize(300,300);
		jforder.setVisible(true);
		String sentence = "<html>" + "���� �̴�� �ֹ��Ͻðڽ��ϱ�?" + "<br>" + "�ֹ��� �ѹ� �ϸ� �ֹ���Ұ� �Ұ����մϴ�."
			+"<br>"+"Ŭ���ϰ� OK/NO�� �������ּ���."+"<html>";
		btn = new JButton(sentence);
		
		dialog = new OrderDialog(this, "Order");
	
		// Show Dialog��� ��ư�� ������ �� Test Dialog��� dialog â�� �ߵ��� event ����
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				dialog.setVisible(true);
				jforder.setVisible(false);
			}
		});
		
		// extends�� JFrame�� btn �߰� 
		jforder.getContentPane().add(btn);	
		setDefaultCloseOperation(jforder.EXIT_ON_CLOSE);
	}
}