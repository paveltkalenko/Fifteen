import java.awt.*;
public class QuadrateBlock {
	private int x,y;
	public byte value;
	public int size;
	
	/**Блок 
	@param value значение блока
	@param x y начальная позиция
	@param y начальная позиция по вертикали
	@param size размер блока
	*/
	QuadrateBlock(byte value,int x,int y,int size)
	{
		this.x=x;this.y=y;
		this.value=value;
		this.size = size;
	}
	QuadrateBlock(byte value)
	{
		this.value=value;
		size=0;x=0;y=0;
	}
	public void Draw(Graphics2D gr)
	{if (value==0) return;
		gr.setBackground(Color.red);
		gr.setColor(new Color(128,128,0));

		gr.setColor(new Color(150,110,0));
		gr.fillRoundRect(x,y , size-size/20, size-size/20, size/4, size/4);
		gr.setColor(new Color(50,50,0));
		Font ft = new Font("Serif",Font.BOLD,(size*4)/5);
		
		gr.setFont(ft);
		String str = String.valueOf(value);
		if (value>9)
		{
		   gr.drawString(str, x+size/10, y+(size*4)/5);
		}
		else {gr.drawString(str, x+size/3, y+(size*4)/5);}
	}
	public void Draw(Graphics2D gr, int x,int y,int size)
	{
		this.x=x; this.y=y;
		this.size=size;
		this.Draw(gr);
	}
}
