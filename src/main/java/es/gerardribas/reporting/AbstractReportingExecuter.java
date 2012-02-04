package es.gerardribas.reporting;

import javax.persistence.EntityManager;

import net.sf.jasperreports.engine.JRException;

public interface AbstractReportingExecuter {

	void fillReport() throws JRException;

	String pdf() throws JRException;

	void pdf(String targetFile) throws JRException;

	String xml(boolean isEmbeddingImages) throws JRException;

	void xml(String targetFile, boolean isEmbeddingImages) throws JRException;

	String html() throws JRException;

	void html(String targetFile) throws JRException;

	String rtf() throws JRException;

	void rtf(String targetFile) throws JRException;

	void xls(String targetFile, boolean isOnePagePerSheet) throws JRException;

	String xls(boolean isOnePagePerSheet) throws JRException;

	String jxl(boolean isOnePagePerSheet) throws JRException;

	void jxl(String targetFile, boolean isOnePagePerSheet) throws JRException;

	String csv() throws JRException;

	void csv(String targetFile) throws JRException;

	String odt() throws JRException;

	void odt(String targetFile) throws JRException;

	String ods(boolean isOnePagePerSheet) throws JRException;

	void ods(String targetFile, boolean isOnePagePerSheet) throws JRException;

	String docx() throws JRException;

	void docx(String targetFile) throws JRException;

	String xlsx(boolean isOnePagePerSheet) throws JRException;

	void xlsx(String targetFile, boolean isOnePagePerSheet) throws JRException;

	String pptx() throws JRException;

	void pptx(String targetFile) throws JRException;

	String xhtml() throws JRException;

	void xhtml(String targetFile) throws JRException;

	String getSourceFileName();

	void setSourceFileName(String sourceFileName);

	String getDestFileName();

	void setDestFileName(String destFileName);

	EntityManager getEntityManager();

}