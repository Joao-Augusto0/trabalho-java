package telas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JButton;

public class TelaMenu extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JMenuBar barraMenu = new JMenuBar();
	private JButton TMedico, TPaciente;
	private String imgIco = "./assets/icone.png";
	private String pathFundo = "./assets/fundo.png";
	private ImageIcon fundo;
	private JLabel lbFundo = new JLabel();

	TelaMenu() {
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

		TMedico = new JButton("Medico");
		TMedico.setBounds(100, 100, 200, 30);
		TPaciente = new JButton("Recepção");
		TPaciente.setBounds(100, 150, 200, 30);

		TMedico.addActionListener(this);
		TPaciente.addActionListener(this);

		painel.add(TMedico);
		painel.add(TPaciente);
	}

	public void actionPerformed(ActionEvent m) {
		if (m.getSource() == TPaciente) {
			this.dispose();
			TelaPaciente tp = new TelaPaciente();
			tp.setVisible(true);
		}
		if (m.getSource() == TMedico) {
			this.dispose();
			TelaMedico tm = new TelaMedico();
			tm.setVisible(true);

		}
	}
}
