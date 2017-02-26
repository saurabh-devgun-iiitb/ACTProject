package graph;

import java.util.ArrayList;
import java.util.List;

public class Node implements INode {
	protected IGraph graph = Graph.getGraph();													//Graph it belongs to
	protected List<IEdge> outgoingEdgeList = new ArrayList<IEdge>();			//List of out edges
	protected List<IEdge> incomingEdgeList = new ArrayList<IEdge>();			//List of in edges
	protected int nodeId;
	private static int ID=0;

	public Node() {			//add Node to graph. Make a graph object
		this.setNodeId(ID++);
		graph.addNode(this);
	}
	public void addGraph(IGraph graph){
		if(graph != null) {
			graph.addNode(this);
			this.graph = graph;
		}
		//else{
			//graph = new Graph(this);
			//mGraph = graph;		//done by constructor
		//}
	}

		@Override
	public List<INode> getChildList() {			//adjacent nodes to
		List<INode> list = new ArrayList<INode>();
		for(int i = 0; i < this.outgoingEdgeList.size(); i++) {
			list.add(this.outgoingEdgeList.get(i).getHead());
		}
		return list;
	}

	@Override
	public List<INode> getParentList() {		//adjacent nodes from
		List<INode> list = new ArrayList<INode>();
		for(int i = 0; i < this.incomingEdgeList.size(); i++) {
			list.add(this.incomingEdgeList.get(i).getTail());
		}
		return list;
	}

	@Override
	public IGraph getGraph() {
		return this.graph;
	}

	@Override
	public void setGraph(IGraph graph) {
		this.graph = graph;
		
	}

	@Override
	public boolean isIncomingEdge(IEdge edge) {	
		return this.incomingEdgeList.contains(edge);
	}

	@Override
	public boolean isOutgoingEdge(IEdge edge) {
		return this.outgoingEdgeList.contains(edge);
	}

	@Override
	public boolean isParent(INode node) {
		for(IEdge e : this.incomingEdgeList) {
			if(e.getTail().equals(node)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isChild(INode node) {
		for(IEdge e : this.outgoingEdgeList) {
			if(e.getHead().equals(node)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<IEdge> getIncomingEdgeList() {
		return this.incomingEdgeList;
	}

	@Override
	public List<IEdge> getOutgoingEdgeList() {
		return this.outgoingEdgeList;
	}

	@Override
	public void addIncomingEdge(IEdge edge) {
		this.incomingEdgeList.add(edge);
	}

	@Override
	public void addOutgoingEdge(IEdge edge) {
		this.outgoingEdgeList.add(edge);
	}

	@Override
	public void deleteIncomingEdge(IEdge edge) {
		this.incomingEdgeList.remove(edge);
	}

	@Override
	public void deleteOutgoingEdge(IEdge edge) {
		this.outgoingEdgeList.remove(edge);
	}

	public int getNodeId() {
		return nodeId;
	}

	public void setNodeId(int id) {
		this.nodeId = id;
	}
	
	public String toString(){
		return Integer.toString(nodeId);
	}
}
