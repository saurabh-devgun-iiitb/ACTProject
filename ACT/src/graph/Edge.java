package graph;

import graph.IEdge;
import graph.IGraph;
import graph.INode;

public class Edge implements IEdge {

	protected IGraph graph = Graph.getGraph();		
	protected INode tail; 		//source
	protected INode head; 		//target
	protected int edgeId;
	protected static int EDGEID = 0;
	
	public Edge(INode tail, INode head) throws Exception {
		if(graph.hasNode(tail) && graph.hasNode(head)){
			this.tail = tail;
			this.head = head;
			setEdgeId(EDGEID++);
			graph.addEdge(this);
		}
		//System.out.println("EDGE: Error happened");
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
	public INode getHead() {
		return this.head;
	}

	@Override
	public INode getTail() {
		return this.tail;
	}

	public int getEdgeId() {
		return edgeId;
	}

	public void setEdgeId(int edgeId) {
		this.edgeId = edgeId;
	}

	public String toString(){
		return Integer.toString(edgeId);
	}
}
