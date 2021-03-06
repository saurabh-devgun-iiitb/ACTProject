
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20150930 (SVN rev 66)
//----------------------------------------------------

package parser;

import java_cup.runtime.*;
import graph.BinaryOperation;
import graph.Operation;
import graph.Guard;
import graph.ActionClass;
import graph.Collection;
import graph.State;
import graph.INode;
import graph.IEdge;
import graph.StateChart;
import graph.Transition;
import graph.FrontEnd;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20150930 (SVN rev 66) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class parser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public parser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\024\000\002\015\011\000\002\002\004\000\002\002" +
    "\004\000\002\002\002\000\002\014\014\000\002\006\005" +
    "\000\002\007\005\000\002\005\005\000\002\005\003\000" +
    "\002\003\004\000\002\003\002\000\002\016\014\000\002" +
    "\012\005\000\002\013\005\000\002\017\005\000\002\011" +
    "\005\000\002\011\002\000\002\004\011\000\002\004\002" +
    "\000\002\010\005" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\077\000\004\011\004\001\002\000\004\006\007\001" +
    "\002\000\004\002\006\001\002\000\004\002\000\001\002" +
    "\000\004\030\010\001\002\000\004\004\011\001\002\000" +
    "\010\005\ufffe\012\ufffe\016\ufffe\001\002\000\010\005\ufff7" +
    "\012\013\016\ufff7\001\002\000\004\006\063\001\002\000" +
    "\010\005\uffff\012\uffff\016\uffff\001\002\000\006\005\017" +
    "\016\016\001\002\000\004\006\021\001\002\000\004\002" +
    "\001\001\002\000\006\005\ufff8\016\ufff8\001\002\000\004" +
    "\030\022\001\002\000\004\004\023\001\002\000\004\017" +
    "\024\001\002\000\004\006\061\001\002\000\004\020\027" +
    "\001\002\000\004\021\033\001\002\000\004\006\030\001" +
    "\002\000\004\030\031\001\002\000\004\021\ufff4\001\002" +
    "\000\010\005\ufff1\022\036\023\ufff1\001\002\000\004\006" +
    "\034\001\002\000\004\030\035\001\002\000\010\005\ufff3" +
    "\022\ufff3\023\ufff3\001\002\000\004\006\054\001\002\000" +
    "\006\005\uffef\023\041\001\002\000\004\005\053\001\002" +
    "\000\004\006\042\001\002\000\004\025\043\001\002\000" +
    "\004\030\044\001\002\000\004\026\045\001\002\000\004" +
    "\030\046\001\002\000\012\005\ufff9\007\ufff9\015\ufff9\027" +
    "\ufff9\001\002\000\006\007\050\027\051\001\002\000\004" +
    "\030\052\001\002\000\004\005\ufff0\001\002\000\012\005" +
    "\ufffa\007\ufffa\015\ufffa\027\ufffa\001\002\000\006\005\ufff6" +
    "\016\ufff6\001\002\000\004\030\055\001\002\000\004\010" +
    "\057\001\002\000\006\005\ufff2\023\ufff2\001\002\000\004" +
    "\030\060\001\002\000\006\005\uffee\023\uffee\001\002\000" +
    "\004\030\062\001\002\000\004\020\ufff5\001\002\000\004" +
    "\030\064\001\002\000\004\004\065\001\002\000\004\013" +
    "\066\001\002\000\004\006\067\001\002\000\004\030\070" +
    "\001\002\000\004\014\072\001\002\000\004\015\076\001" +
    "\002\000\004\006\073\001\002\000\004\030\046\001\002" +
    "\000\006\007\050\015\ufffc\001\002\000\004\005\101\001" +
    "\002\000\004\006\077\001\002\000\004\030\046\001\002" +
    "\000\006\005\ufffb\007\050\001\002\000\010\005\ufffd\012" +
    "\ufffd\016\ufffd\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\077\000\004\015\004\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\004\002\011\001\001\000\006\003\014\014" +
    "\013\001\001\000\002\001\001\000\002\001\001\000\004" +
    "\016\017\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\004" +
    "\012\024\001\001\000\002\001\001\000\004\013\025\001" +
    "\001\000\004\017\031\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\004\011\036\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\004\004\037\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\004\005\046\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\004\010\055\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\004\006\070\001\001\000\004\007" +
    "\074\001\001\000\002\001\001\000\004\005\073\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\004\005\077\001\001\000\002\001\001\000\002\001\001" +
    "" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



	public static void main(String args[]) throws Exception {
		new parser(new Yylex(System.in)).parse();
	}


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$parser$actions {
  private final parser parser;

  /** Constructor */
  CUP$parser$actions(parser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$parser$do_action_part00000000(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parser$result;

      /* select the action based on the action number */
      switch (CUP$parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // system ::= SYSTEM COLON ID LBRACE states transitions RBRACE 
            {
              StateChart RESULT =null;
		 
				 System.out.println("Parser: Stage 1 of Cup.");
				 StateChart sc=new StateChart(Collection.getStateList(),Collection.getTransitionList());
				 System.out.println("Parser: Statechart successfully created."); 
				 System.out.println("Here Statechart says:\n\tNumber of States = "+sc.getNumberOfStates()+"\n\tNo of Transitions = "+sc.getNumberOfTransitions());
				 System.out.print("States are as follows:\n\t");
				 for(State state: sc.getStateSet()){
					System.out.print(state.getName()+",");
				 }
				 System.out.print("\n\nTransitions are as follows:\n\t");	 													 
				 for(Transition transition : sc.getTransitionSet()){
					System.out.print(transition.getName()+",");
				 } 
				 System.out.println("\nEntering Front End Path Generation");
				 sc.setStartState(Collection.getStateByName("s1"));				 
				 FrontEnd fe = new FrontEnd();
				 System.out.println(fe.dfs(sc,sc.getStartState()));
				 //fe.dfs(sc.getGraph(), sc.getStartState().getNode());
				 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("system",11, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-6)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= system EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		StateChart start_val = (StateChart)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = start_val;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$parser$parser.done_parsing();
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // states ::= states state 
            {
              Object RESULT =null;
		int staleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int staright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		State sta = (State)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
									 System.out.println("Parser: Stage 2.1 of Cup.");
									 Collection.addState(sta.getNode().getNodeId(), sta);
									 System.out.println("Parser: State "+sta.getName()+" added to Collection"); 
									 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("states",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // states ::= 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("states",0, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // state ::= STATE COLON ID LBRACE DESC COLON ID inputsAll clickableAll RBRACE 
            {
              State RESULT =null;
		int id1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-7)).left;
		int id1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-7)).right;
		String id1 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-7)).value;
		int id2left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).left;
		int id2right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).right;
		String id2 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-3)).value;
		 
								System.out.println("Parser: Stage 3.1 of Cup.");
								//System.out.println("Parser: Values of state"+ Collection.getInputList()+" "+Collection.getClickableList());
								RESULT=new State(id1,id2,Collection.getInputList(),Collection.getClickableList());
								System.out.println("Parser: State "+id1+" Identified"); 
								
              CUP$parser$result = parser.getSymbolFactory().newSymbol("state",10, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-9)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // inputsAll ::= INPUT COLON idList 
            {
              Object RESULT =null;
		
									System.out.println("Parser: Stage 4.1 of Cup.");
									Collection.addInputListFromIdList();
									System.out.println("Parser: InputList Identified");
								
              CUP$parser$result = parser.getSymbolFactory().newSymbol("inputsAll",4, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // clickableAll ::= CLICKABLE COLON idList 
            {
              Object RESULT =null;
		
									System.out.println("Parser: Stage 4.2 of Cup.");
									Collection.addClickableListFromIdList();
									System.out.println("Parser: ClickableList Identified");
								
              CUP$parser$result = parser.getSymbolFactory().newSymbol("clickableAll",5, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // idList ::= idList COMMA ID 
            {
              Object RESULT =null;
		int id1left = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int id1right = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String id1 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
									System.out.println("Parser: Stage 5 of Cup.");
									Collection.addId(id1);
									System.out.println("Parser: Id "+id1+" identified in a State and added");
										
              CUP$parser$result = parser.getSymbolFactory().newSymbol("idList",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // idList ::= ID 
            {
              Object RESULT =null;
		int id2left = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int id2right = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String id2 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
									System.out.println("Parser: Stage 5 of Cup.");
									Collection.addId(id2);
									System.out.println("Parser: Id "+id2+" identified in a State and added");
									
              CUP$parser$result = parser.getSymbolFactory().newSymbol("idList",3, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // transitions ::= transitions transition 
            {
              Object RESULT =null;
		int tleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int tright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Transition t = (Transition)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
									 System.out.println("Parser: Stage 2 of Cup.");
									 Collection.addTransition(t.getEdge().getEdgeId(), t);
									 System.out.println("Parser: Transition "+t.getName()+" added to Collection"); 
									 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("transitions",1, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // transitions ::= 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("transitions",1, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // transition ::= TRANSITION COLON ID LBRACE source dest trigger guard acti RBRACE 
            {
              Transition RESULT =null;
		int nameleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-7)).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-7)).right;
		String name = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-7)).value;
		int srcleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-5)).left;
		int srcright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-5)).right;
		State src = (State)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-5)).value;
		int desleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).left;
		int desright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).right;
		State des = (State)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-4)).value;
		int trigleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).left;
		int trigright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).right;
		String trig = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-3)).value;
		int grdleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int grdright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Guard grd = (Guard)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int actleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int actright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object act = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		 	
					System.out.print("Parser: Stage 3 of Cup.");
					System.out.println(" A Transition "+name+" Identified");
					Transition transition=new Transition(name,"Desc1",src,des,trig,null,null);
					RESULT = transition;
					System.out.println("Parser: Transition "+transition.getName()+" Made"); 
		 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("transition",12, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-9)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // source ::= SOURCE COLON ID 
            {
              State RESULT =null;
		int idleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int idright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String id = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 
					System.out.println("Parser: Stage 4.1 of Cup.");
					State state =Collection.getStateByName(id);
					RESULT = state;
					System.out.println("Parser: Source of a Transition Identified as "+state); 
					
              CUP$parser$result = parser.getSymbolFactory().newSymbol("source",8, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // dest ::= DEST COLON ID 
            {
              State RESULT =null;
		int idleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int idright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String id = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 
					System.out.println("Parser: Stage 4.2 of Cup.");
					RESULT=Collection.getStateByName(id);
					System.out.println("Parser: Destination of a Transition Identified as "+id); 
					
              CUP$parser$result = parser.getSymbolFactory().newSymbol("dest",9, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // trigger ::= TRIGGER COLON ID 
            {
              String RESULT =null;
		int idleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int idright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String id = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 
					System.out.println("Parser: Stage 4.3 of Cup.");
					RESULT=id;
					System.out.println("Parser: Trigger of a Transition Identified as "+id); 
					
              CUP$parser$result = parser.getSymbolFactory().newSymbol("trigger",13, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // guard ::= GUARD COLON exp 
            {
              Guard RESULT =null;
		int exprleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int exprright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		BinaryOperation expr = (BinaryOperation)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 
						System.out.println("Parser: Stage 4.4 of Cup.");
						Guard g1=new Guard(Collection.getOperationList());
						System.out.println(g1);
						System.out.println("Parser: Guard of a transition Identified"); 
						
              CUP$parser$result = parser.getSymbolFactory().newSymbol("guard",7, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // guard ::= 
            {
              Guard RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("guard",7, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // acti ::= ACTI COLON SAVE ID openBracket idList closeBracket 
            {
              Object RESULT =null;
		int id1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).left;
		int id1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).right;
		String id1 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-3)).value;
		 
						System.out.println("Parser: Stage 4.5 of Cup.");
						ActionClass action = new ActionClass(id1,Collection.getIdList());
						System.out.println("Parser: Keyset is "+ action.store.keySet().toString());
						System.out.println("Parser: Action of a transition Identified"); 
						
              CUP$parser$result = parser.getSymbolFactory().newSymbol("acti",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-6)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // acti ::= 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("acti",2, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // exp ::= ID EQUAL ID 
            {
              BinaryOperation RESULT =null;
		int id1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int id1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		String id1 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int id2left = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int id2right = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String id2 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 
						System.out.println("Parser: Stage 5.1 of Cup.");
						Operation bin1=new BinaryOperation(id1,"=",id2);
						Collection.addOperation(bin1);
						System.out.println(bin1.toString());
						System.out.println("Parser: Expression added to Collection"); 
						
              CUP$parser$result = parser.getSymbolFactory().newSymbol("exp",6, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$parser$do_action(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
              return CUP$parser$do_action_part00000000(
                               CUP$parser$act_num,
                               CUP$parser$parser,
                               CUP$parser$stack,
                               CUP$parser$top);
    }
}

}
