package graph;
import java.util.ArrayList;
import java.util.Stack;

public class FrontEnd {
    private Stack<IEdge> stack = new Stack<IEdge> ();
    private ArrayList<Stack<IEdge>> al = new ArrayList<Stack<IEdge>>();
															// Usually dfs_rec() would be sufficient. However, if we don't want to pass a boolean array to our function, we can use another function dfs(). We only have to pass the adjacency list and the source node to dfs(), as opposed to dfs_rec(), where we have to pass the boolean array additionally.
    public ArrayList<Stack<Transition>> dfs(StateChart statechart, State state){
    	ArrayList<Stack<IEdge>> al = dfs(statechart.getGraph(),statechart.getStartState().getNode());
    	ArrayList<Stack<Transition>> paths = new ArrayList<Stack<Transition>>();
    	Stack<Transition> transitionStack;
    	for(Stack<IEdge> edgeList : al){
    		transitionStack = new Stack<>();
    		for(IEdge edge : edgeList){
    			transitionStack.push(Collection.getTransitionById(edge.getEdgeId()));
    		}
    		paths.add(transitionStack);
    	}
    	return paths;
    }
    public ArrayList<Stack<IEdge>> dfs(IGraph g, INode s){
        int n = g.getNumberOfNodes();						//no of rows (nodes)
        boolean[] visited = new boolean[n];					//make visited array; printVisited(visited);
        dfs_rec(g, visited, s);								//Pass Graph,visited array, src
        print(al);											//STUB AVAILABLE (TODO, IN PROGRESS,STUB AVAILABLE, OBSOLETE)
        return al;
    }
    private void dfs_rec(IGraph g, boolean[] visited, INode v){								//System.out.print(v.getId()+" ");
        visited[v.getNodeId()] = true;		//mark visited and print; printVisited(visited); stack.push(v); System.out.println(stack.toString());
        boolean deadEnd = true;        
        for(IEdge w : v.getOutgoingEdgeList()){	//for cols (elt) in v's row (search unvisited adjacent node)
            deadEnd = false;
            if(!visited[w.getHead().getNodeId()]){
            	stack.push(w);
                dfs_rec(g, visited, w.getHead());		//for unvisited elt do same thing (hold the loop)
            }
            else									//when cycle comes
            {
            	stack.push(w);
            	spitOut(stack);
            	stack.pop();
			}
        }
        if(deadEnd)
        {
        	spitOut(stack);
        }
        if(!stack.isEmpty())			//to take care of the root
        	stack.pop();				//pop the edge that brought me to this node
    }
	private void spitOut(Stack<IEdge> stack)
	{
		Stack<IEdge> stack1 = getCopy(stack);					//System.out.println(stack.toString());
		al.add(stack1);											//System.out.println(al.toString());
	}
	private Stack<IEdge> getCopy(Stack<IEdge> stack)
    {
    	Stack<IEdge> stack1 = new Stack<IEdge>();
    	Stack<IEdge> tempStack= new Stack<IEdge>();
    	//System.out.println("Input Stack is " + stack.toString());
    	while(!stack.empty())
    	{
    		IEdge a = stack.pop();
    		tempStack.push(a);
    	}
    	while(!tempStack.empty())
    	{
    		IEdge a = tempStack.pop();
    		stack.push(a);
    		stack1.push(a);
    	}
		return stack1;											//System.out.println("Output Stack is " + stack1.toString());    	
    }	
	public void print(ArrayList<Stack<IEdge>> al)
	{
		for (int i = 0; i < al.size(); i++) {					//System.out.println(al.size());
			for(int j=0;j<al.get(i).size();j++){
				System.out.print(al.get(i).get(j).getEdgeId()+" ");
			}
			System.out.println();
        }
	}
	public void printVisited(boolean [] b)
    {
    	for(int i=0;i<b.length;i++)
    		System.out.print(b[i]?"1":"0");					//java.lang.Boolean.toString(b[i]));
    	System.out.println();
    }
}