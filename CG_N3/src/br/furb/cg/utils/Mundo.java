package br.furb.cg.utils;

import java.util.LinkedList;
import java.util.List;

import javax.media.opengl.GL;

import br.furb.cg.n3.ds.ObjetoGrafico;
import br.furb.cg.n3.ds.Ponto4D;

public class Mundo {
	private final List<ObjetoGrafico> listaObjGrafico = new LinkedList<>();

	public void adicionarObjGrafico(ObjetoGrafico objGrafico) {
		listaObjGrafico.add(objGrafico);
	}

	public void removeObjGrafico(ObjetoGrafico objGrafico) {
		if (getListaObjGrafico().contains(objGrafico)) {
			getListaObjGrafico().remove(objGrafico);
		} else {
			for (ObjetoGrafico objeto : getListaObjGrafico())
				objeto.removeObjGrafico(objGrafico);
		}
	}

	public void desenha(GL gl) {
		for (ObjetoGrafico obj : listaObjGrafico) {
			obj.atribuirGL(gl);
			obj.desenha();
		}
	}

	public ObjetoGrafico selecionaObjGrafico(Ponto4D ponto) {
		for (ObjetoGrafico objetoGrafico : listaObjGrafico) {
			ObjetoGrafico obj = objetoGrafico.selecionaObjeto(ponto);
			if (obj != null)
				return obj;
		}

		return null;
	}

	public List<ObjetoGrafico> getListaObjGrafico() {
		return listaObjGrafico;
	}
}
