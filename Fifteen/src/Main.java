import javax.swing.*;

import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
public class Main extends JFrame implements ComponentListener
{
	public GraphicWindow grWindow;
	public JLabel ClickCounter;
	private JLabel TimerLabel;
	private MainMenu mainmenu;
	public BestResult bestresult;
	public LevelDifficult leveldifficult;
	public Timer myTime;
	public Main(String title)
	{
		setTitle(title);
		 
		leveldifficult = new LevelDifficult(4,4);
	    ClickCounter = new JLabel();
	    TimerLabel = new JLabel();
	    myTime = new Timer(TimerLabel);
	    JPanel stat_panel = new JPanel();
	    stat_panel.setLayout(new GridLayout(1,2,5,5));
	    stat_panel.add(ClickCounter);
	    stat_panel.add(TimerLabel);
	   
	    setLayout(new BorderLayout(0, 0));
		ClickCounter.setText("Кол-во перемещений: 0");
		TimerLabel.setText("Затраченно времени: ");
        grWindow = new GraphicWindow(this);
		add(grWindow,BorderLayout.CENTER);		
		add(stat_panel,BorderLayout.NORTH);
		

	    bestresult = new BestResult();
	    this.addComponentListener(this);
	    mainmenu = new MainMenu(this);
        this.setJMenuBar(mainmenu);
        
        Dimension d = new Dimension();
        d.setSize(500, 560);       
        this.setPreferredSize(d);
        this.setSize(d);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        grWindow.NewGameInitalisation();
      //  myTime.run();
        myTime.start();
		

	}
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
     Main Window = new Main("Пятнашки");
 

     UIManager.put("OptionPane.yesButtonText","Да");
     UIManager.put("OptionPane.noButtonText","Нет");


   
	}
	public void componentHidden(ComponentEvent event){}
	public void componentMoved(ComponentEvent event){}
	public void componentShown(ComponentEvent event){}
	@SuppressWarnings("deprecation")
	public void componentResized(ComponentEvent event)
	{

		Dimension d=this.getPreferredSize();
		Dimension d2=this.getSize();

		if (d2.height!=d.height)
			{
				setSize(d2);
			}

	}
	
}
