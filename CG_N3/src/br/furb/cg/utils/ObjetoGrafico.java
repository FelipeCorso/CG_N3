package br.furb.cg.utils;

public class ObjetoGrafico {
	private int[] cor = new int[3];
	private Ponto[] vetorPontos;

	private ObjetoGrafico[] vetorObjGrafico;
	private Transformacao transformacao;
	private BBox bBox;

	public ObjetoGrafico() {
		vetorPontos = new Ponto[3];
	}

	public void desenha() {

	}

	public boolean adicionarObjGrafico(ObjetoGrafico objGrafico) {
		return true;
	}

	public boolean removerObjGrafico(ObjetoGrafico objGrafico) {
		return true;
	}

	public void addPonto(Ponto pontoParam) {
		for (int i = 0; i < vetorPontos.length; i++) {
			Ponto ponto = vetorPontos[i];
			if (ponto == null) {
				vetorPontos[i] = pontoParam;
				break;
			}
		}
	}

	public Ponto[] getPontos() {
		return vetorPontos;
	}

}
