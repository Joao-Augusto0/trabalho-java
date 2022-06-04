package telas;

import java.awt.Color; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controle.PacienteProcessa;

import modelo.Paciente;

public class TelaMedico extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JLabel nome, rotulos;
	private JTextField tfnome;
	private JScrollPane rolagem;
	private JTextArea verResultados;
	private JButton read;
	private String imgIco = "";
	private String texto = "";

	public TelaMedico() {
		setTitle("Consultas");
		setBounds(100, 100, 800, 600);
		setIconImage(new ImageIcon(imgIco).getImage());
		painel = new JPanel();
		painel.setBackground(new Color(0, 255, 127));
		setContentPane(painel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);

		nome = new JLabel("nome:");
		nome.setBounds(20, 20, 120, 30);
		painel.add(nome);

		rotulos = new JLabel("agenda:");
		rotulos.setBounds(20, 310, 500, 30);
		painel.add(rotulos);

		tfnome = new JTextField();
		tfnome.setBounds(140, 25, 255, 30);
		painel.add(tfnome);

		verResultados = new JTextArea();
		verResultados.setEditable(false);
		verResultados.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

		preencherAreaDeTexto();
		rolagem = new JScrollPane(verResultados);
		rolagem.setBounds(20, 340, 740, 200);
		painel.add(rolagem);

		read = new JButton("Buscar");

		read.setBounds(405, 25, 110, 30);

		painel.add(read);

		read.addActionListener(this);

	}
	
	private void preencherAreaDeTexto() {
		texto = ""; 
		for (Paciente p : PacienteProcessa.paciente) {
			texto += p.toString();
		}
		verResultados.setText(texto);
	}

	public void actionPerformed(ActionEvent e) {
		
	}
}