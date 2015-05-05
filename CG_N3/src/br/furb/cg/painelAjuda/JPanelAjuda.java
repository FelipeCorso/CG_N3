package br.furb.cg.painelAjuda;

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
		panel_adicionar.setBounds(3, 11, 270, 164);
		add(panel_adicionar);
		panel_adicionar.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_adicionar.setLayout(null);

		JToggleButton tglbtnAdicionar = new JToggleButton("Adicionar");
		tglbtnAdicionar.setBounds(1, 1, 269, 23);
		panel_adicionar.add(tglbtnAdicionar);

		JPanel panel = new JPanel();
		panel.setBounds(5, 24, 229, 137);
		panel_adicionar.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel label_1 = new JLabel("Desenhar");
		panel.add(label_1);
		
				JLabel label = new JLabel("");
				label.setIcon(new ImageIcon(getClass().getResource("\\images\\Mouse Esquerda_45.png")));
				panel.add(label);
		
				JLabel lblDesenharPoligono = new JLabel("Selecionar");
				panel.add(lblDesenharPoligono);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(JPanelAjuda.class.getResource("/br/furb/cg/painelAjuda/images/Mouse Direita_45.png")));
		panel.add(label_6);
		
		JLabel lblRemoverSeleo = new JLabel("Remover Sele\u00E7\u00E3o");
		panel.add(lblRemoverSeleo);
		
		JLabel lblEspao = new JLabel("Espa\u00E7o");
		panel.add(lblEspao);

		JPanel panel_manipular = new JPanel();
		panel_manipular.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_manipular.setBounds(3, 186, 270, 345);
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

		JLabel lblRightUp = new JLabel("E");
		panel_2.add(lblRightUp);

		JLabel lblRotacionarEsquerda = new JLabel("Rotacionar Anti-hor\u00E1rio");
		panel_2.add(lblRotacionarEsquerda);

		JLabel lblLeftUp = new JLabel("Q");
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

		JLabel lblZoomIn = new JLabel("Zoom In");
		panel_2.add(lblZoomIn);

		JLabel lblMouseScrollUp = new JLabel("Mouse Scroll Up");
		panel_2.add(lblMouseScrollUp);

		JLabel lblZoomOut = new JLabel("Zoom Out");
		panel_2.add(lblZoomOut);

		JLabel lblMouseScrollDown = new JLabel("Mouse Scroll Down");
		panel_2.add(lblMouseScrollDown);

		JLabel lblTranslaoParaCima = new JLabel("Transla\u00E7\u00E3o Cima");
		panel_2.add(lblTranslaoParaCima);

		JLabel lblW = new JLabel("W");
		panel_2.add(lblW);

		JLabel lblTranslaoParaBaixo = new JLabel("Transla\u00E7\u00E3o Baixo");
		panel_2.add(lblTranslaoParaBaixo);

		JLabel lblS = new JLabel("S");
		panel_2.add(lblS);

		JLabel lblTranslaoParaEsquerda = new JLabel("Transla\u00E7\u00E3o Esquerda");
		panel_2.add(lblTranslaoParaEsquerda);

		JLabel lblA_1 = new JLabel("A");
		panel_2.add(lblA_1);

		JLabel lblTranslaoParaDireita = new JLabel("Transla\u00E7\u00E3o Direita");
		panel_2.add(lblTranslaoParaDireita);

		JLabel lblD = new JLabel("D");
		panel_2.add(lblD);

		JLabel lblResetar = new JLabel("Resetar");
		panel_2.add(lblResetar);

		JLabel lblR = new JLabel("R");
		panel_2.add(lblR);

		JLabel lblAlterarPrimitiva = new JLabel("Alterar Primitiva");
		panel_2.add(lblAlterarPrimitiva);

		JLabel lblP = new JLabel("P");
		panel_2.add(lblP);

		JLabel lblAumentarEscala = new JLabel("Aumentar Escala");
		panel_2.add(lblAumentarEscala);

		JLabel label_2 = new JLabel("+");
		panel_2.add(label_2);

		JLabel lblDiminuirEscala = new JLabel("Diminuir Escala");
		panel_2.add(lblDiminuirEscala);

		JLabel label_4 = new JLabel("-");
		panel_2.add(label_4);

		JLabel lblRemoverObjeto = new JLabel("Remover Objeto");
		panel_2.add(lblRemoverObjeto);

		JLabel lblDelete = new JLabel("Delete");
		panel_2.add(lblDelete);
	}

}
