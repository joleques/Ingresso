package classes;


import java.math.BigDecimal;
import java.math.RoundingMode;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TesteCalculadoraPrecoIngressos {
	
	private static final TipoIngresso CRIANCA = TipoIngresso.CRIANCA;
	private static final TipoIngresso ADULTO = TipoIngresso.PESSOA;
	private static final TipoIngresso IDOSO = TipoIngresso.IDOSO;
	private static final TipoIngresso ESTUDANTE = TipoIngresso.ESTUDANTE;
	
	private static final DiaSemana SEGUNDA = DiaSemana.SEGUNDA;
	private static final DiaSemana TERCA = DiaSemana.TERCA;
	private static final DiaSemana QUARTA = DiaSemana.QUARTA;
	private static final DiaSemana QUINTA = DiaSemana.QUINTA;
	private static final DiaSemana SEXTA = DiaSemana.SEXTA;
	private static final DiaSemana FIMDESEMANA = DiaSemana.FIMDESEMANA;
	
	
	private CalculadoraPrecoIngressos calculadoraDoPrecoDeIngressos;

	@Before
	public void setUp() throws Exception {
		calculadoraDoPrecoDeIngressos = new CalculadoraPrecoIngressos();
	}

	@After
	public void tearDown() throws Exception {
		calculadoraDoPrecoDeIngressos = null;
	}
	
	@Test
	public void valorDoIngressoSegundaFeiraParaCrianca(){
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(para(CRIANCA),na(SEGUNDA));
		Assert.assertEquals(BigDecimal.valueOf(4.95), valor);
	}

	@Test
	public void valorDoIngressoSegundaFeiraFeriadoParaCrianca(){
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(para(CRIANCA),noFeriadoDe(SEGUNDA));
		Assert.assertEquals(BigDecimal.valueOf(5.50).setScale(2, RoundingMode.HALF_DOWN), valor);
	}

	@Test
	public void valorDoIngressoSegundaFeiraParaCriancaComCarteirinhaDeEstudante(){
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(paraEstudanteComCarteirinha(CRIANCA),na(SEGUNDA));
		Assert.assertEquals(BigDecimal.valueOf(3.58), valor);
	}

	@Test
	public void valorDoIngressoTercaFeiraParaCrianca(){
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(para(CRIANCA),na(TERCA));
		Assert.assertEquals(BigDecimal.valueOf(4.68), valor);
	}

	@Test
	public void valorDoIngressoTercaFeiraParaCriancaComCarteirinhaDeEstudante(){
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(paraEstudanteComCarteirinha(CRIANCA),na(TERCA));
		Assert.assertEquals(BigDecimal.valueOf(3.58), valor);
	}
	
	@Test
	public void valorDoIngressoQuartaFeiraParaCrianca(){
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(para(CRIANCA),na(QUARTA));
		Assert.assertEquals(BigDecimal.valueOf(3.85), valor);
	}
	
	@Test
	public void valorDoIngressoQuartaFeiraParaCriancaComCarteirinhaDeEstudante(){
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(paraEstudanteComCarteirinha(CRIANCA),na(QUARTA));
		Assert.assertEquals(BigDecimal.valueOf(3.58), valor);
	}

	@Test
	public void valorDoIngressoQuintaFeiraParaCrianca(){
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(para(CRIANCA),na(QUINTA));
		Assert.assertEquals(BigDecimal.valueOf(5.50).setScale(2, RoundingMode.HALF_DOWN), valor);
	}
	
	@Test
	public void valorDoIngressoQuintaFeiraParaCriancaComCarteirinhaDeEstudante(){
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(paraEstudanteComCarteirinha(CRIANCA),na(QUINTA));
		Assert.assertEquals(BigDecimal.valueOf(3.58), valor);
	}	

	@Test
	public void valorDoIngressoSextaFeiraParaCrianca(){
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(para(CRIANCA),na(SEXTA));
		Assert.assertEquals(BigDecimal.valueOf(4.90).setScale(2, RoundingMode.HALF_DOWN), valor);
	}
	
	@Test
	public void valorDoIngressoSextaFeiraParaCriancaComCarteirinhaDeEstudante(){
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(paraEstudanteComCarteirinha(CRIANCA),na(SEXTA));
		Assert.assertEquals(BigDecimal.valueOf(3.58), valor);
	}

	@Test
	public void valorDoIngressoFimDeSemanaParaCrianca(){
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(para(CRIANCA),na(FIMDESEMANA));
		Assert.assertEquals(BigDecimal.valueOf(5.50).setScale(2, RoundingMode.HALF_DOWN), valor);
	}
	
	@Test
	public void valorDoIngressoFimDeSemanaParaCriancaComCarteirinhaDeEstudante(){
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(paraEstudanteComCarteirinha(CRIANCA),na(FIMDESEMANA));
		Assert.assertEquals(BigDecimal.valueOf(3.58), valor);
	}

	@Test
	public void valorDoIngressoFimDeSemanaFeriadoParaCriancaComCarteirinhaDeEstudante(){
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(paraEstudanteComCarteirinha(CRIANCA),noFeriadoDe(FIMDESEMANA));
		Assert.assertEquals(BigDecimal.valueOf(3.58), valor);
	}
	
	
	

	@Test
	public void valorDoIngressoSegundaFeiraParaIdoso(){
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(para(IDOSO),na(SEGUNDA));
		Assert.assertEquals(BigDecimal.valueOf(5.40).setScale(2, RoundingMode.HALF_DOWN), valor);
	}

	@Test
	public void valorDoIngressoSegundaFeiraFeriadoParaIdoso(){
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(para(IDOSO),noFeriadoDe(SEGUNDA));
		Assert.assertEquals(BigDecimal.valueOf(5.70).setScale(2, RoundingMode.HALF_DOWN), valor);
	}

	@Test
	public void valorDoIngressoSegundaFeiraParaIdosoComCarteirinhaDeEstudante(){		
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(paraEstudanteComCarteirinha(IDOSO),na(SEGUNDA));
		Assert.assertEquals(BigDecimal.valueOf(3.90).setScale(2, RoundingMode.HALF_DOWN), valor);
	}	

	@Test
	public void valorDoIngressoTercaFeiraParaIdoso(){
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(para(IDOSO),na(TERCA));
		Assert.assertEquals(BigDecimal.valueOf(5.10).setScale(2, RoundingMode.HALF_DOWN), valor);
	}

	@Test
	public void valorDoIngressoTercaFeiraParaIdosoComCarteirinhaDeEstudante(){		
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(paraEstudanteComCarteirinha(IDOSO),na(TERCA));
		Assert.assertEquals(BigDecimal.valueOf(3.90).setScale(2, RoundingMode.HALF_DOWN), valor);
	}	

	@Test
	public void valorDoIngressoQuartaFeiraParaIdoso(){
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(para(IDOSO),na(QUARTA));
		Assert.assertEquals(BigDecimal.valueOf(3.60).setScale(2, RoundingMode.HALF_DOWN), valor);
	}

	@Test
	public void valorDoIngressoQuartaFeiraParaIdosoComCarteirinhaDeEstudante(){		
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(paraEstudanteComCarteirinha(IDOSO),na(QUARTA));
		Assert.assertEquals(BigDecimal.valueOf(3.90).setScale(2, RoundingMode.HALF_DOWN), valor);
	}	

	@Test
	public void valorDoIngressoQuintaFeiraParaIdoso(){
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(para(IDOSO),na(QUINTA));
		Assert.assertEquals(BigDecimal.valueOf(4.20).setScale(2, RoundingMode.HALF_DOWN), valor);
	}

	@Test
	public void valorDoIngressoQuintaFeiraParaIdosoComCarteirinhaDeEstudante(){		
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(paraEstudanteComCarteirinha(IDOSO),na(QUINTA));
		Assert.assertEquals(BigDecimal.valueOf(3.90).setScale(2, RoundingMode.HALF_DOWN), valor);
	}	

	@Test
	public void valorDoIngressoSextaFeiraParaIdoso(){
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(para(IDOSO),na(SEXTA));
		Assert.assertEquals(BigDecimal.valueOf(6.00).setScale(2, RoundingMode.HALF_DOWN), valor);
	}

	@Test
	public void valorDoIngressoSextaFeiraParaIdosoComCarteirinhaDeEstudante(){		
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(paraEstudanteComCarteirinha(IDOSO),na(SEXTA));
		Assert.assertEquals(BigDecimal.valueOf(3.90).setScale(2, RoundingMode.HALF_DOWN), valor);
	}	

	@Test
	public void valorDoIngressoSextaFeiraFeriadoParaIdosoComCarteirinhaDeEstudante(){		
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(paraEstudanteComCarteirinha(IDOSO),noFeriadoDe(SEXTA));
		Assert.assertEquals(BigDecimal.valueOf(3.90).setScale(2, RoundingMode.HALF_DOWN), valor);
	}	

	@Test
	public void valorDoIngressoFimDeSemanaParaIdoso(){
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(para(IDOSO),na(FIMDESEMANA));
		Assert.assertEquals(BigDecimal.valueOf(5.70).setScale(2, RoundingMode.HALF_DOWN), valor);
	}

	@Test
	public void valorDoIngressoFimDeSemanaParaIdosoComCarteirinhaDeEstudante(){		
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(paraEstudanteComCarteirinha(IDOSO),na(FIMDESEMANA));
		Assert.assertEquals(BigDecimal.valueOf(3.90).setScale(2, RoundingMode.HALF_DOWN), valor);
	}	
	
	

	@Test
	public void testarValorDoIngressoSegundaFeiraParaEstudante(){
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(para(ESTUDANTE),na(SEGUNDA));
		Assert.assertEquals(BigDecimal.valueOf(7.20).setScale(2, RoundingMode.HALF_DOWN), valor);
	}

	@Test
	public void valorDoIngressoSegundaFeiraParaEstudanteComCarteirinhaDeEstudante(){
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(paraEstudanteComCarteirinha(ESTUDANTE),na(SEGUNDA));
		Assert.assertEquals(BigDecimal.valueOf(5.20).setScale(2, RoundingMode.HALF_DOWN), valor);
	}

	@Test
	public void testarValorDoIngressoTercaFeiraParaEstudante(){
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(para(ESTUDANTE),na(TERCA));
		Assert.assertEquals(BigDecimal.valueOf(7.60).setScale(2, RoundingMode.HALF_DOWN), valor);
	}

	@Test
	public void valorDoIngressoTercaFeiraParaEstudanteComCarteirinhaDeEstudante(){
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(paraEstudanteComCarteirinha(ESTUDANTE),na(TERCA));
		Assert.assertEquals(BigDecimal.valueOf(5.20).setScale(2, RoundingMode.HALF_DOWN), valor);
	}

	@Test
	public void testarValorDoIngressoQuartaFeiraParaEstudante(){
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(para(ESTUDANTE),na(QUARTA));
		Assert.assertEquals(BigDecimal.valueOf(4.00).setScale(2, RoundingMode.HALF_DOWN), valor);
	}

	@Test
	public void valorDoIngressoQuartaFeiraParaEstudanteComCarteirinhaDeEstudante(){
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(paraEstudanteComCarteirinha(ESTUDANTE),na(QUARTA));
		Assert.assertEquals(BigDecimal.valueOf(5.20).setScale(2, RoundingMode.HALF_DOWN), valor);
	}

	@Test
	public void testarValorDoIngressoQuintaFeiraParaEstudante(){
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(para(ESTUDANTE),na(QUINTA));
		Assert.assertEquals(BigDecimal.valueOf(5.60).setScale(2, RoundingMode.HALF_DOWN), valor);
	}

	@Test
	public void testarValorDoIngressoQuintaFeiraFeriadoParaEstudante(){
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(para(ESTUDANTE),noFeriadoDe(QUINTA));
		Assert.assertEquals(BigDecimal.valueOf(8.00).setScale(2, RoundingMode.HALF_DOWN), valor);
	}

	@Test
	public void valorDoIngressoQuintaFeiraParaEstudanteComCarteirinhaDeEstudante(){
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(paraEstudanteComCarteirinha(ESTUDANTE),na(QUINTA));
		Assert.assertEquals(BigDecimal.valueOf(5.20).setScale(2, RoundingMode.HALF_DOWN), valor);
	}

	@Test
	public void valorDoIngressoQuintaFeiraFeriadoParaEstudanteComCarteirinhaDeEstudante(){
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(paraEstudanteComCarteirinha(ESTUDANTE),noFeriadoDe(QUINTA));
		Assert.assertEquals(BigDecimal.valueOf(5.20).setScale(2, RoundingMode.HALF_DOWN), valor);
	}

	@Test
	public void testarValorDoIngressoSextaFeiraParaEstudante(){
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(para(ESTUDANTE),na(SEXTA));
		Assert.assertEquals(BigDecimal.valueOf(8.00).setScale(2, RoundingMode.HALF_DOWN), valor);
	}

	@Test
	public void valorDoIngressoSextaFeiraParaEstudanteComCarteirinhaDeEstudante(){
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(paraEstudanteComCarteirinha(ESTUDANTE),na(SEXTA));
		Assert.assertEquals(BigDecimal.valueOf(5.20).setScale(2, RoundingMode.HALF_DOWN), valor);
	}

	@Test
	public void testarValorDoIngressoFimDeSemanaParaEstudante(){
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(para(ESTUDANTE),na(FIMDESEMANA));
		Assert.assertEquals(BigDecimal.valueOf(8.00).setScale(2, RoundingMode.HALF_DOWN), valor);
	}

	@Test
	public void valorDoIngressoFimDeSemanaParaEstudanteComCarteirinhaDeEstudante(){
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(paraEstudanteComCarteirinha(ESTUDANTE),na(FIMDESEMANA));
		Assert.assertEquals(BigDecimal.valueOf(5.20).setScale(2, RoundingMode.HALF_DOWN), valor);
	}
	
	
	

	@Test
	public void valorDoIngressoSegundaFeiraParaAdulto(){
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(para(ADULTO),na(SEGUNDA));
		Assert.assertEquals(BigDecimal.valueOf(10.00).setScale(2, RoundingMode.HALF_DOWN), valor);
	}

	@Test
	public void valorDoIngressoSegundaFeiraParaAdultoComCarteirinhaDeEstudante(){
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(paraEstudanteComCarteirinha(ADULTO),na(SEGUNDA));
		Assert.assertEquals(BigDecimal.valueOf(6.50).setScale(2, RoundingMode.HALF_DOWN), valor);
	}

	@Test
	public void valorDoIngressoTercaFeiraParaAdulto(){
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(para(ADULTO),na(TERCA));
		Assert.assertEquals(BigDecimal.valueOf(10.00).setScale(2, RoundingMode.HALF_DOWN), valor);
	}

	@Test
	public void valorDoIngressoTercaFeiraParaAdultoComCarteirinhaDeEstudante(){
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(paraEstudanteComCarteirinha(ADULTO),na(TERCA));
		Assert.assertEquals(BigDecimal.valueOf(6.50).setScale(2, RoundingMode.HALF_DOWN), valor);
	}

	@Test
	public void valorDoIngressoQuartaFeiraParaAdulto(){
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(para(ADULTO),na(QUARTA));
		Assert.assertEquals(BigDecimal.valueOf(10.00).setScale(2, RoundingMode.HALF_DOWN), valor);
	}

	@Test
	public void valorDoIngressoQuartaFeiraParaAdultoComCarteirinhaDeEstudante(){
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(paraEstudanteComCarteirinha(ADULTO),na(QUARTA));
		Assert.assertEquals(BigDecimal.valueOf(6.50).setScale(2, RoundingMode.HALF_DOWN), valor);
	}

	@Test
	public void valorDoIngressoQuintaFeiraParaAdulto(){
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(para(ADULTO),na(QUINTA));
		Assert.assertEquals(BigDecimal.valueOf(10.00).setScale(2, RoundingMode.HALF_DOWN), valor);
	}

	@Test
	public void valorDoIngressoQuintaFeiraParaAdultoComCarteirinhaDeEstudante(){
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(paraEstudanteComCarteirinha(ADULTO),na(QUINTA));
		Assert.assertEquals(BigDecimal.valueOf(6.50).setScale(2, RoundingMode.HALF_DOWN), valor);
	}

	@Test
	public void valorDoIngressoSextaFeiraParaAdulto(){
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(para(ADULTO),na(SEXTA));
		Assert.assertEquals(BigDecimal.valueOf(10.00).setScale(2, RoundingMode.HALF_DOWN), valor);
	}

	@Test
	public void valorDoIngressoSextaFeiraParaAdultoComCarteirinhaDeEstudante(){
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(paraEstudanteComCarteirinha(ADULTO),na(SEXTA));
		Assert.assertEquals(BigDecimal.valueOf(6.50).setScale(2, RoundingMode.HALF_DOWN), valor);
	}

	@Test
	public void valorDoIngressoFimDeSemanaParaAdulto(){
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(para(ADULTO),na(FIMDESEMANA));
		Assert.assertEquals(BigDecimal.valueOf(10.00).setScale(2, RoundingMode.HALF_DOWN), valor);
	}

	@Test
	public void valorDoIngressoFimDeSemanaParaAdultoComCarteirinhaDeEstudante(){
		BigDecimal valor = calculadoraDoPrecoDeIngressos.calcular(paraEstudanteComCarteirinha(ADULTO),na(FIMDESEMANA));
		Assert.assertEquals(BigDecimal.valueOf(6.50).setScale(2, RoundingMode.HALF_DOWN), valor);
	}
	
	
	
	private DescontosDoDia na(DiaSemana diaDaSemana) {
		return DescontosDoDia.factoryDiaSemana(diaDaSemana);
	}

	private DescontosDoDia noFeriadoDe(DiaSemana diaDaSemana) {
		DescontosDoDia descontoDoDia = DescontosDoDia.factoryDiaSemana(diaDaSemana);
		descontoDoDia.setFeriado(true);
		return descontoDoDia;
	}

	private Ingresso para(TipoIngresso tipoIngresso){
		return Ingresso.factoryMetodo(tipoIngresso);
	}

	private Ingresso paraEstudanteComCarteirinha(TipoIngresso tipoIngresso){
		Ingresso ingresso = Ingresso.factoryMetodo(tipoIngresso);
		ingresso.setEstaComCarteirinhaEstudante(true);
		return ingresso;
	}

}
