public class LevelDifficult {
	/**
	 * 
	 */
	private int столбцов;
	private int строк;

	public int всегоячеек(){return столбцов*строк;}
	public int getColumns(){return столбцов;}
	public int getRow(){return строк;}
	LevelDifficult()
	{
		столбцов=4;
		строк=4;
	}
	LevelDifficult(LevelDifficult ld)
	{
		столбцов = ld.столбцов;
		строк=ld.строк;
	}	
	LevelDifficult(int Columns,int Row)
	{
		столбцов=Columns;
		строк=Row;
	
	}
	public boolean isEquivalent(LevelDifficult LD)
	{
		if (LD.getColumns()==столбцов)
		{
			if (LD.getRow()==строк) return true;
		}
		return false;
	}
	
}
