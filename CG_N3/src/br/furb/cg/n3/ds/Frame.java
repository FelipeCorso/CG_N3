package br.furb.cg.n3.ds;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import br.furb.cg.painelAjuda.JFrameAjuda;

public class Frame extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
	private Main renderer = new Main();
	private int janelaLargura = 400, janelaAltura = 400;

	public Frame() {
		// Cria o frame.
		super("CG-N3_Trasnformacao");
		setTitle("CG-N3 - F1 Help");
		setBounds(300, 250, janelaLargura, janelaAltura + 22);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());

		/*
		 * Cria um objeto GLCapabilities para especificar o numero de bits por pixel para RGBA
		 */
		GLCapabilities glCaps = new GLCapabilities();
		glCaps.setRedBits(8);
		glCaps.setBlueBits(8);
		glCaps.setGreenBits(8);
		glCaps.setAlphaBits(8);

		/*
		 * Cria um canvas, adiciona ao frame e objeto "ouvinte" para os eventos Gl, de mouse e teclado
		 */
		GLCanvas canvas = new GLCanvas(glCaps);
		getContentPane().add(canvas, BorderLayout.CENTER);
		canvas.addGLEventListener(renderer);
		canvas.addKeyListener(renderer);
		canvas.addMouseListener(renderer);
		canvas.addMouseMotionListener(renderer);
		canvas.addMouseWheelListener(renderer);
		canvas.requestFocus();

		// Para o F1
		addKeyListener(this);
	}

	public static void main(String[] args) {
		new Frame().setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		/*
		 * F1 - Abre o help
		 */
		case KeyEvent.VK_F1:
			new JFrameAjuda().setVisible(true);
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
