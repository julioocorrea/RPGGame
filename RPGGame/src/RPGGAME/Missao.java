package RPGGAME;

import java.util.ArrayList;
import java.util.List;

public class Missao {
	private String Titulo;
	private String Descricao;
	private List<Item> Recompensas;
	private List<String> Objetivos;
	
	public Missao(String titulo, String descricao, List<String> objetivos, List<Item> recompensas) {
		this.Titulo = titulo;
		this.Descricao = descricao;
		this.Objetivos = objetivos;
		this.Recompensas = recompensas;
	}
	
	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		this.Titulo = titulo;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		this.Descricao = descricao;
	}

	public List<Item> getRecompensas() {
		return Recompensas;
	}

	public void setRecompensas(List<Item> recompensas) {
		Recompensas = recompensas;
	}

	public List<String> getObjetivos() {
		return Objetivos;
	}

	public void setObjetivos(List<String> objetivos) {
		this.Objetivos = objetivos;
	}

	public void IniciarMissao(Personagem personagem, Missao missao) {
		personagem.setMissao(missao);
        System.out.println("========================================================================");
		System.out.println("📜 Missão " + missao.Titulo + " iniciada.");
        System.out.println("========================================================================");
        for (String objetivo : missao.getObjetivos()) {
        	System.out.println("🔰 " + objetivo);
        };
        System.out.println("========================================================================\n\n");
	}
	
	public void CompletarMissao(Personagem personagem) {
		System.out.println("Missão" + personagem.getMissao().getTitulo() + "concluida com sucesso!!");
		for(Item item : this.Recompensas){
			personagem.setItens(item);
			System.out.println("Item " + item.getNome() + " adicionado no inventário.");
		}
	}
	
	public void AtualizarMissao(String objetivo, Personagem personagem) {
		List<String> ObjetivosAtualizados = new ArrayList<>();
		ObjetivosAtualizados = personagem.getMissao().getObjetivos();
		ObjetivosAtualizados.remove(objetivo);
		this.setObjetivos(ObjetivosAtualizados);
		if (this.Objetivos.isEmpty()) {
			CompletarMissao(personagem);
		}
		else {
	        System.out.println("========================================================================");
			System.out.println("📜 Objetivo " + objetivo + " concluido");
			System.out.println("========================================================================\n\n");
		}
	}
}
