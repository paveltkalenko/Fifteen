
public class type_result {
	public LevelDifficult ld;
	public int ClickCount;
	/** 
	 * время в 1/10секунды
	 */
	public int Time; 
	public boolean isEquivalent(LevelDifficult LD)
	{
		if (LD.getColumns()==ld.getColumns())
		{
			if (LD.getRow()==ld.getRow()) return true;
		}
		return false;
	}
	public boolean isCanAdd(type_result result)
	{
		if (!isCanChange(result))
		{
			if ((result.ClickCount<ClickCount)||(result.Time<Time)) return true;
		}
		
		return false;
	}
	public boolean isCanChange(type_result result)
	{
		if (!isEquivalent(result.ld)) return false;
		if ((result.ClickCount<=ClickCount)&&(result.Time<=Time)) return true;
		return false;
	}
	
	
}
