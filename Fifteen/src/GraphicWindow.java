import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
@SuppressWarnings("serial")
public class GraphicWindow extends JPanel implements MouseListener{
	private QuadrateBlock qb[];
	enum direction {toLeft,toRight,toUp,toDown};
	private LevelDifficult ld;
	Main parentframe;
	private JLabel ClickCounterLabel;
	public GraphicWindow(Main parentframe)
	{
		this.parentframe = parentframe;
		this.ld = parentframe.leveldifficult;	
	//	TotalBlocks = this.ld.всегоячеек();
		BlocksPerLine = this.ld.getColumns();
		
		BlockSize=(byte)(this.getWidth()/ld.getColumns());
	//	System.out.println("WIDTH"+this.getWidth());
		ClickCounterLabel=parentframe.ClickCounter;
		//NewGameInitalisation();
	    this.addMouseListener(this);
	};
	public void mousePressed(MouseEvent e)
	{
		int mx,my,gt,tmp;
		if (e.getX()>BlockSize*ld.getColumns()) {return;}

		mx = e.getX()/BlockSize;
		my = e.getY()/BlockSize;
		gt = my*ld.getColumns()+mx;
		if (gt>=ld.всегоячеек()) {return;}
		if (qb[gt].value != 0)
		{
			if (mx>0)
			{
				tmp=qb[gt-1].value;
				if (tmp==0) moveBlock((byte)gt,direction.toLeft);
			}
			if (mx<(ld.getColumns()-1))
			{
				tmp=qb[gt+1].value;
				if (tmp==0) moveBlock((byte)gt,direction.toRight);
			}
			if (my>0)
			{
				tmp=qb[gt-ld.getColumns()].value;
				if (tmp==0) moveBlock((byte)gt,direction.toUp);
			}
			if (my<(ld.getRow()-1))
			{
				tmp=qb[gt+ld.getColumns()].value;
				if (tmp==0) moveBlock((byte)gt,direction.toDown);
			}
		}
		
	}
	protected void paintComponent(Graphics g)
	{
    	super.paintComponents(g);
     	Graphics2D gr = (Graphics2D)g;
     	gr.setColor(new Color(60,50,10));
	//	TotalBlocks = this.ld.всегоячеек();
		BlocksPerLine =ld.getColumns();
     	BlockSize=getWidth()/ld.getColumns();
     	gr.fill3DRect(0, 0, BlockSize*ld.getColumns(), BlockSize*ld.getRow(),false);
     	for (int i=0;i<ld.всегоячеек();i++)
     	{
     		int x,y;
     		x=(i % ld.getColumns());
            y=(i / ld.getColumns());
           qb[i].Draw(gr,x*BlockSize,y*BlockSize,BlockSize);        
     	}
	}
	private void moveBlock(byte from,direction dr)
	{
		if (dr==direction.toLeft)
		{
			qb[from-1].value=qb[from].value;
			qb[from].value=0;
		}
		if (dr==direction.toRight)
		{
			qb[from+1].value=qb[from].value;
			qb[from].value=0;
		}
		if (dr==direction.toDown)
		{
			qb[from+BlocksPerLine].value=qb[from].value;
			qb[from].value=0;
		}
		if (dr==direction.toUp)
		{
			qb[from-BlocksPerLine].value=qb[from].value;
			qb[from].value=0;
		}
		ClickCount++;
		ClickCounterLabel.setText("Кол-во перемещений: "+ClickCount);
		GetPairs();
		
		repaint();
		if (TestEnd()==2) NewGameInitalisation();
	}
	public int GetPairs()
	{
		int chet=0;
		int tmp=0;
		for (int i=0;i<ld.всегоячеек();i++)
		{
			if (qb[i].value==0) 
			{
				tmp=(i/ld.getColumns())+1;
				continue;
			}
			for (int i1=0;i1<ld.всегоячеек();i1++)
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
//	@SuppressWarnings({ "static-access", "deprecation" })
	public int TestEnd()
	{
		int b=0;
		for (int i=0;i<(ld.всегоячеек()-1);i++)
		{
			if (qb[i].value==(i+1)) b++;
		}
		if (b==(ld.всегоячеек()-1)) 
		{
			JOptionPane Dialog = new JOptionPane();
		//	Locale lc = new Locale("es");
			//Dialog.setLocale(lc.JAPAN);
			//Dialog.setDefaultLocale(Locale.ITALIAN);
			parentframe.myTime.stopping();
			b=Dialog.showConfirmDialog(this,"Вы выиграли! Хотите начать игру с начала?","Конец",JOptionPane.YES_NO_OPTION);
			
			type_result result = new type_result();
			result.ClickCount = ClickCount;
			result.ld = new LevelDifficult(this.ld);
			result.Time = parentframe.myTime.GetTime();
			parentframe.bestresult.addnewresult(result);
			
			if (b==JOptionPane.YES_OPTION) return 2;
			else return 1;
		}
		return 0;
	}
	public void NewGameInitalisation()
	{
		ClickCount=0;
		ClickCounterLabel.setText("Кол-во перемещений: "+ClickCount);

		this.ld = parentframe.leveldifficult;
		qb = new QuadrateBlock[ld.всегоячеек()];
	    for (int i=0; i<ld.всегоячеек();i++)
	    {
	    	qb[i]=new QuadrateBlock((byte)i);    
	    }
	    //Случайно перемешиваем блоки
	    
	    Random randomseq = new Random();
	    int chet;
	    do
	    {   chet=0;
	    	for (int i=ld.всегоячеек()-1;i>0;i--) 
	    	{
	    		int d,tmp;	    	
	    	
	    		d = randomseq.nextInt(i);
	    		tmp = qb[i].value;
	    		qb[i].value=qb[d].value;
	    		qb[d].value=(byte)tmp;
	    	}
			

	    	chet=GetPairs();
	    }while((chet%2)==1);
	    
	    repaint();
	//	parentframe.myTime.setNull(); 
	//	parentframe.myTime.run();
	}
	private int BlocksPerLine=4;
    private int ClickCount;
    
	private int BlockSize=90;
	
	public void mouseReleased(MouseEvent e){};
	public void mouseClicked(MouseEvent e){};
	public void mouseEntered(MouseEvent e){};
	public void mouseExited(MouseEvent e){};
	public void mouseMoved(MouseEvent e){};
	
}
