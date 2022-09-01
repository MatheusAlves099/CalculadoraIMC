package br.senai.sp.jandira.model;

import java.time.LocalDate;
import java.time.Period;

public class Cliente {
	public String nome;
	public LocalDate dataNascimento;
	public double altura;
	public double peso;
	
	public double getIMC(){
		return peso / Math.pow(altura, 2);
	}
	
	public int getIdade(){
		LocalDate hoje = LocalDate.now();
		Period periodo = Period.between(dataNascimento, hoje);
		return periodo.getYears();
	}
	
	public String getStatusIMC(){
		
		if (getIMC() <= 18.5) {
			return "Você está abaixo do peso!";
		} else if (getIMC() > 18.5 && getIMC() < 25.0) {
			return "Peso ideal!";
		} else if (getIMC() >= 25.0 && getIMC() < 30.0) {
			return "Você está levemente acima do peso!";
		} else if (getIMC() >= 30.0 && getIMC() < 35.0) {
			return "Obesidade Grau I";
		} else if (getIMC() >= 35.0 && getIMC() < 40.0){
			return "Obesidade Grau II";
		} else {
			return "Obesidade Grau III";
		}
			
		
	}
}
