package classes;

import java.math.BigDecimal;

public class Ingresso {
	
	protected TipoIngresso tipo;
	protected BigDecimal valorIngresso;
	protected boolean estaComCarteirinhaEstudante;
	
	

	public Ingresso() {
		tipo = TipoIngresso.PESSOA;
		valorIngresso = BigDecimal.valueOf(10.0);
		estaComCarteirinhaEstudante = false;
	}

	public static Ingresso factoryMetodo(TipoIngresso tipoIngresso) {
		switch (tipoIngresso) {
		case CRIANCA:
			return new IngressoCrianca();
		case IDOSO:
			return new IngressoIdoso();
		case PESSOA:
			return new Ingresso();
		case ESTUDANTE:
			return new IngressoEstudante();
		}
		return null;
	}

	public TipoIngresso getTipo() {
		return tipo;
	}

	public BigDecimal getValorIngresso() {
		return valorIngresso;
	}

	public boolean estaComCarteirinhaEstudante() {
		return estaComCarteirinhaEstudante;
	}

	public void setEstaComCarteirinhaEstudante(boolean estaComCarteirinhaEstudante) {
		this.estaComCarteirinhaEstudante = estaComCarteirinhaEstudante;
	}
	
	
	

}
