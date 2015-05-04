package br.furb.cg.utils;

import java.util.List;

import javax.media.opengl.GL;

import br.furb.cg.n3.ds.Ponto4D;

/**
 * BoundBox de um objeto. Será sempre um retangulo
 * 
 * @author Carlos
 *
 */
public class BBox {
	public double xMinBBox;
	public double xMaxBBox;
	public double yMinBBox;
	public double yMaxBBox;

	public BBox() {

	}

	public BBox(List<Ponto4D> vertices) {
		if (vertices.size() > 0) {
			xMinBBox = xMaxBBox = vertices.get(0).getX();
			yMinBBox = yMaxBBox = vertices.get(0).getY();

			for (int i = 1; i < vertices.size(); i++) {
				xMinBBox = Math.min(xMinBBox, vertices.get(i).getX());
				xMaxBBox = Math.max(xMaxBBox, vertices.get(i).getX());
				yMinBBox = Math.min(yMinBBox, vertices.get(i).getY());
				yMaxBBox = Math.max(yMaxBBox, vertices.get(i).getY());
			}
		}
	}

	public double getCentroX() {
		return ((xMaxBBox - xMinBBox) / 2) + xMinBBox;
	}

	public double getCentroY() {
		return ((yMaxBBox - yMinBBox) / 2) + yMinBBox;
	}

	public void desenharBBox(GL gl) {
		gl.glColor3f(0, 1.0f, 1.0f);

		gl.glBegin(GL.GL_LINE_LOOP);
		gl.glVertex2d(xMinBBox, yMinBBox);
		gl.glVertex2d(xMinBBox, yMaxBBox);
		gl.glVertex2d(xMaxBBox, yMaxBBox);
		gl.glVertex2d(xMaxBBox, yMinBBox);
		gl.glEnd();
	}

	public boolean dentroBBox(Ponto4D ponto) {
		return dentroBBox(ponto.getX(), ponto.getY());
	}

	public boolean dentroBBox(double x, double y) {
		return x <= xMaxBBox && x >= xMinBBox && y <= yMaxBBox && y >= yMinBBox;
	}

}
