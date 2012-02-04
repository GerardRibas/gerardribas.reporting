/**
 * 
 */
package es.gerardribas.reporting;

import java.util.Map;

import es.gerardribas.reporting.impl.AbstractReportingExecuterImpl;

/**
 * @author Gerard
 *
 */
public class CustomerReportingExecuter extends AbstractReportingExecuterImpl {
	
	public CustomerReportingExecuter() {
		super.setSourceFileName(CustomerReportingExecuter.class.getResource("CustomerReport.jasper").getFile());
	}
	
	@Override
	protected Map<String, Object> getParameters() {
		Map<String, Object> parameters = super.getParameters();
		parameters.put("City", "Dover");
		return parameters;
	}
	
}
