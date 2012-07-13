package classes;

import java.math.BigDecimal;

public class DescontoDeQuintaFeira extends DescontosDoDia {

	@Override
	public BigDecimal retornarDescontoPara(Ingresso ingresso) {
		switch (ingresso.getTipo()) {
		case IDOSO:
		case ESTUDANTE:
			return retornarDesconto(ingresso, BigDecimal.valueOf(0.3));
		}
		return retornarDesconto(ingresso, BigDecimal.valueOf(0));
	}

}
