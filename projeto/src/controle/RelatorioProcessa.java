package controle;

import javax.swing.JOptionPane;

import modelo.modelodao.RelatorioDAO;

public class RelatorioProcessa {
	private static RelatorioDAO rd = new RelatorioDAO();

	public static void salvar(String dados, String arquivo) {
		if (rd.saveReport(dados, arquivo)) {
			JOptionPane.showMessageDialog(null, "Relatório salvo com sucesso.");
		} else {
			JOptionPane.showMessageDialog(null, "Erro ao salvar relatório.");
		}
	}
}