package skeleton.hexagon.frontend.adapter;

import skeleton.hexagon.core.investment.adapter.AdapterInvestmentMockeImp;
import skeleton.hexagon.core.investment.business.domain.model.Investment;
import skeleton.hexagon.core.investment.business.domain.service.InvestmentService;
import skeleton.hexagon.core.investment.business.port.IInvestmentRepository;
import skeleton.hexagon.core.investment.business.usecase.IPortInvertmentService;
import skeleton.hexagon.core.investment.business.usecase.imp.PortInvestmentServiceImp;
import skeleton.hexagon.frontend.InvestmentRestService;

public class AdapterIntegrationTest {

	
	InvestmentRestService service;
	IPortInvertmentService port;
	IInvestmentRepository repository;
	InvestmentService investmentService;
	
	public AdapterIntegrationTest() {
		repository = new AdapterInvestmentMockeImp();
		investmentService = new InvestmentService();
		port = new PortInvestmentServiceImp(repository, investmentService);
		service = new InvestmentRestService(port);
	}
	
	
	public Investment findInvestment(Long id) {
		return port.getInvestment(id);
	}
	
	public Investment insertInvestment(Investment investment) {
		return port.inset(investment);
	}
	
	public void invest(Investment invest) {
		investmentService.process(invest);
	}
}
