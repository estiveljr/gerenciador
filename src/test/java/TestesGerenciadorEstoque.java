
import static org.junit.Assert.*;

import org.junit.Test;

import gerenciador.GerenciadorEstoque;

public class TestesGerenciadorEstoque {

	@Test
	public void custoDeArmazenagem() {
		GerenciadorEstoque gerenciadorDeEstoque = new GerenciadorEstoque(
				10000, 100, 0.1, 10, 10, 5);
		gerenciadorDeEstoque.calcular();
		assertEquals(gerenciadorDeEstoque.getCustoDeArmazenagem(0, 0), 10000, 0);
		assertEquals(gerenciadorDeEstoque.getCustoDeArmazenagem(1, 0), 0, 0);
		assertEquals(gerenciadorDeEstoque.getCustoDeArmazenagem(2, 0), 10, 0);
		assertEquals(gerenciadorDeEstoque.getCustoDeArmazenagem(3, 0), 20, 0);
		assertEquals(gerenciadorDeEstoque.getCustoDeArmazenagem(4, 0), 30, 0);
		assertEquals(gerenciadorDeEstoque.getCustoDeArmazenagem(5, 0), 40, 0);
		assertEquals(gerenciadorDeEstoque.getCustoDeArmazenagem(6, 0), 50, 0);
	}

	@Test
	public void custoDePedir() {
		GerenciadorEstoque gerenciadorDeEstoque = new GerenciadorEstoque(
				10000, 100, 0.1, 10, 10, 5);
		gerenciadorDeEstoque.calcular();
		assertEquals(gerenciadorDeEstoque.getCustoDePedir(0, 0), 10, 0);
		assertEquals(gerenciadorDeEstoque.getCustoDePedir(1, 0), 10, 0);
		assertEquals(gerenciadorDeEstoque.getCustoDePedir(2, 0), 10, 0);
		assertEquals(gerenciadorDeEstoque.getCustoDePedir(3, 0), 10, 0);
		assertEquals(gerenciadorDeEstoque.getCustoDePedir(4, 0), 10, 0);
		assertEquals(gerenciadorDeEstoque.getCustoDePedir(5, 0), 10, 0);
		assertEquals(gerenciadorDeEstoque.getCustoDePedir(6, 0), 0, 0);

	}

	@Test
	public void custoTotalEstoque() {
		GerenciadorEstoque gerenciadorDeEstoque = new GerenciadorEstoque(
				10000, 100, 0.1, 10, 10, 5);
		gerenciadorDeEstoque.calcular();
		assertEquals(gerenciadorDeEstoque.getCustoTotalDoEstoque(0, 0), 10010,
				0);
		assertEquals(gerenciadorDeEstoque.getCustoTotalDoEstoque(1, 0), 10, 0);
		assertEquals(gerenciadorDeEstoque.getCustoTotalDoEstoque(2, 0), 20, 0);
		assertEquals(gerenciadorDeEstoque.getCustoTotalDoEstoque(3, 0), 30, 0);
		assertEquals(gerenciadorDeEstoque.getCustoTotalDoEstoque(4, 0), 40, 0);
		assertEquals(gerenciadorDeEstoque.getCustoTotalDoEstoque(5, 0), 50, 0);
		assertEquals(gerenciadorDeEstoque.getCustoTotalDoEstoque(6, 0), 50, 0);

	}

