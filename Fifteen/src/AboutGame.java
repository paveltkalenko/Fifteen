import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;
public class AboutGame extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3896057806450229786L;

	AboutGame(JFrame Owner)
	{
		super(Owner,"Об игре",true);
		setLayout(new BorderLayout(0, 0));
		//this.setTitle("Об игре");
		JLabel author= new JLabel("<html><h1>Пятнашки</h1><hr>Автор:Ткаленко Павел</html>");
		add(author,BorderLayout.NORTH);
		JButton Ok = new JButton("Ok");
		add(Ok,BorderLayout.SOUTH);
		
		

		Ok.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				dispose();
			}
		});
		setSize(180, 180);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
