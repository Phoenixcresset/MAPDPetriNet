import java.util.LinkedList;
import java.util.List;

public class PetriNet implements PetriNetInterface {
	
	List<Place> listOfPlaces;
	List<Edge> listOfEdges;
	List<Transition> listOfTransitions;
	
	public PetriNet() {
		listOfPlaces = new LinkedList<>();
		listOfEdges = new LinkedList<>();
		listOfTransitions = new LinkedList<>();
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
		for (int i = 0; i<placeToRemove.getLinkedEdgesList().size();++i) {
			this.listOfEdges.remove(placeToRemove.getLinkedEdgesList().get(i)); // on le supprime du PetriNet
			placeToRemove.removeEdgeFromLinkedEdges(placeToRemove.getLinkedEdgesList().get(i)); // on supprime les edges reliés à la place
			
			// on doit supprimer les même edges reliés à la transistion 
			// (je pars du postulat pas très opti de regarder toutes les transistions 
			// et regarder si dans une transistion on a l'Edge associé)
			for (int j = 0; j<this.listOfTransitions.size();++j) {
				this.listOfTransitions.get(j).removeInputEdgeFromInputEdges(placeToRemove.getLinkedEdgesList().get(i));
				j--;
			}
			
			// Décrémenter l'indice pour éviter de sauter un élément
			i--;
		}
		
		// puis on supprime la place 
		this.listOfPlaces.remove(placeToRemove);  
	}

	@Override
	public void removeInputEdge(InputEdge inputEdgeToRemove) {
		this.listOfEdges.remove(inputEdgeToRemove); // pas necessaire de supprimer la place ou transistion reliée
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
		
		// on doit remove les edges liées aussi mais pas forcement les places
		for(int i = 0; i<transitionToRemove.getLinkedInputEdgesList().size();++i) {
			// d'abord les InputEdges
			this.listOfEdges.remove(transitionToRemove.getLinkedInputEdgesList().get(i));
			// puis les OutputEdges
			this.listOfEdges.remove(transitionToRemove.getLinkedOutputEdgesList().get(i));
			
			transitionToRemove.removeInputEdgeFromInputEdges(transitionToRemove.getLinkedOutputEdgesList().get(i));
			transitionToRemove.removeOutputEdgeFromOutputEdges(transitionToRemove.getLinkedOutputEdgesList().get(i));
			i--;
		}
		this.listOfTransitions.remove(transitionToRemove); 
	}


	@Override
	public void linkPlaceWithTransistion(Place p, Transition t, Edge e) {
		// TODO Auto-generated method stub
		// pour le moment je n'ai pas l'impression que ce soit necessaire ...
	}
	
	public String toString() {
		String afficherPetriNet = "places : ";
		
		for (int i = 0; i<this.listOfPlaces.size();++i) afficherPetriNet += listOfPlaces.toString();
		afficherPetriNet += " avec comme Edges : ";
		for (int i = 0; i<this.listOfEdges.size();++i) afficherPetriNet += listOfEdges.toString();
		afficherPetriNet += " avec comme Transistions : ";
		for (int i = 0; i<this.listOfTransitions.size();++i) afficherPetriNet += listOfTransitions.toString();
		
		return "Notre réseau de PetriNet est composé de " + afficherPetriNet;
	}

}
