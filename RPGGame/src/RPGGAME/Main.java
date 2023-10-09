package RPGGAME;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Habilidade habilidadePersonagem = new Habilidade("Ultimate", "Essa habilidade lhe consede 20 de dano fisico e 20 de dano magico", 70, 20, 20);
		Personagem personagem = new Personagem("Julio", habilidadePersonagem);
		
		List<String> objetivosMissao = new ArrayList<>();
		objetivosMissao.add("Use um item");
		objetivosMissao.add("Use uma habilidade");
		objetivosMissao.add("Elimine um inimigo");
		List<Item> recompensasMissao = new ArrayList<>();
		Item itemAtaqueRecompensa = new Item("Espada Suprema", "Este item lhe da 30 de dano fisico e 30 de dano magico", "Ataque", 0, 20, 20, 0);
		Item itemCuraRecompensa = new Item("Poção Suprema", "Este item completa sua saude e sua energia", "Cura", 100, 0, 0, 100);
		recompensasMissao.add(itemAtaqueRecompensa);
		recompensasMissao.add(itemCuraRecompensa);
		Missao missaoPrincipal = new Missao("Missão Principal", "Complete essa missão para zerar o jogo", objetivosMissao, recompensasMissao);
		
		List<Inimigo> ListaDeInimigos = new ArrayList<>();
		Habilidade habilidadeInimigo = new Habilidade("Ultimate", "Essa habilidade lhe consede 10 de dano fisico e 10 de dano magico", 80, 10, 10);
		Inimigo inimigoInicial = new Inimigo("Globin", habilidadeInimigo, 5, 5);
		Habilidade habilidadeBoss = new Habilidade("Ultimate", "Essa habilidade lhe consede 20 de dano fisico e 20 de dano magico", 100, 50, 20);
		Inimigo inimigoBoss = new Inimigo("Dragão", habilidadeInimigo, 80, 50);
		ListaDeInimigos.add(inimigoInicial);
		ListaDeInimigos.add(inimigoBoss);
		
		MundoVirtual mundo = new MundoVirtual(personagem, missaoPrincipal, ListaDeInimigos);
		
	}	
}
