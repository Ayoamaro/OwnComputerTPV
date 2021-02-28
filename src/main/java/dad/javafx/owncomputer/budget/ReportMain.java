package dad.javafx.owncomputer.budget;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dad.javafx.owncomputer.model.Component;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class ReportMain {
	
public static void generatePdf() throws JRException, IOException {
		
		List<Component> product = new ArrayList<>();
		
		Component p1 = new Component();
//		p1.setId(1234L);
//		p1.setNombre("Mi productito");
//		p1.setCantidad(500);
//		misproductos.add(p1);
		
		Component p2 = new Component();
//		p2.setId(4321L);
//		p2.setNombre("Otro productito");
//		p2.setCantidad(123);
//		misproductos.add(p2);

		// compila el informe
		JasperReport report = JasperCompileManager.compileReport(ReportMain.class.getResourceAsStream("/reports/budget.jrxml"));		

		// mapa de parámetros para el informe
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("Company", "Own Computer");
		
		// generamos el informe (combinamos el informe compilado con los datos) 
        JasperPrint print  = JasperFillManager.fillReport(report, parameters, new JRBeanCollectionDataSource(product));
        
        // exporta el informe a un fichero PDF
        JasperExportManager.exportReportToPdfFile(print, "pdf/stockList.pdf");
        
        // Abre el archivo PDF generado con el programa predeterminado del sistema
		Desktop.getDesktop().open(new File("pdf/budget.pdf"));
	}
	
	public static void main(String[] args) throws JRException, IOException {
		generatePdf();
	}

}
