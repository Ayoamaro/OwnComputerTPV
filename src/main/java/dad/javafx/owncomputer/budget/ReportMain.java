package dad.javafx.owncomputer.budget;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import dad.javafx.owncomputer.model.Component;
import dad.javafx.owncomputer.util.Config;
import javafx.beans.property.ListProperty;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * This class is used to create the reports
 * @author Melania, Alexis, Ayoze & Aarón
 * @version 01/02/2021
 * @see <a href = "https://github.com/dam-dad/OwnComputerTPV" /> OwnComputer Github </a>
 */

public class ReportMain {
	
	public static void generatePdf(ListProperty<Component> ticket) throws JRException, IOException {
		
		// compile the report
		JasperReport report = JasperCompileManager.compileReport(ReportMain.class.getResourceAsStream("/reports/budget.jrxml"));		

		// parameter map for report
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("Company", "Own Computer");
		
		// we generate the report (we combine the compiled report with the data)
		JasperPrint print  = JasperFillManager.fillReport(report, parameters, new JRBeanCollectionDataSource(ticket));
        
		// export the report to a PDF file
		JasperExportManager.exportReportToPdfFile(print, Config.getConfigDir() + "/budget.pdf");
        
		//Open the generated PDF file with the system default program
		Desktop.getDesktop().open(new File(Config.getConfigDir() + "/budget.pdf"));
	}
}
