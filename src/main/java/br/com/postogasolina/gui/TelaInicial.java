package br.com.postogasolina.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.postogasolina.dto.AbastecimentoDTO;
import br.com.postogasolina.report.control.Relatorio;
import br.com.postogasolina.service.AbastecimentoService;
import net.sf.jasperreports.engine.JRException;

public class TelaInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	private AbastecimentoService abastecimentoService;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
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
	public TelaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Gerar Relatório");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerarRelatorio();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(154)
					.addComponent(btnNewButton)
					.addContainerGap(181, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(155, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(73))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void gerarRelatorio() {
		
		List<AbastecimentoDTO> listaAbastecimentoDTO = new ArrayList<AbastecimentoDTO>();
		listaAbastecimentoDTO = abastecimentoService.prepararAbastecimentoDTO();
		
		HashMap<String,Object> params = abastecimentoService.resumoAbastecimento();
		
		Relatorio relatorio =  new Relatorio();
		
		try {
			relatorio.gerarRelatorio(listaAbastecimentoDTO, params);
		} catch (JRException e) {
			e.printStackTrace();
		}
	}


	/**
	 * @return the abastecimentoService
	 */
	public AbastecimentoService getAbastecimentoService() {
		return abastecimentoService;
	}


	/**
	 * @param abastecimentoService the abastecimentoService to set
	 */
	public void setAbastecimentoService(AbastecimentoService abastecimentoService) {
		this.abastecimentoService = abastecimentoService;
	}





	
}
