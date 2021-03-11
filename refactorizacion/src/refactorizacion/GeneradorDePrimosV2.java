package refactorizacion;

/** Esta clase genera todos los números primos de 1 hasta un 
 * número máximo especificado por el usuario utilizando la 
 * criba de Eratóstenes 
 * <p> 
 * Dado un vector de enteros empezando en 2, se tachan todos 
 * los múltiplos de 2. A continuación, se encuentra el 
 * siguiente entero no tachado y se tachan sus múltiplos.  
 * Cuando se llega a la raíz cuadrada del valor máximo, los 
 * númerosque queden sin tachar son los números primos 
 * 
 * @author Fernando Berzal 
 * @version 2.0 Enero'2005 (FB)
 */

public class GeneradorDePrimosV2
{    
/* El código aun se puede mejorar
 * - eliminamos la variable dim (nos vale esPrimo.length)
 * - elegimos identificadores más adecuados para los métodos y 
 * - reorganizamos el interior del método inicializarCandidatos (el antiguo inicializarCriba).
 */
	private static boolean esPrimo[];  
	private static int primos[];
	
	public static int[] generarPrimosM2 (int max)
	{      
		if (max < 2) {       
			return new int[0];  // Vector vacío   
			} else {   
				inicializarCandidatos(max);       
				eliminarMultiplos();       
				obtenerCandidatosNoEliminados();
				return primos;     
			}
		}
	
	//elimino dim y reestructuro codigo
	
	private static void inicializarCandidatos (int max)   
	{       
		int i;    
		     
		esPrimo = new boolean[max+1];     	
		esPrimo[0] = esPrimo[1] = false; 
		for (i=2; i<esPrimo.length; i++)    
			esPrimo[i] = true;     
	}
	
	//cambio nombre metodo --> antiguo cribar()
	private static void eliminarMultiplos ()   
	{       
		int i,j;    
		for (i=2; i<Math.sqrt(esPrimo.length)+1; i++) {    
			if (esPrimo[i]) {           
				// Eliminar los múltiplos de i
				for (j=2*i; j<esPrimo.length; j+=i)    
					esPrimo[j] = false;         
				} 
			}  
		}
	
	//Cambio nombre de metodo --> antiguo rellenarPrimos()
	private static void obtenerCandidatosNoEliminados ()   
	{    
		int i, j, cuenta;
		// Contar primos    
		cuenta = 0;       
		for (i=0; i<esPrimo.length; i++)         
			if (esPrimo[i])   
				cuenta++;     
		// Rellenar el vector de números primos
		primos = new int[cuenta];     
		for (i=0, j=0; i<esPrimo.length; i++)        
			if (esPrimo[i])           
				primos[j++] = i;     
		}
	}		
		