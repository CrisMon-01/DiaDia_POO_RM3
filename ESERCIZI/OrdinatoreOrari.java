public class OrdinatoreOrari {
	public static void ordina(Orario[] lista) {
		int imin;
		for (int ord=0; ord<lista.length-1; ord++) {
			imin = ord;
			for (int i=ord+1; i<lista.length; i++)
				if (lista[i].minoreDi(lista[imin])) {
					Orario temp=lista[i];
					lista[i]=lista[imin];
					lista[imin]=temp;
				}
		}
	}
}