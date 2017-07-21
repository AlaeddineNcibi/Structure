
import java.util.ArrayList;
import java.util.*;


public class list {


	/* Add all elements( matches) that start with "prefix" and that have a size equal to the size of "prefix" + 1 in the structure "ls"
	 * using information from the list "ListB" 
	 */
	public static  void AddElement(List<List<String>> ls, List<String> prefix, List<String> ListB) {
		List<String> NextElements = ListB.subList(ListB.indexOf(prefix.get(prefix.size()-1))+1, ListB.size());
		for (int i=0; i<NextElements.size(); i++){
			List<String> List = new ArrayList<String>();
			List.addAll(prefix);
			List.add(NextElements.get(i));
			System.out.println(List);
			ls.add(List);
		}
	}
	
	public static void main(String[] args) {
		/* Lists a, b and C declaration */
		List<String> ListA = new ArrayList<String>();
		List<String> ListB = new ArrayList<String>();
		List<String> ListC = new ArrayList<String>();

		/* The declaration of the list of the lists of matches  */
		List<List<String>> matches= new ArrayList<List<String>>();
		
		/* Lists Data */
		ListA.add(Integer.toString(0));
		for (int element = 1; element <= 19; element++) {
			ListB.add(Integer.toString(element));
		}
		ListC.add(Integer.toString(5));
		
		/* Main code */
		long debut = System.currentTimeMillis();
		AddElement(matches, ListA, ListB);
		for (int size=2; size<=ListB.size(); size++){
			for (int index=0; index<matches.size()+1; index++){
				AddElement(matches, matches.get(0), ListB);
				matches.remove(0);
			}
		}
		System.out.println(System.currentTimeMillis()-debut);
	}	
	
}