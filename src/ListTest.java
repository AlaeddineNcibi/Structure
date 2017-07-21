//import java.awt.List;
import java.util.ArrayList;
import java.util.*;
import java.util.Collections; 

public class ListTest {

	/* Return the sublist "res" that stars with the first appearance of the element "s" in the initial list "ls" */
	public static ArrayList<String> subArrayList(ArrayList<String> ls, String s) {
		ArrayList<String> res = new ArrayList<String>();
		//position of the first occurrence of the element "s" in the list "ls"
		int index=Collections.indexOfSubList(ls,Arrays.asList(s))+1;
		for (int k = index; k < ls.size(); k++) {
			res.add(ls.get(k));
		}
		return res;
	}
	
	/* Return the sublist "res" that stars from the position "i" the initial list "ls" */
	public static ArrayList<String> subArrayList(ArrayList<String> ls, int i) {
		ArrayList<String> res = new ArrayList<String>();
		for (int k = i; k < ls.size(); k++) {
			res.add(ls.get(k));
		}
		return res;
	}
	
	
	/* Add all elements( matches) that start with "prefix" and that have a size equal to the size of "prefix" + 1 in the structure "ls"
	 * using information from the list "ListB" 
	 */
	public static  void AddElement(ArrayList<ArrayList<String>> ls, ArrayList<String> prefix, ArrayList<String> ListB) {
		ArrayList<String> NextElements = subArrayList(ListB, prefix.get(prefix.size()-1));
		for (int i=0; i<NextElements.size(); i++){
			ArrayList<String> List = new ArrayList<String>();
			List.addAll(prefix);
			List.add(NextElements.get(i));
			System.out.println(List);
			ls.add(List);
		}
	}
	
	public static void main(String[] args) {
		/* Lists a, b and C declaration */
		ArrayList<String> ListA = new ArrayList<String>();
		ArrayList<String> ListB = new ArrayList<String>();
		ArrayList<String> ListC = new ArrayList<String>();

		/* The declaration of the list of the lists of matches  */
		ArrayList<ArrayList<String>> matches= new ArrayList<ArrayList<String>>();
		
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