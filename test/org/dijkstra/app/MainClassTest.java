package org.dijkstra.app;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

/**
 * 
 * @author Zakaria RHORBAL 
 * 
 * @Class Cette classe contients 4 tests unitaires pour tester
 *         notre methode plusLongChemin
 *         
 * @Test4 contient le test principal:
 * 		- lecture des données depuis le fichier array.csv
 *
 */
class MainClassTest {

	private static final String COMMA_DELIMITER = ",";

	@Test
	void test() {
		int[][] test = new int[][] { { 25, 14 }, { 21, 100 } };
		int[] resultTab = MainClass.plusLongChemin(test);
		int[] exepected = { 25, 21, 100 };
		assertArrayEquals(exepected, resultTab);
	}

	@Test
	void test2() {
		int[][] test = new int[][] { { 25, 14, 15 }, { 21, 100, 47 }, { 1, 10, 47 } };
		int[] resultTab = MainClass.plusLongChemin(test);
		int[] exepected = { 25, 21, 100, 47, 47 };
		assertArrayEquals(exepected, resultTab);
	}

	@Test
	void test3() {
		int[][] test = new int[][] { { 25, 14, 15, 47 }, { 21, 100, 47, 4 }, { 14, 10, 80, 7 }, { 1000, 7, 470, 80 },

		};
		int[] resultTab = MainClass.plusLongChemin(test);
		int[] exepected = { 25, 21, 100, 47, 80, 470, 80 };
		assertArrayEquals(exepected, resultTab);

	}

	@Test
	void test4() {
		System.out.println("************************pas d'equals ici*********************");
		System.out.println("************************pas d'equals ici*********************");
		System.out.println("************************pas d'equals ici*********************");
		int[][] test = new int[100][100];
		// Read from file ;
		try {
			File myObj = new File("resources/array.csv");
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
		int[] resultTab = MainClass.plusLongChemin(test);
		System.out.println("pas d'equals ici");

	}
}
