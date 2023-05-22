package br.com.postogasolina.gui;

import java.awt.Component;
import java.awt.Font;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.postogasolina.domain.Bomba;
import br.com.postogasolina.domain.Combustivel;
import br.com.postogasolina.domain.Posto;
import br.com.postogasolina.domain.TipoCombustivel;
import br.com.postogasolina.domain.Veiculo;
import br.com.postogasolina.service.BombaService;
import br.com.postogasolina.service.CombustivelService;
import br.com.postogasolina.service.PostoService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaBomba extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private PostoService postoService;
	private CombustivelService combustivelService;
	private BombaService bombaService;
	
	//PROVA: Velocidade de abastecimento da bomba de gasolina:10 litros / minuto
	private final Integer  VELOCIDADE_GASOLINA = 10; 
	//PROVA: Velocidade de abastecimento da bomba de Ã¡lcool:12 litros / minuto
	private final Integer  VELOCIDADE_ALCOOL = 12; 
	
	//PROVA: O preÃ§o do litro de gasolina:R$ 2.90
	private final Double  PRECO_GASOLINA = 2.90; 
	//PROVA: O preÃ§o do litro de  Ã¡lcool: R$ 2.27
	private final Double  PRECO_ALCOOL = 2.27; 
	
	private JComboBox<Posto> comboPosto;
	private JComboBox<Combustivel> comboCombustivel;
	
	private JTextField tfPreco;
	private JTextField tfTempo;

	/**
	 * Create the panel.
	 */
	public TelaBomba(PostoService postoService, CombustivelService combustivelService, BombaService bombaService) {
		
		this.postoService = postoService;
		this.combustivelService = combustivelService;
		this.bombaService = bombaService;
		
		JLabel lblTitulo = new JLabel("BOMBA");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel = new JLabel("Posto: ");
		
		JLabel lblNewLabel_1 = new JLabel("Combustível: ");
		
		JLabel lblNewLabel_2 = new JLabel("Preço: ");
		
		JLabel lblNewLabel_3 = new JLabel("Tempo litro/minuto:");
		
		comboPosto = new JComboBox<Posto>();	
		
		comboCombustivel = new JComboBox<Combustivel>();
		comboCombustivel.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				regraPrecoDinheiro();
			}
		});
		
		tfPreco = new JTextField();
		tfPreco.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if( !filtrar(e, true) )
					e.consume();   //consume não faz nada
			}
		});
		tfPreco.setColumns(10);
		
		tfTempo = new JTextField();
		tfTempo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if( !filtrar(e, false) )
					e.consume();   //consume não faz nada
			}
		});
		tfTempo.setColumns(10);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				criarBomba();
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(21)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_3))
							.addGap(36)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(tfTempo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfPreco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(comboCombustivel, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(comboPosto, 0, 123, Short.MAX_VALUE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(172)
							.addComponent(btnNewButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(190)
							.addComponent(lblTitulo)))
					.addContainerGap(177, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitulo)
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboPosto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboCombustivel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(tfPreco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(tfTempo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(44)
					.addComponent(btnNewButton)
					.addContainerGap(48, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

		iniciarCombos();
	}
	
	private boolean filtrar(KeyEvent e, boolean numDouble) {
		char tecla = e.getKeyChar();
		char[] permitidos = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		
		boolean permitido = false;
		for (char c : permitidos) {
			if( tecla == c ) {
				permitido = true;
				break;
			}
		}	
		if( numDouble && tecla == '.' )
			permitido = true;
				
		return permitido;
	}	
	
	private void regraPrecoDinheiro() {
		
		Combustivel c = (Combustivel) comboCombustivel.getSelectedItem();
		
		if( c != null ) {
			if( c.getTipoCombustivel() == TipoCombustivel.GASOLINA_COMUM ) {
				tfPreco.setText( String.valueOf(PRECO_GASOLINA) );
				tfPreco.setEnabled(false);		
				tfTempo.setText( String.valueOf(VELOCIDADE_GASOLINA) );
				tfTempo.setEnabled(false);
				
			}else if( c.getTipoCombustivel() == TipoCombustivel.ALCOOL ) {
				tfPreco.setText( String.valueOf(PRECO_ALCOOL) );
				tfPreco.setEnabled(false);		
				tfTempo.setText( String.valueOf(VELOCIDADE_ALCOOL) );
				tfTempo.setEnabled(false);
				
			}else {
				tfPreco.setText( "" );
				tfPreco.setEnabled(true);
				tfTempo.setText( "" );
				tfTempo.setEnabled(true);
			}					
		}
	}
	
	private void criarBomba() {
		
		Posto posto = (Posto) comboPosto.getSelectedItem();;
		Combustivel Combustivel = (Combustivel) comboCombustivel.getSelectedItem();
		Bomba bomba;
		
		if( tfPreco.getText().equals("") )
			JOptionPane.showMessageDialog(null, "Precisa informar o preço", "ERRO", JOptionPane.WARNING_MESSAGE);
		else if( tfTempo.getText().equals("") ) 
			JOptionPane.showMessageDialog(null, "Precisa informar o tempo de abastecimento por litro", "ERRO", JOptionPane.WARNING_MESSAGE);
		else {
			
			if( Combustivel.getTipoCombustivel() == TipoCombustivel.ALCOOL ) 
				bomba = new Bomba(null, PRECO_ALCOOL, VELOCIDADE_ALCOOL, Combustivel, posto);
			else if( Combustivel.getTipoCombustivel() == TipoCombustivel.GASOLINA_COMUM )	
				bomba = new Bomba(null, PRECO_GASOLINA, VELOCIDADE_GASOLINA, Combustivel, posto);
			else {
				Double preco = Double.parseDouble( tfPreco.getText() );
				Integer velocidade = Integer.parseInt( tfTempo.getText() );
				bomba = new Bomba(null, preco, velocidade, Combustivel, posto);
			}
			
			String mensagem = "Bomba de " + bomba + " criada com sucesso.";
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
	
	public void iniciarCombos() {
		inicarComboPosto();
		inicarComboCombustivel();
	}
	
	private void inicarComboPosto() {
		
		comboPosto.removeAllItems();  //limpar comboBox
		
		List<Posto> list = postoService.findAll();
		for (Posto posto : list) {
			comboPosto.addItem(posto);
		}
	}
	
	private void inicarComboCombustivel() {
		
		comboCombustivel.removeAllItems(); //limpar comboBox
		
		List<Combustivel> list = combustivelService.findAll();
		for (Combustivel c : list) {
			comboCombustivel.addItem(c);
		}
	}

}
