package br.unisa.vo;

/**
 * Item para mapear os conjunto de itenm de compra com a qtd encontras nas notas
 * fiscais e a sequencia binaria conrespondente
 * 
 * @author zyon
 *
 */
public class ItensCompra {

	private String nomeConjuntoDeItem;
	private int qtd;
	private int[] sequenciaBinaria;

	/**
	 * @param nome
	 * @param seq
	 */
	public ItensCompra(String nome, int... seq) {
		this.nomeConjuntoDeItem = nome;
		this.sequenciaBinaria = seq;
	}

	/**
	 * Quantidade de item encontrado nas notas fiscais
	 * 
	 * @return int
	 */
	public int getQtd() {
		return qtd;
	}

	/**
	 * Metodo para incrementa a qtd de item
	 */
	public void incrementeQtd() {
		this.qtd++;
	}

	/**
	 * Nome do conjunto que pode ser cerveja e tira gosto e assim por diante
	 * 
	 * @return String
	 */
	public String getNomeConjuntoDeItem() {
		return nomeConjuntoDeItem;
	}

	/**
	 * @param nomeConjuntoDeItem
	 */
	public void setNomeConjuntoDeItem(String nomeConjuntoDeItem) {
		this.nomeConjuntoDeItem = nomeConjuntoDeItem;
	}

	/**
	 * Sequencia binaria conrespondente para o item
	 * 
	 * @return int[]
	 */
	public int[] getSequenciaBinaria() {
		return sequenciaBinaria;
	}

	/**
	 * @param sequenciaBinaria
	 */
	public void setSequenciaBinaria(int[] sequenciaBinaria) {
		this.sequenciaBinaria = sequenciaBinaria;
	}
}
