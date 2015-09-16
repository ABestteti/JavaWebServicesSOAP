package org.ws.calc;

public class Calculadora {
	public double soma(double i, double j) {
		return (i + j);
	}
	
	public double subtracao(double i, double j) {
		return (i - j);
	}
	
	public double multiplicacao(double i, double j) {
		return (i * j);
	}
	
	public double divisao(double i, double j) {
		
		if (j == 0) {
			throw new RuntimeException("Divisao por zero detectada!");
		}
		return (i / j);
	}
}
