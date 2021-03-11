package refactorizacion;

public class CribaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


//		int[] miarray = Criba.generarPrimos(100); 
		
//		int[] miarray = GeneradorDePrimos.generarPrimosM1(100); 
		
		int[] miarray = GeneradorDePrimosV2.generarPrimosM2(100);
		
		System.out.println("El contenido de la criba es:");
		for (int elemento:miarray)
			System.out.print(" -> " + elemento );
	}
}
