package controller;

import java.util.LinkedList;
import java.util.List;

import elements.Edge;
import elements.EmptyingEdge;
import elements.InputEdge;
import elements.OutputEdge;
import elements.Place;
import elements.Transition;
import elements.ZeroEdge;


/**
 * Class used to create and edit a PetriNet.
 */
public class PetriNet implements IPetriNet {

	private List<Place> listOfPlaces;
	private List<Edge> listOfEdges;
	private List<Transition> listOfTransitions;

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
		// We delete every edge linked to the place to be removed
		for (int i = 0; i < placeToRemove.getLinkedEdgesList().size(); ++i) {
			this.listOfEdges.remove(placeToRemove.getLinkedEdgesList().get(i)); // Remove the edge from the PetriNet
			placeToRemove.removeEdgeFromLinkedEdges(placeToRemove.getLinkedEdgesList().get(i)); // Remove the edge from the Place

			// on doit supprimer les même edges reliés à la transistion
			// (je pars du postulat pas très opti de regarder toutes les transistions
			// et regarder si dans une transistion on a l'Edge associé)
			
			// Il n'y aura pas un problème vu que l'edge est déjà supprimé de la place ? (donc il faudrait mettre la boucle entre les lignes 54 et 55
			for (int j = 0; j < this.listOfTransitions.size(); ++j) {
				this.listOfTransitions.get(j).removeEdgeFromLinkedEdges(placeToRemove.getLinkedEdgesList().get(i));
				j--;
			}

			// Décrémenter l'indice pour éviter de sauter un élément
			// C'est à dire ?
			i--;
		}

		// Delete the place from the PetriNet
		this.listOfPlaces.remove(placeToRemove);
	}

	@Override
	public void removeInputEdge(InputEdge inputEdgeToRemove) {
		this.listOfEdges.remove(inputEdgeToRemove);
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

		// Remove every edge linked to the transition (but not the places)
		for (int i = 0; i < transitionToRemove.getLinkedInputEdgesList().size(); ++i) {
			// Remove all Input Edges from the PetriNet
			this.listOfEdges.remove(transitionToRemove.getLinkedInputEdgesList().get(i));
			// Remove all Output Edges from the PetriNet
			// Heu, problème si les deux listes ne font pas la même taille nn ?
			this.listOfEdges.remove(transitionToRemove.getLinkedOutputEdgesList().get(i));
			
			// Remove all Edges from the transition
			transitionToRemove.removeInputEdgeFromInputEdges(transitionToRemove.getLinkedInputEdgesList().get(i));
			transitionToRemove.removeOutputEdgeFromOutputEdges(transitionToRemove.getLinkedOutputEdgesList().get(i));
			i--;
		}
		
		// Remove the Transition from the PetriNet
		this.listOfTransitions.remove(transitionToRemove);
	}

	@Override
	public void linkPlaceWithTransistion(Edge edgeToLink, Place placeToLink, Transition transitionToLink) {

		if (edgeToLink instanceof InputEdge) {
			transitionToLink.addInputEdgeToLinkedEdges((InputEdge) edgeToLink);
		}
		else if (edgeToLink instanceof OutputEdge) {
			transitionToLink.addOutputEdgeToLinkedEdges((OutputEdge) edgeToLink);
		}
		else {
			System.out.println("Tried to link an Edge that was not an InputEdge or an OutputEdge, the Edge class should not be used as an instance, linking cancelled.");
		}
		edgeToLink.setLinkedPlace(placeToLink);
		edgeToLink.setLinkedTransition(transitionToLink);
		placeToLink.addEdgeToLinkedEdges(edgeToLink);
	}

	@Override
	public String toString() {
		String afficherPetriNet = "places : ";

		for (int i = 0; i < this.listOfPlaces.size(); ++i) {
			afficherPetriNet += listOfPlaces.toString();
		}
		afficherPetriNet += " avec comme Edges : ";
		for (int i = 0; i < this.listOfEdges.size(); ++i) {
			afficherPetriNet += listOfEdges.toString();
		}
		afficherPetriNet += " avec comme Transistions : ";
		for (int i = 0; i < this.listOfTransitions.size(); ++i) {
			afficherPetriNet += listOfTransitions.toString();
		}

		return "Notre réseau de PetriNet est composé de " + afficherPetriNet;
	}

}
