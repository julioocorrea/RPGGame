package RPGGAME;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Item {
	private String Nome;
	private String Descricao;
	private String Tipo;
	private int DanoFisico;
	private int DanoMagico;
	private int Energia;
	private int Cura;
	
	public Item(String nome, String descricao, String tipo, int cura, int danoFisico, int danoMagico, int energia) {
       this.Nome = nome;
       this.Descricao = descricao;
       this.Tipo = tipo;
       this.Cura = cura;
       this.DanoFisico = danoFisico;
       this.DanoMagico = danoMagico;
       this.Energia = energia;
	}
	
	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
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
		return Energia;
	}

	public void setEnergia(int energia) {
		Energia = energia;
	}

	public int getCura() {
		return Cura;
	}

	public void setCura(int cura) {
		Cura = cura;
	}
	
	
	public void PegarItem(Personagem personagem) {
		Item NovoItem = new Item(this.Nome, this.Descricao, this.Tipo, this.Cura, this.DanoFisico, this.DanoMagico, this.Energia);
		personagem.setItens(NovoItem);
        System.out.println("========================================================================");
		System.out.println("💰 Você pegou o item "+this.getNome()+"");
		System.out.println("========================================================================");
        System.out.print("💬 ");
        System.out.println(this.getDescricao());
        System.out.println("========================================================================\n\n");	
	}
	
	
	public void UsarItem(Personagem personagem) {
        Scanner input = new Scanner(System.in);
		int cont;
		
		do {
	        System.out.println("========================================================================");
	        System.out.println("Qual item você deseja usar?");
			for (Item item : personagem.getItens()) {
				System.out.println((personagem.getItens().indexOf(item) + 1) + ": " + item.getNome());
			}
	        System.out.println("========================================================================");
	        System.out.println("Digite o número do item que deseja usar: ");
	        int Escolha = input.nextInt();
	        
			for (Item item : personagem.getItens()) {
				if ((personagem.getItens().indexOf(item) + 1) == Escolha) {
					personagem.setSaude(personagem.getSaude() + item.Cura);
					personagem.setDanoFisico(personagem.getDanoFisico() + item.DanoFisico);
					personagem.setDanoMagico(personagem.getDanoMagico() + item.DanoMagico);
					personagem.setEnergia(personagem.getEnergia() + item.Energia);
					
			        System.out.println("========================================================================");
					System.out.println("🌟 " + this.Nome + " usado com sucesso.");
			        System.out.println("========================================================================\n\n");
			        System.out.println("========================================================================");
			        System.out.println("   ⚔️ Informações do Personagem ⚔️");
			        System.out.println("========================================================================");
			        System.out.println(personagem.toString());
			        System.out.println("========================================================================\n\n");			        
			        
					if (personagem.getMissao().getObjetivos().contains("Use um item")) {
						personagem.getMissao().AtualizarMissao("Use um item", personagem);
		        	}
				}
				else {
			        System.out.println("========================================================================");
					System.out.println("Item inexistente");
			        System.out.println("========================================================================\n\n");
				}
			}
			
	        System.out.println("========================================================================");
			System.out.println("Usar outro item?\n"
							 + "1: Sim\n"
							 + "2: Não\n");
			System.out.println("Digite o número referente a sua escolha: ");
			cont = input.nextInt();
	        System.out.println("========================================================================\n");
			
		} while (cont != 2);
	}
}
