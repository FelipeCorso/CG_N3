package br.furb.cg.n3.ds;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

import javax.media.opengl.GL;

import br.furb.cg.utils.BBox;
import br.furb.cg.utils.ScanLine;

public final class ObjetoGrafico {

	GL gl;
	private float tamanho = 2.0f;

	private LinkedList<Ponto4D> listaPontos = new LinkedList<>();

	private BBox bBox = new BBox(getListaPontos());

	private int primitiva = GL.GL_LINE_STRIP;
	// private Ponto4D[] vertices = { new Ponto4D(10.0, 10.0, 0.0, 1.0), new
	// Ponto4D(20.0, 10.0, 0.0, 1.0), new Ponto4D(20.0, 20.0, 0.0, 1.0), new
	// Ponto4D(10.0, 20.0, 0.0, 1.0) };

	// private int primitiva = GL.GL_POINTS;
	// private Ponto4D[] vertices = { new Ponto4D(10.0, 10.0, 0.0, 1.0) };

	private Transformacao4D matrizObjeto = new Transformacao4D();
	private boolean selecionado;

	// / Matrizes temporarias que sempre sao inicializadas com matriz Identidade
	// entao podem ser "static".
	private static Transformacao4D matrizTmpTranslacao = new Transformacao4D();
	private static Transformacao4D matrizTmpTranslacaoInversa = new Transformacao4D();
	private static Transformacao4D matrizTmpEscala = new Transformacao4D();
	// private static Transformacao4D matrizTmpRotacaoZ = new Transformacao4D();
	private static Transformacao4D matrizGlobal = new Transformacao4D();
	private List<ObjetoGrafico> listaObjGraficos = new LinkedList<>();

	private Color cor = Color.BLACK;

	// private double anguloGlobal = 0.0;

	public ObjetoGrafico() {
	}

	public void atribuirGL(GL gl) {
		this.gl = gl;
	}

	public double obterTamanho() {
		return tamanho;
	}

	public void alterarPrimitava(int cod_primitiva) {
		this.primitiva = cod_primitiva;
	}

	public double obterPrimitava() {
		return primitiva;
	}

	public void desenha() {
		gl.glColor3d(getCor().getRed(), getCor().getGreen(), getCor().getBlue());
		gl.glLineWidth(tamanho);
		gl.glPointSize(tamanho);

		gl.glPushMatrix();
		gl.glMultMatrixd(matrizObjeto.GetDate(), 0);
		gl.glBegin(primitiva);
		// for (byte i = 0; i < vertices.length; i++) {
		// gl.glVertex2d(vertices[i].obterX(), vertices[i].obterY());
		// }
		for (Ponto4D ponto : listaPontos) {
			gl.glVertex2d(ponto.getX(), ponto.getY());
		}
		gl.glEnd();

		if (selecionado) {
			bBox.desenharBBox(gl);
		}

		for (ObjetoGrafico objetoGrafico : listaObjGraficos) {
			objetoGrafico.atribuirGL(gl);
			objetoGrafico.desenha();
		}

		gl.glPopMatrix();
	}

	public void translacaoXY(double tx, double ty) {
		Ponto4D ponto = new Ponto4D(tx, ty);
		translacaoXYZ(ponto.getX(), ponto.getY(), ponto.getZ());
	}

	public void translacaoXYZ(double tx, double ty, double tz) {
		Transformacao4D matrizTranslate = new Transformacao4D();
		matrizTranslate.atribuirTranslacao(tx, ty, tz);
		matrizObjeto = matrizTranslate.transformMatrix(matrizObjeto);
	}

	public void escalaXY(double Sx, double Sy) {
		Transformacao4D matrizScale = new Transformacao4D();
		matrizScale.atribuirEscala(Sx, Sy, 1.0);
		matrizObjeto = matrizScale.transformMatrix(matrizObjeto);
	}

	// /TODO: erro na rotacao
	public void rotacaoZ(double angulo) {
		// anguloGlobal += 10.0; // rotacao em 10 graus
		// Transformacao4D matrizRotacaoZ = new Transformacao4D();
		// matrizRotacaoZ.atribuirRotacaoZ(Transformacao4D.DEG_TO_RAD * angulo);
		// matrizObjeto = matrizRotacaoZ.transformMatrix(matrizObjeto);

		Transformacao4D matrizGlobal = new Transformacao4D();
		Transformacao4D matrizTranslacao = new Transformacao4D();
		Transformacao4D matrizRotacao = new Transformacao4D();
		Transformacao4D matrizTranslacaoInversa = new Transformacao4D();
		Ponto4D ponto = new Ponto4D(-getBBox().getCentroX(), -getBBox().getCentroY());
		matrizTranslacao.atribuirTranslacao(ponto.getX(), ponto.getY(), ponto.getZ());

		matrizRotacao.atribuirRotacaoZ(Transformacao4D.DEG_TO_RAD * angulo);

		Ponto4D pontoTranslacaoInversa = new Ponto4D(getBBox().getCentroX(), getBBox().getCentroY());
		matrizTranslacaoInversa.atribuirTranslacao(pontoTranslacaoInversa.getX(), pontoTranslacaoInversa.getY(), pontoTranslacaoInversa.getZ());

		matrizGlobal = matrizTranslacao.transformMatrix(matrizGlobal);
		matrizGlobal = matrizRotacao.transformMatrix(matrizGlobal);
		matrizGlobal = matrizTranslacaoInversa.transformMatrix(matrizGlobal);

		matrizObjeto = matrizObjeto.transformMatrix(matrizGlobal);

	}

