package br.unisa.exec;

import java.util.List;

import br.unisa.infra.LerNotasFiscais;
import br.unisa.service.CalculaRede;
import br.unisa.vo.ItensCompra;

/**
 * Class para iniciar process
 * 
 * @author zyon
 *
 */
public class MainExec {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<ItensCompra> conjuntoItens = CalculaRede
				.calcularQtdDeItensNasNotas(LerNotasFiscais.readNotas());
		System.out
				.println("Lista de quantidades de conjunto contenendo em uma nota de compra");
		// imprmindo conjunto e quantidade
		for (ItensCompra itensCompra : conjuntoItens) {
			System.out.println("Qtd: " + itensCompra.getQtd()
					+ " Nome do Conjunto: "
					+ itensCompra.getNomeConjuntoDeItem());
		}
	}
}
