package elements;
import java.util.LinkedList;

/**
 * A base element which stores tokens.
 */
public class Place {

	// Instance Variables
	/** How many tokens does this place have */
	private int tokensNumber;
	/** Linked List of all edges connected to this place */
	private LinkedList<Edge> linkedEdgesList;
	

	// Constructor
	/**
	 * Constructs an empty place without any links.
	 */
	public Place() {
		this.tokensNumber = 0;
		this.linkedEdgesList = new LinkedList<Edge>();
	}
	
	/**
	 * Constructs a place with the specified number of tokens.
	 * @param tokenNumber number of tokens of the new place
	 */
	public Place(int tokenNumber) {
		// Handling negative tokens
		if (tokenNumber < 0) {
			this.tokensNumber = 0;
		}
		else {
			this.tokensNumber = tokenNumber;	
		}
		this.linkedEdgesList = new LinkedList<Edge>();
	}

	// Setters and Getters

	/**
	 * Returns how many tokens does this place have.
	 * @return number of tokens in this place
	 */
	public int getTokensNumber() {
		return tokensNumber;
	}

	/**
	 * Replaces the number of tokens of this place by the specified number.
	 * @param tokenNumber the new number of tokens of this place
	 */
	public void setTokensNumber(int tokenNumber) {
		if (tokenNumber < 0)
		{
			tokenNumber = 0;
		}
		this.tokensNumber = tokenNumber;
	}

	/**
	 * Connects an existing edge to this place.
	 * @param edgeToAdd the edge to connect
	 */
	public void addEdgeToLinkedEdges(Edge edgeToAdd) {
		linkedEdgesList.add(edgeToAdd);
	}

	/**
	 * Unlinks a specific edge from this place.
	 * @param edgeToRemove the edge to unlink from this place
	 */
	public void removeEdgeFromLinkedEdges(Edge edgeToRemove) {
		linkedEdgesList.remove(edgeToRemove);
	}
	
	/**
	 * Returns the list of all edges linked to this place.
	 * @return linkedList of all linked edges
	 */
	public LinkedList<Edge> getLinkedEdgesList(){
		return this.linkedEdgesList;
	}

	// Methods

	/**
	 * This method is used by InputEdges to add tokens to this place.
	 * @param tokensToAdd how many tokens to add
	 */
	public void addTokens(int tokensToAdd) {
		if (tokensToAdd < 0) {
			return;
		}
		this.setTokensNumber(this.getTokensNumber() + tokensToAdd);
	}

	/**
	 * This method is used by OutputEdges to remove tokens from this place. 
	 * @param tokensToRemove how many tokens to remove
	 */
	public void removeTokens(int tokensToRemove) {
		// Handling case if too many tokens were removed
		if (tokensToRemove > this.getTokensNumber()) {
			this.setTokensNumber(0);
		}
		else if (tokensToRemove < 0) {
			return;
		}
		else {
			this.setTokensNumber(this.getTokensNumber() - tokensToRemove);	
		}
		
	}

	/**
	 * This method is used by EmptyingEdges and ZeroEdges to check if this place is empty or not.
	 * @return true if no tokens are in this place, false otherwise
	 */
	public boolean checkIfEmpty() {
		return this.getTokensNumber() == 0;
	}

	/**
	 * This method is used by EmptyingEdges to clear this place of all of its tokens.
	 */
	public void clearAllTokens() {
		this.setTokensNumber(0);
	}
	
	@Override
	public String toString() {
		return "( " + this.getTokensNumber() + " )";
	}
	

	
}
