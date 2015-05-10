package br.furb.cg.n3.ds;

import java.awt.BorderLayout;

import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import br.furb.cg.painelAjuda.JFrameAjuda;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	private Main renderer;
	private int janelaLargura = 400, janelaAltura = 400;
	private JFrameAjuda frameAjuda;

	public Frame() {
		// Cria o frame.
		super("CG_N3 - F1 Help");
		setBounds(300, 250, janelaLargura, janelaAltura + 22);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());

		frameAjuda = new JFrameAjuda();
		frameAjuda.setVisible(true);
		renderer = new Main(frameAjuda.getPanelAjuda());

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

	}

	public static void main(String[] args) {
		new Frame().setVisible(true);
	}

	@Override
	public void dispose() {
		frameAjuda.dispose();
		super.dispose();
	}

}
