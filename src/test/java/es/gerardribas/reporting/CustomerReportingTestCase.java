/**
 * 
 */
package es.gerardribas.reporting;

import net.sf.jasperreports.engine.JRException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.IOException;

/**
 * @author Gerard
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring-config.xml")
public class CustomerReportingTestCase {

	@Autowired
	private CustomerReportingExecuter customerReportingExecuter;

	@Test
	public void testFillReportToCsv() throws JRException, IOException {
        customerReportingExecuter.fillReport();
        customerReportingExecuter.csv();
        checkFileExists(".csv");
	}

    @Test
    public void testFillReportToCsvTargetFile() throws JRException, IOException {
        customerReportingExecuter.fillReport();
        File tempFile = File.createTempFile("customerReport", "csv");
        customerReportingExecuter.csv(tempFile.getAbsolutePath());
        checkFileExists(tempFile);
    }

    @Test
    public void testFillReportToDocx() throws JRException, IOException {
        customerReportingExecuter.fillReport();
        customerReportingExecuter.docx();
        checkFileExists(".docx");
    }

    @Test
    public void testFillReportToDocxTargetFile() throws JRException, IOException {
        customerReportingExecuter.fillReport();
        File tempFile = File.createTempFile("customerReport", "docx");
        customerReportingExecuter.docx(tempFile.getAbsolutePath());
        checkFileExists(tempFile);
    }

    @Test
    public void testFillReportToHtml() throws JRException, IOException {
        customerReportingExecuter.fillReport();
        customerReportingExecuter.html();
        checkFileExists(".html");
    }

    @Test
    public void testFillReportToHtmlTargetFile() throws JRException, IOException {
        customerReportingExecuter.fillReport();
        File tempFile = File.createTempFile("customerReport", "html");
        customerReportingExecuter.html(tempFile.getAbsolutePath());
        checkFileExists(tempFile);
    }

    @Test
    public void testFillReportToJxl() throws JRException, IOException {
        customerReportingExecuter.fillReport();
        customerReportingExecuter.jxl(false);
        checkFileExists(".xls");
    }

    @Test
    public void testFillReportToJxlTargetFile() throws JRException, IOException {
        customerReportingExecuter.fillReport();
        File tempFile = File.createTempFile("customerReport", "xls");
        customerReportingExecuter.jxl(tempFile.getAbsolutePath(), false);
        checkFileExists(tempFile);
    }

    @Test
    public void testFillReportToJxlOnePagePerSheet() throws JRException, IOException {
        customerReportingExecuter.fillReport();
        customerReportingExecuter.jxl(true);
        checkFileExists(".xls");
    }

    @Test
    public void testFillReportToJxlTargetFileOnePagePerSheet() throws JRException, IOException {
        customerReportingExecuter.fillReport();
        File tempFile = File.createTempFile("customerReport", "xls");
        customerReportingExecuter.jxl(tempFile.getAbsolutePath(), true);
        checkFileExists(tempFile);
    }

    @Test
    public void testFillReportToPdf() throws JRException, IOException {
        customerReportingExecuter.fillReport();
        customerReportingExecuter.pdf();
        checkFileExists(".pdf");
    }

    @Test
    public void testFillReportToPdfTargetFile() throws JRException, IOException {
        customerReportingExecuter.fillReport();
        File tempFile = File.createTempFile("customerReport", "pdf");
        customerReportingExecuter.pdf(tempFile.getAbsolutePath());
        checkFileExists(tempFile);
    }

    @Test
    public void testFillReportToXml() throws JRException, IOException {
        customerReportingExecuter.fillReport();
        customerReportingExecuter.xml(false);
        checkFileExists(".jrpxml");
    }

    @Test
    public void testFillReportToXmlTargetFile() throws JRException, IOException {
        customerReportingExecuter.fillReport();
        File tempFile = File.createTempFile("customerReport", "xml");
        customerReportingExecuter.xml(tempFile.getAbsolutePath(), false);
        checkFileExists(tempFile);
    }

    @Test
    public void testFillReportToRtf() throws JRException, IOException {
        customerReportingExecuter.fillReport();
        customerReportingExecuter.rtf();
        checkFileExists(".rtf");
    }

    @Test
    public void testFillReportToRtfTargetFile() throws JRException, IOException {
        customerReportingExecuter.fillReport();
        File tempFile = File.createTempFile("customerReport", "rtf");
        customerReportingExecuter.rtf(tempFile.getAbsolutePath());
        checkFileExists(tempFile);
    }

    @Test
    public void testFillReportToXls() throws JRException, IOException {
        customerReportingExecuter.fillReport();
        customerReportingExecuter.xls(false);
        checkFileExists(".xls");
    }

    @Test
    public void testFillReportToXlsTargetFile() throws JRException, IOException {
        customerReportingExecuter.fillReport();
        File tempFile = File.createTempFile("customerReport", "xls");
        customerReportingExecuter.xls(tempFile.getAbsolutePath(), false);
        checkFileExists(tempFile);
    }

    @Test
    public void testFillReportToOdt() throws JRException, IOException {
        customerReportingExecuter.fillReport();
        customerReportingExecuter.odt();
        checkFileExists(".odt");
    }

    @Test
    public void testFillReportToOdtTargetFile() throws JRException, IOException {
        customerReportingExecuter.fillReport();
        File tempFile = File.createTempFile("customerReport", "odt");
        customerReportingExecuter.odt(tempFile.getAbsolutePath());
        checkFileExists(tempFile);
    }

    @Test
    public void testFillReportToOds() throws JRException, IOException {
        customerReportingExecuter.fillReport();
        customerReportingExecuter.ods(false);
        checkFileExists(".ods");
    }

    @Test
    public void testFillReportToOdsTargetFile() throws JRException, IOException {
        customerReportingExecuter.fillReport();
        File tempFile = File.createTempFile("customerReport", "odt");
        customerReportingExecuter.ods(tempFile.getAbsolutePath(), false);
        checkFileExists(tempFile);
    }

    @Test
    public void testFillReportToXslx() throws JRException, IOException {
        customerReportingExecuter.fillReport();
        customerReportingExecuter.xlsx(false);
        checkFileExists(".xlsx");
    }

    @Test
    public void testFillReportToXslxTargetFile() throws JRException, IOException {
        customerReportingExecuter.fillReport();
        File tempFile = File.createTempFile("customerReport", "odt");
        customerReportingExecuter.xlsx(tempFile.getAbsolutePath(), false);
        checkFileExists(tempFile);
    }

    @Test
    public void testFillReportToPptx() throws JRException, IOException {
        customerReportingExecuter.fillReport();
        customerReportingExecuter.pptx();
        checkFileExists(".pptx");
    }

    @Test
    public void testFillReportToPptxTargetFile() throws JRException, IOException {
        customerReportingExecuter.fillReport();
        File tempFile = File.createTempFile("customerReport", "pptx");
        customerReportingExecuter.pptx(tempFile.getAbsolutePath());
        checkFileExists(tempFile);
    }

    @Test
    public void testFillReportToXhtml() throws JRException, IOException {
        customerReportingExecuter.fillReport();
        customerReportingExecuter.xhtml();
        checkFileExists(".xhtml");
    }

    @Test
    public void testFillReportToXhtmlTargetFile() throws JRException, IOException {
        customerReportingExecuter.fillReport();
        File tempFile = File.createTempFile("customerReport", "xhtml");
        customerReportingExecuter.xhtml(tempFile.getAbsolutePath());
        checkFileExists(tempFile);
    }

    private void checkFileExists(String extension) throws IOException {
        Resource customerReportPrinted = new FileSystemResource(customerReportingExecuter.getDestFileName());
        Assert.assertTrue(customerReportPrinted.exists());
        Resource customerReportPrintedCsv = new FileSystemResource(customerReportingExecuter.getDestFileName().replace(".jrprint", extension));
        Assert.assertTrue(customerReportPrintedCsv.exists());
        Assert.assertTrue(customerReportPrinted.getFile().delete());
        Assert.assertTrue(customerReportPrintedCsv.getFile().delete());
    }

    private void checkFileExists(File tempFile) throws IOException {
        Resource customerReportPrinted = new FileSystemResource(customerReportingExecuter.getDestFileName());
        Assert.assertTrue(customerReportPrinted.exists());
        Assert.assertNotEquals(0, tempFile.length());
        Assert.assertTrue(customerReportPrinted.getFile().delete());
        Assert.assertTrue(tempFile.delete());
    }
}
