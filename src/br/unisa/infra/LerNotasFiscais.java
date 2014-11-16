package br.unisa.infra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.unisa.vo.NotaFiscal;

/**
 * Class responsavel por fazer a leitura das notas fiscais que esta no arquivo
 * 
 * @author zyon
 *
 */
public class LerNotasFiscais {

	private static BufferedReader leitor;

	/**
	 * Retorna lista de nota fiscal encontrada no arquivo
	 * 
	 * @return List{@link LerNotasFiscais}
	 */
	public static List<NotaFiscal> readNotas() {
		List<NotaFiscal> notasFiscais = new ArrayList<NotaFiscal>();
		try {
			leitor = new BufferedReader(new FileReader("listaNotaFiscal.txt"));
			String linha = "";
			// pulando primeira linha que é comentario
			leitor.readLine();
			while ((linha = leitor.readLine()) != null) {
				if (linha.length() > 0) {
					notasFiscais.add(extrairItemNota(linha));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("erro ao ler arquivo de nota fiscal");
		}

		return notasFiscais;
	}

	private static NotaFiscal extrairItemNota(String linhaNota) {
		NotaFiscal nota = new NotaFiscal();
		// pegando numero da nota
		Pattern pattern = Pattern.compile("([0-9]*)");
		Matcher matcher = pattern.matcher(linhaNota);
		matcher.find();
		// jogando numero na nota
		nota.setNumNotaFiscal(Integer.parseInt(matcher.group(1)));
		// pegando sequencia binarios de itens q contem a nota
		pattern = Pattern.compile("- ([0-9 ,]*)");
		matcher = pattern.matcher(linhaNota);
		matcher.find();
		nota.setItensNotaFiscal(extrairArrayInt(matcher.group(1).split(",")));

		return nota;

	}

	private static int[] extrairArrayInt(String[] arrayString) {
		int[] valores = new int[3];
		valores[0] = Integer.parseInt(arrayString[0]);
		valores[1] = Integer.parseInt(arrayString[1]);
		valores[2] = Integer.parseInt(arrayString[2]);
		return valores;
	}
}
