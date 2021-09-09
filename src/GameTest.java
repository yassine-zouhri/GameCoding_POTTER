
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GameTest {
	
	static double[] pourcentages = { 1, 0.95, 0.90, 0.80, 0.75 };
	static int[]  reduction = new int[5];
	
	public static Double calcul(List<Integer> listLivre) {
		
		  if ( listLivre.isEmpty() ||  listLivre == null) {
			  return 0.0;  
		  }
			  
		  int[] listRedoublantLivre = CalculeRedoublantLivre(listLivre);
		  CalculePourcentage(listRedoublantLivre);
		  
		  double prixTotal = 0.0;
		  for (int i = 0; i < reduction.length; i++) {
			  prixTotal += reduction[i] * 8 * pourcentages[i] * (i+1); 
	  	  }
		  return prixTotal;
	 }
	
	public static  int[] CalculeRedoublantLivre(List<Integer> listLives) {
		
		  int[] resultat = new int[5];
		  for (int item : listLives) {
			  resultat[item - 1]++;
		  }
		  return resultat;
		  
	}
	
	public static  void CalculePourcentage(int[] listRedoublant) {
		
		  if (listRedoublant == null) return;

		  int nombreLivre = 0;
		  for (int i = 0; i < listRedoublant.length; i++) {
			  if (listRedoublant[i] > 0) {nombreLivre++; listRedoublant[i]--;}
		  }
		  
		  
		  if (nombreLivre > 0) {
			  reduction[nombreLivre - 1] += 1;
			  CalculePourcentage(listRedoublant);
		  }
	}
	

	 
	
	
    
    
     public static void main(String[] args) {

    	 List<Integer> listLivre= new ArrayList<Integer>() ;
    	 listLivre.add(1);listLivre.add(1 );listLivre.add( 2);listLivre.add( 3);listLivre.add( 3);listLivre.add( 4);
    	 double prix = calcul(listLivre);
    	 System.out.println("Prix total = " + prix);
	}
}