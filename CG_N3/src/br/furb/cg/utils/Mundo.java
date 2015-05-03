package br.furb.cg.utils;

import java.util.LinkedList;

import javax.media.opengl.GL;

import br.furb.cg.n3.ds.ObjetoGrafico;

public class Mundo {
	LinkedList<ObjetoGrafico> listaObjGrafico = new LinkedList<>();
	private Camera camera;

	public void adicionarObjGrafico(ObjetoGrafico objGrafico) {
		listaObjGrafico.add(objGrafico);
	}

	public void removerObjGrafico(ObjetoGrafico objGrafico) {
	}

	public void desenha(GL gl) {
		for (ObjetoGrafico obj : listaObjGrafico) {
			obj.atribuirGL(gl);
			obj.desenha();
		}
	}
}
