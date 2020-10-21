package inicio.java;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import inicio.mediosdepago.entidades.Tarjeta;

public class AppJava {

	public static void main(String[] args) throws ParseException {

		String numTStr = "023";
		System.out.println("Numero original: " + numTStr);

		// De Str a obj Integer
		Integer numTInteger = Integer.parseInt(numTStr);

		// De Str a obj Double
		Double numDouble = Double.parseDouble(numTStr);
		numDouble++;

		String numTStr2 = "023";
		// BigInteger
		BigInteger bigInt = new BigInteger(numTStr2);
		bigInt.add(new BigInteger(numTStr));
		System.out.println("BigInteger: " + bigInt);

		Integer doble = numTInteger + numTInteger;

		// De obj Integer a int
		int numInt = numTInteger.intValue();
		numInt++;
		double numTDouble = numDouble.doubleValue();

		// De int a String
		String numSig = String.valueOf(numInt);

		System.out.println("Siguiente numero: " + numSig);
		System.out.println("Doble: " + doble);
		System.out.println();

		Object objeto = new Object();
		// Comparar
		System.out.println("Equals: " + numTStr.equals(numTStr2)); // "023" = "023"
		System.out.println();

		// getClass getSuperclass
		System.out.println("numSig.getClass: " + numSig.getClass());
		System.out.println("doble.getClass: " + doble.getClass());
		System.out.println("numSig.getClass.getSuperclass: " + numSig.getClass().getSuperclass());
		System.out.println();

		// hasCode (Similiar a un id de objetos)
		System.out.println("numSig.hashCode: " + numSig.hashCode());
		System.out.println("doble.hashCode: " + doble.hashCode());
		System.out.println("numTStr.hashCode: " + numTStr.hashCode());
		System.out.println();

		Tarjeta tarjeta = new Tarjeta(200, "ARS", "0001000012300234");
		System.out.println("Tarjeta -> " + tarjeta);
		System.out.println();

		// Formateo de Str
		String miCadena = String.format("Tarjeta: %s Numero original: %s", tarjeta.toString(), numTStr);
		System.out.println(miCadena);
		System.out.println();

		// Fecha
		Date hoy = new Date();
		System.out.println("Fecha actual: " + hoy);
		System.out.println("Miliseg: " + hoy.getTime());

		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy/MM/dd");
		String hoyFormat = simpleDate.format(hoy);
		System.out.println("Fecha format: " + hoyFormat);

		// Método con excepcion
		Date fechaAnt = simpleDate.parse("20201010");
		System.out.println("Fecha anterior: " + fechaAnt);

	}

}
