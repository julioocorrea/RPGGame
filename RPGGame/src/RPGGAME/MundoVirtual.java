	package RPGGAME;
	
	import java.util.List;
	import java.util.Scanner;
	
	public class MundoVirtual {
		private int[] MapaDoMundo;
		private Personagem Personagem;
		private Missao Missao;
		private List<Inimigo> ListaDeInimigos;
		
		public MundoVirtual(Personagem personagem, Missao missao, List<Inimigo> listaDeInimigos) {
			this.MapaDoMundo = new int[] {1, 2, 3, 4};
			this.Personagem = personagem;
			this.ListaDeInimigos = listaDeInimigos;
			this.Missao = missao;
			int posicao = 0;
			
	        System.out.println("========================================================================");
	    System.out.println("   🏰 Bem-vindo ao Reino do RPG! 🏰");
	    System.out.println("========================================================================");
	    System.out.println(personagem.toString());
	    System.out.println("========================================================================\n\n");
	    
	    missao.IniciarMissao(personagem);
		
	    for (int i = 1; i <= MapaDoMundo.length; i++) {
	    	GerenciarInteracao(personagem, MapaDoMundo, i, listaDeInimigos);
	    }
	    
	}
	
	public int[] getMapaDoMundo() {
		return MapaDoMundo;
	}
	
	public void setMapaDoMundo(int[] mapaDoMundo) {
		MapaDoMundo = mapaDoMundo;
	}
	
	public Personagem getPersonagem() {
		return Personagem;
	}
	
	public void setPersonagem(Personagem personagem) {
		Personagem = personagem;
	}
	
	public Missao getMissao() {
		return Missao;
	}
	
	public void setMissao(Missao missao) {
		Missao = missao;
	}
	
	public List<Inimigo> getListaDeInimigos() {
		return ListaDeInimigos;
	}
	
	public void setListaDeInimigos(List<Inimigo> listaDeInimigos) {
		ListaDeInimigos = listaDeInimigos;
	}
	
	public void GerenciarInteracao(Personagem personagem, int[] mapa, int posicao, List<Inimigo> listaDeInimigos) {
	        Scanner input = new Scanner(System.in);
	        int cont;
	        String acao;
	        
	        if (mapa[(posicao - 1)] == 1) {
				do {
					System.out.println("========================================================================");
			        System.out.println("Ações Disponiveis:\n"
									 + "C: Caminhar");
			        System.out.println("========================================================================");
					System.out.println("Digite a letra referente a sua escolha: ");
					acao = input.next();
			        System.out.println("========================================================================\n");
			        
				} while (!acao.equalsIgnoreCase("C"));
				
				personagem.Caminhar(posicao);
				
	        }
			else if (mapa[(posicao - 1)] == 2) {
				Item itemInicial = new Item("Espada Basica", "Esse item lhe concede 5 de dano fisico e 5 de dano magico", "ataque", 0, 5, 5, 0);
				itemInicial.PegarItem(personagem);
				
				do {
					System.out.println("========================================================================");
			        System.out.println("Que ação deseja realizar?\n"
									 + "C: Caminhar\n"
									 + "U: Usar Item");
			        System.out.println("========================================================================");
					System.out.println("Digite a letra referente a sua escolha: ");
					acao = input.next();
			        System.out.println("========================================================================");
			        
				} while (acao.equalsIgnoreCase("U") && acao.equalsIgnoreCase("C"));
				
				if (acao.equalsIgnoreCase("U")) {
			        itemInicial.UsarItem(personagem);
				}
				else {
					personagem.Caminhar(posicao);
				}
				
			}
			else if (mapa[(posicao - 1)] == 3) {
		        System.out.println("\n\n========================================================================");
		        System.out.println("        💀 Inimigo a Vista 💀");
		        System.out.println("========================================================================");
		        System.out.println("👺 Inimigo: " + listaDeInimigos.get(0).getNome());
		        System.out.println("💊 Saúde: " + listaDeInimigos.get(0).getSaude());
		        System.out.println("⚡ Energia: " + listaDeInimigos.get(0).getEnergia());
		        System.out.println("🗡️ Dano Físico: " + listaDeInimigos.get(0).getDanoFisico());
		        System.out.println("🔮 Dano Mágico: " + listaDeInimigos.get(0).getDanoMagico());
		        System.out.println("========================================================================\n\n");
	
				do {
					if (!personagem.getItens().isEmpty()) {
						System.out.println("========================================================================");
				        System.out.println("Deseja usar algum item antes do duelo?\n"
										 + "1: Sim\n"
										 + "2: Não\n");
						System.out.println("Digite o número referente a sua escolha: \n"
								 		 + "obs: você não pode usar itens durante a batalha.");
						cont = input.nextInt();
				        System.out.println("========================================================================\n");
					} else {
						cont = 2;
					}
				} while (cont != 1 && cont != 2);
				
				if (cont == 1) {
					Item itemEscolhido = new Item();
					do {
				        System.out.println("========================================================================");
				        System.out.println("Qual item você deseja usar?");
						for (Item item : personagem.getItens()) {
							System.out.println((personagem.getItens().indexOf(item) + 1) + ": " + item.getNome());
						}
				        System.out.println("========================================================================");
				        System.out.println("Digite o número do item que deseja usar: ");
				        cont = input.nextInt();
				        
						for (Item item : personagem.getItens()) {
							if ((personagem.getItens().indexOf(item)) == cont - 1) {
								itemEscolhido = personagem.getItens().get(cont - 1);
							}
						}
					} while (itemEscolhido.getNome() != personagem.getItens().get(cont - 1).getNome());
					
					itemEscolhido.UsarItem(personagem);
					Batalha batalhaInicial = new Batalha(personagem, listaDeInimigos.get(0));
				}
				else {
					Batalha batalhaInicial = new Batalha(personagem, listaDeInimigos.get(0));
				}
				
			}
			else  {
		        System.out.println("\n========================================================================");
		        System.out.println("        💀 Boss a Vista 💀");
		        System.out.println("========================================================================");
		        System.out.println("👺 Inimigo: " + listaDeInimigos.get(1).getNome());
		        System.out.println("💊 Saúde: " + listaDeInimigos.get(1).getSaude());
		        System.out.println("⚡ Energia: " + listaDeInimigos.get(1).getEnergia());
		        System.out.println("🗡️ Dano Físico: " + listaDeInimigos.get(1).getDanoFisico());
		        System.out.println("🔮 Dano Mágico: " + listaDeInimigos.get(1).getDanoMagico());
		        System.out.println("========================================================================\n\n");
		        
				do {
					System.out.println("========================================================================");
			        System.out.println("Deseja usar algum item antes do duelo?\n"
									 + "1: Sim\n"
									 + "2: Não\n");
					System.out.println("Digite o número referente a sua escolha: \n"
							 		 + "obs: você não pode usar itens durante a batalha.");
					cont = input.nextInt();
			        System.out.println("========================================================================\n");
				} while (cont != 1 && cont != 2);
				
				if (cont == 1) {
					Item itemEscolhido = new Item();
					do {
				        System.out.println("========================================================================");
				        System.out.println("Qual item você deseja usar?");
						for (Item item : personagem.getItens()) {
							System.out.println((personagem.getItens().indexOf(item) + 1) + ": " + item.getNome());
						}
				        System.out.println("========================================================================");
				        System.out.println("Digite o número do item que deseja usar: ");
				        cont = input.nextInt();
				        
						for (Item item : personagem.getItens()) {
							if ((personagem.getItens().indexOf(item)) == cont - 1) {
								itemEscolhido = personagem.getItens().get(cont - 1);
								itemEscolhido.UsarItem(personagem);
								break;
							}
						}
						
						if (!personagem.getItens().isEmpty()) {
					        System.out.println("========================================================================");
							System.out.println("Usar outro item?\n"
											 + "1: Sim\n"
											 + "2: Não\n");
							System.out.println("Digite o número referente a sua escolha: ");
							cont = input.nextInt();
					        System.out.println("========================================================================\n");
						}
						else {
							cont = 2;
						}

					} while (cont != 2);
					
					Batalha batalhaInicial = new Batalha(personagem, listaDeInimigos.get(1));
					
				}
				else {
					
					Batalha batalhaInicial = new Batalha(personagem, listaDeInimigos.get(1));
					
				}
			}
		}
	}
	
	
