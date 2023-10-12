package controller;

import elements.Edge;
import elements.EmptyingEdge;
import elements.InputEdge;
import elements.OutputEdge;
import elements.Place;
import elements.Transition;
import elements.ZeroEdge;


public interface PetriNetInterface {
	public void addPlace(Place placeToAdd);

	public void addInputEdge(InputEdge inputEdgeToAdd);

	public void addOutputEdge(OutputEdge outputEdgeToAdd);

	public void addEmptyingEdge(EmptyingEdge emptyingEdgeToAdd);

	public void addZeroEdge(ZeroEdge zeroEdgeToAdd);

	public void addTransition(Transition transitionToAdd);

	public void removePlace(Place placeToRemove);

	public void removeInputEdge(InputEdge inputEdgeToRemove);

	public void removeOutputEdge(OutputEdge outputEdgeToRemove);

	public void removeEmptyingEdge(EmptyingEdge emptyingEdgeToRemove);

	public void removeZeroEdge(ZeroEdge zeroEdgeToRemove);

	public void removeTransition(Transition transitionToRemove);
	
	public void linkPlaceWithTransistion(Place p, Transition t, Edge e);
}
