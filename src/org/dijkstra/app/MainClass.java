package org.dijkstra.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author Zakaria RHORBAL
 * @Class Cette classe contient la methode plusLongChemin qui calcule le max de
 *        biscuits possible que la sousis pourra avaler
 * 
 * @Method : return an array of integers La methode prend en parametres le
 *         tableau en question la valeur de retourne sera un tableau de longueur
 *         = longueur(tableau en question * 2) -1
 * 
 * @Algorithme : Nous allons comparer deux valeurs : - à droite de notre
 *             position (i,j) avec la valeur en bas de notre position (i,j)
 * 
 * @Optimisation : Cette algorithme n'est pas exacte, on peut utiliser le brute
 *               force et parcourir tous les chemins possibles et comparerer la
 *               somme de tous les element d'un chemin. le max (chemins) sera la
 *               sortie attendu. Mais ça demende du temps d'excution énorme.
 *               Solution : soit on utilise Dijiktra ou parcours en profondeurs
 *               avec les algorithme de machine Learning.
 * 
 * @version : 0.0.1beta
 */
public class MainClass {

	private static final String COMMA_DELIMITER = ",";
	
	public static int[] plusLongChemin(int[][] arrays) {

		final int arrayLength = arrays.length;
		final int resultLength = (arrayLength * 2) - 1;
		int[] result = new int[resultLength];
		result[0] = arrays[0][0];
		result[resultLength - 1] = arrays[arrayLength - 1][arrayLength - 1];
		System.out.println(result.length);
		System.out.println("**************initialisation *****************");
		for (int v : result) {
			System.out.println(v);
		}
		System.out.println("**************Fin initialisation ****************");
		int i = 0;
		int j = 0;
		long start = System.currentTimeMillis();
		long sm = 0;
		while ((i < arrayLength - 1) || (j < arrayLength - 1)) {
			int right = 0;
			int bottom = 0;
			if (i >= arrayLength - 1) {
				right = arrays[i][j + 1];
				bottom = 0;
			} else if (j >= arrayLength - 1) {
				right = 0;
				bottom = arrays[i + 1][j];
			} else {
				right = arrays[i][j + 1];
				bottom = arrays[i + 1][j];
			}
			System.out.println("compare ( " + right + " and " + bottom + " )");
			if (right > bottom) {
				j++;
				result[i + j] = right;
			} else {
				i++;
				result[i + j] = bottom;
			}
			sm += result[i + j];
		}
		System.out.println("time to execute while " + (System.currentTimeMillis() - start) + " ms");
		System.out.println("------------------sum of all elements in result : " + sm);
		int indice = 1;
		for (int v : result) {
			System.out.println("result : { " + indice + " }: " + v);
			indice++;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[][] test = new int[100][100];
		// Read from file ;
		try {
			File myObj = new File("array.csv");
			Scanner myReader = new Scanner(myObj);
			String[] data = new String[100];
			int k = 0;
			while (myReader.hasNextLine()) {
				data[k] = myReader.nextLine();
				k++;
			}
			System.out.println("************* k =" + k);
			int i = 0;
			int j = 0;
			for (String s : data) {
				String[] splitCar = s.split(COMMA_DELIMITER);
				j = 0;
				for (String t : splitCar) {
					test[i][j] = Integer.parseInt(t);
					System.out.print("(" + i + " , " + j + ") = " + t + "*************");
					j++;
				}
				i++;
			}
			System.out.println("------------------the last :" + test[99][99]);
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		System.out.println("Debut");
		MainClass.plusLongChemin(test);
	}
}
