//Made a change to this line ONLY
package graph;
import java.util.*;
//same file different place
public class ActionClass {
	private Transition transition;
	public static HashMap<String, HashMap<Integer, HashMap<String, Object>>> store = new HashMap<String, HashMap<Integer, HashMap<String, Object>>>();	
		//List of tables, string or objects
	private HashMap<String, Object> hm;		//for symbol to table mapping.A- table 1; B-table 2.
	public ActionClass(String id, List<String> list){
		System.out.println("ActionClass: Constructor call\nActionClass: Searching for "+id+"\nActionClass: Current Store is "+store.keySet().toString());
		if(store.keySet() == null){			//no table exists
			System.out.println("Actionclass: First time Entry");
			store.put(id, new HashMap<Integer, HashMap<String, Object>>());
			System.out.println("ActionClass: Table "+id+" created.");
			hm = new HashMap<>();
			for(int j = 0;j < list.size();j++){
				hm.put(list.get(j), null);
			}
			store.get(id).put(store.get(id).size()+1, hm);
		}
		else{
			boolean flag = false;
			for (int i = 0; i < store.size(); i++) {
				if(store.keySet().contains(id)){		//search existing table
					flag = true;
					hm = new HashMap<>();
					for(int j=0;j<list.size();j++){
						hm.put(list.get(j), null);
					}
					store.get(id).put(store.get(id).size()+1, hm);
				}
			}
			if(flag == false){							//table not found
				store.put(id, new HashMap<Integer, HashMap<String, Object>>());
				System.out.println("ActionClass: Table "+id+" created.");
				hm = new HashMap<>();
				for(int j = 0;j < list.size();j++){
					hm.put(list.get(j), null);
				}
				store.get(id).put(store.get(id).size()+1, hm);
			}
		}
	}
	//update method
	//delete method
	//retrieve method
}
