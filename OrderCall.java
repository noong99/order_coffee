import javax.swing.*;
import java.awt.event.*;

class OrderCall extends JFrame { // 주문하면 주문취소가 불가능하다는 경각심을 부여하기 위해 
	// 이 java파일은 기본 파일이므로 OrderDialog에 대한 파일을 따로 만들어줘야함
	OrderDialog dialog;
	JButton btn;
	JFrame jforder = new JFrame("Check again");

	public OrderCall() {
		super("Order");
		jforder.setSize(300,300);
		jforder.setVisible(true);
		String sentence = "<html>" + "정말 이대로 주문하시겠습니까?" + "<br>" + "주문을 한번 하면 주문취소가 불가능합니다."
			+"<br>"+"클릭하고 OK/NO를 선택해주세요."+"<html>";
		btn = new JButton(sentence);
		
		dialog = new OrderDialog(this, "Order");
	
		// Show Dialog라는 버튼을 눌렀을 때 Test Dialog라는 dialog 창이 뜨도록 event 설정
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				dialog.setVisible(true);
				jforder.setVisible(false);
			}
		});
		
		// extends한 JFrame에 btn 추가 
		jforder.getContentPane().add(btn);	
		setDefaultCloseOperation(jforder.EXIT_ON_CLOSE);
	}
}