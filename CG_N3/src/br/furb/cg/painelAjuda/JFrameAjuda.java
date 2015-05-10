package br.furb.cg.painelAjuda;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JFrameAjuda extends JFrame {

	private static final long serialVersionUID = 2028546175861047326L;
	private JPanel contentPane;
	private JPanelAjuda panelAjuda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					JFrameAjuda frame = new JFrameAjuda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameAjuda() {
		setTitle("Painel Ajuda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 571);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panelAjuda = new JPanelAjuda();
		contentPane.add(panelAjuda, BorderLayout.CENTER);

	}

	public JPanelAjuda getPanelAjuda() {
		return panelAjuda;
	}

}
