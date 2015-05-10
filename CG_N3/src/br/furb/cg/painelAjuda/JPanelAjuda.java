package br.furb.cg.painelAjuda;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class JPanelAjuda extends JPanel {

	private static final long serialVersionUID = 4275319781157386639L;
	private JToggleButton tglbtnAdicionar;
	private JToggleButton tglbtnManipular;

	/**
	 * Create the panel.
	 */
	public JPanelAjuda() {
		setLayout(null);

		JPanel panel_adicionar = new JPanel();
		panel_adicionar.setBounds(6, 11, 287, 86);
		add(panel_adicionar);
		panel_adicionar.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_adicionar.setLayout(new BorderLayout(0, 0));

		tglbtnAdicionar = new JToggleButton("Adicionar");
		panel_adicionar.add(tglbtnAdicionar, BorderLayout.NORTH);
		tglbtnAdicionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setManipularEnabled(false);
			}
		});

		JPanel funcoesAdicionar = new JPanel();
		funcoesAdicionar.setBorder(new CompoundBorder(new EmptyBorder(0, 5, 0, 0), null));

		funcoesAdicionar.setLayout(new GridLayout(3, 2, -100, 0));

		JLabel lblRemoverSeleo = new JLabel("Novo");
		funcoesAdicionar.add(lblRemoverSeleo);

		JLabel lblEspao = new JLabel("Insert");
		funcoesAdicionar.add(lblEspao);

		JLabel label_1 = new JLabel("Desenhar");
		funcoesAdicionar.add(label_1);

		JLabel lblMouseBotoEsquerdo = new JLabel("Mouse Bot\u00E3o Esquerdo");
		funcoesAdicionar.add(lblMouseBotoEsquerdo);

		JLabel lblDesenharPoligono = new JLabel("Concluir");
		funcoesAdicionar.add(lblDesenharPoligono);

		JLabel lblMouseBotoDireito = new JLabel("Mouse Bot\u00E3o Direito");
		funcoesAdicionar.add(lblMouseBotoDireito);
		panel_adicionar.add(funcoesAdicionar, BorderLayout.CENTER);

		JPanel panel_manipular = new JPanel();
		panel_manipular.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_manipular.setBounds(3, 108, 290, 423);
		add(panel_manipular);
		panel_manipular.setLayout(new BorderLayout(0, 0));

		tglbtnManipular = new JToggleButton("Manipular");
		tglbtnManipular.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setAdicionarEnabled(false);
			}
		});
		panel_manipular.add(tglbtnManipular, BorderLayout.NORTH);

		JPanel funcoesManipular = new JPanel();
		funcoesManipular.setBorder(new CompoundBorder(new EmptyBorder(0, 5, 0, 0), null));
		panel_manipular.add(funcoesManipular, BorderLayout.CENTER);
		funcoesManipular.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblSelecionar = new JLabel("Selecionar");
		funcoesManipular.add(lblSelecionar);

		JLabel lblMouseBotoEsquerdo_1 = new JLabel("Mouse Bot\u00E3o Esquerdo");
		funcoesManipular.add(lblMouseBotoEsquerdo_1);

		JLabel lblRemoverSeleo_1 = new JLabel("Remover Sele\u00E7\u00E3o");
		funcoesManipular.add(lblRemoverSeleo_1);

		JLabel label_3 = new JLabel("Mouse Bot\u00E3o Direito");
		funcoesManipular.add(label_3);

		JLabel lblUp = new JLabel("Mover para cima");
		funcoesManipular.add(lblUp);

		JLabel lblUp_1 = new JLabel("UP");
		funcoesManipular.add(lblUp_1);

		JLabel lblMoverParaBaixo = new JLabel("Mover para baixo");
		funcoesManipular.add(lblMoverParaBaixo);

		JLabel lblDown = new JLabel("Down");
		funcoesManipular.add(lblDown);

		JLabel lblMoverParaEsquerda = new JLabel("Mover para esquerda");
		funcoesManipular.add(lblMoverParaEsquerda);

		JLabel lblLeft = new JLabel("Left");
		funcoesManipular.add(lblLeft);

		JLabel lblMoverParaDireita = new JLabel("Mover para direita");
		funcoesManipular.add(lblMoverParaDireita);

		JLabel lblRight = new JLabel("Right");
		funcoesManipular.add(lblRight);

		JLabel lblRotacionarDireita = new JLabel("Rotacionar Hor\u00E1rio");
		funcoesManipular.add(lblRotacionarDireita);

		JLabel lblRightUp = new JLabel("E");
		funcoesManipular.add(lblRightUp);

		JLabel lblRotacionarEsquerda = new JLabel("Rotacionar Anti-hor\u00E1rio");
		funcoesManipular.add(lblRotacionarEsquerda);

		JLabel lblLeftUp = new JLabel("Q");
		funcoesManipular.add(lblLeftUp);

		JLabel lblDefinirCorVermelha = new JLabel("Definir Cor Vermelha");
		funcoesManipular.add(lblDefinirCorVermelha);

		JLabel lblV = new JLabel("R");
		funcoesManipular.add(lblV);

		JLabel lblDefinirCorAzul = new JLabel("Definir Cor Azul");
		funcoesManipular.add(lblDefinirCorAzul);

		JLabel lblA = new JLabel("G");
		funcoesManipular.add(lblA);

		JLabel lblDefinirCorVerde = new JLabel("Definir Cor Verde");
		funcoesManipular.add(lblDefinirCorVerde);

		JLabel lblB = new JLabel("B");
		funcoesManipular.add(lblB);

		JLabel lblZoomIn = new JLabel("Zoom In");
		funcoesManipular.add(lblZoomIn);

		JLabel lblMouseScrollUp = new JLabel("Mouse Scroll Up");
		funcoesManipular.add(lblMouseScrollUp);

		JLabel lblZoomOut = new JLabel("Zoom Out");
		funcoesManipular.add(lblZoomOut);

		JLabel lblMouseScrollDown = new JLabel("Mouse Scroll Down");
		funcoesManipular.add(lblMouseScrollDown);

		JLabel lblTranslaoParaCima = new JLabel("Transla\u00E7\u00E3o Cima");
		funcoesManipular.add(lblTranslaoParaCima);

		JLabel lblW = new JLabel("W");
		funcoesManipular.add(lblW);

		JLabel lblTranslaoParaBaixo = new JLabel("Transla\u00E7\u00E3o Baixo");
		funcoesManipular.add(lblTranslaoParaBaixo);

		JLabel lblS = new JLabel("S");
		funcoesManipular.add(lblS);

		JLabel lblTranslaoParaEsquerda = new JLabel("Transla\u00E7\u00E3o Esquerda");
		funcoesManipular.add(lblTranslaoParaEsquerda);

		JLabel lblA_1 = new JLabel("A");
		funcoesManipular.add(lblA_1);

		JLabel lblTranslaoParaDireita = new JLabel("Transla\u00E7\u00E3o Direita");
		funcoesManipular.add(lblTranslaoParaDireita);

		JLabel lblD = new JLabel("D");
		funcoesManipular.add(lblD);

		JLabel lblResetar = new JLabel("Resetar");
		funcoesManipular.add(lblResetar);

		JLabel lblR = new JLabel("R");
		funcoesManipular.add(lblR);

		JLabel lblAlterarPrimitiva = new JLabel("Alterar Primitiva");
		funcoesManipular.add(lblAlterarPrimitiva);

		JLabel lblP = new JLabel("P");
		funcoesManipular.add(lblP);

		JLabel lblAumentarEscala = new JLabel("Aumentar Escala");
		funcoesManipular.add(lblAumentarEscala);

		JLabel label_2 = new JLabel("+");
		funcoesManipular.add(label_2);

		JLabel lblDiminuirEscala = new JLabel("Diminuir Escala");
		funcoesManipular.add(lblDiminuirEscala);

		JLabel label_4 = new JLabel("-");
		funcoesManipular.add(label_4);

		JLabel lblRemoverObjeto = new JLabel("Remover Objeto");
		funcoesManipular.add(lblRemoverObjeto);

		JLabel lblDelete = new JLabel("Delete");
		funcoesManipular.add(lblDelete);
	}

	public boolean isAdicionarEnabled() {
		return tglbtnAdicionar.isSelected();
	}

	public void setAdicionarEnabled(boolean enable) {
		tglbtnAdicionar.setSelected(enable);
	}

	public boolean isManipularEnabled() {
		return tglbtnManipular.isSelected();
	}

	public void setManipularEnabled(boolean enable) {
		tglbtnManipular.setSelected(enable);
	}
}
