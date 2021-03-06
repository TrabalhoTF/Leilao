package business;



import java.time.LocalDate;

public class Leilao {
	private int id_leilao;
	private boolean tipo, ativo;// para o tipo caberia melhor um enum, mas
								// coloquei na persistencia para aceitar true
								// para demanda e false para oferta
	private Usuario principal;
	LocalDate data_inicio;
	private LocalDate data_fim;
	private Lote lote;

	public Leilao(int id_leilao, Lote lote, boolean tipo, boolean ativo, Usuario principal, LocalDate data_inicio, LocalDate data_fim) {
		super();
		this.lote = lote;
		this.id_leilao = id_leilao;
		this.tipo = tipo;
		this.ativo = ativo;
		this.principal = principal;
		this.data_inicio = data_inicio;
		this.data_fim = data_fim;
	}

	public Leilao(boolean tipo, boolean ativo, Lote lote, Usuario principal, LocalDate data_inicio,LocalDate data_fim) {
		super();
		this.lote = lote;
		this.id_leilao = 0;
		this.tipo = tipo;
		this.ativo = ativo;
		this.principal = principal;
		this.data_inicio = data_inicio;
		this.data_fim = data_fim;
	}

	public Lote getLote() {
		return lote;
	}

	public void setLote(Lote lote) {
		this.lote = lote;
	}

	public int getId_leilao() {
		return id_leilao;
	}

	public void setId_leilao(int id_leilao) {
		this.id_leilao = id_leilao;
	}

	public boolean isTipo() {
		return tipo;
	}

	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Usuario getPrincipal() {
		return principal;
	}

	public void setPrincipal(Usuario principal) {
		this.principal = principal;
	}

	public LocalDate getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(LocalDate data_inicio) {
		this.data_inicio = data_inicio;
	}

	public LocalDate getData_fim() {
		return data_fim;
	}

	public void setData_fim(LocalDate data_fim) {
		this.data_fim = data_fim;
	}

}
