package com.calculadora.calculadora;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class CalculadoraApplication {

//	@Autowired
//	public static Aritmetica aritmetica;
	private static final String SOMA = "+";
	private static final String SUBTRACAO = "-";
	private static final String MULTIPLICACAO = "*";
	private static final String DIVISAO = "/";
	private static final String RAIZ_QUADRADA = "%";

	public static void main(String[] args) {
		String calculadoraLigada = "ON";
		while (calculadoraLigada.equals("ON")) {
			Scanner usarCalculadora = new Scanner(System.in);
			System.out.println("Digite \"ON\" para ligar ou \"OFF\" para desligar a calculadora:");
			String respostaUsarCalculadora = usarCalculadora.nextLine();
			//Qualquer valor pode entrar no Scanner, garantir que só valores numericos ou de pergunta
			if (respostaUsarCalculadora.equals("ON") || respostaUsarCalculadora.equals("on")) {
				while (respostaUsarCalculadora.equals("ON") || respostaUsarCalculadora.equals("on")) {
					try {
						String maisValores = "sim";
						Double primeiroValorInserido = null;
						Double segundoValorInserido = null;
						List<Double> listaDeValores = new ArrayList<>();
						Scanner operadorInseridoScanner;
						String operadorInserido = null;

						while (maisValores.equals("sim")) {
							//Insere primeiro valor
							while (Objects.isNull(primeiroValorInserido)){
								try {
									Scanner primeiroValor = new Scanner(System.in);
									System.out.println("Valor:");
									primeiroValorInserido = primeiroValor.nextDouble();
								} catch (InputMismatchException e) {
									//TODO quando cair em exception, tratar para voltar ao codigo
									System.out.println("Valor não numérico inserido. Por favor, insira uma valor numérico.");
								}
							}
							//Insere Operador
							while (!operadorInserido.equals(SOMA) && !operadorInserido.equals(SUBTRACAO)
									&& !operadorInserido.equals(MULTIPLICACAO) && !operadorInserido.equals(DIVISAO)
									&& !operadorInserido.equals(RAIZ_QUADRADA)) {

								operadorInseridoScanner = new Scanner(System.in);
								System.out.println("Insira o operador ('+' - adição, '-' - subtração, '*' - multiplicação, '/' - divisão, '%' - raiz quadrada):");
								operadorInserido = operadorInseridoScanner.nextLine();

								if (!operadorInserido.equals(SOMA) && !operadorInserido.equals(SUBTRACAO)
										&& !operadorInserido.equals(MULTIPLICACAO) && !operadorInserido.equals(DIVISAO)
										&& !operadorInserido.equals(RAIZ_QUADRADA)) {
									System.out.println("Operador inválido");
								}
							}
							if (!operadorInserido.equals("%") && Objects.nonNull(operadorInserido)) {
								//Insere Segundo valor
								while (Objects.isNull(segundoValorInserido)) {
									try {
										Scanner segundoValor = new Scanner(System.in);
										System.out.println("Valor:");
										segundoValorInserido = segundoValor.nextDouble();

									} catch (InputMismatchException e) {
										System.out.println("Valor não numérico inserido. Por favor, insira uma valor numérico.");
									}
								}
								//Inserir mais valores
								//TODO tratar caso digite outra coisa
								Scanner terceiroValor = new Scanner(System.in);
								System.out.println("Inserir mais valores? (sim / não)");
								maisValores = terceiroValor.nextLine();

								listaDeValores.add(segundoValorInserido);
								listaDeValores.add(primeiroValorInserido);

							} else {
								//TODO Tratar para poder inserir mais valores
								Scanner terceiroValor = new Scanner(System.in);
								System.out.println("Inserir mais valores? (sim / não)");
								maisValores = terceiroValor.nextLine();
							}
						}
//							Scanner valorInseridoScanner1 = new Scanner(System.in);
//							System.out.println("Valor:");
//							Double valorInserido2 = valorInseridoScanner.nextDouble();
						//Usar hash map?
						//Usar Enum
						//TODO Testar se é possivel inserir valor vazio, caso sim, tratar
						switch (operadorInserido) {
							case SOMA:
								System.out.println("O resultado é: " + adicao(listaDeValores));
								Scanner desligarCalculadoraAdicao = new Scanner(System.in);
								System.out.println("Desligar calculadora? (ON / OFF)");
								respostaUsarCalculadora = desligarCalculadoraAdicao.nextLine();
								break;
							case SUBTRACAO:
								System.out.println("O resultado é: " + subtracao(listaDeValores));
								Scanner desligarCalculadoraSubtracao = new Scanner(System.in);
								System.out.println("Desligar calculadora? (ON / OFF)");
								respostaUsarCalculadora = desligarCalculadoraSubtracao.nextLine();
								break;
							case MULTIPLICACAO:
								System.out.println("O resultado é: " + multiplicacao(listaDeValores));
								Scanner desligarCalculadoraMultiplicacao = new Scanner(System.in);
								System.out.println("Desligar calculadora? (ON / OFF)");
								respostaUsarCalculadora = desligarCalculadoraMultiplicacao.nextLine();
								break;
							case DIVISAO:
								System.out.println("O resultado é: " + divisao(listaDeValores));
								Scanner desligarCalculadoraDivisao = new Scanner(System.in);
								System.out.println("Desligar calculadora? (ON / OFF)");
								respostaUsarCalculadora = desligarCalculadoraDivisao.nextLine();
								break;
							case RAIZ_QUADRADA:
								System.out.println("O resultado é: " + raizQuadrada(primeiroValorInserido));
								Scanner desligarCalculadoraRaiz = new Scanner(System.in);
								System.out.println("Desligar calculadora? (ON / OFF)");
								respostaUsarCalculadora = desligarCalculadoraRaiz.nextLine();
								break;
							default:
								System.out.println("Operador inserido inválido:");
							}
						} catch (Exception e){
							throw new NotImplementedException("");
						}
					}
				} else if (respostaUsarCalculadora.equals("OFF") || respostaUsarCalculadora.equals("off")) {
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
		Double valorResultante = valor.get(1);
		valorResultante = valorResultante * valor.get(0);
		return valorResultante;
	}
	private static Double divisao(List<Double> valor){
		Double valorResultante = valor.get(1);
		valorResultante = valorResultante / valor.get(0);
		return valorResultante;
	}
	private static Double raizQuadrada(Double valor){
		Double valorResultante = Math.sqrt(valor);
		return valorResultante;
	}
}

