package classes;

import java.math.BigDecimal;

public abstract class DescontosDoDia {
	
	protected boolean feriado = false;
	
	

	public void setFeriado(boolean feriado) {
		this.feriado = feriado;
	}

	public static DescontosDoDia factoryDiaSemana(DiaSemana diaDaSemana) {
		switch (diaDaSemana) {
				case SEGUNDA:
					return new DescontoDeSegundaFeira();
				case TERCA:
					return new DescontoDeTercaFeira();
				case QUARTA:
					return new DescontoDeQuartaFeira();
				case QUINTA:
					return new DescontoDeQuintaFeira();
				case SEXTA:
					return new DescontoDeSextaFeira();
				case FIMDESEMANA:
					return new DescontoDeFimDeSemana();
		}
		return null;
	}
	
	private BigDecimal retornarDescontoDeEstudante(Ingresso ingresso){
		if(ingresso.estaComCarteirinhaEstudante()){
			return BigDecimal.valueOf(0.35);
		}
		return null;
	}
	
	private BigDecimal retornarDescontoDeFeriado(Ingresso ingresso){
		BigDecimal retorno = null;
		if(ehFeriado()){
			retorno = BigDecimal.valueOf(0);
			if( ehIdoso(ingresso)){
				retorno = BigDecimal.valueOf(0.05);
			}
		}
		return retorno;
	}

	private boolean ehFeriado() {
		return feriado;
	}

	private boolean ehIdoso(Ingresso ingresso) {
		return ingresso.getTipo() == TipoIngresso.IDOSO;
	}
	

	protected BigDecimal retornarDesconto(Ingresso ingresso, BigDecimal percentualDesconto){
		BigDecimal desconto = retornarDescontoDeEstudante(ingresso);
		if(desconto == null){
			desconto = retornarDescontoDeFeriado(ingresso);
			if(desconto == null){
				return percentualDesconto;
			}
		}
		return desconto;
	}
	public abstract  BigDecimal retornarDescontoPara(Ingresso ingresso) ;

}
