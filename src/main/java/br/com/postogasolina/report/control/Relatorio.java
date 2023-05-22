package br.com.postogasolina.report.control;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import br.com.postogasolina.dto.AbastecimentoDTO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class Relatorio {

	public void gerarRelatorio( List<AbastecimentoDTO> lista, HashMap<String,Object> params) throws JRException {
		
		InputStream fonte = Relatorio.class.getResourceAsStream("/br/com/postogasolina/report/ireport/relatorio.jrxml");  //carregar o arquivo
		
		JasperReport report = JasperCompileManager.compileReport(fonte);  //compila o JasperReport e trata a exceção JRException
		
		JasperPrint print = JasperFillManager.fillReport
				(report, params, new JRBeanCollectionDataSource(lista) );   //2º parametro tipo como se fosse passar uma imagem, exemplo de uma logo, 
				                                                          //seria uma referencia HashMap (chave e valor), passa o nome e o caminho da imagem 
																	      //3º parametro transforma a lita em um datasource
		
		JasperViewer.viewReport(print, false);     //método para exibição. o false é para que a aplicação continuar ligada se fechar o reltório
	}
}
