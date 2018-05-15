//НЕ ИСПОЛЬЗУЕТСЯ
import java.util.Random;

import javax.swing.JLabel;

public class Game {
	private LevelDifficult ld;
	private JLabel ClickCounterLabel;
	enum direction {toLeft,toRight,toUp,toDown}
	private int ClickCount;
	Main parentframe;
	private QuadrateBlock qb[];
	public	Game()
	{
		ClickCount=0;
		ClickCounterLabel.setText("Кол-во перемещений: "+ClickCount);

		this.ld = parentframe.leveldifficult;
		qb = new QuadrateBlock[ld.totalcells()];
	    for (int i = 0; i<ld.totalcells(); i++)
	    {
	    	qb[i]=new QuadrateBlock((byte)i);    
	    }
	    //Случайно перемешиваем блоки
	    
	    Random randomseq = new Random();
	    int chet;
	    do
	    {   chet=0;
	    	for (int i = ld.totalcells()-1; i>0; i--)
	    	{
	    		int d,tmp;	    	
	    	
	    		d = randomseq.nextInt(i);
	    		tmp = qb[i].value;
	    		qb[i].value=qb[d].value;
	    		qb[d].value=(byte)tmp;
	    	}
			

	    	chet=GetPairs();
	    }while((chet%2)==1);
	    
	    
	}
	public int GetPairs()
	{
		int chet=0;
		int tmp=0;
		for (int i = 0; i<ld.totalcells(); i++)
		{
			if (qb[i].value==0) 
			{
				tmp=(i/ld.getColumns())+1;
				continue;
			}
			for (int i1 = 0; i1<ld.totalcells(); i1++)
			{
				if (qb[i1].value==0) continue;
				if ((i1>i)&&(qb[i1].value<qb[i].value)) chet++; 	
			}
		
		
		}
		if (((ld.getColumns()%2)==1)||((ld.getRow()%2)==1)) {tmp=0;}  
		int ttt=tmp+chet;

		System.out.println("tmp="+tmp+"\tchet="+chet+"\tttt= "+ttt);
		return ttt;
	}
	
}
