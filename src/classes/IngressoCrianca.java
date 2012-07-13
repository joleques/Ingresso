package classes;

import java.math.BigDecimal;

public class IngressoCrianca extends Ingresso{

	public IngressoCrianca() {
		super();
		super.tipo = TipoIngresso.CRIANCA;
		super.valorIngresso = BigDecimal.valueOf(5.5);
	}

	
}
