package UNIDAD_2.Boletin_4.Ej1;

public class ContadorVocales {
	int vocalesTotales;
	
	
	public ContadorVocales() {
		super();
		this.vocalesTotales = 0;
	}

	public synchronized void incrementaVocales(int num) {
		this.vocalesTotales = vocalesTotales + num;
	}

	public int getVocalesTotales() {
		return vocalesTotales;
	}

	public void setVocalesTotales(int vocalesTotales) {
		this.vocalesTotales = vocalesTotales;
	}
}
