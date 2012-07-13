package classes;

import java.math.BigDecimal;

public class DescontoDeTercaFeira extends DescontosDoDia {

	@Override
	public BigDecimal retornarDescontoPara(Ingresso ingresso) {
		switch (ingresso.getTipo()) {
		case CRIANCA:
		case IDOSO:
			return retornarDesconto(ingresso, BigDecimal.valueOf(0.15));
		case ESTUDANTE:
			return retornarDesconto(ingresso, BigDecimal.valueOf(0.05));
		}
		return retornarDesconto(ingresso, BigDecimal.valueOf(0));
	}

}
