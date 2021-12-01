package ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import us.lsi.common.Files2;

public class Ejercicio1 {

	// FORMA FUNCIONAL
	public static boolean ejercicio1(List<String> ls, Predicate<String> pS,
			Predicate<Integer> pI, Function<String,Integer> f){
			return ls.stream().filter(pS).map(f).anyMatch(pI);
	}

//---------------------------------------------------------------------------------------------
	// FORMA ITERATIVA
	public static boolean ejercicio1It(List<String> ls, Predicate<String> pS,
			Predicate<Integer> pI, Function<String,Integer> f){
		int i = 0; // 'i' es el puntero que marca por donde voy en la lista
		boolean res = false; // es lo que se devuelve en la lista
		while(i < ls.size()) {
			String cosito = ls.get(i); // coge el elemento 'i' de ls
			if(pS.test(cosito)) {      // coresponde al filter => filter(pS)
				Integer cosito2 = f.apply(cosito);   // coresponde al map(f)
				if(pI.test(cosito2)) {
					res = true;
					return res;
				}
			}
			i++;
		}
		return false;
	}
	
//---------------------------------------------------------------------------------------------	
	// FORMA RECURSIVA FINAL
	public static boolean ejercicio1Rec(List<String> ls, Predicate<String> pS,
			Predicate<Integer> pI, Function<String,Integer> f){
		return ejercicio1RecFin(ls, pS, pI, f, 0);
	}
	
	public static boolean ejercicio1RecFin(List<String> ls, Predicate<String> pS,
			Predicate<Integer> pI, Function<String,Integer> f, Integer i){
		if(pI.test(f.apply(ls.get(i))) && pS.test(ls.get(i))) {
			return true; // este if es lo mismo que el if de la Forma Iterativa
		}
		else {
			if(i == ls.size()-1) { // si 'i' es el último elemento de 'ls'
				return false;
			}
			return ejercicio1RecFin(ls, pS, pI, f, i+1); // se llama así mismo y avanza la lista
		}
	}

//---------------------------------------------------------------------------------------------	
	// LECTOR DEL EJERCICIO 1
	public static List<List<String>> lectorEj1(String ruta) {
		List<List<String>> lista = new ArrayList<List<String>>(); // creo una lista de listas
		List<String> res = Files2.linesFromFile(ruta); // para que se lea la ruta del ejercicio 1
		for (int i = 0; i < res.size(); i++) {
			List<String> listaAux = new ArrayList<>(); // lista auxiliar
			String[] campos = res.get(i).split(",");
			for (int j = 0; j < campos.length; j++) {
				listaAux.add(campos[j]);
			}
			lista.add(listaAux);
		}
		return lista;
	}
}
