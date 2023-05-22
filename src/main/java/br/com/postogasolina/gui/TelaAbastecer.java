package br.com.postogasolina.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.postogasolina.domain.Bomba;
import br.com.postogasolina.domain.Veiculo;
import br.com.postogasolina.service.AbastecimentoService;
import br.com.postogasolina.service.BombaService;
import br.com.postogasolina.service.VeiculoService;

public class TelaAbastecer extends JPanel {
	

	private static final long serialVersionUID = 1L;

	private VeiculoService veiculoService;
	private BombaService bombaService;
	private AbastecimentoService abastecimentoService;

	private JTextField txQtdLitros;
	
	private JComboBox<Veiculo> comboBoxCarro;
	private JComboBox<Bomba> comboBoxBomba;
	
	/**
	 * Create the panel.
	 */
	public TelaAbastecer( VeiculoService veiculoService, BombaService bombaService, AbastecimentoService abastecimentoService ) {
		

		this.veiculoService = veiculoService;
		this.bombaService = bombaService;
		this.abastecimentoService = abastecimentoService;
		
		comboBoxCarro = new JComboBox<Veiculo>();

		comboBoxBomba = new JComboBox<Bomba>();
		
		JLabel lblCarro = new JLabel("Selecione o carro: ");
		
		JLabel lblAbastecimento = new JLabel("ABASTECIMENTO");
		lblAbastecimento.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblBomba = new JLabel("Selecione a bomba: ");
		
		JLabel lblQtdLitros = new JLabel("Quantidade de litros: ");

		txQtdLitros = new JTextField();
		txQtdLitros.setColumns(10);
		
		JButton btnAbastecer = new JButton("Abastecer");
		btnAbastecer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abastecer();
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(36)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblBomba, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblCarro, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblQtdLitros, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txQtdLitros, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxBomba, 0, 182, Short.MAX_VALUE)
								.addComponent(comboBoxCarro, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(180)
							.addComponent(lblAbastecimento))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(172)
							.addComponent(btnAbastecer)))
					.addContainerGap(70, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(36, Short.MAX_VALUE)
					.addComponent(lblAbastecimento)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxCarro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCarro))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxBomba, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBomba))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblQtdLitros)
						.addComponent(txQtdLitros, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(46)
					.addComponent(btnAbastecer)
					.addGap(69))
		);
		setLayout(groupLayout);

		iniciarCombos();
	}
	
	private void abastecer() {
		
		Bomba bomba = (Bomba) comboBoxBomba.getSelectedItem();
		Veiculo veiculo = (Veiculo) comboBoxCarro.getSelectedItem();
		double qtdLitros = 0.0;
		String litros = txQtdLitros.getText();
		if( !litros.equals("") )
			qtdLitros = Double.parseDouble( txQtdLitros.getText() );
		
		if( qtdLitros > 0 ) {
			abastecimentoService.create(bomba, veiculo, qtdLitros);
			
			String mensagem = veiculo.toString() + " abasteceu " + qtdLitros + " litros de " + bomba.toString();
			JOptionPane.showMessageDialog(null, mensagem, "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null, "Precisa informar a quantidade de litros", "ERRO", JOptionPane.WARNING_MESSAGE);
		}
		
	}
	
	public void iniciarCombos() {
		inicarComboBoxCarro();
		inicarComboBoxBomba();
	}
	
	private void inicarComboBoxCarro() {
		
		comboBoxCarro.removeAllItems();  //limpar comboBox
		
		List<Veiculo> list = veiculoService.findAll();
		for (Veiculo veiculo : list) {
			comboBoxCarro.addItem(veiculo);
		}
	}
	
	private void inicarComboBoxBomba() {
		
		comboBoxBomba.removeAllItems(); //limpar comboBox
		
		List<Bomba> list = bombaService.findAll();
		for (Bomba bomba : list) {
			comboBoxBomba.addItem(bomba);
		}
	}
	
}
