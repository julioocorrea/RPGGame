package RPGGAME;

import java.util.ArrayList;
import java.util.List;

public class Inimigo {
	private String Nome;
	private int Nivel;
	private int Saude;
	private int Energia;
	private int DanoFisico;
	private int DanoMagico;
	private List<Habilidade> Habilidade;
	
	public Inimigo(String nome, Habilidade habilidade) {
		this.Nome = nome;
		this.Nivel = 1;
		this.Saude = 100;
		this.Energia = 100;
		this.DanoFisico = 5;
		this.DanoMagico = 5;
		this.Habilidade = new ArrayList<>();
		this.Habilidade.add(habilidade);
		
		
        System.out.println("========================================================================");
        System.out.println("        💀 Inimigo a Vista 💀");
        System.out.println("========================================================================");
        System.out.println("👺 Inimigo: " + this.Nome);
        System.out.println("💊 Saúde: " + this.Saude);
        System.out.println("⚡ Energia: " + this.Energia);
        System.out.println("🗡️ Dano Físico: " + this.DanoFisico);
        System.out.println("🔮 Dano Mágico: " + this.DanoMagico);
        System.out.println("========================================================================\n\n");
		
	}
	
	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public int getNivel() {
		return Nivel;
	}

	public void setNivel(int nivel) {
		Nivel = nivel;
	}

	public int getSaude() {
		return Saude;
	}

	public void setSaude(int saude) {
		Saude = saude;
	}

	public int getEnergia() {
		return Energia;
	}

	public void setEnergia(int energia) {
		Energia = energia;
	}

	public int getDanoFisico() {
		return DanoFisico;
	}

	public void setDanoFisico(int danoFisico) {
		DanoFisico = danoFisico;
	}

	public int getDanoMagico() {
		return DanoMagico;
	}

	public void setDanoMagico(int danoMagico) {
		DanoMagico = danoMagico;
	}

	public List<Habilidade> getHabilidade() {
		return Habilidade;
	}

	public void setHabilidade(List<Habilidade> habilidade) {
		Habilidade = habilidade;
	}

	public void Atacar(Personagem personagem) {
		if (personagem.getSaude() > this.DanoFisico) {
			personagem.setSaude(personagem.getSaude() - this.DanoFisico);
			personagem.setEnergia(personagem.getEnergia() - this.DanoMagico);
	        System.out.println("========================================================================");
			System.out.println("👺🏹 Você foi atacado pelo " + this.Nome );
	        System.out.println("========================================================================");
		}
	}
	
}
