package refactorizacion;

/** * Clase para generar todos los n�meros primos de 1 hasta * un n�mero m�ximoespecificado por el usuario. Como 
  * algoritmo se utiliza la criba de Erat�stenes. * <p> * Erat�stenes de Cirene (276 a.C., Cirene, Libia � 194 
  * a.C., Alejandr�a, Egipto) fue el primer hombre que  
  * calcul� la circunferencia de la Tierra. Tambi�n 
  * se le conoce por su trabajo con calendarios que ya  
  * inclu�an a�os bisiestosy por dirigir la m�tica  
  * biblioteca de Alejandr�a. 
  * <p> 
  * El algoritmo es bastante simple: Dado un vector de 
  * enteros empezando en 2,se tachan todos los m�ltiplos 
  * de 2. A continuaci�n, se encuentra el siguiente 
  * entero no tachado y se tachan todos sus m�ltiplos. El  
  * proceso se repite hasta que se pasa de la ra�z cuadrada 
  * del valor m�ximo. Todos los n�meros que quedensin  
  * tachar son n�meros primos. 
  * 
  * @author Fernando Berzal 
  * @version 1.0 Enero�2005 (FB) 
  */

public class Criba 
{  
	/**     
	 * * Generar n�meros primos de 1 a max 
	 * * @param max es el valor m�ximo   
	 * * @return Vector de n�meros primos   
	 * */
	public static int[] generarPrimos (int max) 
	{        
		int i,j;     
	
		if (max >= 2) { 
			// Declaraciones        
			int dim = max + 1; // Tama�o del array
			boolean[] esPrimo = new boolean[dim];    
			
			// Inicializar el array        
			for (i=0; i<dim; i++)    
				esPrimo[i] = true; // Eliminar el 0 y el 1, que no son primos
			esPrimo[0] = esPrimo[1] = false; 
			
			// Criba        
			for (i=2; i<Math.sqrt(dim)+1; i++) {    
				if (esPrimo[i]) {               
					// Eliminar los m�ltiplos de i
					for (j=2*i; j<dim; j+=i)    
						esPrimo[j] = false;             
					}         
				}
			
			// �Cu�ntos primos hay?   
			int cuenta = 0;           
			for (i=0; i<dim; i++) {   
				if (esPrimo[i])                  
					cuenta++;         
				}
			
			// Rellenar el vector de n�meros primos        
			int[] primos = new int[cuenta];             
			for (i=0, j=0; i<dim; i++) {                
				if (esPrimo[i])               
					primos[j++] = i;           
				}             
			return primos;      
			} else { // max < 2        
				return new int[0];  // Vector vac�o
				}
		}				
}

