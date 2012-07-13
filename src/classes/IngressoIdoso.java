package classes;

import java.math.BigDecimal;

public class IngressoIdoso extends Ingresso {


	public IngressoIdoso() {
		super();
		super.tipo = TipoIngresso.IDOSO;
		super.valorIngresso = BigDecimal.valueOf(6.00);
	}

	
}
