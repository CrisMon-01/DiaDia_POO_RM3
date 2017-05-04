public class Ordinatore {
	public static void ordina(Comparabile[] lista){
		int imin;
		for (int ord=0; ord<lista.length-1; ord++){
			imin = ord;
			for (int i=ord+1; i<lista.length; i++)
				if (lista[i].minoreDi(lista[imin])){
					Comparabile temp=lista[i];
					lista[i]=lista[imin];
					lista[imin]=temp;
				}
		}
	}
}