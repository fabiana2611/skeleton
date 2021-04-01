package skeleton.hexagon.frontend.adapter;

import skeleton.hexagon.core.client.business.domain.Client;
import skeleton.hexagon.core.client.business.domain.type.TypeClient;
import skeleton.hexagon.core.contract.business.domain.model.Contract;
import skeleton.hexagon.core.investment.adapter.AdapterInvestmentMockeImp;
import skeleton.hexagon.core.investment.business.domain.model.Investment;
import skeleton.hexagon.core.investment.business.domain.service.InvestmentService;
import skeleton.hexagon.core.investment.business.port.IInvestmentRepository;
import skeleton.hexagon.core.investment.business.usecase.IPortInvertmentService;
import skeleton.hexagon.core.investment.business.usecase.imp.PortInvestmentServiceImp;
import skeleton.hexagon.frontend.InvestmentRestService;

import static java.util.Objects.isNull;

public class AdapterUI {

	static InvestmentRestService service;
	static IPortInvertmentService port;
	static IInvestmentRepository repository;
	static InvestmentService investmentService;
	
	public void init() {
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
	
	public static void main(String[] args) {
		
		AdapterUI adapter = new AdapterUI();
		adapter.init();
		
		Investment invest = adapter.getOne();
		
		investmentService.process(invest);
		Investment result = port.inset(invest);
		
		Investment investUpdated = port.getInvestment(result.getId());
		
		System.out.println("Process OK: " + !isNull(investUpdated));
		
		
	}
	
	private Investment getOne() {
		Client client = new Client("New Client", TypeClient.INDIVIDUAL);
		Contract contract = new Contract("New Contract", client);
		Investment invest = new Investment(contract);
		invest.invest(100);
		return invest;
	}

}
