package inicio.cerradura;

public class CerraduraApp {

	public static void main(String[] args) {
		Cerradura c = new Cerradura(123, 2);
		c.abrir(012);
		c.abrir(123);
		System.out.println("Esta abierta " + c.estaAbierta());
		System.out.println("Esta cerrrada " + c.estaCerrada());
		System.out.println("Intentos fallidos: " + c.contarAperturasFallidas());
		System.out.println("Intentos exitosos: " + c.contarAperturasExitosas());
		//System.out.println("Esta blockeada "+ c.fueBloqueada());

	}
}
