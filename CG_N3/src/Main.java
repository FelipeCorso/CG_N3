import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.media.opengl.DebugGL;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.swing.SwingUtilities;

import br.furb.cg.utils.Ponto;
import br.furb.cg.utils.teclado.KeyMouseListener;

public class Main extends KeyMouseListener implements GLEventListener {
	private GL gl;
	private GLU glu;
	private GLAutoDrawable glDrawable;
	private double mouseX;
	private double mouseY;

	public Main() {
		objetoGrafico.addPonto(new Ponto(5, 5, 0));
	}

	private ObjetoGrafico[] objetos = null;

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
		glu.gluOrtho2D(-30.0f, 30.0f, -30.0f, 30.0f);
		// glu.gluOrtho2D(-400.0, 400.0, -400.0, 400.0);

		gl.glLineWidth(1.0f);
		gl.glPointSize(1.0f);

		desenhaSRU();
		// for (byte i = 0; i < objetos.length; i++) {
		// objetos[i].desenha();
		// }

		// objeto.desenha();
		gl.glBegin(GL.GL_LINES);
		/**/gl.glVertex2d(objetoGrafico.getPontos()[0].getX(), objetoGrafico.getPontos()[0].getY());
		/**/gl.glVertex2d(getMouseX(), getMouseY());
		gl.glEnd();

		gl.glFlush();
	}

	public void desenhaSRU() {
		gl.glColor3f(1.0f, 0.0f, 0.0f);
		gl.glBegin(GL.GL_LINES);
		/**/gl.glVertex2f(-20.0f, 0.0f);
		/**/gl.glVertex2f(20.0f, 0.0f);
		gl.glEnd();

		gl.glColor3f(0.0f, 1.0f, 0.0f);
		gl.glBegin(GL.GL_LINES);
		/**/gl.glVertex2f(0.0f, -20.0f);
		/**/gl.glVertex2f(0.0f, 20.0f);
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

	private br.furb.cg.utils.ObjetoGrafico objetoGrafico = new br.furb.cg.utils.ObjetoGrafico();

	@Override
	public void mouseClicked(MouseEvent e) {

		if (SwingUtilities.isLeftMouseButton(e)) {
			Ponto ponto = new Ponto();
			ponto.setX(e.getX());
			ponto.setY(e.getY());

			objetoGrafico.addPonto(ponto);
			glDrawable.display();
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		setMouseX(e.getX() - 15);
		setMouseY(e.getY() - 15);

		System.out.println("x: " + getMouseX());
		System.out.println("y: " + getMouseY());
		System.out.println();
		System.out.println();

		glDrawable.display();
	}

	public double getMouseX() {
		return mouseX;
	}

	public void setMouseX(double mouseX) {
		this.mouseX = mouseX;
	}

	public double getMouseY() {
		return mouseY;
	}

	public void setMouseY(double mouseY) {
		this.mouseY = mouseY;
	}

}
