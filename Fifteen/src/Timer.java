import java.util.*;
import javax.swing.*;
//import java.
public class Timer extends Thread {
    private JLabel LabelTimer;
	private int CurrentTime;
    private boolean can_running;
	public Timer(JLabel LT)
	{
		can_running=true;
		LabelTimer=LT;
		CurrentTime=0;
		// TODO Auto-generated constructor stub
	}

  //  public void start()
 //   {
 //     try
//      {
    //	  while(can_running)
    	//  {
 //   	  CurrentTime++;
 //   	  sleep(100);	  
    //	  LabelTimer.setText("Затраченно времени: "+CurrentTime);
    	 // LabelTimer.updateUI();
    //	  }
 //     }
      
   //   catch(InterruptedException ex)
   //   {
    	  
 //     }
      
  //  }
    public void run()
    {
    	try
    	{
    		
    	  CurrentTime=0;
    	  while(can_running)
    	  {
    	   CurrentTime++;
    	  //sleep(100);
    	  Thread.sleep(10);
          LabelTimer.setText("Затраченно llвремени: "+CurrentTime);
         // if (CurrentTime==100) can_running=false;
    	  LabelTimer.updateUI();
    	  }
    	}
    	catch (InterruptedException ex)
        {
      	  ex.printStackTrace();
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
