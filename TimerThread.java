import javax.swing.*;
import java.awt.*;

public class TimerThread extends Thread
{
	JLabel timerlb;
	public TimerThread(JLabel timerlb){
		this.timerlb = timerlb;
	}

	public void run(){
		int t = 0;
		while(true){
			timerlb.setText(Integer.toString(t));
			t++;
			try{
				Thread.sleep(1000);
			}
			catch(InterruptedException e){
				return;
			}
		}
	}
}