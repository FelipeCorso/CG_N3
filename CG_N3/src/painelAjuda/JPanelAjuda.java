package painelAjuda;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class JPanelAjuda extends JPanel {

	/**
	 * Create the panel.
	 */
	public JPanelAjuda() {
		setLayout(null);

		JPanel panel_adicionar = new JPanel();
		panel_adicionar.setBounds(0, 11, 251, 98);
		add(panel_adicionar);
		panel_adicionar.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_adicionar.setLayout(null);

		JToggleButton tglbtnAdicionar = new JToggleButton("Adicionar");
		tglbtnAdicionar.setBounds(1, 1, 249, 23);
		panel_adicionar.add(tglbtnAdicionar);

		JPanel panel = new JPanel();
		panel.setBounds(1, 24, 249, 68);
		panel_adicionar.add(panel);
		panel.setLayout(null);

		JLabel lblDesenharPoligono = new JLabel("Desenhar");
		lblDesenharPoligono.setBounds(10, 8, 53, 28);
		panel.add(lblDesenharPoligono);

		JLabel lblExcluir = new JLabel("Excluir");
		lblExcluir.setBounds(3, 54, 53, 14);
		panel.add(lblExcluir);

		JLabel lblImg = new JLabel("Tecla Del");
		lblImg.setBounds(54, 54, 53, 14);
		panel.add(lblImg);

		JLabel label = new JLabel("");
		label.setBounds(73, 8, 34, 45);
		label.setIcon(new ImageIcon(getClass().getResource(
				"..\\images\\Mouse Esquerda_45.png")));
		panel.add(label);

		JPanel panel_manipular = new JPanel();
		panel_manipular.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_manipular.setBounds(0, 120, 251, 153);
		add(panel_manipular);
		panel_manipular.setLayout(new BorderLayout(0, 0));

		JToggleButton tglbtnNewToggleButton = new JToggleButton("Manipular");
		panel_manipular.add(tglbtnNewToggleButton, BorderLayout.NORTH);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new CompoundBorder(new EmptyBorder(0, 5, 0, 0), null));
		panel_manipular.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblUp = new JLabel("Mover para cima");
		panel_2.add(lblUp);

		JLabel lblUp_1 = new JLabel("UP");
		panel_2.add(lblUp_1);

		JLabel lblMoverParaBaixo = new JLabel("Mover para baixo");
		panel_2.add(lblMoverParaBaixo);

		JLabel lblDown = new JLabel("Down");
		panel_2.add(lblDown);

		JLabel lblMoverParaEsquerda = new JLabel("Mover para esquerda");
		panel_2.add(lblMoverParaEsquerda);

		JLabel lblLeft = new JLabel("Left");
		panel_2.add(lblLeft);

		JLabel lblMoverParaDireita = new JLabel("Mover para direita");
		panel_2.add(lblMoverParaDireita);

		JLabel lblRight = new JLabel("Right");
		panel_2.add(lblRight);

		JLabel lblRotacionarDireita = new JLabel("Rotacionar Hor\u00E1rio");
		panel_2.add(lblRotacionarDireita);

		JLabel lblRightUp = new JLabel("R");
		panel_2.add(lblRightUp);

		JLabel lblRotacionarEsquerda = new JLabel(
				"Rotacionar Anti-hor\u00E1rio");
		panel_2.add(lblRotacionarEsquerda);

		JLabel lblLeftUp = new JLabel("L");
		panel_2.add(lblLeftUp);

		JLabel lblDefinirCorVermelha = new JLabel("Definir Cor Vermelha");
		panel_2.add(lblDefinirCorVermelha);

		JLabel lblV = new JLabel("R");
		panel_2.add(lblV);

		JLabel lblDefinirCorAzul = new JLabel("Definir Cor Azul");
		panel_2.add(lblDefinirCorAzul);

		JLabel lblA = new JLabel("G");
		panel_2.add(lblA);

		JLabel lblDefinirCorVerde = new JLabel("Definir Cor Verde");
		panel_2.add(lblDefinirCorVerde);

		JLabel lblB = new JLabel("B");
		panel_2.add(lblB);
	}

}
