package inicio.collection.inicial;

import java.util.Comparator;

import inicio.mediosdepago.entidades.Tarjeta;

public class CardComparator implements Comparator<Tarjeta> {

	@Override
	public int compare(Tarjeta t1, Tarjeta t2) {
		return t1.getFechaVenc().compareTo(t2.getFechaVenc());
	}

}
