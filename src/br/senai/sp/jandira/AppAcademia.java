package br.senai.sp.jandira;

import java.time.LocalDate;

import br.senai.sp.jandira.gui.FrameCalculadoraImc;
import br.senai.sp.jandira.model.Cliente;

public class AppAcademia {

	public static void main(String[] args) {
		
		FrameCalculadoraImc tela = new FrameCalculadoraImc();
		tela.titulo = "Calculadora IMC";
		tela.largura = 300;
		tela.altura = 465;
		tela.criarTela();
		
		Cliente Joaquin = new Cliente();
		Joaquin.nome = "Joaquin Phoenix";
		Joaquin.peso = 65;
		Joaquin.altura = 1.73;
		Joaquin.dataNascimento = LocalDate.of(1960, 1, 25);
		
		System.out.printf("O IMC de Joaquin é: %s\n", Joaquin.getIMC());
		System.out.printf("A idade de Joaquin é: %s anos.\n", Joaquin.getIdade());
		System.out.println("O Status do IMC de Joaquin é: " + Joaquin.getStatusIMC());
		
		Cliente Heath = new Cliente();
		Heath.nome = "Heath Ledger";
		Heath.peso = 67;
		Heath.altura = 1.75;
		Heath.dataNascimento = LocalDate.of(1964, 5, 20);
		
		System.out.printf("\nO IMC de Heath é: %s\n", Heath.getIMC());		
		System.out.printf("A idade de Heath é: %s anos.\n", Heath.getIdade());
		System.out.println("O Status do IMC de Heath é: " + Heath.getStatusIMC());

	}

}
