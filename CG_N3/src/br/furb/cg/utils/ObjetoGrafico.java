package br.furb.cg.utils;

public class ObjetoGrafico {
	private int[] cor = new int[3];
	private Ponto[] vetorPontos;
	private ObjetoGrafico[] vetorObjGrafico;
	private Transformacao transformacao;
	private BBox bBox;

	public void desenha() {

	}

	public boolean adicionarObjGrafico(ObjetoGrafico objGrafico) {
		return true;
	}

	public boolean removerObjGrafico(ObjetoGrafico objGrafico) {
		return true;
	}

}
