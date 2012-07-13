package classes;

import java.math.BigDecimal;

public class DescontoDeSegundaFeira extends DescontosDoDia {

	@Override
	public BigDecimal retornarDescontoPara(Ingresso ingresso) {
		switch (ingresso.getTipo()) {
		case CRIANCA:
		case IDOSO:
		case ESTUDANTE:
			return retornarDesconto(ingresso,BigDecimal.valueOf(0.1));
		}
		return retornarDesconto(ingresso,BigDecimal.valueOf(0));
	}
	

}
