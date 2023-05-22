package br.com.postogasolina.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class TelaCard extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel painelCards;
	
	private TelaVeiculo cardVeiculo;
	private TelaCombustivel cardCombustivel;
	private TelaBomba cardBomba;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCard frame = new TelaCard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 345);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(0, 0));
		
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
		
		JMenu menu2 = new JMenu("Abastecimento");
		JMenuItem menu2Abastecer = new JMenuItem("Abastecer");
		menu2.add(menu2Abastecer);
		JMenuItem menu2Relatorio = new JMenuItem("Relatório");
		menu2.add(menu2Relatorio);
		
		JMenu menu3 = new JMenu("Sobre");
		JMenuItem menu3Sobre = new JMenuItem("Informação");
		menu3.add(menu3Sobre);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(menu1);
		menuBar.add(menu2);
		menuBar.add(menu3);
		
		panel.add(menuBar, BorderLayout.LINE_START);
		getContentPane().add(panel, BorderLayout.NORTH);
		
		painelCards = new JPanel();
		painelCards.setLayout(new CardLayout(0, 0));
	
		cardVeiculo = new TelaVeiculo();
		painelCards.add( cardVeiculo, "cardVeiculo" );
		
		cardCombustivel = new TelaCombustivel();
		painelCards.add( cardCombustivel, "cardCombustivel" );
		
		cardBomba = new TelaBomba();
		painelCards.add( cardBomba, "cardBomba" );
		
		
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
				break;	
				
			case "Combustivel":
				c.show( painelCards, "cardCombustivel");
				break;		
				
			default:
				break;
		}
	}

}