	//@Test
	public void matrizDeTransicao() {
		GerenciadorEstoque gerenciadorDeEstoque = new GerenciadorEstoque(
				10000, 100, 0.1, 10, 10, 5);
		gerenciadorDeEstoque.calcular();
		assertEquals(gerenciadorDeEstoque.getMatrizDeTransicao(0,0),0,0.001);
		assertEquals(gerenciadorDeEstoque.getMatrizDeTransicao(0,1),0,0.001);
		assertEquals(gerenciadorDeEstoque.getMatrizDeTransicao(0,2),1,0.001);
		assertEquals(gerenciadorDeEstoque.getMatrizDeTransicao(0,3),1,0.001);
		assertEquals(gerenciadorDeEstoque.getMatrizDeTransicao(0,4),1,0.001);
		assertEquals(gerenciadorDeEstoque.getMatrizDeTransicao(0,5),1,0.001);
		assertEquals(gerenciadorDeEstoque.getMatrizDeTransicao(0,6),1,0.001);
		
		assertEquals(gerenciadorDeEstoque.getMatrizDeTransicao(1,0),0.999954600070238,0.001);
		assertEquals(gerenciadorDeEstoque.getMatrizDeTransicao(1,1),4.53999297624849e-05,0.001);
		assertEquals(gerenciadorDeEstoque.getMatrizDeTransicao(1,2),0,0.001);
		assertEquals(gerenciadorDeEstoque.getMatrizDeTransicao(1,3),0,0.001);
		assertEquals(gerenciadorDeEstoque.getMatrizDeTransicao(1,4),0,0.001);
		assertEquals(gerenciadorDeEstoque.getMatrizDeTransicao(1,5),0,0.001);
		assertEquals(gerenciadorDeEstoque.getMatrizDeTransicao(1,6),0,0.001);
		
		assertEquals(gerenciadorDeEstoque.getMatrizDeTransicao(2,0),0.999500600772613,0.001);
		assertEquals(gerenciadorDeEstoque.getMatrizDeTransicao(2,1),0.000453999297624848,0.001);
		assertEquals(gerenciadorDeEstoque.getMatrizDeTransicao(2,2),4.53999297624849e-05,0.001);
		assertEquals(gerenciadorDeEstoque.getMatrizDeTransicao(2,3),0,0.001);
		assertEquals(gerenciadorDeEstoque.getMatrizDeTransicao(2,4),0,0.001);
		assertEquals(gerenciadorDeEstoque.getMatrizDeTransicao(2,5),0,0.001);
		assertEquals(gerenciadorDeEstoque.getMatrizDeTransicao(2,6),0,0.001);
		
		assertEquals(gerenciadorDeEstoque.getMatrizDeTransicao(3,0),0.997230604284488,0.001);
		assertEquals(gerenciadorDeEstoque.getMatrizDeTransicao(3,1),0.00226999648812424,0.001);
		assertEquals(gerenciadorDeEstoque.getMatrizDeTransicao(3,2),0.000453999297624848,0.001);
		assertEquals(gerenciadorDeEstoque.getMatrizDeTransicao(3,3),4.53999297624849e-05,0.001);
		assertEquals(gerenciadorDeEstoque.getMatrizDeTransicao(3,4),0,0.001);
		assertEquals(gerenciadorDeEstoque.getMatrizDeTransicao(3,5),0,0.001);
		assertEquals(gerenciadorDeEstoque.getMatrizDeTransicao(3,6),0,0.001);
		
		assertEquals(gerenciadorDeEstoque.getMatrizDeTransicao(4,0),0.989663949324074,0.001);
		assertEquals(gerenciadorDeEstoque.getMatrizDeTransicao(4,1),0.00756665496041414,0.001);
		assertEquals(gerenciadorDeEstoque.getMatrizDeTransicao(4,2),0.00226999648812424,0.001);
		assertEquals(gerenciadorDeEstoque.getMatrizDeTransicao(4,3),0.000453999297624848,0.001);
		assertEquals(gerenciadorDeEstoque.getMatrizDeTransicao(4,4),4.53999297624849e-05,0.001);
		assertEquals(gerenciadorDeEstoque.getMatrizDeTransicao(4,5),0,0.001);
		assertEquals(gerenciadorDeEstoque.getMatrizDeTransicao(4,6),0,0.001);
		
		assertEquals(gerenciadorDeEstoque.getMatrizDeTransicao(5,0),0.970747311923039,0.001);
		assertEquals(gerenciadorDeEstoque.getMatrizDeTransicao(5,1),0.0189166374010354,0.001);
		assertEquals(gerenciadorDeEstoque.getMatrizDeTransicao(5,2),0.00756665496041414,0.001);
		assertEquals(gerenciadorDeEstoque.getMatrizDeTransicao(5,3),0.00226999648812424,0.001);
		assertEquals(gerenciadorDeEstoque.getMatrizDeTransicao(5,4),0.000453999297624848,0.001);
		assertEquals(gerenciadorDeEstoque.getMatrizDeTransicao(5,5),4.53999297624849e-05,0.001);
		assertEquals(gerenciadorDeEstoque.getMatrizDeTransicao(5,6),0,0.001);
		
		assertEquals(gerenciadorDeEstoque.getMatrizDeTransicao(6,0),0.932914037120968,0.001);
		assertEquals(gerenciadorDeEstoque.getMatrizDeTransicao(6,1),0.0378332748020707,0.001);
		assertEquals(gerenciadorDeEstoque.getMatrizDeTransicao(6,2),0.0189166374010354,0.001);
		assertEquals(gerenciadorDeEstoque.getMatrizDeTransicao(6,3),0.00756665496041414,0.001);
		assertEquals(gerenciadorDeEstoque.getMatrizDeTransicao(6,4),0.00226999648812424,0.001);
		assertEquals(gerenciadorDeEstoque.getMatrizDeTransicao(6,5),0.000453999297624848,0.001);
		assertEquals(gerenciadorDeEstoque.getMatrizDeTransicao(6,6),4.53999297624849e-05,0.001);
	}
	
