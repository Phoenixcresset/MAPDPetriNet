package controller;

import elements.Edge;
import elements.Place;
import elements.Transition;


public interface IPetriNet {
	public void addPlace(Place placeToAdd);

	public void addEdge(Edge edgeToAdd);

	public void addTransition(Transition transitionToAdd);

	public void removePlace(Place placeToRemove);

	public void removeEdge(Edge edgeToRemove);

	public void removeTransition(Transition transitionToRemove);

	public void linkPlaceWithTransistion(Edge edgeToLink, Place placeToLink, Transition transitionToLink);

	public String toStringElements();
}
