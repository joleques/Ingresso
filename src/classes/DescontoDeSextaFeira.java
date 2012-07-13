package classes;

import java.math.BigDecimal;

public class DescontoDeSextaFeira extends DescontosDoDia {

	@Override
	public BigDecimal retornarDescontoPara(Ingresso ingresso) {
		switch (ingresso.getTipo()) {
		case CRIANCA:
			return retornarDesconto(ingresso, BigDecimal.valueOf(0.11));
		}
		return retornarDesconto(ingresso, BigDecimal.valueOf(0));
	}

}