	@Test
	public void matrizEstacionaria() {
		GerenciadorEstoque gerenciadorDeEstoque = new GerenciadorEstoque(
				10000, 100, 0.1, 10, 10, 5);
		gerenciadorDeEstoque.calcular();
		assertEquals(gerenciadorDeEstoque.getMatrizEstacionaria(0,0),0.482646418415240,0.01);
		assertEquals(gerenciadorDeEstoque.getMatrizEstacionaria(0,1),0.0195731802219321,0.01);
		assertEquals(gerenciadorDeEstoque.getMatrizEstacionaria(0,2),0.00978659011096606,0.01);
		assertEquals(gerenciadorDeEstoque.getMatrizEstacionaria(0,3),0.00391463604438642,0.01);
		assertEquals(gerenciadorDeEstoque.getMatrizEstacionaria(0,4),0.00117439081331593,0.01);
		assertEquals(gerenciadorDeEstoque.getMatrizEstacionaria(0,5),0.000234878162663185,0.01);
		assertEquals(gerenciadorDeEstoque.getMatrizEstacionaria(0,6),0.482669906231506,0.01);
		
		assertEquals(gerenciadorDeEstoque.getMatrizEstacionaria(1,0),0.482646418415240,0.01);
		assertEquals(gerenciadorDeEstoque.getMatrizEstacionaria(1,1),0.0195731802219321,0.01);
		assertEquals(gerenciadorDeEstoque.getMatrizEstacionaria(1,2),0.00978659011096606,0.01);
		assertEquals(gerenciadorDeEstoque.getMatrizEstacionaria(1,3),0.00978659011096606,0.01);
		assertEquals(gerenciadorDeEstoque.getMatrizEstacionaria(1,4),0.00117439081331593,0.01);
		assertEquals(gerenciadorDeEstoque.getMatrizEstacionaria(1,5),0.000234878162663185,0.01);
		assertEquals(gerenciadorDeEstoque.getMatrizEstacionaria(1,6),0.482669906231506,0.01);
		
		assertEquals(gerenciadorDeEstoque.getMatrizEstacionaria(2,0),0.482646418415240,0.01);
		assertEquals(gerenciadorDeEstoque.getMatrizEstacionaria(2,1),0.0195731802219321,0.01);
		assertEquals(gerenciadorDeEstoque.getMatrizEstacionaria(2,2),0.00978659011096606,0.01);
		assertEquals(gerenciadorDeEstoque.getMatrizEstacionaria(2,3),0.00978659011096606,0.01);
		assertEquals(gerenciadorDeEstoque.getMatrizEstacionaria(2,4),0.00117439081331593,0.01);
		assertEquals(gerenciadorDeEstoque.getMatrizEstacionaria(2,5),0.000234878162663185,0.01);
		assertEquals(gerenciadorDeEstoque.getMatrizEstacionaria(2,6),0.482669906231506,0.01);
		
		assertEquals(gerenciadorDeEstoque.getMatrizEstacionaria(3,0),0.482646418415240,0.01);
		assertEquals(gerenciadorDeEstoque.getMatrizEstacionaria(3,1),0.0195731802219321,0.01);
		assertEquals(gerenciadorDeEstoque.getMatrizEstacionaria(3,2),0.00978659011096606,0.01);
		assertEquals(gerenciadorDeEstoque.getMatrizEstacionaria(3,3),0.00978659011096606,0.01);
		assertEquals(gerenciadorDeEstoque.getMatrizEstacionaria(3,4),0.00117439081331593,0.01);
		assertEquals(gerenciadorDeEstoque.getMatrizEstacionaria(3,5),0.000234878162663185,0.01);
		assertEquals(gerenciadorDeEstoque.getMatrizEstacionaria(3,6),0.482669906231506,0.01);
		
		assertEquals(gerenciadorDeEstoque.getMatrizEstacionaria(4,0),0.482646418415240,0.01);
		assertEquals(gerenciadorDeEstoque.getMatrizEstacionaria(4,1),0.0195731802219321,0.01);
		assertEquals(gerenciadorDeEstoque.getMatrizEstacionaria(4,2),0.00978659011096606,0.01);
		assertEquals(gerenciadorDeEstoque.getMatrizEstacionaria(4,3),0.00978659011096606,0.01);
		assertEquals(gerenciadorDeEstoque.getMatrizEstacionaria(4,4),0.00117439081331593,0.01);
		assertEquals(gerenciadorDeEstoque.getMatrizEstacionaria(4,5),0.000234878162663185,0.01);
		assertEquals(gerenciadorDeEstoque.getMatrizEstacionaria(4,6),0.482669906231506,0.01);
		
		assertEquals(gerenciadorDeEstoque.getMatrizEstacionaria(5,0),0.482646418415240,0.01);
		assertEquals(gerenciadorDeEstoque.getMatrizEstacionaria(5,1),0.0195731802219321,0.01);
		assertEquals(gerenciadorDeEstoque.getMatrizEstacionaria(5,2),0.00978659011096606,0.01);
		assertEquals(gerenciadorDeEstoque.getMatrizEstacionaria(5,3),0.00978659011096606,0.01);
		assertEquals(gerenciadorDeEstoque.getMatrizEstacionaria(5,4),0.00117439081331593,0.01);
		assertEquals(gerenciadorDeEstoque.getMatrizEstacionaria(5,5),0.000234878162663185,0.01);
		assertEquals(gerenciadorDeEstoque.getMatrizEstacionaria(5,6),0.482669906231506,0.01);
		
		assertEquals(gerenciadorDeEstoque.getMatrizEstacionaria(6,0),0.482646418415240,0.01);
		assertEquals(gerenciadorDeEstoque.getMatrizEstacionaria(6,1),0.0195731802219321,0.01);
		assertEquals(gerenciadorDeEstoque.getMatrizEstacionaria(6,2),0.00978659011096606,0.01);
		assertEquals(gerenciadorDeEstoque.getMatrizEstacionaria(6,3),0.00978659011096606,0.01);
		assertEquals(gerenciadorDeEstoque.getMatrizEstacionaria(6,4),0.00117439081331593,0.01);
		assertEquals(gerenciadorDeEstoque.getMatrizEstacionaria(6,5),0.000234878162663185,0.01);
		assertEquals(gerenciadorDeEstoque.getMatrizEstacionaria(6,6),0.482669906231506,0.01);
	}
	
