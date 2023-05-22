package br.com.postogasolina.gui;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;

public class TelaVeiculo extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public TelaVeiculo() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
		JLabel lblTitulo = new JLabel("VEÍCULOS");
		add(lblTitulo);

	}

}
