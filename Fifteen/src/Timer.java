import java.util.*;
import javax.swing.*;
//import java.
public class Timer extends Thread {
    private JLabel LabelTimer;
	private volatile int CurrentTime;
    private volatile boolean can_running;
	public Timer(JLabel LT)
	{
		can_running=true;
		LabelTimer=LT;
		CurrentTime=0;

	}

	@Override
    public void run()
    {
    	while(true)
		{
			CurrentTime = 0;
			while (can_running)
			{
				if (!Thread.interrupted())
				{

					CurrentTime++;
					//sleep(100)
					int seconds = CurrentTime / 100;
					int minutes = seconds / 60;
					seconds %= 60;
					String time = minutes+":" + seconds+"."+(CurrentTime%100);
					LabelTimer.setText("Затраченно времени: " + time);
					// if (CurrentTime==100) can_running=false;
					LabelTimer.updateUI();

					try
					{
						Thread.sleep(10);
					} catch (InterruptedException ex)
					{
						ex.printStackTrace();
					}
				}
				else
				{
						return;
				}

			}
			Thread.yield();


		}

      
    }
    public void stopping()
    {
    	can_running=false;
    	return;
    }
    
    public int GetTime()
    {
    	return CurrentTime;
    }
    public void setNull()
    {
    	CurrentTime=0;
   // 	LabelTimer.setText("Затраченно времени: "+CurrentTime);
    	can_running=true;
    }
    

}