	@Test
	public void probabilidadeEstacionaria() {
		GerenciadorEstoque gerenciadorDeEstoque = new GerenciadorEstoque(
				10000, 100, 0.1, 10, 10, 5);
		gerenciadorDeEstoque.calcular();
		assertEquals(gerenciadorDeEstoque.getProbabilidadeEstacionaria(0,0),0.482646418415240,0.01);
		assertEquals(gerenciadorDeEstoque.getProbabilidadeEstacionaria(0,1),0.0195731802219321,0.01);
		assertEquals(gerenciadorDeEstoque.getProbabilidadeEstacionaria(0,2),0.00978659011096606,0.01);
		assertEquals(gerenciadorDeEstoque.getProbabilidadeEstacionaria(0,3),0.00391463604438642,0.01);
		assertEquals(gerenciadorDeEstoque.getProbabilidadeEstacionaria(0,4),0.00117439081331593,0.01);
		assertEquals(gerenciadorDeEstoque.getProbabilidadeEstacionaria(0,5),0.000234878162663185,0.01);
		assertEquals(gerenciadorDeEstoque.getProbabilidadeEstacionaria(0,6),0.482669906231506,0.01);
	}
	
	@Test
	public void custoMedioDaPoliticaDeEstoque() {
		GerenciadorEstoque gerenciadorDeEstoque = new GerenciadorEstoque(
				10000, 100, 0.1, 10, 10, 5);
		gerenciadorDeEstoque.calcular();
		assertEquals(gerenciadorDeEstoque.getCustoMedioDaPoliticaDeEstoque(),4.855991765874566e+03,0.1e+03);

	}
	
