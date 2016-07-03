import java.awt.BorderLayout;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
//import javax.swing.JPanel;
import javax.swing.JSlider;


public class LevelDifficultDialog extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7958710582125035818L;
	private JSlider RowSlider;
	private JSlider ColumnSlider;
	private boolean ok;
	LevelDifficult ld;
	
	public LevelDifficultDialog(JFrame Owner,LevelDifficult LD) {
		super(Owner, "Уровень сложности", true);
		ok=false;
		ld=LD;
	    GridLayout gl = new GridLayout(3,2,0,5);
	    setSize(300,200);
	    setLocationRelativeTo(null);
		setLayout(new BorderLayout(5,10));
		setLayout(gl);
		RowSlider = new JSlider();
		RowSlider.setMaximum(10);
		RowSlider.setMinimum(2);
		RowSlider.setPaintLabels(true);
		RowSlider.setPaintTicks(true);
		RowSlider.setMajorTickSpacing(1);
		RowSlider.setMinorTickSpacing(1);
		RowSlider.setPaintTrack(true);
		ColumnSlider = new JSlider();
		ColumnSlider.setMaximum(10);
		ColumnSlider.setPaintLabels(true);
		ColumnSlider.setPaintTicks(true);
		ColumnSlider.setMajorTickSpacing(1);
		ColumnSlider.setMinorTickSpacing(1);
		ColumnSlider.setPaintTrack(true);
		ColumnSlider.setMinimum(2);
		add(new JLabel("Строк"));
		add(RowSlider);
		add(new JLabel("Столбцов"));
		add(ColumnSlider);
		
	//	add(pl,BorderLayout.NORTH);
		JButton jbOk = new JButton("Ok");
		JButton jbCancel = new JButton("Отмена");
		
		add(jbOk);
		add(jbCancel);
		
		jbOk.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ld = new LevelDifficult(ColumnSlider.getValue(),RowSlider.getValue());
				setVisible(false);
				ok=true;
			}
		});
		jbCancel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				dispose();
				//ok=true;
			}
		});

		// TODO Auto-generated constructor stub
	}
	public boolean ShowDialog()
	{
		ColumnSlider.setValue(ld.getColumns());
		RowSlider.setValue(ld.getRow());
		setVisible(true);
		return ok;
	}
	public LevelDifficult GetDifficult()
	{
		return ld;
	}


}
