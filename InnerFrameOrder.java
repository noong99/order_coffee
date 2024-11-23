import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class InnerFrameOrder extends JDialog{
	JFrame jf;

	// InnerFrame�� �Ѱ� ���������
	JInternalFrame inframe1;
	// JDesktopPane ���� ������ �ȵ�
	JDesktopPane desktop; // Inner Frame�� ���� Panel
	JLabel again;
	JButton ok;

	public InnerFrameOrder(String msg){

		jf= new JFrame(msg);

		inframe1 = new JInternalFrame("Inner Frame 1");
		inframe1.setTitle(" "); // innerframe�� title�� ���°� ����� �� ���Ƽ� 
		
		// ��� inframe1�� desktop�� ���߿� �ٿ������
		desktop = new JDesktopPane();

		// Inner Frame setting
		// inframe1 - ��ư ����

		ok = new JButton("Ok");
		again = new JLabel("�ٽ� �������ּ���. �ٽ� �޴�â���� ���ư��ϴ�.");

		inframe1.getContentPane().add(ok, BorderLayout.SOUTH);
		inframe1.getContentPane().add(again, BorderLayout.CENTER);
		inframe1.setSize(430,210);
		inframe1.setVisible(true);

		// Inner Frame ���̱�
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