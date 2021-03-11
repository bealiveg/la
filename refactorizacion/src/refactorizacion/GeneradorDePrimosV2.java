package refactorizacion;

/** Esta clase genera todos los n�meros primos de 1 hasta un 
 * n�mero m�ximo especificado por el usuario utilizando la 
 * criba de Erat�stenes 
 * <p> 
 * Dado un vector de enteros empezando en 2, se tachan todos 
 * los m�ltiplos de 2. A continuaci�n, se encuentra el 
 * siguiente entero no tachado y se tachan sus m�ltiplos.  
 * Cuando se llega a la ra�z cuadrada del valor m�ximo, los 
 * n�merosque queden sin tachar son los n�meros primos 
 * 
 * @author Fernando Berzal 
 * @version 2.0 Enero'2005 (FB)
 */

public class GeneradorDePrimosV2
{    
/* El c�digo aun se puede mejorar
 * - eliminamos la variable dim (nos vale esPrimo.length)
 * - elegimos identificadores m�s adecuados para los m�todos y 
 * - reorganizamos el interior del m�todo inicializarCandidatos (el antiguo inicializarCriba).
 */
	private static boolean esPrimo[];  
	private static int primos[];
	
	public static int[] generarPrimosM2 (int max)
	{      
		if (max < 2) {       
			return new int[0];  // Vector vac�o   
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
				// Eliminar los m�ltiplos de i
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
		// Rellenar el vector de n�meros primos
		primos = new int[cuenta];     
		for (i=0, j=0; i<esPrimo.length; i++)        
			if (esPrimo[i])           
				primos[j++] = i;     
		}
	}		
		