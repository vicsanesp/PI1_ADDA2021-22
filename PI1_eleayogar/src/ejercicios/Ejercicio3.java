package ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import us.lsi.common.Files2;

public class Ejercicio3 {
	
	// FORMA FUNCIONAL
	public static String ejercicio3(Integer a, Integer limit) {
		return Stream
				.iterate(Par.of(0, a),
						t -> t.v1 < limit,
						t -> Par.of(t.v1+1, t.v1 % 3 == 1 ? t.v2 : t.v1+t.v2))
				.collect(Collectors.toList())
				.toString();
	}

//---------------------------------------------------------------------------------------------
	// FORMA ITERATIVA
	// Creo el record que se menciona en el enunciado del ejercicio 3
	public record Par (Integer v1, Integer v2) {
		public static Par of(Integer v1, Integer v2) {
			return new Par(v1,v2);
		}
	}
	
	public static String ejercicio3It(Integer a, Integer limit) {
		Par p = Par.of(0,a); // hago un llamado al record y lo renombro como "p"
		List<Par> lista = new ArrayList<>(); // creo una lista vacia llamada "lista"
		lista.add(p); // con esto se añada el primer elemento de la lista dentro de la lista
		
		while(p.v1 < limit) {  // dentro del while se pone el segundo parametro del itarate
			p = Par.of(p.v1+1, p.v1 % 3 == 1 ? p.v2 : p.v1+p.v2);
			lista.add(p);
		}

		return lista.toString();
	}


//---------------------------------------------------------------------------------------------
	// FORMA RECURSIVA FINAL
	public static String ejercicio3Rec(Integer a, Integer limit) {
		Par p = Par.of(0,a);
		List<Par> lista = new ArrayList<>();
		lista.add(p);
		return ejercicio3RecFin(a, limit, p, lista);
	}
	
	public static String ejercicio3RecFin(Integer a, Integer limit, Par p, List<Par> lista) {
		if (p.v1 < limit) {
			p = Par.of(p.v1+1, p.v1 % 3 == 1 ? p.v2 : p.v1+p.v2);
			lista.add(p);
		} else {
			return lista.toString();
		}
		return ejercicio3RecFin(a, limit, p, lista);
		
	}
	
	// otra versión, en la que primero ponemos el caso en el que no se cumple el if y luego 
	// se pone el caso en el que se cumple el fin
	public static String ejercicio3RecFin2(Integer a, Integer limit, Par p, List<Par> lista) {
		if (p.v1 >= limit) {
			return lista.toString();
			
		} else {
			p = Par.of(p.v1+1, p.v1 % 3 == 1 ? p.v2 : p.v1+p.v2);
			lista.add(p);
			return ejercicio3RecFin2(a, limit, p, lista);
		}
		
		
	}

//---------------------------------------------------------------------------------------------
	// LECTOR DEL EJERCICIO 3
	public static List<Par> lectorEj3(String ruta) {
		List<Par> lista = new ArrayList<>();
		List<String> res = Files2.linesFromFile(ruta);
		for (int i = 0; i < res.size(); i++) {
			String[] campos = res.get(i).split(",");
			Par aux = Par.of(Integer.parseInt(campos[0]), Integer.parseInt(campos[1]));
			lista.add(aux);
		}
		return lista;
	}

}
