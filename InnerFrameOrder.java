import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class InnerFrameOrder extends JDialog{
	JFrame jf;

	// InnerFrame을 한개 만들고자함
	JInternalFrame inframe1;
	// JDesktopPane 선언 잊으면 안됨
	JDesktopPane desktop; // Inner Frame의 상위 Panel
	JLabel again;
	JButton ok;

	public InnerFrameOrder(String msg){

		jf= new JFrame(msg);

		inframe1 = new JInternalFrame("Inner Frame 1");
		inframe1.setTitle(" "); // innerframe의 title은 없는게 깔끔할 것 같아서 
		
		// 모든 inframe1를 desktop에 나중에 붙여줘야함
		desktop = new JDesktopPane();

		// Inner Frame setting
		// inframe1 - 버튼 삽입

		ok = new JButton("Ok");
		again = new JLabel("다시 선택해주세요. 다시 메뉴창으로 돌아갑니다.");

		inframe1.getContentPane().add(ok, BorderLayout.SOUTH);
		inframe1.getContentPane().add(again, BorderLayout.CENTER);
		inframe1.setSize(430,210);
		inframe1.setVisible(true);

		// Inner Frame 붙이기
		desktop.add(inframe1);

		// JFrame setting
		jf.getContentPane().add(desktop);
		jf.setSize(450,250);

		jf.setVisible(true);		

		ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				jf.setVisible(false);
			}
		});
	}
}