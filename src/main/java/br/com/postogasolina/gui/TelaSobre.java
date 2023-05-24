package br.com.postogasolina.gui;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

public class TelaSobre extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public TelaSobre() {
		
		JLabel lblTitulo = new JLabel("INFORMAÇÃO");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel = new JLabel("Teste de seleção Desenvolvedor JAVA");
		
		JLabel lblNewLabel_1 = new JLabel("LOGUS TECNOLOGIA");
		
		JLabel lblNewLabel_2 = new JLabel("GERALDO JORGE AQUINO");
		
		JLabel lblNewLabel_3 = new JLabel("FullStack Developer");
		
		JLabel lblNewLabel_4 = new JLabel("Candidato 5");
		
		JLabel lblNewLabel_5 = new JLabel("(88) 9 9999-6947");
		
		JLabel lblNewLabel_6 = new JLabel("geraldo.gja@gmail.com");
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(42)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_4)
								.addComponent(lblNewLabel_5)
								.addComponent(lblNewLabel_6)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(181)
							.addComponent(lblTitulo)))
					.addContainerGap(186, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(lblTitulo)
					.addGap(34)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel)
					.addGap(33)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_5)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_6)
					.addContainerGap(61, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
	}
}
