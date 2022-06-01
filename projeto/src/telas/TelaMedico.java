package telas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class TelaMedico extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JMenuBar barraMenu = new JMenuBar();
	private JMenu menuRelatorio;
	private JMenuItem itemPets, itemUsuarios, itemDashBoard, itemRelatorio;
	private String imgIco = "./assets/icone.png";
	private String pathFundo = "./assets/fundo.png";
	private ImageIcon fundo;
	private JLabel lbFundo = new JLabel();

	TelaMedico() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Acesso dos Funcionarios");
		setBounds(100, 100, 400, 400);
		setIconImage(new ImageIcon(imgIco).getImage());
		painel = new JPanel();
		painel.setBackground(new Color(255, 233, 213));
		setJMenuBar(barraMenu);
		setContentPane(painel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);

		fundo = new ImageIcon(new ImageIcon(pathFundo).getImage().getScaledInstance(850, 605, 100));
		lbFundo.setIcon(fundo);
		lbFundo.setBounds(20, 15, 850, 605);
		painel.add(lbFundo);

		menuRelatorio = new JMenu("Relat�rios");
		barraMenu.add(menuRelatorio);
		itemRelatorio = new JMenuItem("Relat�rios de Servi�os");
		itemDashBoard = new JMenuItem("Analizar Dados - DashBoard");
		menuRelatorio.add(itemRelatorio);
		menuRelatorio.add(itemDashBoard);

		barraMenu.setBackground(new Color(255, 233, 213));

		itemDashBoard.addActionListener(this);
		itemRelatorio.addActionListener(this);
	}

	private void abrirPlanilha() {
		Runtime rt = Runtime.getRuntime();
		String dashboard[] = { "cmd", "/c", "start", "/data/Triagem.xlsm" };
		try {
			rt.exec(dashboard);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == itemPets) {
			TelaPaciente pf = new TelaPaciente();
			pf.setModal(true);
			pf.setVisible(true);
		}
		if (e.getSource() == itemUsuarios) {
			TelaLogin uf = new TelaLogin();
			uf.setModal(true);
			uf.setVisible(true);
		}
		if (e.getSource() == itemRelatorio) {
			TelaPaciente tp = new TelaPaciente();
			tp.setModal(true);
			tp.setVisible(true);
		}
		if (e.getSource() == itemDashBoard) {
			abrirPlanilha();
		}
	}
}