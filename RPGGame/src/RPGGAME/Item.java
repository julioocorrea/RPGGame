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
	
	public Item() {

	}
	
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
		List<Item> itensAtualizados = new ArrayList<>();
		itensAtualizados = personagem.getItens();
		itensAtualizados.add(NovoItem);
		personagem.setItens(itensAtualizados);
        System.out.println("========================================================================");
		System.out.println("💰 Você encontrou o item "+this.getNome()+"");
		System.out.println("========================================================================");
        System.out.print("💬 ");
        System.out.println(this.getDescricao());
        System.out.println("========================================================================\n");	
	}
	
	public void UsarItem(Personagem personagem) {
		int cont;
		List<Item> itensAtualizados = new ArrayList<>();
		itensAtualizados = personagem.getItens();
		
		if (!personagem.getItens().isEmpty()) {
			for (Item item : itensAtualizados) {
				if (item.getNome() == this.getNome()) {
					if (personagem.getSaude() + item.Cura < 100) {
						personagem.setSaude(personagem.getSaude() + item.Cura);
					} else {
						personagem.setSaude(100);
					}
					if (personagem.getEnergia() + item.Energia < 100) {
						personagem.setEnergia(personagem.getEnergia() + item.Energia);
					} else {
						personagem.setEnergia(100);
					}
					personagem.setDanoFisico(personagem.getDanoFisico() + item.DanoFisico);
					personagem.setDanoMagico(personagem.getDanoMagico() + item.DanoMagico);

					
			        System.out.println("========================================================================");
					System.out.println("🌟 " + this.Nome + " usado com sucesso.");
			        System.out.println("========================================================================\n\n");
			        System.out.println("========================================================================");
			        System.out.println("   ⚔️ Informações do Personagem ⚔️");
			        System.out.println("========================================================================");
			        System.out.println(personagem.toString());
			        System.out.println("========================================================================\n\n");			        
			        
			        itensAtualizados.remove(item);
			        
					if (personagem.getMissao().getObjetivos().contains("Use um item")) {
						personagem.getMissao().AtualizarMissao("Use um item", personagem);
		        	}
					break;
				}
			}
		}

		personagem.setItens(itensAtualizados);
		
	}
	
	public void EscolherItem(Personagem personagem) {
        Scanner input = new Scanner(System.in);
        int cont;
        
		System.out.println("========================================================================");
        System.out.println("Deseja usar algum de seus itens?");
        System.out.println("1: Sim");
        System.out.println("2: Não");
        System.out.println("========================================================================");
        System.out.println("Digite o número de sua escolha:");
        cont = input.nextInt();
        System.out.println("========================================================================\n");
        
        if (cont == 1) {
            System.out.println("========================================================================");
	        System.out.println("Qual item você deseja usar?");
			for (Item item : personagem.getItens()) {
				System.out.println((personagem.getItens().indexOf(item) + 1) + ": " + item.getNome());
			}
            System.out.println("========================================================================");
            System.out.println("Digite o número do item que deseja usar: ");
            cont = input.nextInt();
            System.out.println("========================================================================\n");
            for (Item item : personagem.getItens()) {
				if (personagem.getItens().indexOf(item) == (cont - 1)) {
					personagem.getItens().get((cont - 1)).UsarItem(personagem);  
					break;
				}
			}
        }
	}
}
