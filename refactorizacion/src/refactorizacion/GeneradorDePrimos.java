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

public class GeneradorDePrimos
{    
	private static int dim;  
	private static boolean esPrimo[];  
	private static int primos[];
	
	public static int[] generarPrimosM1 (int max)
	{      
		if (max < 2) {       
			return new int[0];  // Vector vac�o   
			} else {   
				inicializarCriba(max);       
				cribar();       
				rellenarPrimos();
				return primos;     
			}
		}
	
	private static void inicializarCriba (int max)   
	{       
		int i;    
		dim = max + 1;     
		esPrimo = new boolean[dim];     
		for (i=0; i<dim; i++)    
			esPrimo[i] = true;     
		esPrimo[0] = esPrimo[1] = false; 
		}
	
	private static void cribar ()   
	{       
		int i,j;    
		for (i=2; i<Math.sqrt(dim)+1; i++) {    
			if (esPrimo[i]) {           
				// Eliminar los m�ltiplos de i
				for (j=2*i; j<dim; j+=i)    
					esPrimo[j] = false;         
				} 
			}  
		}
	
	private static void rellenarPrimos ()   
	{    
		int i, j, cuenta;
		// Contar primos    
		cuenta = 0;       
		for (i=0; i<dim; i++)         
			if (esPrimo[i])   
				cuenta++;     
		// Rellenar el vector de n�meros primos
		primos = new int[cuenta];     
		for (i=0, j=0; i<dim; i++)        
			if (esPrimo[i])           
				primos[j++] = i;     
		}
	}		
		