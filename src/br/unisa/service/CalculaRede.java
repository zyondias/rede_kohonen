package br.unisa.service;

import java.util.ArrayList;
import java.util.List;

import br.unisa.infra.LerNotasFiscais;
import br.unisa.vo.ItensCompra;
import br.unisa.vo.NotaFiscal;

/**
 * Class responsavel por fazer o calculo da rede
 * 
 * @author zyon
 *
 */
public class CalculaRede {

	/**
	 * Metodo para fazer o calculo de qtd de conjuntos contem nas notas fiscais
	 * 
	 * @param notasFiscais
	 * @return {@link List}{@link ItensCompra}
	 */
	public static List<ItensCompra> calcularQtdDeItensNasNotas(
			List<NotaFiscal> notasFiscais) {
		List<ItensCompra> conjuntoItensCompra = geraListaConjutoCompras();

		// percorrendo lista de nota fiscal
		for (NotaFiscal nota : LerNotasFiscais.readNotas()) {
			pegarItemQueContemNaNota(nota, conjuntoItensCompra).incrementeQtd();
		}

		return conjuntoItensCompra;
	}

	private static ItensCompra pegarItemQueContemNaNota(NotaFiscal nota,
			List<ItensCompra> conjuntoItensCompra) {
		int menorValor = Integer.MAX_VALUE;
		Integer posicao = null;

		for (ItensCompra itensCompra : conjuntoItensCompra) {
			int valor = calculaBinNotaBinConjunto(nota.getItensNotaFiscal(),
					itensCompra.getSequenciaBinaria());
			if (valor < menorValor) {
				menorValor = valor;
				posicao = conjuntoItensCompra.indexOf(itensCompra);
			}
		}
		if (posicao != null) {
			return conjuntoItensCompra.get(posicao);
		}
		return null;
	}

	private static int calculaBinNotaBinConjunto(int[] binNota, int[] binConjuto) {
		int somaTotal;

		somaTotal = (int) Math.pow((binNota[0] - binConjuto[0]), 2);
		somaTotal += (int) Math.pow((binNota[1] - binConjuto[1]), 2);
		somaTotal += (int) Math.pow((binNota[2] - binConjuto[2]), 2);

		return somaTotal;
	}

	private static List<ItensCompra> geraListaConjutoCompras() {
		// ordem da sequencia
		// cerveja | Tira gosto | bebe
		List<ItensCompra> lista = new ArrayList<ItensCompra>();

		lista.add(new ItensCompra("Cerveja, Tira Gosto,  Artg. P/ Bebe ", 1, 1,
				1));

		lista.add(new ItensCompra("Cerveja e Tira Gosto", 1, 1, 0));

		lista.add(new ItensCompra("Cerveja e Artg. P/ Bebe", 1, 0, 1));

		lista.add(new ItensCompra("Cerveja", 1, 0, 0));

		lista.add(new ItensCompra("Tira Gosto", 0, 1, 0));

		lista.add(new ItensCompra("Artg. P/ Bebe", 0, 0, 1));

		lista.add(new ItensCompra("Tira Gosto, Artg. P/ Bebe", 0, 1, 1));

		return lista;
	}
}
