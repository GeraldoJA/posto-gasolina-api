package br.com.postogasolina.gui;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import br.com.postogasolina.domain.Combustivel;
import br.com.postogasolina.domain.TipoCombustivel;
import br.com.postogasolina.service.CombustivelService;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class TelaCombustivel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JComboBox<TipoCombustivel> comboBox;
	private CombustivelService combustivelService;
	
	/**
	 * Create the panel.
	 */
	public TelaCombustivel( CombustivelService combustivelService ) {
		
		this.combustivelService = combustivelService;
		
		JLabel lblTitulo = new JLabel("COMBUSTÍVEL");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarCombustivel();
			}
		});
		
		JLabel lblNewLabel = new JLabel("Selecione o Combustível:");
		
		comboBox = new JComboBox<TipoCombustivel>();
		inicarComboBox();
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTitulo)
						.addComponent(btnNewButton)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(113, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitulo)
					.addGap(50)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addComponent(btnNewButton)
					.addContainerGap(145, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
	
	private void cadastrarCombustivel() {
		
		List<Combustivel> list = combustivelService.findAll();
		TipoCombustivel tipo = (TipoCombustivel) comboBox.getSelectedItem();
		Combustivel combustivel = new Combustivel(null, tipo);
		
		if( list.contains(combustivel) ) {
			JOptionPane.showMessageDialog(null, "Combustível já cadastrado", "ERRO", JOptionPane.WARNING_MESSAGE);
		}else {
			combustivelService.create(combustivel);
			String mensagem = combustivel.getTipoCombustivel() + " cadastrado com sucesso";
			JOptionPane.showMessageDialog(null, mensagem, "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	private void inicarComboBox() {
			
		comboBox.addItem( TipoCombustivel.ALCOOL );
		comboBox.addItem( TipoCombustivel.DIESEL );
		comboBox.addItem( TipoCombustivel.GASOLINA_ADITIVADA );
		comboBox.addItem( TipoCombustivel.GASOLINA_COMUM );
		comboBox.addItem( TipoCombustivel.GASOLINA_PREMIUM );
	}

}
