package graph;

import java.util.ArrayList;

public class myGraph{
	public static void main(String[] args) throws Exception{
		String stateName = "S1";
		String stateDesc = "D1";
		ArrayList<String> stateInput = new ArrayList<String>();
		stateInput.add("I1");
		stateInput.add("I2");
		stateInput.add("I3");
		ArrayList<String> stateClickable = new ArrayList<String>();
		stateClickable.add("C1");
		stateClickable.add("C2");
		
		State state = new State(stateName,stateDesc,stateInput,stateClickable);
		System.out.println("MAIN: State Details: "+state);
		Collection.addState(state.getNode().getNodeId(), state);
		stateInput = null; stateClickable = null;
		int stateNum = 2,input = 3,click = 3,j=0;
		for(int i=2;i<10;i++){
			stateInput = new ArrayList<String>();
			stateClickable  = new ArrayList<String>();
			stateName = "S"+stateNum;
			stateDesc = "Description"+stateNum++;
			for(j=0;j<3;j++){
				stateInput.add("I"+input++);
				
				stateClickable.add("C"+click++);
			}
			state = new State(stateName,stateDesc,stateInput,stateClickable);
			System.out.println("MAIN: State Details: " + state);
			Collection.addState(state.getNode().getNodeId(), state);
			System.out.println("MAIN: State Added to Collection");
			stateInput = null;
			stateClickable = null;
		}
		Collection.printState();
		
		//System.out.println("Check:TransitionDestState : "+transitionDestinationState.toString());
		String transitionTrigger = "C1";	//check that s1 has c1 in it.
		String transitionGuardBinaryOperationLhs = "I1";	//check that variables are ci in s1
		String transitionGuardBinaryOperationOp = "=";
		String transitionGuardBinaryOperationRhs = "I2";	//check
		//check that lhs and rhs are defined at s1. may be at the time for adding guard to transition
		BinaryOperation transitionGuardBinaryOperation = new BinaryOperation(transitionGuardBinaryOperationLhs, transitionGuardBinaryOperationOp, transitionGuardBinaryOperationRhs); 
		//make some binary expressions
		String transitionGuardUnaryOperationVar = "I3";		//check
		String transitionGuardUnaryOperationOp = "!";
		UnaryOperation  transitionGuardUnaryOperation = new UnaryOperation(transitionGuardUnaryOperationVar,transitionGuardUnaryOperationOp);
		Collection.addOperation(transitionGuardUnaryOperation);
		Collection.addOperation(transitionGuardBinaryOperation);
		Guard transitionGuard = new Guard(Collection.getOperationList());
		
		String transitionAction = "A1";		//Maybe implemented as name,value pair (eg- save I1,I2 pair)
		int i=0;
		int error=0;
		System.out.println("MAIN: Going to start creating transitions");
		System.out.println("Error:"+error++);
		Transition transition = new Transition("T"+i++,"D"+i,Collection.getStateByName("S1"), Collection.getStateByName("S2"), transitionTrigger, transitionGuard, transitionAction);
		System.out.println("Error:"+error++);
		Collection.addTransition(transition.getEdge().getEdgeId(), transition);
		System.out.println("Error:"+error++);
		transition = new Transition("T"+i++,"D"+i,Collection.getStateByName("S1"),Collection.getStateByName("S3"),transitionTrigger,transitionGuard,transitionAction);
		System.out.println("Error:"+error++);
		Collection.addTransition(transition.getEdge().getEdgeId(), transition);
		System.out.println("Error:"+error++);
		transition = new Transition("T"+i++,"D"+i,Collection.getStateByName("S1"),Collection.getStateByName("S4"),transitionTrigger,transitionGuard,transitionAction);
		System.out.println("Error:"+error++);
		Collection.addTransition(transition.getEdge().getEdgeId(), transition);
		System.out.println("Error:"+error++);
		transition = new Transition("T"+i++,"D"+i,Collection.getStateByName("S2"),Collection.getStateByName("S5"),"C5",transitionGuard,transitionAction);
		System.out.println("Error:"+error++);
		Collection.addTransition(transition.getEdge().getEdgeId(), transition);
		System.out.println("Error:"+error++);
		transition = new Transition("T"+i++,"D"+i,Collection.getStateByName("S4"),Collection.getStateByName("S6"),"C12",transitionGuard,transitionAction);
		System.out.println("Error:"+error++);
		Collection.addTransition(transition.getEdge().getEdgeId(), transition);
		System.out.println("Error:"+error++);
		transition = new Transition("T"+i++,"D"+i,Collection.getStateByName("S6"),Collection.getStateByName("S3"),"C16",transitionGuard,transitionAction);
		System.out.println("Error:"+error++);
		Collection.addTransition(transition.getEdge().getEdgeId(), transition);
		System.out.println("Error:"+error++);
		System.out.println("MAIN: All Transitions Added");
		System.out.println("Entering Front End");
		StateChart stateChart = new StateChart(Collection.getStateList(), Collection.getTransitionList());
		stateChart.setStartState(Collection.getStateByName("S1"));
		FrontEnd fe = new FrontEnd();
		System.out.println(fe.dfs(stateChart, stateChart.getStartState()));
	}
}