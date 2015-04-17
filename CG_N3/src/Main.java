/// \file Exemplo_N2_Jogl_Eclipse.java
/// \brief Exemplo_N2_Jogl_Eclipse: desenha uma linha na diagonal.
/// \version $Revision: 1.0 $
/// \author Dalton Reis.
/// \date 03/05/13.
/// Obs.: variaveis globais foram usadas por questoes didaticas mas nao sao recomendas para aplicacoes reais.

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.media.opengl.DebugGL;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

public class Main implements GLEventListener, KeyListener, MouseMotionListener, MouseListener {
    private float ortho2D_minX = -400.0f, ortho2D_maxX = 400.0f, ortho2D_minY = -400.0f, ortho2D_maxY = 400.0f;
    private GL gl;
    private GLU glu;
    private GLAutoDrawable glDrawable;

    @Override
    public void init(GLAutoDrawable drawable) {
	System.out.println(" --- init ---");
	glDrawable = drawable;
	gl = drawable.getGL();
	glu = new GLU();
	glDrawable.setGL(new DebugGL(gl));
	System.out.println("Espa�o de desenho com tamanho: " + drawable.getWidth() + " x " + drawable.getHeight());
	gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
    }

    public void SRU() {
	// gl.glDisable(gl.GL_TEXTURE_2D);
	// gl.glDisableClientState(gl.GL_TEXTURE_COORD_ARRAY);
	// gl.glDisable(gl.GL_LIGHTING); //TODO: [D] FixMe: check if lighting
	// and texture is enabled

	// eixo x
	gl.glColor3f(1.0f, 0.0f, 0.0f);
	gl.glLineWidth(1.0f);
	gl.glBegin(GL.GL_LINES);
	gl.glVertex2f(-200.0f, 0.0f);
	gl.glVertex2f(200.0f, 0.0f);
	gl.glEnd();
	// eixo y
	gl.glColor3f(0.0f, 1.0f, 0.0f);
	gl.glBegin(GL.GL_LINES);
	gl.glVertex2f(0.0f, -200.0f);
	gl.glVertex2f(0.0f, 200.0f);
	gl.glEnd();
    }

    private double x = 100;
    private double y = 100;

    // exibicaoPrincipal
    @Override
    public void display(GLAutoDrawable arg0) {
	gl.glClear(GL.GL_COLOR_BUFFER_BIT);
	gl.glMatrixMode(GL.GL_PROJECTION);
	gl.glLoadIdentity();
	glu.gluOrtho2D(ortho2D_minX, ortho2D_maxX, ortho2D_minY, ortho2D_maxY);
	gl.glMatrixMode(GL.GL_MODELVIEW);
	gl.glLoadIdentity();

	SRU();

	// seu desenho ...
	gl.glColor3f(0.0f, 0.0f, 0.0f);
	circulo(30, x, y);
	ponto(x, y);

	circulo(100, 100, 100);

	gl.glBegin(GL.GL_LINE_LOOP);
	gl.glVertex2d(RetornaX(45, 100) + 100, RetornaY(45, 100) + 100);
	gl.glVertex2d(RetornaX(135, 100) + 100, RetornaY(135, 100) + 100);
	gl.glVertex2d(RetornaX(225, 100) + 100, RetornaY(225, 100) + 100);
	gl.glVertex2d(RetornaX(315, 100) + 100, RetornaY(315, 100) + 100);
	gl.glEnd();

	gl.glFlush();

    }

    public void ponto(double x, double y) {
	gl.glPointSize(4.0f);
	gl.glBegin(GL.GL_POINTS);
	gl.glVertex2d(x, y);
	gl.glEnd();
    }

    public void circulo(double raio, double x, double y) {
	gl.glPointSize(4.0f);
	gl.glBegin(GL.GL_LINE_LOOP);
	for (int i = 0; i < 72; i++) {
	    gl.glVertex2d(RetornaX(i * 5, raio) + x, RetornaY(i * 5, raio) + y);
	}
	gl.glEnd();
    }

    private double RetornaX(double angulo, double raio) {
	return (raio * Math.cos(Math.PI * angulo / 180.0));
    }

    private double RetornaY(double angulo, double raio) {
	return (raio * Math.sin(Math.PI * angulo / 180.0));
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    private boolean collision(double x, double y) {
	if (!collisionBBox(x, y)) {
	    return !collisionCircle(x, y);
	}
	return false;
    }

    private double bBoxMaxX, bBoxMinX, bBoxMaxY, bBoxMinY;

    private boolean collisionBBox(double x, double y) {
	boolean result = true;
	if (x >= bBoxMaxX || x <= bBoxMinX) {
	    result = false;
	}
	if (y >= bBoxMaxY || y <= bBoxMinY) {
	    result = false;
	}
	return result;
    }

    private boolean collisionCircle(double x, double y) {
	return ((x - 100) * (x - 100)) + ((y - 100) * (y - 100)) <= (100 * 100);
    }

    @Override
    public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
	System.out.println(" --- reshape ---");
    }

    @Override
    public void displayChanged(GLAutoDrawable arg0, boolean arg1, boolean arg2) {
	System.out.println(" --- displayChanged ---");
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
	System.out.println(" --- keyReleased ---");
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
	System.out.println(" --- keyTyped ---");
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
    }

    @Override
    public void mouseDragged(MouseEvent arg0) {
	if (!collision(arg0.getX() - 150, arg0.getY() - 100)) {

	    x = arg0.getX() - 150;
	    y = (arg0.getY() - 100);
	}

	glDrawable.display();
    }

    @Override
    public void mouseMoved(MouseEvent arg0) {
    }

}
