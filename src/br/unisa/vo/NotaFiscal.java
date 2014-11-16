package br.unisa.vo;

/**
 * Class para mapear o objeto de nota fiscal
 * 
 * @author zyon
 *
 */
public class NotaFiscal {

	private int numNotaFiscal;
	private int[] itensNotaFiscal;

	/**
	 * Retorna o numero da nota fiscal
	 * @return Int
	 */
	public int getNumNotaFiscal() {
		return numNotaFiscal;
	}

	/**
	 * @param numNotaFiscal
	 */
	public void setNumNotaFiscal(int numNotaFiscal) {
		this.numNotaFiscal = numNotaFiscal;
	}

	/**
	 * Retorna array de inteiros de binarios para informa se contem um dos itens
	 * cerveja, artigo para bebe, tira gosto
	 * @return int[]
	 */
	public int[] getItensNotaFiscal() {
		return itensNotaFiscal;
	}

	/**
	 * @param itensNotaFiscal
	 */
	public void setItensNotaFiscal(int[] itensNotaFiscal) {
		this.itensNotaFiscal = itensNotaFiscal;
	}

}
