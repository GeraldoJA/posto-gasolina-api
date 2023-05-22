package br.com.postogasolina.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.com.postogasolina.dto.AbastecimentoDTO;
import br.com.postogasolina.report.control.Relatorio;
import br.com.postogasolina.service.AbastecimentoService;
import net.sf.jasperreports.engine.JRException;

public class TelaRelatorio extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private AbastecimentoService abastecimentoService;
	
	/**
	 * Create the panel.
	 */
	public TelaRelatorio( AbastecimentoService abastecimentoService ) {
		
		this.abastecimentoService = abastecimentoService;
		
		JButton btnRelatorio = new JButton("Gerar Relatório");
		btnRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerarRelatorio();
			}
		});
		
		JLabel lblNewLabel = new JLabel("RELATÓRIO");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(166)
							.addComponent(btnRelatorio))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(180)
							.addComponent(lblNewLabel)))
					.addContainerGap(179, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(110)
					.addComponent(btnRelatorio)
					.addContainerGap(141, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		


	}
	
	private void gerarRelatorio() {
		
		List<AbastecimentoDTO> listaAbastecimentoDTO =  this.abastecimentoService.prepararAbastecimentoDTO();
		HashMap<String,Object> params = this.abastecimentoService.resumoAbastecimento();
		
		Relatorio relatorio =  new Relatorio();
		try {
			relatorio.gerarRelatorio(listaAbastecimentoDTO, params);
		} catch (JRException e) {
			e.printStackTrace();
		}
	}
}
