package gerenciador;

import org.ejml.simple.SimpleMatrix;

public class GerenciadorEstoque {
	private int custoFalta;
	private int valorPeca;
	private double taxaArmazenamento;
	private int consumoMedio;
	private int custoPedido;
	private int estoqueLimite;
	private SimpleMatrix custoDeArmazenagem;
	private SimpleMatrix custoDePedir;
	private SimpleMatrix custoTotalDoEstoque;
	private SimpleMatrix matrizDeTransicao;
	private SimpleMatrix matrizEstacionaria;
	private SimpleMatrix probabilidadeEstacionaria;
	private SimpleMatrix custoMedioDaPoliticaDeEstoque;
	private SimpleMatrix matrizDeCustosMedios;

	public double getCustoDeArmazenagem(int a, int b) {
		return custoDeArmazenagem.get(a, b);
	}
	public double getCustoDePedir(int a, int b) {
		return custoDePedir.get(a, b);
	}
	public double getCustoTotalDoEstoque(int a, int b) {
		return custoTotalDoEstoque.get(a, b);
	}
	public double getMatrizDeTransicao(int a, int b) {
		return matrizDeTransicao.get(a, b);
	}
	public double getMatrizEstacionaria(int a, int b) {
		return matrizEstacionaria.get(a, b);
	}
	public double getProbabilidadeEstacionaria(int a, int b) {
		return probabilidadeEstacionaria.get(a, b);
	}
	public double getCustoMedioDaPoliticaDeEstoque() {
		return custoMedioDaPoliticaDeEstoque.get(0, 0);
	}
	public double getMatrizDeCustosMedios(int a, int b) {
		return matrizDeCustosMedios.get(a, b);
	}
	
	// Construtor da classe
	public GerenciadorEstoque(int custoFalta, int valorPeca,
			double taxaArmazenamento, int consumoMedio, int custoPedido,
			int estoqueLimite) {
		this.custoFalta = custoFalta;
		this.valorPeca = valorPeca;
		this.taxaArmazenamento = taxaArmazenamento;
		this.consumoMedio = consumoMedio;
		this.custoPedido = custoPedido;
		this.estoqueLimite = estoqueLimite;

	}

	//método principal da classe
	public String calcular() {
		double custoMinimo = 0;
		double pontoPedido = 0;
		double estoqueMaximo = 0;
		matrizDeTransicao = new SimpleMatrix(estoqueLimite + 2,estoqueLimite + 2);
		probabilidadeEstacionaria = new SimpleMatrix(1, estoqueLimite + 2);
		custoMedioDaPoliticaDeEstoque = new SimpleMatrix(1,1);
		matrizDeCustosMedios = new SimpleMatrix(estoqueLimite, estoqueLimite +1);

		// Calculo de estoque
		custoDeArmazenagem = new SimpleMatrix(estoqueLimite + 2, 1);
		custoDeArmazenagem.set(0, 0, custoFalta);
		for (int S = 1; S <= estoqueLimite; S++) {
			// Custo de Manter
			for (int A = 1; A <= S + 1; A++) {
				int Q = A - 1;
				custoDeArmazenagem.set(A, 0, Q * valorPeca * taxaArmazenamento);
			}

			// Custo de Pedir
			custoDePedir = new SimpleMatrix(estoqueLimite + 2, 1);
			for (int s = -1; s <= S - 1; s++) {
				for (int A = 0; A <= S + 1; A++) {
					if (s + 1 >= A)
						custoDePedir.set(A, 0, custoPedido);
					if (s + 1 < A)
						custoDePedir.set(A, 0, 0);
				}
				custoTotalDoEstoque = custoDeArmazenagem.plus(custoDePedir);

				double i = 0;
				int k = 0;
				double h = 0;
				int fimMatriz = S + 1;
				for (int x = S; x >= s +1  ; x--) {
					for (int y = x; y >= 0; y--) {
						matrizDeTransicao.set(x + 1, y + 1, poisson(consumoMedio, k));
						k++;
					}
					for (int j = 1; j < x + 1; j++) {
						i = (i + matrizDeTransicao.get(x +1, j));
					}
					
					matrizDeTransicao.set(x + 1,0,1-i);
					i=0;
					k=0;
				}
				
				
				for (int x = 1; x < S + 1; x++) {
					for (int y = 0; y < S +1; y++) {
						h = h + matrizDeTransicao.get(x,y);
					}
					if (h==0){
						for (int y = 0; y < S + 1; y++) {
							matrizDeTransicao.set(x,y,matrizDeTransicao.get(S+1,y));							
						}
					}
					h=0;
				}
				
				
				
				matrizDeTransicao.set(0,fimMatriz,1); //Probabilidade a partir da falta
				matrizEstacionaria = matrizDeTransicao;
				for (int j = 1; j < 500; j++) {
					matrizEstacionaria = matrizEstacionaria.mult(matrizDeTransicao);
				}
								
				for (int a = 0; a < S + 2; a++) {
					probabilidadeEstacionaria.set(0,a,matrizEstacionaria.get(0,a));
				}
				
				custoMedioDaPoliticaDeEstoque = probabilidadeEstacionaria.mult(custoTotalDoEstoque);
				
				//limpar esta linha caso queira executar o teste da matriz de transicao

				matrizDeTransicao.set(0.0);
				matrizDeCustosMedios.set(S-1,s+1,custoMedioDaPoliticaDeEstoque.get(0,0));
				
			}

		}
		
		double X =1000000; //varredura para menor custo
		double z=0;
		double Z=0;
		
		for (int t = 0; t < estoqueLimite; t++) {
			for (int j = 0; j < estoqueLimite +1 ; j++) {
				if(matrizDeCustosMedios.get(t,j) > 0){
					if(matrizDeCustosMedios.get(t,j) < X){
						X = matrizDeCustosMedios.get(t,j);
						Z=t+1;
						z=j-1;
					}
				}
			}
		}
		

		
		 //RETORNOS FINAIS
		custoMinimo = arredondar(X,2,1);
		pontoPedido = z;
		estoqueMaximo = Z;		
		return 
				"Custo mínimo: R$ " + custoMinimo
				+ "\nPonto de pedido: " + pontoPedido
				+ "\nEstoque máximo: " + estoqueMaximo;
	}
	
	
	//MÉTODOS INTERNOS
	protected static double poisson(double consMedio,double k){
		double distPoison = ((Math.exp(-consMedio))*Math.pow(consMedio,k))/fatorial(k);
		return distPoison; 
	}
	protected static double fatorial(double k){
		if(k<=1){
		    return 1;
		}else{
		    return k*fatorial(k-1);
		}
    }
	
	protected double arredondar(double valor, int casas, int ceilOrFloor) {
		double verif, arredondado = valor;
		int multp = 1;
		for (int i = 0; i < casas; i++)
			multp *= 10;
		arredondado *= multp;
		verif = arredondado;
		arredondado = Math.floor(arredondado);
		verif -= arredondado;
		verif = Math.floor(verif * 10);
		if (verif > 4)
			arredondado++;
		arredondado /= multp;
		return arredondado;
	}
}
