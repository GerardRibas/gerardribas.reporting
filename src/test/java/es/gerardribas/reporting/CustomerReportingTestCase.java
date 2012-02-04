/**
 * 
 */
package es.gerardribas.reporting;

import net.sf.jasperreports.engine.JRException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
	public void testFillReport() {
		try {
			customerReportingExecuter.fillReport();
			if (customerReportingExecuter.getDestFileName() == null) {
				Assert.fail("Destination file is null");
			} else {
				System.out.println(customerReportingExecuter.getDestFileName());
				customerReportingExecuter.docx();
				customerReportingExecuter.csv();
			}

		} catch (JRException e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}
}
