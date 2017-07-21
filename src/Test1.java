import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.LinkedList;



public class Test1 {

	public static ArrayList<String> subArrayList(ArrayList<String> ls, int i, int j) {
		ArrayList<String> res = new ArrayList<String>();
		for (int k = i; k <= j; k++) {
			res.add(ls.get(k));
		}

		return res;
	}

	public static ArrayList<ArrayList<String>> Combinations(ArrayList<String> motList, int Longeur) {
		ArrayList<ArrayList<String>> Resultat = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < motList.size(); i++) {
			if (Longeur == 1)
				Resultat.add(subArrayList(motList, i, i)); 
			else { 
				ArrayList<String> ListIntermediaire = subArrayList(motList, i + 1,  motList.size() - 1);
				ArrayList<ArrayList<String>> CombiList = Combinations(ListIntermediaire, Longeur - 1);
				for (ArrayList<String> list : CombiList) {
					list.add(0, motList.get(i));
					Resultat.add(list);
				}
			}
		}
		return Resultat;
	}

	public static void main(String[] args) {

		/* Lists declaration*/
		ArrayList<String> ListA = new ArrayList<String>();
		ArrayList<String> ListB = new ArrayList<String>();
		ArrayList<String> ListC = new ArrayList<String>();
		//ArrayList<String> Combinations = new ArrayList<String>();
		ArrayList<ArrayList<String>> temp = new ArrayList<ArrayList<String>>();

		/* Lists Data */
		ListA.add(Integer.toString(0));
		for (int element = 1; element <= 19; element++) {
			ListB.add(Integer.toString(element));
		}
		ListC.add(Integer.toString(5));



		ArrayList<String> S = new ArrayList<String>() ;
		long debut = System.currentTimeMillis();
		for (int sizeB = 1; sizeB <= ListB.size(); sizeB++) {
			temp = Combinations(ListB, sizeB);
			for (int element = 0; element < temp.size(); element++) {
				S = temp.get(element);
				S.add(0,"0");
				System.out.println(S);
			}
		}

		System.out.println(System.currentTimeMillis()-debut);
	}

}