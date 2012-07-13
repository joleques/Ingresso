package classes;

import java.math.BigDecimal;

public class DescontoDeFimDeSemana extends DescontosDoDia {

	@Override
	public BigDecimal retornarDescontoPara(Ingresso ingresso) {
		switch (ingresso.getTipo()) {
		case IDOSO:
			return retornarDesconto(ingresso, BigDecimal.valueOf(0.05));
		}
		return retornarDesconto(ingresso, BigDecimal.valueOf(0));
	}

}
