package br.furb.cg.n3.ds;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import javax.media.opengl.DebugGL;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.swing.SwingUtilities;

import br.furb.cg.utils.Camera;
import br.furb.cg.utils.Mundo;
import br.furb.cg.utils.teclado.KeyMouseListener;

public class Main extends KeyMouseListener implements GLEventListener {

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

	private ObjetoGrafico[] objetos = null;

	public Main() {
		mundo.adicionarObjGrafico(objetoGrafico);
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
		// /**/gl.glVertex2d(objetoGrafico.getPontos()[0].getX(), objetoGrafico.getPontos()[0].getY());
		// /**/gl.glVertex2d(0.0, 0.0);
		// /**/gl.glVertex2d(getValorX(), getValorY());
		// gl.glEnd();
		desenhaPonto();
		desenhaObjetosMundo();

		gl.glFlush();
	}

	public void desenhaPonto() {
		if (pontoSelecionado != null) {
			gl.glColor3f(1, 0, 0);
			gl.glPointSize(3);
			gl.glBegin(GL.GL_POINTS);
			/**/gl.glVertex2d(pontoSelecionado.getX(), pontoSelecionado.getY());
			gl.glEnd();
		}
	}

	public void desenhaObjetosMundo() {
		mundo.desenha(gl);
	}

	public void desenhaSRU() {
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
		case KeyEvent.VK_P:
			objetos[0].exibeVertices();
			break;
		case KeyEvent.VK_M:
			objetos[0].exibeMatriz();
			break;

		case KeyEvent.VK_R:
			objetos[0].atribuirIdentidade();
			break;

		case KeyEvent.VK_RIGHT:
			objetos[0].translacaoXYZ(2.0, 0.0, 0.0);
			break;
		case KeyEvent.VK_LEFT:
			objetos[0].translacaoXYZ(-2.0, 0.0, 0.0);
			break;
		case KeyEvent.VK_UP:
			objetos[0].translacaoXYZ(0.0, 2.0, 0.0);
			break;
		case KeyEvent.VK_DOWN:
			objetos[0].translacaoXYZ(0.0, -2.0, 0.0);
			break;

		case KeyEvent.VK_PAGE_UP:
			objetos[0].escalaXYZ(2.0, 2.0);
			break;
		case KeyEvent.VK_PAGE_DOWN:
			objetos[0].escalaXYZ(0.5, 0.5);
			break;

		case KeyEvent.VK_HOME:
			// objetos[0].RoracaoZ();
			break;

		case KeyEvent.VK_1:
			objetos[0].escalaXYZPtoFixo(0.5, new Ponto4D(-15.0, -15.0, 0.0, 0.0));
			break;

		case KeyEvent.VK_2:
			objetos[0].escalaXYZPtoFixo(2.0, new Ponto4D(-15.0, -15.0, 0.0, 0.0));
			break;

		case KeyEvent.VK_3:
			objetos[0].rotacaoZPtoFixo(10.0, new Ponto4D(-15.0, -15.0, 0.0, 0.0));
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

	private ObjetoGrafico objetoGrafico = new ObjetoGrafico();

	@Override
	public void mouseClicked(MouseEvent e) {

		if (SwingUtilities.isLeftMouseButton(e)) {
			if (objetoGrafico != null) {
				Ponto4D ponto = new Ponto4D(e.getX(), e.getY());
				pontoSelecionado = ponto;
				objetoGrafico.addPonto(ponto);
			}
		} else {
			if (SwingUtilities.isRightMouseButton(e)) {

			}
		}
		glDrawable.display();
	}

	@Override
	public void mouseMoved(MouseEvent e) {

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
	public void mouseWheelMoved(MouseWheelEvent arg0) {
		// TODO Auto-generated method stub
		super.mouseWheelMoved(arg0);
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
