package graph;

import java.util.ArrayList;
import java.util.List;

public class State {
	private Node node;
	private String name;
	private String desc;
	private StateChart sc;
	ArrayList<String> input = new ArrayList<String>();
	//private boolean[] inputBool;	//unary
	ArrayList<String> clickable = new ArrayList<String>();
	public State(String stateName, String stateDesc, ArrayList<String> stateInput, ArrayList<String> stateClickable) {
		System.out.println("STATE: Creating a new State ("+stateName+")");
		node = new Node();
		this.name = stateName;
		this.desc = stateDesc;
		for(int i=0;i<stateInput.size();i++){
			this.input.add(stateInput.get(i));	
		}
		stateInput.clear();
		for(int i=0;i<stateClickable.size();i++)
			this.clickable.add(stateClickable.get(i));		
		stateClickable.clear();
	}
	public Node getNode() {
		return node;
	}
	public void setNode(Node node) {
		this.node = node;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public ArrayList<String> getInput() {
		return input;
	}
	public void setInput(ArrayList<String> input) {
		this.input = input;
	}
	public ArrayList<String> getClickable() {
		return clickable;
	}
	public void setClickable(ArrayList<String> clickable) {
		this.clickable = clickable;
	}
	public String toString(){
		return name+" "+node.getNodeId()+" "+desc+" "+sc+" "+input+" "+clickable;
	}
	/*
	public List<Transition> getIncomingTransitionList() {
		List<Transition> t = new ArrayList<>();
		StateChart statechart = new StateChart();
		for(IEdge e : node.mIncomingEdgeList){
			t.add(statechart.getTransition(e));
		}
	}

	public void addOutgoingTransition(IEdge edge) {
		this.mOutgoingEdgeList.add(edge);
	}
	
	public List<IEdge> getOutgoingTransitionList() {
		return this.mOutgoingEdgeList;
	}
	
	public void addIncomingTransition(IEdge edge) {
		this.mIncomingEdgeList.add(edge);
	}
	
	//changing state of Node
	public boolean isIncomingTransition(IEdge e) {	
		return this.mIncomingEdgeList.contains(e);
	}

	public boolean isOutgoingTransition(IEdge e) {
		return this.mOutgoingEdgeList.contains(e);
	}

	public void deleteIncomingTransition(IEdge edge) {
		this.mIncomingEdgeList.remove(edge);
	}

	public void deleteOutgoingTransition(IEdge edge) {
		this.mOutgoingEdgeList.remove(edge);
	}*/
}
