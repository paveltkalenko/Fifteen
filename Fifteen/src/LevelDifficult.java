public class LevelDifficult {
	/**
	 * 
	 */
	private int columns;
	private int rows;

	public int totalcells(){return columns * rows;}
	public int getColumns(){return columns;}
	public int getRow(){return rows;}
	LevelDifficult()
	{
		columns =4;
		rows =4;
	}
	LevelDifficult(LevelDifficult ld)
	{
		columns = ld.columns;
		rows =ld.rows;
	}	
	LevelDifficult(int Columns,int Row)
	{
		columns =Columns;
		rows =Row;
	
	}
	public boolean isEquivalent(LevelDifficult LD)
	{
		if (LD.getColumns()== columns)
		{
			if (LD.getRow()== rows) return true;
		}
		return false;
	}
	
}
