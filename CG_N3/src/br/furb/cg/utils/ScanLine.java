package br.furb.cg.utils;

import java.util.List;

import br.furb.cg.n3.ds.Ponto4D;


public class ScanLine {

	/**
	 * VErifica se um ponto qualquer está dentro de um poligono concavo ou
	 * convexo
	 * 
	 * @param vertices
	 *            lista de vertices do poligono
	 * @param pSel
	 *            ponto a ser verificado
	 * @return se o ponto esta dentro do poigono
	 */
	public static boolean pontoDoPoligono(List<Ponto4D> vertices, Ponto4D pSel) {
		int n = 0;
		for (int i = 0; i < vertices.size() - 1; i++) {
			Ponto4D vertice = vertices.get(i);
			if (vertice.getY() != vertices.get(i + 1).getY()) {
				Ponto4D pInt = pontoItersecsao(vertice, vertices.get(i + 1), pSel);
				if (pInt.getX() == pSel.getX()) {
					return true;
				} else {
					if (pInt.getX() > pSel.getX() && pInt.getY() > Math.min(vertice.getY(), vertices.get(i + 1).getY()) && pInt.getY() <= Math.max(vertice.getY(), vertices.get(i + 1).getY())) {
						n += 1;
					}
				}
			} else {
				if ((pSel.getY() == vertice.getY()) && pSel.getX() >= Math.min(vertice.getX(), vertices.get(i + 1).getX()) && pSel.getX() <= Math.max(vertice.getX(), vertices.get(i + 1).getX())) {
					return true;
				}
			}
		}
		return n % 2 != 0;
	}

	private static Ponto4D pontoItersecsao(Ponto4D p1, Ponto4D p2, Ponto4D pSel) {
		double x = 0;
		double ti = (pSel.getY() - p1.getY()) / (p2.getY() - p1.getY());
		if (ti >= 0 && ti <= 1) {
			x = p1.getX() + (p2.getX() - p1.getX()) * ti;
		}
		return new Ponto4D(x, pSel.getY());
	}
}
