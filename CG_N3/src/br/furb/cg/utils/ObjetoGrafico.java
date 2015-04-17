package br.furb.cg.utils;

import java.util.List;

public class ObjetoGrafico {
	private int[] cor = new int[3];
	private List<Ponto> listaPontos;
	private List<ObjetoGrafico> listaObjGrafico;
	private Transformacao transformacao;
	private BBox bBox;

	public void desenha() {

	}

	public boolean adicionarObjGrafico(ObjetoGrafico objGrafico) {
		return listaObjGrafico.add(objGrafico);
	}

	public boolean removerObjGrafico(ObjetoGrafico objGrafico) {
		return listaObjGrafico.remove(objGrafico);
	}

}
