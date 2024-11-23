import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class OrderDialog extends JDialog {
	JTextField tf;
	JButton ok;
	JButton no;

	public OrderDialog (JFrame frame, String title){
		super(frame, title);
		setLayout(new FlowLayout());

		ok = new JButton("OK");
		add(ok); // JFrame�� ok, �� ok button �߰�

		no = new JButton("NO");
		add(no);

		setSize(200,200); // JFrame�� ������ ����
		
		// ok ��ư�� ������ �� DialogCall.java���� ������ Test Dialog â�� �Ⱥ��̰��ϴ� event
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				}
			});
		
		no.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new InnerFrameOrder("Order");
				setVisible(false);
			}
		});
	}
}