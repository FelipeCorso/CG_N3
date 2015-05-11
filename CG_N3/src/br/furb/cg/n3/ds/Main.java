package br.furb.cg.n3.ds;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import javax.media.opengl.DebugGL;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.swing.SwingUtilities;

import br.furb.cg.painelAjuda.JPanelAjuda;
import br.furb.cg.utils.BBox;
import br.furb.cg.utils.Camera;
import br.furb.cg.utils.Mundo;
import br.furb.cg.utils.teclado.KeyMouseListener;

public class Main extends KeyMouseListener implements GLEventListener {

	private static final int ZOOM_IN = -3;
	private static final int ZOOM_OUT = +3;
	private int xMinOrtho2D = 0;
	private int xMaxOrtho2D = 400;
	private int yMinOrtho2D = 400;
	private int yMaxOrtho2D = 0;

	private Camera camera = new Camera(xMinOrtho2D, xMaxOrtho2D, yMinOrtho2D, yMaxOrtho2D);

	private GL gl;
	private GLU glu;
	private GLAutoDrawable glDrawable;

	private Ponto4D pontoSelecionado = null;

	private double valorX = 200.0;
	private double valorY = 200.0;
	private Mundo mundo = new Mundo();

	private int antigoX = 0;
	private int antigoY = 0;

	private boolean desenharRastro;
	// private ObjetoGrafico objetoGrafico = new ObjetoGrafico();
	private ObjetoGrafico objetoGrafico;
	private double ultimoX;
	private double ultimoY;
	private int atualX;
	private int atualY;
	private JPanelAjuda panelAjuda;

	public Main(JPanelAjuda frameAjuda) {
		// mundo.adicionarObjGrafico(objetoGrafico);
		panelAjuda = frameAjuda;
	}

	// "render" feito logo apos a inicializacao do contexto OpenGL.
	@Override
	public void init(GLAutoDrawable drawable) {
		glDrawable = drawable;
		gl = drawable.getGL();
		glu = new GLU();
		glDrawable.setGL(new DebugGL(gl));

		gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);

