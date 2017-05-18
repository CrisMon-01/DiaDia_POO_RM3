package calcolaArea;

public class CalcolatoreDiArea implements Calcolatore{
		public float calcola(Cerchio1 c) {
		int r = c.getRaggio();
		return 3.14f * r * r;
		}
		@Override
		public float calcola(Quadrato1 q) {
		int l = q.getLato();
		return l * l;
		}
		static public float sommaAll(Calcolatore calcolatore, Forma1[] forme) {
			float acc = 0;
			for(Forma1 forma : forme) {
			acc += forma.accetta(calcolatore); // ERRORE: NON COMPILA
			}
			return acc;
			}
		public static void main(String [] args) {
		CalcolatoreDiArea calcolatore = new CalcolatoreDiArea();
		Cerchio1 cerchio = new Cerchio1(1);
		Quadrato1 quadrato = new Quadrato1(2);
		System.out.println(calcolatore.calcola(cerchio));
		System.out.println(calcolatore.calcola(quadrato));
		}
		}

