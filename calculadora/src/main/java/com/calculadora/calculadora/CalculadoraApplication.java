package com.calculadora.calculadora;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class CalculadoraApplication {

	public static void main(String[] args) {
		//Vai rodar a app, digitar qual valor quer, depois qual operador e depois o outro valor.
		//Lê a linha de comando primeiro valor
		//TODO Usar laço de repetição para ler quando valores quiser
		String calculadoraLigada = "ON";
		while (calculadoraLigada.equals("ON")) {
			Scanner usarCalculadora = new Scanner(System.in);
			System.out.println("Digite \"ON\" para ligar ou \"OFF\" para desligar a calculadora:");
			String respostaUsarCalculadora = usarCalculadora.nextLine();

			//Qualquer valor pode entrar no Scanner, garantir que só valores numericos ou de pergunta
			if (respostaUsarCalculadora.equals("ON")) {
				while (respostaUsarCalculadora.equals("ON")) {
					try {
						String maisValores = "sim";
						Double primeiroValorInserido = null;
						List<Double> scanner = new ArrayList<>();
						Scanner operadorInseridoScanner;
						String operadorInserido = null;

						while (maisValores.equals("sim")) {
							//Insere primeiro valor
							Scanner primeiroValor = new Scanner(System.in);
							System.out.println("Valor:");
							primeiroValorInserido = primeiroValor.nextDouble();

							//Insere Operador
							operadorInseridoScanner = new Scanner(System.in);
							System.out.println("Insira o operador ('+' - adição, '-' - subtração, '*' - multiplicação, '/' - divisão, '%' - raiz quadrada):");
							operadorInserido = operadorInseridoScanner.nextLine();
							
							if (!operadorInserido.equals("%")) {
								//Insere Segundo valor
								Scanner segundoValor = new Scanner(System.in);
								System.out.println("Valor:");
								Double segundoValorInserido = segundoValor.nextDouble();

								//Inserir mais valores
								//TODO tratar caso digite outra coisa
								Scanner terceiroValor = new Scanner(System.in);
								System.out.println("Inserir mais valores? (sim / não)");
								maisValores = terceiroValor.nextLine();

								scanner.add(segundoValorInserido);
								scanner.add(primeiroValorInserido);

							} else {
								Scanner terceiroValor = new Scanner(System.in);
								System.out.println("Inserir mais valores? (sim / não)");
								maisValores = terceiroValor.nextLine();
							}


						}
//							Scanner valorInseridoScanner1 = new Scanner(System.in);
//							System.out.println("Valor:");
//							Double valorInserido2 = valorInseridoScanner.nextDouble();
							switch (operadorInserido) {
								case "+":
									System.out.println("O resultado é: " + adicao(scanner));
									//TODO Tratar codigo caso venha outro valor
									Scanner desligarCalculadoraAdicao = new Scanner(System.in);
									System.out.println("Desligar calculadora? (ON / OFF)");
									respostaUsarCalculadora = desligarCalculadoraAdicao.nextLine();
									break;
								case "-":
									System.out.println("O resultado é: " + subtracao(scanner));
									//TODO Tratar codigo caso venha outro valor
									Scanner desligarCalculadoraSubtracao = new Scanner(System.in);
									System.out.println("Desligar calculadora? (ON / OFF)");
									respostaUsarCalculadora = desligarCalculadoraSubtracao.nextLine();
									break;
								case "*":
									System.out.println("O resultado é: " + multiplicacao(scanner));
									//TODO Tratar codigo caso venha outro valor
									Scanner desligarCalculadoraMultiplicacao = new Scanner(System.in);
									System.out.println("Desligar calculadora? (ON / OFF)");
									respostaUsarCalculadora = desligarCalculadoraMultiplicacao.nextLine();
									break;
								case "/":
									System.out.println("O resultado é: " + divisao(scanner));
									//TODO Tratar codigo caso venha outro valor
									Scanner desligarCalculadoraDivisao = new Scanner(System.in);
									System.out.println("Desligar calculadora? (ON / OFF)");
									respostaUsarCalculadora = desligarCalculadoraDivisao.nextLine();
									break;
								case "%":
									System.out.println("O resultado é: " + raizQuadrada(primeiroValorInserido));
									//TODO Tratar codigo caso venha outro valor
									Scanner desligarCalculadoraRaiz = new Scanner(System.in);
									System.out.println("Desligar calculadora? (ON / OFF)");
									respostaUsarCalculadora = desligarCalculadoraRaiz.nextLine();
									break;
								default:
									System.out.println("Operador inserido inválido:");
							}
						} catch (Exception e) {
							throw new NotImplementedException("");
						}
					}
				} else if (respostaUsarCalculadora.equals("OFF")) {
					System.out.println("Desligando Calculadora");
					calculadoraLigada = "OFF";
				} else {
					System.out.println("Valor inválido");
				}
			}
		}

	private static Double adicao(List<Double> valor){
		Double valorResultante = 0.0;
		for (Double numero : valor){
			valorResultante = valorResultante + numero;
		}
		return valorResultante;
	}
	private static Double subtracao(List<Double> valor){
		Double valorResultante = 0.0;
		for (Double numero : valor){
			valorResultante = valorResultante - numero;
		}
		return valorResultante;
	}
	private static Double multiplicacao(List<Double> valor){
		Double valorResultante = 0.0;
		for (Double numero : valor){
			valorResultante = valorResultante * numero;
		}
		return valorResultante;
	}
	private static Double divisao(List<Double> valor){
		Double valorResultante = 0.0;
		for (Double numero : valor){
			valorResultante = valorResultante / numero;
		}
		return valorResultante;
	}
	private static Double raizQuadrada(Double valor){
		Double valorResultante = Math.sqrt(valor);
		return valorResultante;
	}
}

