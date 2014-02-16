/**
 * 
 */
package es.gerardribas.reporting.impl;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JExcelApiExporter;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRXhtmlExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.oasis.JROdsExporter;
import net.sf.jasperreports.engine.export.oasis.JROdtExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRPptxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.query.JRJpaQueryExecuterFactory;
import net.sf.jasperreports.engine.util.JRLoader;
import es.gerardribas.reporting.AbstractReportingExecuter;

/**
 * @author Gerard
 * 
 */
public abstract class AbstractReportingExecuterImpl implements AbstractReportingExecuter {

	@PersistenceContext
	private EntityManager entityManager;

	private String sourceFileName;

	private String destFileName;

	/* (non-Javadoc)
	 * @see es.gerardribas.reporting.impl.AbstractReportingExecuter#fillReport()
	 */
	public void fillReport() throws JRException {
		try {
			destFileName = JasperFillManager.fillReportToFile(sourceFileName,
					getParameters());
			entityManager.close();
		} finally {
			if (entityManager.isOpen())
				entityManager.close();
			if (entityManager.isOpen())
				entityManager.close();
		}
	}

	/* (non-Javadoc)
	 * @see es.gerardribas.reporting.impl.AbstractReportingExecuter#pdf()
	 */
	public String pdf() throws JRException {
		return JasperExportManager.exportReportToPdfFile(destFileName);
	}

	/* (non-Javadoc)
	 * @see es.gerardribas.reporting.impl.AbstractReportingExecuter#pdf(java.lang.String)
	 */
	public void pdf(String targetFile) throws JRException {
		JasperExportManager.exportReportToPdfFile(destFileName, targetFile);
	}

	/* (non-Javadoc)
	 * @see es.gerardribas.reporting.impl.AbstractReportingExecuter#xml(boolean)
	 */
	public String xml(boolean isEmbeddingImages) throws JRException {
		return JasperExportManager.exportReportToXmlFile(destFileName,
				isEmbeddingImages);
	}

	/* (non-Javadoc)
	 * @see es.gerardribas.reporting.impl.AbstractReportingExecuter#xml(java.lang.String, boolean)
	 */
	public void xml(String targetFile, boolean isEmbeddingImages)
			throws JRException {
		JasperExportManager.exportReportToXmlFile(destFileName, targetFile,
				isEmbeddingImages);
	}

	/* (non-Javadoc)
	 * @see es.gerardribas.reporting.impl.AbstractReportingExecuter#html()
	 */
	public String html() throws JRException {
		return JasperExportManager.exportReportToHtmlFile(destFileName);
	}

	/* (non-Javadoc)
	 * @see es.gerardribas.reporting.impl.AbstractReportingExecuter#html(java.lang.String)
	 */
	public void html(String targetFile) throws JRException {
		JasperExportManager.exportReportToHtmlFile(destFileName, targetFile);
	}

	/* (non-Javadoc)
	 * @see es.gerardribas.reporting.impl.AbstractReportingExecuter#rtf()
	 */
	public String rtf() throws JRException {
		String targetFile = getDefaultTargetFile("rtf");
		defaultExporter(new JRRtfExporter(), targetFile);
		return targetFile;
	}

	protected JasperPrint getJasperPrint() throws JRException {
		return (JasperPrint) JRLoader.loadObjectFromFile(destFileName);
	}

	/* (non-Javadoc)
	 * @see es.gerardribas.reporting.impl.AbstractReportingExecuter#rtf(java.lang.String)
	 */
	public void rtf(String targetFile) throws JRException {
		defaultExporter(new JRRtfExporter(), targetFile);
	}

	/* (non-Javadoc)
	 * @see es.gerardribas.reporting.impl.AbstractReportingExecuter#xls(java.lang.String, boolean)
	 */
	public void xls(String targetFile, boolean isOnePagePerSheet)
			throws JRException {
		defaultExcelExporter(new JRXlsExporter(), targetFile, isOnePagePerSheet);
	}

