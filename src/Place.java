
public class Place {
	private int tokenNumber;
	
	public Place()
	{
		this.tokenNumber = 0;
	}
	
	public void addTokens(int tokensToAdd)
	{
		this.tokenNumber += tokensToAdd;
	}
	public void removeTokens(int tokensToRemove)
	{
		this.tokenNumber -= tokensToRemove;
	}
	public boolean checkIfTempty()
	{
		return this.tokenNumber == 0;
	}
	public void empty()
	{
		this.tokenNumber = 0;
	}
}