	public void atribuirIdentidade() {
		// anguloGlobal = 0.0;
		matrizObjeto.atribuirIdentidade();
	}

	public void escalaXYZPtoFixo(double escala, Ponto4D ptoFixo) {
		matrizGlobal.atribuirIdentidade();

		matrizTmpTranslacao.atribuirTranslacao(ptoFixo.obterX(), ptoFixo.obterY(), ptoFixo.obterZ());
		matrizGlobal = matrizTmpTranslacao.transformMatrix(matrizGlobal);

		matrizTmpEscala.atribuirEscala(escala, escala, 1.0);
		matrizGlobal = matrizTmpEscala.transformMatrix(matrizGlobal);

		ptoFixo.inverterSinal(ptoFixo);
		matrizTmpTranslacaoInversa.atribuirTranslacao(ptoFixo.obterX(), ptoFixo.obterY(), ptoFixo.obterZ());
		matrizGlobal = matrizTmpTranslacaoInversa.transformMatrix(matrizGlobal);

		matrizObjeto = matrizObjeto.transformMatrix(matrizGlobal);
	}

	public void rotacaoZPtoFixo(double angulo, Ponto4D ptoFixo) {
		matrizGlobal.atribuirIdentidade();

		matrizTmpTranslacao.atribuirTranslacao(ptoFixo.obterX(), ptoFixo.obterY(), ptoFixo.obterZ());
		matrizGlobal = matrizTmpTranslacao.transformMatrix(matrizGlobal);

		matrizTmpEscala.atribuirRotacaoZ(Transformacao4D.DEG_TO_RAD * angulo);
		matrizGlobal = matrizTmpEscala.transformMatrix(matrizGlobal);

		ptoFixo.inverterSinal(ptoFixo);
		matrizTmpTranslacaoInversa.atribuirTranslacao(ptoFixo.obterX(), ptoFixo.obterY(), ptoFixo.obterZ());
		matrizGlobal = matrizTmpTranslacaoInversa.transformMatrix(matrizGlobal);

		matrizObjeto = matrizObjeto.transformMatrix(matrizGlobal);
	}

	public void exibeMatriz() {
		matrizObjeto.exibeMatriz();
	}

	public void exibeVertices() {
		// System.out.println("P0[" + vertices[0].obterX() + "," +
		// vertices[0].obterY() + "," + vertices[0].obterZ() + "," +
		// vertices[0].obterW() + "]");
		// System.out.println("P1[" + vertices[1].obterX() + "," +
		// vertices[1].obterY() + "," + vertices[1].obterZ() + "," +
		// vertices[1].obterW() + "]");
		// System.out.println("P2[" + vertices[2].obterX() + "," +
		// vertices[2].obterY() + "," + vertices[2].obterZ() + "," +
		// vertices[2].obterW() + "]");
		// System.out.println("P3[" + vertices[3].obterX() + "," +
		// vertices[3].obterY() + "," + vertices[3].obterZ() + "," +
		// vertices[3].obterW() + "]");
		// System.out.println("anguloGlobal:" + anguloGlobal);
	}

	public void addPonto(Ponto4D ponto) {
		listaPontos.add(ponto);
	}

	public void adicionaObjGrafico(ObjetoGrafico objetoGrafico) {
		listaObjGraficos.add(objetoGrafico);
	}

	public ObjetoGrafico selecionaObjeto(Ponto4D ponto) {
		selecionado = false;
		if (getBBox().dentroBBox(ponto.getX(), ponto.getY())) {
			if (ScanLine.pontoDoPoligono(getListaPontos(), ponto)) {
				selecionado = true;
				return this;
			}
		}

		for (ObjetoGrafico objetoGrafico : getListaObjGraficos()) {
			ObjetoGrafico obj = objetoGrafico.selecionaObjeto(ponto);
			if (obj != null)
				return obj;
		}
		return null;
	}

	public void removeObjGrafico(ObjetoGrafico objGrafico) {
		if (getListaObjGraficos().contains(objGrafico)) {
			getListaObjGraficos().remove(objGrafico);
			setBBox(new BBox(getListaPontos()));
			for (Ponto4D ponto : getListaPontos()) {
				getBBox().dentroBBox(ponto);
			}
		} else {
			for (ObjetoGrafico objeto : getListaObjGraficos()) {
				objeto.removeObjGrafico(objGrafico);
			}
		}
	}

	public Ponto4D selecionaPonto(Ponto4D ponto) {
		for (Ponto4D point : getListaPontos()) {
			if (ponto.getDistance(point) < 50) {
				return point;
			}
		}
		return null;
	}

	public BBox getBBox() {
		return bBox;
	}

	public void setBBox(BBox bBox) {
		this.bBox = bBox;
	}

	public LinkedList<Ponto4D> getListaPontos() {
		return listaPontos;
	}

	public List<ObjetoGrafico> getListaObjGraficos() {
		return listaObjGraficos;
	}

	public boolean isSelecionado() {
		return selecionado;
	}

	public void setSelecionado(boolean selecionado) {
		this.selecionado = selecionado;
	}

	public Color getCor() {
		return cor;
	}

	public void setCor(Color cor) {
		this.cor = cor;
	}

}
