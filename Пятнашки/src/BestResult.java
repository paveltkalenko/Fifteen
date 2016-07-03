import java.io.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;
import java.util.*;
import java.io.FileInputStream;


public class BestResult {
	ArrayList <type_result> BestsResults; 
	private File f;
	public int BestClickCount;
	private JFrame br_frame;
	final static private String filename="result.txt";
	
	public void ShowResultWindow()
	{   
		JPanel pn = new JPanel();
		GridLayout gridL = new GridLayout(BestsResults.size()+1,3,5,5);
		
		br_frame = new JFrame("Лучший результат");
	    br_frame.setSize(400,200);
	    br_frame.setLayout(new BorderLayout(0, 0));
	    
	    br_frame.setLocationRelativeTo(null);
		br_frame.setVisible(true);
		JButton jbOk = new JButton("Ok");
		JLabel jLabel = new JLabel("Лучший результат: " + String.valueOf(BestClickCount)+" ходов");
		pn.setLayout(gridL);
		pn.add(new JLabel("Уровень сложности"));
		pn.add(new JLabel("Кол-во ходов"));
		pn.add(new JLabel("Время"));
		for (int i=0;i<BestsResults.size();i++)
		{
			type_result tr;
			String ld;
			tr = BestsResults.get(i);
			ld = String.valueOf(tr.ld.getColumns()) + "x" + String.valueOf(tr.ld.getRow());
			pn.add(new JLabel(ld));
			pn.add(new JLabel(String.valueOf(tr.ClickCount)));
			pn.add(new JLabel(String.valueOf(tr.Time)));
			
		}
			
		br_frame.add(pn,BorderLayout.NORTH);
		br_frame.add(jbOk,BorderLayout.SOUTH);
		jbOk.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//br_frame.setVisible(false);
				br_frame.dispose();
			}
		});
		
	}
	private void readresult()
	{
		try
		{
			FileInputStream fin = new FileInputStream(f);
			DataInputStream datain = new DataInputStream(fin);
			int size;
			int rows;
			int columns;
			size = datain.readInt();
			for (int i=0;i<size;i++)
			{
				type_result tr=new type_result();
				columns = datain.readInt();
				rows = datain.readInt();
				tr.ld = new LevelDifficult(columns,rows);
				tr.ClickCount = datain.readInt();
				tr.Time = datain.readInt();
				BestsResults.add(tr);
			}
			datain.close();
			fin.close();
			//fin.read()
		}
		catch(IOException e)
		{
			
			e.printStackTrace();
		}
		
	}
	
	public void addnewresult(type_result result)
	{
		if (BestsResults.isEmpty()) {BestsResults.add(result);SaveToFile();return;}

			for (int i=0;i<BestsResults.size();i++)
			{
				type_result SavedResult;
				SavedResult = BestsResults.get(i);
				if (SavedResult.ld.isEquivalent(result.ld))
				{
					if ((SavedResult.ClickCount>=result.ClickCount)&&(SavedResult.Time>=result.Time))
					{
						BestsResults.set(i,result);
						System.out.print("Замена, лучшего результата\n");
						SaveToFile();
						return;
					}
					if ((SavedResult.ClickCount<=result.ClickCount)&&(SavedResult.Time<=result.Time))
					{
						System.out.print("Лучшего результата нет!\n");
						return;
					}		
				}	
			}
			System.out.print("Добавить результат\n");
			BestsResults.add(result);
			SaveToFile();
				
	}
	public void SaveToFile()
	{
		try
		{
		FileOutputStream fout = new FileOutputStream(f);
		DataOutputStream dataout = new DataOutputStream(fout);
	
		dataout.writeInt(BestsResults.size());
		//fout.write();
		for (int i=0;i<BestsResults.size();i++)
		{
			type_result tr;
			tr = BestsResults.get(i);
			dataout.writeInt(tr.ld.getColumns());
			dataout.writeInt(tr.ld.getRow());
			dataout.writeInt(tr.ClickCount);
			dataout.writeInt(tr.Time);
		}
		dataout.close();
		fout.close();
		}
		catch(IOException e)
		{
		  e.printStackTrace();
		}	
	}
	BestResult()
	{   BestsResults = new ArrayList<type_result>();
		f =new File(filename);
		if (!f.exists())
		{
			
			try
			{
			FileOutputStream fout = new FileOutputStream(f);
			fout.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			
		}
		else readresult();
	
		
	}
}
