
public class Edge {
	private int weight;
	private int value;
	
	public Edge(int weight, int value)
	{
		this.weight = weight;
		this.value = value;
	}
	
	public void changeValue(int new_value)
	{
		this.value = new_value;
	}
	
	public void trigger()
	{
		return;
	}
	
	
}
