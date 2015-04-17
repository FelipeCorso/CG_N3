package br.furb.cg.utils;

import java.util.List;

public class Mundo {
	private List<ObjetoGrafico> listaObjGrafico;
	private Camera camera;

	public boolean adicionarObjGrafico(ObjetoGrafico objGrafico) {
		return listaObjGrafico.add(objGrafico);
	}

	public boolean removerObjGrafico(ObjetoGrafico objGrafico) {
		return listaObjGrafico.remove(objGrafico);
	}
}
