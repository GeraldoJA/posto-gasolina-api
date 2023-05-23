package br.com.postogasolina.gui;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import br.com.postogasolina.domain.Veiculo;
import br.com.postogasolina.service.VeiculoService;

public class TelaVeiculo extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private VeiculoService veiculoService;
	
	private JTextField txModelo;
	private JTextField tfNome;
	private JTextField tfPlaca;
	private JTextField tfCapacidade;

	/**
	 * Create the panel.
	 */
	public TelaVeiculo( VeiculoService veiculoService ) {
		
		this.veiculoService = veiculoService;
			
		JLabel lblTitulo = new JLabel("VEÍCULOS");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel = new JLabel("Modelo: ");
		
		JLabel lblNewLabel_1 = new JLabel("Nome: ");
		
		JLabel lblNewLabel_2 = new JLabel("Placa");
		
		JLabel lblNewLabel_3 = new JLabel("Capacidade Tanque:");
		
		txModelo = new JTextField();
		txModelo.setColumns(10);
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		
		tfPlaca = new JTextField();
		tfPlaca.setColumns(10);
		
		tfCapacidade = new JTextField();
		tfCapacidade.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if( !filtrar(e) )
					e.consume();   //consume n�o faz nada
			}
		});
		tfCapacidade.setColumns(10);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrar();
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(190)
							.addComponent(lblTitulo))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(txModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(tfNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(tfPlaca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_3)
									.addGap(18)
									.addComponent(tfCapacidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(174)
							.addComponent(btnNewButton)))
					.addContainerGap(195, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitulo)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(txModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(tfNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(tfPlaca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(tfCapacidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addComponent(btnNewButton)
					.addContainerGap(88, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
	
	private boolean filtrar(KeyEvent e) {
		char tecla = e.getKeyChar();
		char[] permitidos = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		
		boolean permitido = false;
		for (char c : permitidos) {
			if( tecla == c ) {
				permitido = true;
				break;
			}
		}
		
		return permitido;
	}	
	
	
	private void cadastrar() {
		
		Veiculo veiculo = new Veiculo();
		veiculo.setModelo( txModelo.getText() );
		veiculo.setNome( tfNome.getText() ); 
		veiculo.setPlaca( tfPlaca.getText() );
		
		if(tfCapacidade.getText().equals("") ) {
			veiculo.setCapacidadeTanque( 0.0 );
			veiculo.setQtdCombustivel( 0.0 );
		}else {
			veiculo.setCapacidadeTanque( Double.parseDouble(tfCapacidade.getText()) ); 
			veiculo.setQtdCombustivel( 0.0 );
		}
		
		if( veiculo.getModelo().length() < 2 || veiculo.getModelo().length() > 30 )
			JOptionPane.showMessageDialog(null, "Modelo precisa ter entre 2 e 30 caracteres", "ERRO", JOptionPane.WARNING_MESSAGE);
		else if( veiculo.getNome().length() < 1 || veiculo.getNome().length() > 30 )
			JOptionPane.showMessageDialog(null, "Nome precisa ter entre 1 e 30 caracteres", "ERRO", JOptionPane.WARNING_MESSAGE);
		else if( veiculo.getPlaca().length() < 1 || veiculo.getPlaca().length() > 20 )
			JOptionPane.showMessageDialog(null, "Placa precisa ter entre 1 e 20 caracteres", "ERRO", JOptionPane.WARNING_MESSAGE);
		else if( veiculo.getCapacidadeTanque() <= 0 )
			JOptionPane.showMessageDialog(null, "Informe uma quantidade v�lida", "ERRO", JOptionPane.WARNING_MESSAGE);
		else {
			veiculoService.create(veiculo);
			String mensagem = veiculo.toString() +  " cadastrado com Sucesso!";
			JOptionPane.showMessageDialog(null, mensagem, "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
			
			limpar();
		}
			
	}

	private void limpar() {
		
		for (int i = 0; i < this.getComponentCount(); i++) {
			Component c = this.getComponent(i);
			if( c instanceof JTextField ) {
				JTextField campo = (JTextField) c;
				campo.setText(null);
			}
		}
	}
}
