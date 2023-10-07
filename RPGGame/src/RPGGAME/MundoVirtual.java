package RPGGAME;

import java.util.List;

public class MundoVirtual {
	private int[][] MapaDoMundo;
	private List<Personagem> ListaDePersonagens;
	private List<Missao> ListaDeMissoes;
	private List<Inimigo> ListaDeInimigos;
	
	public int[][] getMapaDoMundo() {
		return MapaDoMundo;
	}

	public void setMapaDoMundo(int[][] mapaDoMundo) {
		MapaDoMundo = mapaDoMundo;
	}

	public List<Personagem> getListaDePersonagens() {
		return ListaDePersonagens;
	}

	public void setListaDePersonagens(List<Personagem> listaDePersonagens) {
		ListaDePersonagens = listaDePersonagens;
	}

	public List<Missao> getListaDeMissoes() {
		return ListaDeMissoes;
	}

	public void setListaDeMissoes(List<Missao> listaDeMissoes) {
		ListaDeMissoes = listaDeMissoes;
	}

	public List<Inimigo> getListaDeInimigos() {
		return ListaDeInimigos;
	}

	public void setListaDeInimigos(List<Inimigo> listaDeInimigos) {
		ListaDeInimigos = listaDeInimigos;
	}

	public void GerenciarInteracao() {
		
	}
}
