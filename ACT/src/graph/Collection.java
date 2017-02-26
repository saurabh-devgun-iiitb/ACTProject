package graph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Collection {
	private static HashMap<Integer,State> stateList = new HashMap<>();
	private static ArrayList<String> idList = new ArrayList<String>();
	private static ArrayList<String> inputList = new ArrayList<String>();
	private static ArrayList<String> clickableList = new ArrayList<String>();	
	private static HashMap<Integer,Transition> transitionList = new HashMap<>();
	private static ArrayList<Operation> operationList = new ArrayList<Operation>();
	private static ArrayList<Guard> guardList = new ArrayList<Guard>();
	
	
	public static List<State> getStateList() {
		System.out.println("COLLECTION: Fetching State List of size "+stateList.size());
		List<State> list = new ArrayList<>(stateList.values());
		return list;
	}
	public static void addState(int id, State state){
		System.out.println("COLLECTION: Adding the state "+state.getName());
		stateList.put(id, state);
	}
	public static List<Transition> getTransitionList() {
		System.out.println("COLLECTION: Fetching Transition List of size "+transitionList.size());
		List<Transition> list = new ArrayList<>(transitionList.values());
		return list;
	}
	public static void addTransition(int id, Transition transition){
		System.out.println("COLLECTION: Adding a new Transition with id: "+id+" and name: "+transition.getName());
		transitionList.put(id, transition);		
	}
	public static List<Operation> getOperationList(){
		return operationList;
	}
	public static void addOperation(Operation expression){
		operationList.add(expression);
	}
	public static List<Guard> getGuardList(){
		return guardList;
	}
	public static void addGuard(Guard guard){
		//System.out.println("Hi Dude");
		guardList.add(guard);
	}
	
	public static boolean hasState(INode state){
		System.out.println("COLLECTION: Does the state exist?");
		if(stateList.containsValue(state))
			return true;
		return false;
	}
	public static State getStateByName(String stateName)
	{
		System.out.println("COLLECTION: Searching "+stateName+" in Collection of size "+stateList.size());
		int i=0;
		while(i < stateList.size() && !Collection.stateList.get(i).getName().equals(stateName))
			i++;
		if(i==stateList.size())
			return null;
		System.out.println("COLLECTION: State Found- "+stateList.get(i));
		return Collection.stateList.get(i);
	}
	public static void printState() {
		for(int i = 0; i<stateList.size();i++){
			System.out.println("COLLECTION: States:\t"+Collection.stateList.get(i).getName()+" "+Collection.stateList.get(i).getDesc()+" "+Collection.stateList.get(i).getInput().toString()+" "+Collection.stateList.get(i).getClickable().toString());
		}		
	}
	public static State getStateById(int id){
		return stateList.get(id);
	}
	public static Transition getTransitionById(int id){
		return transitionList.get(id);
	}
	public static void addId(String str){
		idList.add(str);
		System.out.println(str+" addded to Collection");
	}
	public static ArrayList<String> getIdList(){
		return idList;
	}
	public static void addInputListFromIdList(){
		for(int i=0;i<idList.size();i++)
			inputList.add(idList.get(i));		
		idList.clear();
		System.out.println("InputList: "+inputList.toString());
	}
	public static void addClickableListFromIdList(){
		for(int i=0;i<idList.size();i++)
			clickableList.add(idList.get(i));		
		idList.clear();
		System.out.println("ClickableList: "+clickableList.toString());
	}	
	public static ArrayList<String> getInputList(){
		return inputList;
	}
	public static ArrayList<String> getClickableList(){
		return clickableList;
	}
}
