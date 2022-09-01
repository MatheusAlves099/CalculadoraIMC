package br.senai.sp.jandira.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.senai.sp.jandira.model.Cliente;


public class FrameCalculadoraImc {
	
	public String titulo;
	public int largura;
	public int altura;
	
	public Font fontLabels = new Font("Trebuchet MS", Font.BOLD, 13);
	public Color corDoBotao = new Color(255, 0, 0);
	public Color corDoPainel = new Color(192, 192, 192);
	
	public void criarTela () {
		
		JFrame tela = new JFrame();
		tela.setTitle(titulo);
		tela.setSize(largura, altura);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setLayout(null);
	
		// obter uma referência do painel de conteúdo da tela
		Container painel = tela.getContentPane();
		painel.setBackground(corDoPainel);
		
		// criar os componentes de tela
		JLabel labelImc1 = new JLabel();
		labelImc1.setText("IMC");
		labelImc1.setBounds(15, 20, 110, 40);
		labelImc1.setFont(new Font("Gill Sans MT", Font.BOLD, 30));
		labelImc1.setForeground(Color.red);
		
		JLabel labelNome = new JLabel();
		labelNome.setText("Nome: ");
		labelNome.setBounds(15, 70, 100, 30);
		labelNome.setFont(fontLabels);
		
		JTextField textFieldNome = new JTextField();
		textFieldNome.setBounds(15, 100, 150, 25);
		
		JLabel labelPeso = new JLabel();
		labelPeso.setText("Peso: ");
		labelPeso.setBounds(15, 130, 100, 30);
		labelPeso.setFont(fontLabels);
		
		JTextField textFieldPeso = new JTextField();
		textFieldPeso.setBounds(15, 160, 80, 25);
		
		JLabel labelAltura = new JLabel();
		labelAltura.setText("Altura: ");
		labelAltura.setBounds(15, 190, 100, 30);
		labelAltura.setFont(fontLabels);
		
		JTextField textFieldAltura = new JTextField();
		textFieldAltura.setBounds(15, 220, 80, 25);
		
		JLabel labelDataNasc = new JLabel();
		labelDataNasc.setText("Data Nasc: ");
		labelDataNasc.setBounds(15, 250, 100, 30);
		labelDataNasc.setFont(fontLabels);
		
		JTextField textFieldDataNasc = new JTextField();
		textFieldDataNasc.setBounds(15, 280, 80, 25);
		
		JLabel labelImc2 = new JLabel();
		labelImc2.setText("");
		labelImc2.setBounds(15, 310, 300, 30);
		labelImc2.setFont(fontLabels);
		
		JLabel labelImcEsta = new JLabel();
		labelImcEsta.setText("");
		labelImcEsta.setBounds(15, 335, 300, 30);
		labelImcEsta.setFont(fontLabels);
		
		JLabel labelSuaIdade = new JLabel();
		labelSuaIdade.setText("");
		labelSuaIdade.setBounds(15, 360, 200, 30);
		labelSuaIdade.setFont(fontLabels);
		
		JButton buttonCalcular = new JButton();
		buttonCalcular.setText("Calcular");
		buttonCalcular.setFont(fontLabels);
		buttonCalcular.setBounds(105, 275, 100, 30);
		buttonCalcular.setForeground(Color.white);
		buttonCalcular.setBackground(corDoBotao);
		
		// adicionar os componentes ao painel
		painel.add(buttonCalcular);
		painel.add(labelImc1);
		painel.add(labelNome);
		painel.add(textFieldNome);
		painel.add(labelPeso);
		painel.add(textFieldPeso);
		painel.add(labelAltura);
		painel.add(textFieldAltura);
		painel.add(labelDataNasc);
		painel.add(textFieldDataNasc);
		painel.add(labelImc2);
		painel.add(labelImcEsta);
		painel.add(labelSuaIdade);
		
		// tornar a janela visível
		tela.setVisible(true);
		
		// definir ouvintes/listeners para os componentes de tela
		buttonCalcular.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Cliente cliente = new Cliente();
				cliente.nome = textFieldNome.getText();
				cliente.peso = Double.parseDouble(textFieldPeso.getText());
				cliente.altura = Double.parseDouble(textFieldAltura.getText());
				
				String[] dataNascimento = textFieldDataNasc.getText().split("/");
				
				int dia = Integer.parseInt(dataNascimento[0]);
				int mes = Integer.parseInt(dataNascimento[1]);
				int ano = Integer.parseInt(dataNascimento[2]);
				
				cliente.dataNascimento = LocalDate.of(ano, mes, dia);
				
				labelImc2.setText("Seu IMC é: " + cliente.getIMC());
				labelImcEsta.setText("Status IMC: " + cliente.getStatusIMC());
				labelSuaIdade.setText("Sua idade é: " + cliente.getIdade());
			}
		});
	}
	
}
