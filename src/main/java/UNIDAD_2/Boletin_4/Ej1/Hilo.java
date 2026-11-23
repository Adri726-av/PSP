package UNIDAD_2.Boletin_4.Ej1;

public class Hilo implements Runnable{
	private String vocal;
	private String texto;
	private ContadorVocales vocalesTotales;
	private int numVocal;
	
	
	public Hilo(String vocal) {
		super();
		this.vocal = vocal;
		this.texto = "Hola buenos dias";
		this.numVocal = 0;
	}


	@Override
	public void run() {
		for (int i = 0; i < texto.length(); i++) {
			if (String.valueOf(texto.charAt(i)).equalsIgnoreCase(vocal)) {
				this.numVocal++;
			}
		}
		vocalesTotales.incrementaVocales(numVocal);
		System.out.println("Hay " + numVocal + " " + vocal);
	}
	
}