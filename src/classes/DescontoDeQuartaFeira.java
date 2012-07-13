package classes;

import java.math.BigDecimal;

public class DescontoDeQuartaFeira extends DescontosDoDia {

	@Override
	public BigDecimal retornarDescontoPara(Ingresso ingresso) {
		switch (ingresso.getTipo()) {
		case CRIANCA:
			return retornarDesconto(ingresso, BigDecimal.valueOf(0.3));
		case IDOSO:
			return retornarDesconto(ingresso, BigDecimal.valueOf(0.4));
		case ESTUDANTE:
			return retornarDesconto(ingresso, BigDecimal.valueOf(0.5));
		}
		return retornarDesconto(ingresso, BigDecimal.valueOf(0));
	}

}