		// for (byte i = 0; i < objetos.length; i++) {
		// objetos[i].atribuirGL(gl);
		// }
		// objeto.atribuirGL(gl);
	}

	// metodo definido na interface GLEventListener.
	// "render" feito pelo cliente OpenGL.
	@Override
	public void display(GLAutoDrawable arg0) {
		gl.glClear(GL.GL_COLOR_BUFFER_BIT);
		gl.glMatrixMode(GL.GL_MODELVIEW);
		gl.glLoadIdentity();

		// configurar window
		// glu.gluOrtho2D(-30.0f, 30.0f, -30.0f, 30.0f);
		glu.gluOrtho2D(camera.getxMinOrtho2D(), camera.getxMaxOrtho2D(), camera.getyMinOrtho2D(), camera.getyMaxOrtho2D());

		gl.glColor3f(0.0f, 0.0f, 0.0f);
		gl.glLineWidth(1.0f);
		gl.glPointSize(3.0f);

		// desenhaSRU();
		// for (byte i = 0; i < objetos.length; i++) {
		// objetos[i].desenha();
		// }

		// if(clicou) {
		// gl.glBegin(GL.GL_POINTS);
		// gl.glVertex2d(objetoGrafico.getPontos()[0].getX(),objetoGrafico.getPontos()[0].getY());
		// gl.glEnd();
		// }

		// objeto.desenha();
		// gl.glBegin(GL.GL_LINES);
		// /**/gl.glVertex2d(objetoGrafico.getPontos()[0].getX(),
		// objetoGrafico.getPontos()[0].getY());
		// /**/gl.glVertex2d(0.0, 0.0);
		// /**/gl.glVertex2d(getValorX(), getValorY());
		// gl.glEnd();
		desenhaPonto();
		desenhaObjetosMundo();
		desenhaBBox();
		desenhaRastro();

		gl.glFlush();
	}

	private void desenhaPonto() {
		if (pontoSelecionado != null) {
			gl.glColor3f(1, 0, 0);
			gl.glPointSize(3);
			gl.glBegin(GL.GL_POINTS);
			/**/gl.glVertex2d(pontoSelecionado.getX(), pontoSelecionado.getY());
			gl.glEnd();
		}
	}

	private void desenhaObjetosMundo() {
		mundo.desenha(gl);
	}

	private void desenhaBBox() {
		if (objetoGrafico != null) {
			objetoGrafico.setBBox(new BBox(objetoGrafico.getListaPontos()));
		}
	}

	private void desenhaRastro() {
		if (desenharRastro) {
			gl.glBegin(GL.GL_LINES);
			gl.glVertex2d(ultimoX, ultimoY);
			gl.glVertex2d(atualX, atualY);
			gl.glEnd();
		}
	}

	private void desenhaSRU() {
		// gl.glColor3f(1.0f, 0.0f, 0.0f);
		// gl.glBegin(GL.GL_LINES);
		// /**/gl.glVertex2f(-20.0f, 0.0f);
		// /**/gl.glVertex2f(20.0f, 0.0f);
		// gl.glEnd();
		//
		// gl.glColor3f(0.0f, 1.0f, 0.0f);
		// gl.glBegin(GL.GL_LINES);
		// /**/gl.glVertex2f(0.0f, -20.0f);
		// /**/gl.glVertex2f(0.0f, 20.0f);
		// gl.glEnd();

		// eixo x
		gl.glColor3f(1.0f, 0.0f, 0.0f);
		gl.glLineWidth(1.0f);
		gl.glBegin(GL.GL_LINES);
		/**/gl.glVertex2f(-200.0f, 0.0f);
		/**/gl.glVertex2f(200.0f, 0.0f);
		gl.glEnd();
		// eixo y
		gl.glColor3f(0.0f, 1.0f, 0.0f);
		gl.glBegin(GL.GL_LINES);
		/**/gl.glVertex2f(0.0f, -200.0f);
		/**/gl.glVertex2f(0.0f, 200.0f);
		gl.glEnd();

	}

	@Override
	public void keyPressed(KeyEvent e) {

		switch (e.getKeyCode()) {

		/*
		 * Q - Rotaciona para a esquerda
		 */
		case KeyEvent.VK_Q:
			if (objetoGrafico != null)
				objetoGrafico.rotacaoZ(-3);
			break;
		/*
		 * E - Rotaciona para a direita
		 */
		case KeyEvent.VK_E:
			if (objetoGrafico != null)
				objetoGrafico.rotacaoZ(3);
			break;
		/*
		 * W - Translacao para cima
		 */
		case KeyEvent.VK_W:
			if (objetoGrafico != null)
				objetoGrafico.translacaoXY(0, -3);
			break;
		/*
		 * S - Translacao para baixo
		 */
		case KeyEvent.VK_S:
			if (objetoGrafico != null)
				objetoGrafico.translacaoXY(0, 3);
			break;
		/*
		 * A - Translacao para esquerda
		 */
		case KeyEvent.VK_A:
			if (objetoGrafico != null)
				objetoGrafico.translacaoXY(-3, 0);
			break;
		/*
		 * D - Translacao para direita
		 */
		case KeyEvent.VK_D:
			if (objetoGrafico != null)
				objetoGrafico.translacaoXY(3, 0);
			break;
		/*
		 * R - Resetar
		 */
		case KeyEvent.VK_R:
			if (objetoGrafico != null)
				objetoGrafico.atribuirIdentidade();
			break;
		/*
		 * Seta Cima - Movimentar câmera
		 */
		case KeyEvent.VK_UP:
			camera.pan(0, 3);
			break;
		/*
		 * Seta Baixo - Movimentar câmera
		 */
		case KeyEvent.VK_DOWN:
			camera.pan(0, -3);
			break;
		/*
		 * Seta Esquerda - Movimentar câmera
		 */
		case KeyEvent.VK_LEFT:
			camera.pan(3, 0);
			break;
		/*
		 * Seta Direita - Movimentar câmera
		 */
		case KeyEvent.VK_RIGHT:
			camera.pan(-3, 0);
			break;
		/*
		 * P - Altera a primitiva
		 */
		case KeyEvent.VK_P:
			if (objetoGrafico != null) {
				if (objetoGrafico.obterPrimitava() == GL.GL_LINE_LOOP) {
					objetoGrafico.alterarPrimitava(GL.GL_LINE_STRIP);
				} else {
					objetoGrafico.alterarPrimitava(GL.GL_LINE_LOOP);
				}
			}
			break;
		/*
		 * + - Aumenta a escala
		 */
		case KeyEvent.VK_ADD:
			if (objetoGrafico != null)
				objetoGrafico.escalaXY(2.0, 2.0);
			break;
		/*
		 * - Diminui a escala
		 */
		case KeyEvent.VK_SUBTRACT:
			if (objetoGrafico != null)
				objetoGrafico.escalaXY(0.5, 0.5);
			break;
		/*
		 * Inserir - Insere um objeto
		 */
		case KeyEvent.VK_INSERT:
			if (objetoGrafico == null) {
				objetoGrafico = new ObjetoGrafico();
				mundo.adicionarObjGrafico(objetoGrafico);
			} else {
				ObjetoGrafico obj = new ObjetoGrafico();
				objetoGrafico.adicionaObjGrafico(obj);
				objetoGrafico = obj;
			}
			break;
		/*
		 * Delete - Remove o objeto
		 */
		case KeyEvent.VK_DELETE:
			if (objetoGrafico != null) {
				mundo.removeObjGrafico(objetoGrafico);
				objetoGrafico = null;
				pontoSelecionado = null;
				desenharRastro = false;
			}
			break;
		/*
		 * V - Define a cor vermelha para o objeto
		 */
		case KeyEvent.VK_V:
			if (objetoGrafico != null) {
				objetoGrafico.setCor(Color.RED);
			}
			break;
		/*
		 * G - Define a cor verde para o objeto
		 */
		case KeyEvent.VK_G:
			if (objetoGrafico != null) {
				objetoGrafico.setCor(Color.GREEN);
			}
			break;
		/*
		 * B - Define a cor azul para o objeto
		 */
		case KeyEvent.VK_B:
			if (objetoGrafico != null) {
				objetoGrafico.setCor(Color.BLUE);
			}
			break;

		}

		glDrawable.display();
	}

	// metodo definido na interface GLEventListener.
	// "render" feito depois que a janela foi redimensionada.
	@Override
	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
		// System.out.println(" --- reshape ---");
	}

	// metodo definido na interface GLEventListener.
	// "render" feito quando o modo ou dispositivo de exibicao associado foi
	// alterado.
	@Override
	public void displayChanged(GLAutoDrawable arg0, boolean arg1, boolean arg2) {
		// System.out.println(" --- displayChanged ---");
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		if (panelAjuda.isAdicionarEnabled()) {
			if (SwingUtilities.isLeftMouseButton(e)) {
				if (objetoGrafico != null) {
					Ponto4D ponto = new Ponto4D(e.getX(), e.getY());
					pontoSelecionado = ponto;
					objetoGrafico.addPonto(ponto);
					ultimoX = ponto.obterX();
					ultimoY = ponto.obterY();
					desenharRastro = true;
				}
			} else {
				if (SwingUtilities.isRightMouseButton(e)) {
					objetoGrafico.setSelecionado(false);
					objetoGrafico = null;
					desenharRastro = false;
					pontoSelecionado = null;
				}
			}

		} else {
			if (panelAjuda.isManipularEnabled()) {
				if (SwingUtilities.isLeftMouseButton(e)) {
					Ponto4D ponto = new Ponto4D(e.getX(), e.getY());

					// Tira a seleção do objeto atual, para não ficarem dois selecionados
					if (objetoGrafico != null) {
						objetoGrafico.setSelecionado(false);
					}

					objetoGrafico = mundo.selecionaObjGrafico(ponto);
					if (objetoGrafico != null) {
						pontoSelecionado = objetoGrafico.selecionaPonto(ponto);
					} else {
						pontoSelecionado = null;
					}
				} else {
					if (SwingUtilities.isRightMouseButton(e)) {
						if (objetoGrafico != null) {
							objetoGrafico.setSelecionado(false);
							objetoGrafico = null;
						}
						pontoSelecionado = null;
					}
				}

			}
		}

		glDrawable.display();

	}

	@Override
	public void mouseMoved(MouseEvent e) {

		atualX = e.getX();
		atualY = e.getY();

		if (glDrawable != null) {
			glDrawable.display();
		}

		// System.out.println("getAntigoX(): " + getAntigoX());
		// System.out.println("getAntigoY(): " + getAntigoY());
		//
		// int movtoX = e.getX() - antigoX;
		// int movtoY = e.getY() - antigoY;
		// valorX += movtoX;
		// valorY -= movtoY;
		//
		// // Dump ...
		// System.out.println("posMouse: " + movtoX + " / " + movtoY);
		//
		// setAntigoX(e.getX());
		// setAntigoY(e.getY());
		//
		// System.out.println("e.getX(): " + e.getX());
		// System.out.println("e.getY(): " + e.getY());
		//
		// System.out.println("getValorX(): " + getValorX());
		// System.out.println("getValorY(): " + getValorY());
		//
		// System.out.println();
		// glDrawable.display();
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		if (e.getWheelRotation() < 0) {
			camera.zoom(ZOOM_IN);
		} else {
			if (e.getWheelRotation() > 0) {
				camera.zoom(ZOOM_OUT);
			}
		}
		glDrawable.display();
	}

	public double getValorX() {
		return valorX;
	}

	public void setValorX(double valorX) {
		this.valorX = valorX;
	}

	public double getValorY() {
		return valorY;
	}

	public void setValorY(double valorY) {
		this.valorY = valorY;
	}

	public int getAntigoX() {
		return antigoX;
	}

	public void setAntigoX(int antigoX) {
		this.antigoX = antigoX;
	}

	public int getAntigoY() {
		return antigoY;
	}

	public void setAntigoY(int antigoY) {
		this.antigoY = antigoY;
	}

}
