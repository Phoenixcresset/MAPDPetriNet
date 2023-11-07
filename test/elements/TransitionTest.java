package elements;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TransitionTest {

	// Setters and Getters
	@Test
	public void testAddInputEdgeToLinkedEdges() {
		final Transition transition = new Transition();
		final InputEdge edge = new InputEdge(5);
		transition.addInputEdgeToLinkedEdges(edge);
		assertEquals(transition.getLinkedEdgesList().get(0), edge);
	}

	@Test
	public void testAddOutputEdgeToLinkedEdges() {
		final Transition transition = new Transition();
		final OutputEdge edge = new OutputEdge(5);
		transition.addOutputEdgeToLinkedEdges(edge);
		assertEquals(transition.getLinkedEdgesList().get(0), edge);
	}

	@Test
	public void testRemoveInputEdgeFromInputEdges() {
		final Transition transition = new Transition();
		final InputEdge edge = new InputEdge(5);
		transition.addInputEdgeToLinkedEdges(edge);
		transition.removeInputEdgeFromInputEdges(edge);
		assertEquals(transition.getLinkedEdgesList().size(), 0);
	}

	@Test
	public void testRemoveOutputEdgeFromOutputEdges() {
		final Transition transition = new Transition();
		final OutputEdge edge = new OutputEdge(5);
		transition.addOutputEdgeToLinkedEdges(edge);
		transition.removeOutputEdgeFromOutputEdges(edge);
		assertEquals(transition.getLinkedEdgesList().size(), 0);
	}

	@Test
	public void testRemoveEdgeFromLinkedEdges() {
		final Transition transition = new Transition();
		final InputEdge edge_1 = new InputEdge(5);
		final OutputEdge edge_2 = new OutputEdge(5);
		transition.addInputEdgeToLinkedEdges(edge_1);
		transition.addOutputEdgeToLinkedEdges(edge_2);
		transition.removeEdgeFromLinkedEdges(edge_1);
		assertEquals(transition.getLinkedEdgesList().size(), 1);
		assertEquals(transition.getLinkedEdgesList().get(0), edge_2);
		transition.removeEdgeFromLinkedEdges(edge_2);
		assertEquals(transition.getLinkedEdgesList().size(), 0);
	}

	@Test
	public void testGetLinkedInputEdgesList() {
		final Transition transition = new Transition();
		final InputEdge edge = new InputEdge(5);
		transition.addInputEdgeToLinkedEdges(edge);
		assertEquals(transition.getLinkedInputEdgesList().get(0), edge);
	}

	@Test
	public void testGetLinkedOutputEdgesList() {
		final Transition transition = new Transition();
		final OutputEdge edge = new OutputEdge(5);
		transition.addOutputEdgeToLinkedEdges(edge);
		assertEquals(transition.getLinkedOutputEdgesList().get(0), edge);
	}

	@Test
	public void testGetLinkedEdgesList() {
		final Transition transition = new Transition();
		final InputEdge edge_1 = new InputEdge(5);
		final OutputEdge edge_2 = new OutputEdge(5);
		transition.addInputEdgeToLinkedEdges(edge_1);
		transition.addOutputEdgeToLinkedEdges(edge_2);
		assertEquals(transition.getLinkedEdgesList().get(0), edge_1);
		assertEquals(transition.getLinkedEdgesList().get(1), edge_2);
	}

	// Methods

	@Test
	public void testToString() {
		final Transition transition = new Transition();
		assertEquals(transition.toString(), "[ ]");
	}

}