	/* (non-Javadoc)
	 * @see es.gerardribas.reporting.impl.AbstractReportingExecuter#xls(boolean)
	 */
	public String xls(boolean isOnePagePerSheet) throws JRException {
		String targetFile = getDefaultTargetFile("xls");
		defaultExcelExporter(new JRXlsExporter(), targetFile, isOnePagePerSheet);
		return targetFile;
	}

	/* (non-Javadoc)
	 * @see es.gerardribas.reporting.impl.AbstractReportingExecuter#jxl(boolean)
	 */
	public String jxl(boolean isOnePagePerSheet) throws JRException {
		String targetFile = getDefaultTargetFile("xls");
		defaultExcelExporter(new JExcelApiExporter(), targetFile,
				isOnePagePerSheet);
		return targetFile;
	}

	/* (non-Javadoc)
	 * @see es.gerardribas.reporting.impl.AbstractReportingExecuter#jxl(java.lang.String, boolean)
	 */
	public void jxl(String targetFile, boolean isOnePagePerSheet)
			throws JRException {
		defaultExcelExporter(new JExcelApiExporter(), targetFile,
				isOnePagePerSheet);
	}

	/* (non-Javadoc)
	 * @see es.gerardribas.reporting.impl.AbstractReportingExecuter#csv()
	 */
	public String csv() throws JRException {
		String targetFile = getDefaultTargetFile("csv");
		defaultExporter(new JRCsvExporter(), targetFile);
		return targetFile;
	}

	/* (non-Javadoc)
	 * @see es.gerardribas.reporting.impl.AbstractReportingExecuter#csv(java.lang.String)
	 */
	public void csv(String targetFile) throws JRException {
		defaultExporter(new JRCsvExporter(), targetFile);
	}

	/* (non-Javadoc)
	 * @see es.gerardribas.reporting.impl.AbstractReportingExecuter#odt()
	 */
	public String odt() throws JRException {
		String targetFile = getDefaultTargetFile("odt");
		defaultExporter(new JROdtExporter(), targetFile);
		return targetFile;
	}

	/* (non-Javadoc)
	 * @see es.gerardribas.reporting.impl.AbstractReportingExecuter#odt(java.lang.String)
	 */
	public void odt(String targetFile) throws JRException {
		defaultExporter(new JROdtExporter(), targetFile);
	}

	/* (non-Javadoc)
	 * @see es.gerardribas.reporting.impl.AbstractReportingExecuter#ods(boolean)
	 */
	public String ods(boolean isOnePagePerSheet) throws JRException {
		String targetFile = getDefaultTargetFile("ods");
		defaultExcelExporter(new JROdsExporter(), targetFile, isOnePagePerSheet);
		return targetFile;
	}

	/* (non-Javadoc)
	 * @see es.gerardribas.reporting.impl.AbstractReportingExecuter#ods(java.lang.String, boolean)
	 */
	public void ods(String targetFile, boolean isOnePagePerSheet)
			throws JRException {
		defaultExcelExporter(new JROdsExporter(), targetFile, isOnePagePerSheet);
	}

	/* (non-Javadoc)
	 * @see es.gerardribas.reporting.impl.AbstractReportingExecuter#docx()
	 */
	public String docx() throws JRException {
		String targetFile = getDefaultTargetFile("docx");
		defaultExporter(new JRDocxExporter(), targetFile);
		return targetFile;
	}

	/* (non-Javadoc)
	 * @see es.gerardribas.reporting.impl.AbstractReportingExecuter#docx(java.lang.String)
	 */
	public void docx(String targetFile) throws JRException {
		defaultExporter(new JRDocxExporter(), targetFile);
	}

