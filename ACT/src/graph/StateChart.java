package graph;

import java.util.*;

public class StateChart {
	private Graph graph;
	private List<State> states = new ArrayList<>();
	private List<Transition> transitions = new ArrayList<>();
	private State startState;
	
	public StateChart(List<State> states,List<Transition> transitions) {
		graph = Graph.getGraph();
		this.states = states;
		this.transitions = transitions;
	}
	public List<State> getStateSet() {
		return states;
		//return (List<State>)(List<?>) graph.getNodeSet();
	}
	public List<Transition> getTransitionSet() {
		return transitions;
		//return (List<Transition>)(List<?>)graph.getEdgeSet();
	}
	public State getStartState() {
		return startState;
	}
	public void setStartState(State startState) {
		this.startState = startState;
	}
	public Graph getGraph(){
		return graph;
	}
	public String toString(){
		return "Statechart";
	}
	public int getNumberOfStates() {
		return graph.getNumberOfNodes();
	}
	public int getNumberOfTransitions() {
		return graph.getNumberOfEdges();
	}
}	
/*	
	public INode addState(INode state) {
		return graph.addNode(state);
	}

	public INode deleteState(INode state) {
		return graph.deleteNode(state);
	}

	public IEdge addTransition(IEdge transition) {
		return super.addEdge(transition);
	}

	public IEdge deleteTransition(IEdge transition) {
		return super.deleteEdge(transition);
	}
	
	public boolean hasState(INode state) {
		return super.hasNode(state);
	}

	public boolean hasTransition(IEdge transition) {
		return super.hasEdge(transition);
	}

	public INode getStateById(int id){
		return super.getNodeById(id);
	}
	public INode setRoot(int id){
		
	}*/
