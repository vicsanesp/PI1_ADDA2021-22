package tests;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import ejercicios.Ejercicio1;
import ejercicios.Ejercicio2;
import ejercicios.Ejercicio3;
import ejercicios.Ejercicio3.Par;
import ejercicios.Ejercicio4;
import us.lsi.common.DoublePair;
import us.lsi.common.Files2;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("\nEJERCICIO 1");
		List<List<String>> ej1 = Ejercicio1.lectorEj1("./ficheros/PI1E1_DatosEntrada.txt");
		
		// El predicado sobre String devuelve cierto si dicho String contiene 'a', 'e' ó 'o'
		Predicate<String> pS = s -> (s.contains("a") || s.contains("e") || s.contains("o"));
		
		// El predicado sobre Integer devuelve cierto si ese entero es par
		// para saber si es par se divide entre 2 y se comprueba que el resto es igual a 0
		Predicate<Integer> pI = s -> s%2 == 0;
		
		// La función String -> Integer devuelve la longitud de la cadena 
		Function<String, Integer> f = s -> s.length();

		for (int i = 0; i < ej1.size(); i++) {
			System.out.println("Entrada: " + ej1.get(i));
			System.out.println("1. Iterativa (while):\t " + Ejercicio1.ejercicio1(ej1.get(i), pS, pI, f));
			System.out.println("2. Recursiva final:\t " + Ejercicio1.ejercicio1Rec(ej1.get(i), pS, pI, f));
			System.out.println("3. Funcional:\t\t " + Ejercicio1.ejercicio1(ej1.get(i), pS, pI, f));
			System.out.println("");
		}

		
//---------------------------------------------------------------------------------------------
		System.out.println("\nEJERCICIO 2");
		List<List<String>> ej2_1 = Ejercicio2.lectorEj2("./ficheros/PI1E2_DatosEntrada1.txt");
		List<List<String>> ej2_2 = Ejercicio2.lectorEj2("./ficheros/PI1E2_DatosEntrada2.txt");

		System.out.println("Entrada: " + ej2_1);
		System.out.println("1. Iterativa (while):\t " + Ejercicio2.ejercicio2It(ej2_1));
		System.out.println("2. Recursiva final:\t " + Ejercicio2.ejercicio2Rec(ej2_1));
		System.out.println("3. Funcional:\t\t " + Ejercicio2.ejercicio2(ej2_1));
		System.out.println("");
		
		System.out.println("Entrada: " + ej2_2);
		System.out.println("1. Iterativa (while):\t " + Ejercicio2.ejercicio2It(ej2_2));
		System.out.println("2. Recursiva final:\t " + Ejercicio2.ejercicio2Rec(ej2_2));
		System.out.println("3. Funcional:\t\t " + Ejercicio2.ejercicio2(ej2_2));
		System.out.println("");

		
//---------------------------------------------------------------------------------------------
		System.out.println("\nEJERCICIO 3");
		List<Par> ej3 = Ejercicio3.lectorEj3("./ficheros/PI1E3_DatosEntrada.txt");
		for (int i = 0; i < ej3.size(); i++) {
			System.out.println("Entrada: " + ej3.get(i));
			System.out.println("1. Iterativa (while):\t " + Ejercicio3.ejercicio3It(ej3.get(i).v1(), ej3.get(i).v2()));
			System.out.println("2. Recursiva final:\t " + Ejercicio3.ejercicio3Rec(ej3.get(i).v1(), ej3.get(i).v2()));
			System.out.println("3. Funcional:\t\t " + Ejercicio3.ejercicio3(ej3.get(i).v1(), ej3.get(i).v2()));
			System.out.println("");
		}

		
//---------------------------------------------------------------------------------------------
		System.out.println("\nEJERCICIO 4");
		List<DoublePair> ej4 = Ejercicio4.lectorEj4("./ficheros/PI1E4_DatosEntrada.txt");
		for (int i = 0; i < ej4.size(); i++) {
			System.out.println("Entrada: " + ej4.get(i));
			System.out.println("1. Iterativa (while):\t " + Ejercicio4.ejercicio4It(ej4.get(i).first(), ej4.get(i).second()));
			System.out.println("2. Recursiva final:\t " + Ejercicio4.ejercicio4Rec(ej4.get(i).first(), ej4.get(i).second()));
			System.out.println("3. Funcional:\t\t " + Ejercicio4.ejercicio4(ej4.get(i).first(), ej4.get(i).second()));
			System.out.println("");
		}
	}

}
