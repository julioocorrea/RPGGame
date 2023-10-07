package RPGGAME;

public class Batalha {
	public Batalha(Personagem personagem, Inimigo inimigo) {
        Character vencedor = null;	
		
        System.out.println("========================================================================");
        System.out.println("                  ⚔️ Duelo Iniciado ⚔️");
        System.out.println("========================================================================\n");

        do {
        	if (inimigo.getSaude() > personagem.getDanoFisico()) {
        		
           		personagem.Atacar(inimigo);
           		
           		if (personagem.getSaude() > inimigo.getDanoFisico()) {
            		inimigo.Atacar(personagem);
            		
            		System.out.println(toString(personagem, inimigo));
            		
           		}
           		else {
        			personagem.setSaude(0);
        			personagem.setEnergia(0);
        	        System.out.println("========================================================================");
        			System.out.println("👺🏹 Você foi eliminado pelo " + inimigo.getNome() );
        	        System.out.println("========================================================================");
        	        System.out.println("========================================================================");
        			System.out.println("                       Game over");
        	        System.out.println("========================================================================");
        	        
        	        vencedor = 'I';
        	        
           		}
        	}
        	else {
        		inimigo.setSaude(0);
    			inimigo.setEnergia(0);
    	        System.out.println("========================================================================");
    			System.out.println("🤴🗡️. " +inimigo.getNome()+ " Eliminado");
    	        System.out.println("========================================================================");
    	        System.out.println("\n========================================================================");
    	        System.out.println("                ⚔️ Fim do Duelo ⚔️");
    	        System.out.println("========================================================================");
    			System.out.println("🤴 Personagem: 💊 " + personagem.getSaude() + " ⚡ " + personagem.getEnergia());
    	        System.out.println("========================================================================");
    			System.out.println("👺 Inimigo: " + inimigo.getNome() + " Eliminado");
    	        System.out.println("========================================================================\n\n");
    	        
    	        vencedor = 'P';
    	        
    			personagem.getMissao().AtualizarMissao("Elimine um inimigo", personagem);
        	}
        } while (vencedor == null);
        
        
	}
	
	public String toString(Personagem personagem, Inimigo inimigo) {
		return "\n========================================================================\n"
			  +"               ⚔️ Informações do Duelo ⚔️\n"
			  +"========================================================================\n"
			  +"🤴 Personagem: 💊 " + personagem.getSaude() + " ⚡ " + personagem.getEnergia() + "\n"
			  +"========================================================================\n"
			  +"👺 Inimigo: 💊 " + inimigo.getSaude() + " ⚡ " + inimigo.getEnergia() + "\n"
			  +"========================================================================\n";		
	}
}
