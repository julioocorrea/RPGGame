package RPGGAME;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Habilidade habilidadePersonagem = new Habilidade("Ultimate", "Essa habilidade lhe consede 20 de dano fisico e 20 de dano magico", 80, 20, 20);
		Personagem personagem = new Personagem("Julio", habilidadePersonagem);
		
        System.out.println("========================================================================");
        System.out.println("   🏰 Bem-vindo ao Reino do RPG! 🏰");
        System.out.println("========================================================================");
        System.out.println(personagem.toString());
        System.out.println("========================================================================\n\n");
		
		List<String> objetivosMissao = new ArrayList<>();
		objetivosMissao.add("Use um item");
		objetivosMissao.add("Ative uma habilidade");
		objetivosMissao.add("Elimine um inimigo");
		
		List<Item> recompensasMissao = new ArrayList<>();
		Item itemAtaqueRecompensa = new Item("Espada Suprema", "Este item lhe da 15 de dano fisico e 15 de dano magico", "Ataque", 0, 15, 15, 0);
		Item itemCuraRecompensa = new Item("Poção Suprema", "Este item lhe da 20 de saude e 20 de energia", "Cura", 20, 0, 0, 20);
		recompensasMissao.add(itemAtaqueRecompensa);
		recompensasMissao.add(itemCuraRecompensa);
		
		Missao missaoPrincipal = new Missao("Missão Principal", "Complete essa missão para zerar o jogo", objetivosMissao, recompensasMissao);
		missaoPrincipal.IniciarMissao(personagem, missaoPrincipal);
		
		Item itemInicial = new Item("Espada Basica", "Esse item lhe concede 5 de dano fisico e 5 de dano magico", "ataque", 0, 5, 5, 0);
		itemInicial.PegarItem(personagem);
        itemInicial.UsarItem(personagem);
		
		Habilidade habilidadeInimigo = new Habilidade("Ultimate", "Essa habilidade lhe consede 10 de dano fisico e 10 de dano magico", 80, 10, 10);
		Inimigo inimigoInicial = new Inimigo("Globin", habilidadeInimigo);
		
        Batalha batalhaInicial = new Batalha(personagem, inimigoInicial);

		
	}	
}
