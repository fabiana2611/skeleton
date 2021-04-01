package skeleton.hexagon.frontend;

import skeleton.hexagon.core.investment.business.domain.model.Investment;
import skeleton.hexagon.core.investment.business.usecase.IPortInvertmentService;

public class InvestmentRestService {
	
	IPortInvertmentService port;
	
	public InvestmentRestService(IPortInvertmentService port) {
		this.port = port;
	}
	
	public Investment findInvestment(Long id) {
		return port.getInvestment(id);
	}
	
	public void insertInvestment(Investment investment) {
		port.inset(investment);
	}

}