	/* (non-Javadoc)
	 * @see es.gerardribas.reporting.impl.AbstractReportingExecuter#xlsx(boolean)
	 */
	public String xlsx(boolean isOnePagePerSheet) throws JRException {
		String targetFile = getDefaultTargetFile("xlsx");
		defaultExcelExporter(new JRXlsxExporter(), targetFile,
				isOnePagePerSheet);
		return targetFile;
	}

	/* (non-Javadoc)
	 * @see es.gerardribas.reporting.impl.AbstractReportingExecuter#xlsx(java.lang.String, boolean)
	 */
	public void xlsx(String targetFile, boolean isOnePagePerSheet)
			throws JRException {
		defaultExcelExporter(new JRXlsxExporter(), targetFile,
				isOnePagePerSheet);
	}

	/* (non-Javadoc)
	 * @see es.gerardribas.reporting.impl.AbstractReportingExecuter#pptx()
	 */
	public String pptx() throws JRException {
		String targetFile = getDefaultTargetFile("pptx");
		defaultExporter(new JRPptxExporter(), targetFile);
		return targetFile;
	}

	/* (non-Javadoc)
	 * @see es.gerardribas.reporting.impl.AbstractReportingExecuter#pptx(java.lang.String)
	 */
	public void pptx(String targetFile) throws JRException {
		defaultExporter(new JRPptxExporter(), targetFile);
	}

	/* (non-Javadoc)
	 * @see es.gerardribas.reporting.impl.AbstractReportingExecuter#xhtml()
	 */
	public String xhtml() throws JRException {
		String targetFile = getDefaultTargetFile("xhtml");
		defaultExporter(new JRXhtmlExporter(), targetFile);
		return targetFile;
	}

	/* (non-Javadoc)
	 * @see es.gerardribas.reporting.impl.AbstractReportingExecuter#xhtml(java.lang.String)
	 */
	public void xhtml(String targetFile) throws JRException {
		defaultExporter(new JRXhtmlExporter(), targetFile);
	}

	private void defaultExporter(JRExporter exporter, String targetFile)
			throws JRException {
		exporter.setParameter(JRExporterParameter.JASPER_PRINT,
				getJasperPrint());
		exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, targetFile);
		exporter.exportReport();
	}

	private void defaultExcelExporter(JRExporter exporter, String targetFile,
			boolean isOnePagePerSheet) throws JRException {
		exporter.setParameter(JRExporterParameter.JASPER_PRINT,
				getJasperPrint());
		exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, targetFile);
		exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,
				isOnePagePerSheet);
		exporter.exportReport();
	}
	
	protected String getDefaultTargetFile(String extension){
		String targetFile = null;
		if(destFileName != null){
			targetFile = destFileName.replace(".jrprint", "." + extension);
		}
		return targetFile;
	}

	protected Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put(JRJpaQueryExecuterFactory.PARAMETER_JPA_ENTITY_MANAGER,
				entityManager);
		return parameters;
	}

	/* (non-Javadoc)
	 * @see es.gerardribas.reporting.impl.AbstractReportingExecuter#getSourceFileName()
	 */
	public String getSourceFileName() {
		return sourceFileName;
	}

	/* (non-Javadoc)
	 * @see es.gerardribas.reporting.impl.AbstractReportingExecuter#setSourceFileName(java.lang.String)
	 */
	public void setSourceFileName(String sourceFileName) {
		this.sourceFileName = sourceFileName;
	}

	/* (non-Javadoc)
	 * @see es.gerardribas.reporting.impl.AbstractReportingExecuter#getDestFileName()
	 */
	public String getDestFileName() {
		return destFileName;
	}

	/* (non-Javadoc)
	 * @see es.gerardribas.reporting.impl.AbstractReportingExecuter#setDestFileName(java.lang.String)
	 */
	public void setDestFileName(String destFileName) {
		this.destFileName = destFileName;
	}

	/* (non-Javadoc)
	 * @see es.gerardribas.reporting.impl.AbstractReportingExecuter#getEntityManager()
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

}
