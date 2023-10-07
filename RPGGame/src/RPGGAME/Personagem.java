package RPGGAME;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Personagem {
	private String Nome;
	private int Nivel;
	private int Saude;
	private int Energia;
	private int DanoFisico;
	private int DanoMagico;
	private List<Habilidade> Habilidades;
	private List<Item> Itens;
	private Missao Missao;
	
	public Personagem(String nome, Habilidade habilidade) {
		this.Habilidades = new ArrayList<>();
		this.Habilidades.add(habilidade);
		this.Itens = new ArrayList<>();
		this.Nome = nome;
		this.Nivel = 1;
		this.Saude = 100;
		this.Energia = 100;
		this.DanoFisico = 10;
		this.DanoMagico = 10;
		this.Missao = null;
	}
	
	public String getNome() {
		return this.Nome;
	}

	public void setNome(String nome) {
		this.Nome = nome;
	}

	public int getNivel() {
		return this.Nivel;
	}

	public void setNivel(int nivel) {
		this.Nivel = nivel;
	}

	public int getSaude() {
		return this.Saude;
	}

	public void setSaude(int saude) {
		this.Saude = saude;
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

	public int getEnergia() {
		return this.Energia;
	}

	public void setEnergia(int energia) {
		this.Energia = energia;
	}

	public List<Habilidade> getHabilidades() {
		return this.Habilidades;
	}

	public void setHabilidades(List<Habilidade> habilidades) {
		this.Habilidades = habilidades;
	}

	public List<Item> getItens() {
		return this.Itens;
	}

	public void setItens(Item item) {
		this.Itens.add(item);
	}

	public Missao getMissao() {
		return this.Missao;
	}

	public void setMissao(Missao missao) {
		this.Missao = missao;
	}

	public void Atacar(Inimigo inimigo) {
		if (inimigo.getSaude() > this.DanoFisico) {
			inimigo.setSaude(inimigo.getSaude() - this.DanoFisico);
			inimigo.setEnergia(inimigo.getEnergia() - this.DanoMagico);
	        System.out.println("========================================================================");
			System.out.println("🤴🗡️. Você atacou o inimigo "+inimigo.getNome()+"");
	        System.out.println("========================================================================");
		}
	}
	public void Caminhar(double X, double Y) {

	}
	
	
	public String toString() {
		return "🤴🏼 Personagem: " + this.getNome() + "\n"
				+ "💊 Saúde: " + this.getSaude() + "\n"
				+ "⚡ Energia: " + this.getEnergia() + "\n"
				+ "🗡️ Dano Físico: " + this.getDanoFisico() + "\n"
				+ "🔮 Dano Mágico: " + this.getDanoMagico() + "\n"
				+ "========================================================================\n"
				+ "🌟 Habilidade: " + this.getHabilidades().get(0).getNome() + "\n"
				+ "⚡ Custo de Energia: " + this.getHabilidades().get(0).getCustoDeEnergia() + "\n"
				+ "💬 " + this.getHabilidades().get(0).getDescricao();
	}
}
