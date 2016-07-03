import javax.swing.*;
import java.awt.event.*;
public class MainMenu extends JMenuBar
{   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
Main parentFrame;
	public MainMenu(Main parent)
	{
		parentFrame = parent;
		JMenu MenuGame = new JMenu("Игра");
		JMenu Help = new JMenu("Помощь");
		JMenuItem aboutgame = new JMenuItem("Об игре");
		JMenuItem newgame = new JMenuItem("Новая");
	    JMenuItem лучшийрезультат = new JMenuItem("Лучший результат");
	    JMenuItem открыть = new JMenuItem("Открыть игру");
	    JMenuItem сохранить = new JMenuItem("Сохранить игру");
	    JMenuItem уровень = new JMenuItem("Изменить сложность");
		JMenuItem exit = new JMenuItem("Выход");
		MenuGame.add(newgame);
		MenuGame.add(лучшийрезультат);
		MenuGame.add(открыть);
		MenuGame.add(сохранить);
		MenuGame.add(уровень);
		MenuGame.add(exit);
		Help.add(aboutgame);
		this.add(MenuGame);
		this.add(Help);
		newgame.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ActionNewGame();
			}

		});
		exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}

		});
		лучшийрезультат.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ПоказатьЛучшийРезультат();
			}

		});
		уровень.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				LevelDifficultDialog lDD = new LevelDifficultDialog(parentFrame,parentFrame.leveldifficult);
				if (lDD.ShowDialog()) {parentFrame.leveldifficult=lDD.GetDifficult();ActionNewGame();}

			}

		});		
		aboutgame.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new AboutGame(parentFrame);
			}

		});
		
	}
	private void ПоказатьЛучшийРезультат()
	{
		parentFrame.bestresult.ShowResultWindow();
	}
	private void ActionNewGame()
	{
	//= new Timer(parentFrame.L)
		parentFrame.myTime.stopping();
	//	parentFrame.
		parentFrame.grWindow.NewGameInitalisation();
		parentFrame.myTime.setNull();
//		parentFrame.myTime.run();
	//	parentFrame.NewGameInitalisation();

	}
	

}
