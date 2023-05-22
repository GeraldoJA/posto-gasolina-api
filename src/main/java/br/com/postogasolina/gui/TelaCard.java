package br.com.postogasolina.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import br.com.postogasolina.service.AbastecimentoService;
import br.com.postogasolina.service.BombaService;
import br.com.postogasolina.service.CombustivelService;
import br.com.postogasolina.service.PostoService;
import br.com.postogasolina.service.VeiculoService;

public class TelaCard extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel painelCards;
	
	private TelaVeiculo cardVeiculo;
	private TelaCombustivel cardCombustivel;
	private TelaBomba cardBomba;
	private TelaRelatorio cardRelatorio;
	private TelaSobre cardSobre;
	private TelaAbastecer cardAbastecer;

	/**
	 * Create the frame.
	 */
	public TelaCard( PostoService postoService, VeiculoService veiculoService, 
			CombustivelService combustivelService, BombaService bombaService, AbastecimentoService abastecimentoService ) {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 345);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(0, 0));
		
		//Menu 1
		JMenu menu1 = new JMenu("Cadastrar");
		
		JMenuItem menu1Veiculos = new JMenuItem("Veículo");
		menu1Veiculos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mudarCard("Veículo");
			}
		});
		menu1.add(menu1Veiculos);
		
		JMenuItem menu1Bombas = new JMenuItem("Bomba");
		menu1Bombas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mudarCard("Bomba");
			}
		});
		menu1.add(menu1Bombas);
		
		JMenuItem menu1Combustivel = new JMenuItem("Combustivel");
		menu1Combustivel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mudarCard("Combustivel");
			}
		});
		menu1.add(menu1Combustivel);
		
		//Menu 2
		JMenu menu2 = new JMenu("Abastecimento");
		
		JMenuItem menu2Abastecer = new JMenuItem("Abastecer");
		menu2Abastecer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mudarCard("Abastecer");
			}
		});
		menu2.add(menu2Abastecer);
		
		JMenuItem menu2Relatorio = new JMenuItem("Relatório");
		menu2Relatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mudarCard("Relatório");
			}
		});
		menu2.add(menu2Relatorio);
		
		//Menu 3
		JMenu menu3 = new JMenu("Ajuda");
		JMenuItem menu3Sobre = new JMenuItem("Informação");
		menu3Sobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mudarCard("Informação");
			}
		});
		menu3.add(menu3Sobre);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(menu1);
		menuBar.add(menu2);
		menuBar.add(menu3);
		
		panel.add(menuBar, BorderLayout.LINE_START);
		getContentPane().add(panel, BorderLayout.NORTH);
		
		painelCards = new JPanel();
		painelCards.setLayout(new CardLayout(0, 0));
	
		cardVeiculo = new TelaVeiculo( veiculoService );
		painelCards.add( cardVeiculo, "cardVeiculo" );
		
		cardCombustivel = new TelaCombustivel(combustivelService);
		painelCards.add( cardCombustivel, "cardCombustivel" );
		
		cardBomba = new TelaBomba( postoService, combustivelService, bombaService );
		painelCards.add( cardBomba, "cardBomba" );
		
		cardRelatorio = new TelaRelatorio( abastecimentoService );
		painelCards.add( cardRelatorio, "cardRelatorio" );
		
		cardSobre = new TelaSobre();
		painelCards.add( cardSobre, "cardSobre" );
			
		cardAbastecer = new TelaAbastecer(veiculoService, bombaService, abastecimentoService);
		painelCards.add( cardAbastecer, "cardAbastecer" );
		
		((CardLayout) painelCards.getLayout()).show( painelCards, "cardSobre");
		
		getContentPane().add(painelCards, BorderLayout.CENTER);

	}
	
	
	private void mudarCard( String card) {
		
		CardLayout c = (CardLayout) painelCards.getLayout();
		
		switch (card) {
		
			case "Veículo":
				c.show( painelCards, "cardVeiculo");
				break;
				
			case "Bomba":
				c.show( painelCards, "cardBomba");
				cardBomba.iniciarCombos();
				break;	
				
			case "Combustivel":
				c.show( painelCards, "cardCombustivel");
				break;
			
			case "Abastecer":
				c.show( painelCards, "cardAbastecer");
				cardAbastecer.iniciarCombos();
				break;
				
			case "Relatório":
				c.show( painelCards, "cardRelatorio");
				break;		
			
			case "Informação":
				c.show( painelCards, "cardSobre");
				break;	
				
			default:
				break;
		}
	}


}
