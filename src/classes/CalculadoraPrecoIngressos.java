package classes;

import java.math.BigDecimal;

public class CalculadoraPrecoIngressos {

	public BigDecimal calcular(Ingresso ingresso, DescontosDoDia descontosDoDia) {
		BigDecimal percentualDeDesconto = descontosDoDia.retornarDescontoPara(ingresso);
		return  executarCalculo(ingresso.getValorIngresso(), percentualDeDesconto);
	}
	
	private BigDecimal executarCalculo(BigDecimal valorIngresso, BigDecimal percentualDesconto){
		return valorIngresso.subtract((valorIngresso.multiply(percentualDesconto))).setScale(2, BigDecimal.ROUND_UP);
	}

}
