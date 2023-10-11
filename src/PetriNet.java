import java.util.ArrayList;
import java.util.List;

public class PetriNet implements PetriNetInterface {
	
	List<Place> listOfPlaces;
	List<Edge> listOfEdges;
	List<Transition> listOfTransitions;
	
	public PetriNet() {
		listOfPlaces = new ArrayList<>();
		listOfEdges = new ArrayList<>();
		listOfTransitions = new ArrayList<>();
	}
	
	

	@Override
	public void addPlace(Place placeToAdd) {
		this.listOfPlaces.add(placeToAdd);
	}

	@Override
	public void addInputEdge(InputEdge inputEdgeToAdd) {
		this.listOfEdges.add(inputEdgeToAdd);

	}

	@Override
	public void addOutputEdge(OutputEdge outputEdgeToAdd) {
		this.listOfEdges.add(outputEdgeToAdd);

	}

	@Override
	public void addEmptyingEdge(EmptyingEdge emptyingEdgeToAdd) {
		this.listOfEdges.add(emptyingEdgeToAdd);
	}

	@Override
	public void addZeroEdge(ZeroEdge zeroEdgeToAdd) {
		this.listOfEdges.add(zeroEdgeToAdd);

	}

	@Override
	public void addTransition(Transition transitionToAdd) {
		this.listOfTransitions.add(transitionToAdd);
	}

	@Override
	public void removePlace(Place placeToRemove) {		
		// on doit supprimer les edges reliés à la place (donc j'ai rajouté un getter)
		for (int i = 0; i<placeToRemove.getLinkedEdgesList().size();i++) {
			this.listOfEdges.remove(placeToRemove.getLinkedEdgesList().get(i)); // on le supprime du PetriNet
			placeToRemove.removeEdgeFromLinkedEdges(placeToRemove.getLinkedEdgesList().get(i)); // on supprime les edges reliés à la place
			
			// on doit supprimer les edges reliés à la transistion
			//TODO
		}
		
		// puis on supprime la place 
		this.listOfPlaces.remove(placeToRemove);  
	}

	@Override
	public void removeInputEdge(InputEdge inputEdgeToRemove) {
		this.listOfEdges.remove(inputEdgeToRemove); // on devra surement verifier
	}

	@Override
	public void removeOutputEdge(OutputEdge outputEdgeToRemove) {
		this.listOfEdges.remove(outputEdgeToRemove);
	}

	@Override
	public void removeEmptyingEdge(EmptyingEdge emptyingEdgeToRemove) {
		this.listOfEdges.remove(emptyingEdgeToRemove);
	}

	@Override
	public void removeZeroEdge(ZeroEdge zeroEdgeToRemove) {
		this.listOfEdges.remove(zeroEdgeToRemove);

	}

	@Override
	public void removeTransition(Transition transitionToRemove) {
		this.listOfTransitions.remove(transitionToRemove); // on doit remove les places et les transistions liés aussi
	}


	@Override
	public void linkPlaceWithTransistion(Place p, Transition t, Edge e) {
		// TODO Auto-generated method stub
		
	}

}
