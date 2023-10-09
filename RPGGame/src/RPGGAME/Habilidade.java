package RPGGAME;

public class Habilidade {
	private String nome;
	private String descricao;
	private int CustoDeEnergia;
	private int AumentoDoDanoFisico;
	private int AumentoDoDanoMagico;
	
	public Habilidade(String nome, String descricao, int custoDeEnergia, int aumentoDoDanoFisico, int aumentoDoDanoMagico) {
		this.nome = nome;
		this.descricao = descricao;
		this.CustoDeEnergia = custoDeEnergia;
		this.AumentoDoDanoFisico = aumentoDoDanoFisico;
		this.AumentoDoDanoMagico = aumentoDoDanoMagico;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getCustoDeEnergia() {
		return CustoDeEnergia;
	}

	public void setCustoDeEnergia(int custoDeEnergia) {
		CustoDeEnergia = custoDeEnergia;
	}

	public int getAumentoDoDanoFisico() {
		return AumentoDoDanoFisico;
	}

	public void setAumentoDoDanoFisico(int aumentoDoDanoFisico) {
		AumentoDoDanoFisico = aumentoDoDanoFisico;
	}

	public int getAumentoDoDanoMagico() {
		return AumentoDoDanoMagico;
	}

	public void setAumentoDoDanoMagico(int aumentoDoDanoMagico) {
		AumentoDoDanoMagico = aumentoDoDanoMagico;
	}

	public void AtivarHabilidade(Personagem personagem) {
		if (personagem.getEnergia() >= this.getCustoDeEnergia()) {
			personagem.setDanoFisico(personagem.getDanoFisico() + this.AumentoDoDanoFisico);
			personagem.setDanoMagico(personagem.getDanoMagico() + this.AumentoDoDanoMagico);
			personagem.setEnergia(personagem.getEnergia() - this.CustoDeEnergia);
	        System.out.println("========================================================================");
			System.out.println(" 🌟🌟🌟🌟🌟🌟🌟 " + personagem.getNome() + " usou a habilidade " + this.nome + " 🌟🌟🌟🌟🌟🌟🌟 ");
	        System.out.println("========================================================================");
	        System.out.println(personagem.toString());
	        System.out.println("========================================================================\n");
	        
			if (!personagem.getMissao().getObjetivos().isEmpty()) {
		        personagem.getMissao().AtualizarMissao("Use uma habilidade", personagem);
			}

	        System.out.println("========================================================================\n");
		}
		else {
			System.out.println("Energia insuficiente para ativar a habilidade.");
		}
	}
	
}
