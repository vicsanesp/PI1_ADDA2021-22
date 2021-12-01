package ejercicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import us.lsi.common.Files2;

public class Ejercicio2 {
	
	// FORMA FUNCIONAL
	public static Map<Integer,List<String>> ejercicio2(List<List<String>> listas) {
		return listas.stream()
				.flatMap(lista -> lista.stream())
				.collect(Collectors.groupingBy(String::length));
	}

//---------------------------------------------------------------------------------------------
	// FORMA ITERATIVA
	public static Map<Integer,List<String>> ejercicio2It(List<List<String>> listas) {
		Map<Integer, List<String>> mapa = new HashMap<>();
		int i = 0; // inicia el puntero 'i' a 0
		
		while(i < listas.size()) { // se escribe while porque el formato es List<List<String>> y necesitamos mirar cada elemento
			int j = 0;
			
			while(j < listas.get(i).size()) {
				Integer longPalabraListaChikita = listas.get(i).get(j).length(); //coge la longitud de cada palabra
				String palabra = listas.get(i).get(j); //coge las diferentes palabras
				
				if(mapa.containsKey(longPalabraListaChikita)) {
					mapa.get(longPalabraListaChikita).add(palabra); // si la palabra coincide con la longitud, añadela
				} 
				else {
					List<String> listaAux = new ArrayList<>();
					listaAux.add(palabra);
					mapa.put(longPalabraListaChikita, listaAux); // si no está en el mapa, añadelo
				}
				j++; // se pone esto para que pase al siguiente elemento de la lista chikita
			}
			
			i++; // se pone 'i++' para que pase a la siguiente lista
		}
		
		return mapa;
	}
	
//---------------------------------------------------------------------------------------------	
	// FORMA RECURSIVA FINAL
	public static Map<Integer,List<String>> ejercicio2Rec(List<List<String>> listas) {
		Map<Integer, List<String>> mapa = new HashMap<>();
		return ejercicio2RecFin(listas, mapa, 0, 0);	
	}
	
	
	public static Map<Integer,List<String>> ejercicio2RecFin(List<List<String>> listas, 
			Map<Integer, List<String>> mapa, Integer i, Integer j) {
		if (i < listas.size()) {
			if (j < listas.get(i).size()) {
				Integer longPalabraListaChikita = listas.get(i).get(j).length(); // longitud de cada palabra
				String palabra = listas.get(i).get(j); // selecciona las diferentes palabras
				if (mapa.containsKey(longPalabraListaChikita)) {
					mapa.get(longPalabraListaChikita).add(palabra);
				}
				else {
					List<String> listaAux = new ArrayList<>();
					listaAux.add(palabra);
					mapa.put(longPalabraListaChikita, listaAux); // si no está en el mapa, añadelo
				}
				mapa = ejercicio2RecFin(listas, mapa, i, j+1);
			}
			else {
				mapa = ejercicio2RecFin(listas, mapa, i+1, 0);
			}
		}
		return mapa;	
	}

//---------------------------------------------------------------------------------------------	
	// LECTOR DEL EJERCICIO 2
	public static List<List<String>> lectorEj2(String ruta) {
		List<List<String>> lista = new ArrayList<>();
		List<String> res = Files2.linesFromFile(ruta);
		
		for (int i = 0; i < res.size(); i++) {
			String[] campos = res.get(i).split(",");
			List<String> listaAux = new ArrayList<>();
			
			for (int j = 0; j < campos.length; j++) {
				listaAux.add(campos[j]);
			}
			lista.add(listaAux);
		}
		
		return lista;
	}

}
