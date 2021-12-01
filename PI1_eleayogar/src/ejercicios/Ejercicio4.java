package ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import us.lsi.common.DoublePair;
import us.lsi.common.Files2;

public class Ejercicio4 {
	
/* Dados dos numeros 'n' y 'e' (con n real positivo mayor que 1 y e real en el intervalo [0,1)),
 * devuelva un numero real que se corresponda con la raiz cubica de n con un error menor que e.
*/
	
	// FORMA FUNCIONAL
	public static record Rango(Double i, Double j, Double raiz, Double n, Double e) {
		public static Rango of(Double i, Double j, Double n, Double e) {
			return new Rango(i, j, (i+j)/2, n, e);
		}
		
		public Rango Next() {
			Double raiz = (i+j)/2;
			Double cuboDeRaiz = (raiz * raiz * raiz);
			Rango r;
			if(cuboDeRaiz > n) {
				r = Rango.of(i, raiz, n, e);
			} else {
				r = Rango.of(raiz, j, n, e);
			}
			return r;
		}
	}
	
	public static Double ejercicio4(Double n, Double e) {
		Rango ir = Rango.of(0., n, n, e);
		Stream<Rango> stream = Stream.iterate(ir, r -> r.Next());
		Optional<Rango> res = stream.filter(r->Math.abs(r.n()-(r.raiz()*r.raiz()*r.raiz()))<r.e()).findFirst();
		return res.get().raiz();
	}
	
//---------------------------------------------------------------------------------------------
	// FORMA ITERATIVA
	public static Double ejercicio4It(Double n, Double e) {
		Double i = 0.;  // es el puntero (numero inicial)
		Double j = n;   // renombro 'n'
		
		while(true) {
			Double raiz = (i + j) /2; // ayamos la mitad de 'n'
			Double cuboDeRaiz = (raiz * raiz * raiz);
			Double diferencia = cuboDeRaiz - n;
			if(Math.abs(diferencia) < e ) {
				return raiz;
			}
			else if(cuboDeRaiz > n) {
				j = raiz;
			} else {
				i = raiz;
			}
		}
	}
//---------------------------------------------------------------------------------------------	
	// FORMA RECURSIVA FINAL
	public static Double ejercicio4Rec(Double n, Double e) {
		return ejercicio4RecFin(n, e, 0., n);
	}
	
	public static Double ejercicio4RecFin(Double n, Double e, Double i, Double j) {
		Double raiz = (i + j) /2; // ayamos la mitad de 'n'
		Double cuboDeRaiz = (raiz * raiz * raiz);
		Double diferencia = cuboDeRaiz - n;
		if(Math.abs(diferencia) < e ) {
			return raiz;
		} else {
			if(cuboDeRaiz > n) {
				return ejercicio4RecFin(n, e, i, raiz);
			} else {
				return ejercicio4RecFin(n, e, raiz, j);
			}
		}
	}
//---------------------------------------------------------------------------------------------
	// LECTOR DEL EJERCICIO 4
	public static List<DoublePair> lectorEj4(String ruta) {
		List<String> fichero = Files2.linesFromFile(ruta); //para leer el fichero del Ejercicio 4
		List<DoublePair> lista = new ArrayList<>(); // lista en la que se mete la información que se lee
		
		for (int i = 0; i < fichero.size(); i++) {
			Double priNum = Double.valueOf(fichero.get(i).split(",")[0]);
			Double segNum = Double.valueOf(fichero.get(i).split(",")[1]);
			lista.add(DoublePair.of(priNum, segNum));			
		}
		return lista;
	}
}
