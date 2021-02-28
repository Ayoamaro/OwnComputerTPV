package dad.javafx.owncomputer.budget;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import dad.javafx.owncomputer.model.Component;
import javafx.beans.property.ListProperty;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class ReportMain {
	
	public static void generatePdf(ListProperty<Component> ticket) throws JRException, IOException {
		
		// compila el informe
		JasperReport report = JasperCompileManager.compileReport(ReportMain.class.getResourceAsStream("/reports/budget.jrxml"));		

		// mapa de parámetros para el informe
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("Company", "Own Computer");
		
		// generamos el informe (combinamos el informe compilado con los datos) 
		JasperPrint print  = JasperFillManager.fillReport(report, parameters, new JRBeanCollectionDataSource(ticket));
        
		// exporta el informe a un fichero PDF
		JasperExportManager.exportReportToPdfFile(print, "pdf/budget.pdf");
        
		// Abre el archivo PDF generado con el programa predeterminado del sistema
		Desktop.getDesktop().open(new File("pdf/budget.pdf"));
	}
}
