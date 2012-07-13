package classes;

import java.math.BigDecimal;

public class IngressoEstudante extends Ingresso {

	public IngressoEstudante() {
		super();
		super.tipo = TipoIngresso.ESTUDANTE;
		super.valorIngresso = BigDecimal.valueOf(8.00);
	}
}
