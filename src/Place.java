import java.util.LinkedList;

public class Place {

	// Instance Variables
	private int tokensNumber;
	private LinkedList<Edge> linkedEdgesList;
	

	// Constructor
	public Place() {
		this.tokensNumber = 0;
	}

	// Setters and Getters

	public int getTokensNumber() {
		return tokensNumber;
	}

	public void setTokensNumber(int tokenNumber) {
		this.tokensNumber = tokenNumber;
	}

	public void addEdgeToLinkedEdges(Edge edgeToAdd) {
		linkedEdgesList.add(edgeToAdd);
	}

	public void removeEdgeFromLinkedEdges(Edge edgeToRemove) {
		linkedEdgesList.remove(edgeToRemove);
	}
	
	public LinkedList<Edge> getLinkedEdgesList(){
		return this.linkedEdgesList;
	}

	// Methods

	public void addTokens(int tokensToAdd) {
		this.setTokensNumber(this.getTokensNumber() + tokensToAdd);
	}

	public void removeTokens(int tokensToRemove) {
		this.setTokensNumber(this.getTokensNumber() - tokensToRemove);
	}

	public boolean checkIfTempty() {
		return this.getTokensNumber() == 0;
	}

	public void empty() {
		this.setTokensNumber(0);
	}
}