	@Test
	public void matrizDeCustosMedios() {
		GerenciadorEstoque gerenciadorDeEstoque = new GerenciadorEstoque(
				10000, 100, 0.1, 10, 10, 5);
		gerenciadorDeEstoque.calcular();
		assertEquals(gerenciadorDeEstoque.getMatrizDeCustosMedios(0,0),8904.25048923981,200);
		assertEquals(gerenciadorDeEstoque.getMatrizDeCustosMedios(0,1),8904.65485525710,200);
		assertEquals(gerenciadorDeEstoque.getMatrizDeCustosMedios(0,2),0,0);
		assertEquals(gerenciadorDeEstoque.getMatrizDeCustosMedios(0,3),0,0);
		assertEquals(gerenciadorDeEstoque.getMatrizDeCustosMedios(0,4),0,0);
		assertEquals(gerenciadorDeEstoque.getMatrizDeCustosMedios(0,5),0,0);
		
		assertEquals(gerenciadorDeEstoque.getMatrizDeCustosMedios(1,0),6253.61240274750,200);
		assertEquals(gerenciadorDeEstoque.getMatrizDeCustosMedios(1,1),6257.48939233247,200);
		assertEquals(gerenciadorDeEstoque.getMatrizDeCustosMedios(1,2),6258.13553792599,200);
		assertEquals(gerenciadorDeEstoque.getMatrizDeCustosMedios(1,3),0,0);
		assertEquals(gerenciadorDeEstoque.getMatrizDeCustosMedios(1,4),0,0);
		assertEquals(gerenciadorDeEstoque.getMatrizDeCustosMedios(1,5),0,0);
		
		assertEquals(gerenciadorDeEstoque.getMatrizDeCustosMedios(2,0),5020.56595756974,200);
		assertEquals(gerenciadorDeEstoque.getMatrizDeCustosMedios(2,1),5021.48922195129,200);
		assertEquals(gerenciadorDeEstoque.getMatrizDeCustosMedios(2,2),5021.75901785657,200);
		assertEquals(gerenciadorDeEstoque.getMatrizDeCustosMedios(2,3),5021.80123036598,200);
		assertEquals(gerenciadorDeEstoque.getMatrizDeCustosMedios(2,4),0,0);
		assertEquals(gerenciadorDeEstoque.getMatrizDeCustosMedios(2,5),0,0);
		
		assertEquals(gerenciadorDeEstoque.getMatrizDeCustosMedios(3,0),4952.58918761469,200);
		assertEquals(gerenciadorDeEstoque.getMatrizDeCustosMedios(3,1),4951.31015182448,200);
		assertEquals(gerenciadorDeEstoque.getMatrizDeCustosMedios(3,2),4950.79388048769,200);
		assertEquals(gerenciadorDeEstoque.getMatrizDeCustosMedios(3,3),4950.65077744465,200);
		assertEquals(gerenciadorDeEstoque.getMatrizDeCustosMedios(3,4),4950.63094272953,200);
		assertEquals(gerenciadorDeEstoque.getMatrizDeCustosMedios(3,5),0,0);
		
		assertEquals(gerenciadorDeEstoque.getMatrizDeCustosMedios(4,0),4866.79283843069,200);
		assertEquals(gerenciadorDeEstoque.getMatrizDeCustosMedios(4,1),4860.77718443092,2007);
		assertEquals(gerenciadorDeEstoque.getMatrizDeCustosMedios(4,2),4857.61954359447,200);
		assertEquals(gerenciadorDeEstoque.getMatrizDeCustosMedios(4,3),4856.36845090575,200);
		assertEquals(gerenciadorDeEstoque.getMatrizDeCustosMedios(4,4),4856.03548528748,200);
		assertEquals(gerenciadorDeEstoque.getMatrizDeCustosMedios(4,5),4855.99176587457,200);

	}
	
	
/*	//Não funcionam pois usam métodos internos do classe.
 * 
	@Test
	public void fatorial(){
		//GerenciadorEstoque gerenciadorDeEstoque = new GerenciadorEstoque(
		//		10000, 100, 0.1, 10, 10, 5);
		assertEquals(GerenciadorEstoque.fatorial(2),2,0);
		assertEquals(GerenciadorEstoque.fatorial(5),120,0);
		assertEquals(GerenciadorEstoque.fatorial(8),40320,0);
	}
	
	@Test
	public void poisson(){
		assertEquals(GerenciadorEstoque.poisson(100,80),0.0052,0.001);
		assertEquals(GerenciadorEstoque.poisson(50,45),0.0458,0.001);
	}*/
		
}
