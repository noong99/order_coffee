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
		add(ok); // JFrame에 ok, 즉 ok button 추가

		no = new JButton("NO");
		add(no);

		setSize(200,200); // JFrame의 사이즈 지정
		
		// ok 버튼을 눌렀을 때 DialogCall.java에서 지정한 Test Dialog 창을 안보이게하는 event
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