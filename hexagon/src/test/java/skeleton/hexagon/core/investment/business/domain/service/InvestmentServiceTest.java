package skeleton.hexagon.core.investment.business.domain.service;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import skeleton.hexagon.core.client.business.domain.Client;
import skeleton.hexagon.core.client.business.domain.type.TypeClient;
import skeleton.hexagon.core.contract.business.domain.model.Contract;
import skeleton.hexagon.core.investment.business.domain.model.Investment;

public class InvestmentServiceTest {

	private InvestmentService service = new InvestmentService();
	
	@Test
	public void investIndividual() {
		
		Client client = new Client("A", TypeClient.INDIVIDUAL);
		Investment investment = new Investment(new Contract("Vie", client));
		
		investment.invest(50d);
		
		service.process(investment);
		
		assertTrue(investment.getInvestValue() == investment.getValue());
	}
	
	@Test
	public void investIndividualMoreThanLimit() {
		
		Client client = new Client("A", TypeClient.INDIVIDUAL);
		Investment investment = new Investment(new Contract("Vie", client));
		
		investment.invest(150d);
		
		service.process(investment);
		
		assertTrue(investment.getInvestValue() == 100d);
	}
	
	@Test
	public void investCompany() {
		
		Client client = new Client("A", TypeClient.COMPANY);
		Investment investment = new Investment(new Contract("Vie", client));
		
		investment.invest(150d);
		
		service.process(investment);
		
		assertTrue(investment.getInvestValue() == investment.getValue());
	}
	
	@Test
	public void investCompanyLessThanLimit() {
		
		Client client = new Client("A", TypeClient.COMPANY);
		Investment investment = new Investment(new Contract("Vie", client));
		
		investment.invest(50d);
		
		service.process(investment);
		
		assertTrue(investment.getInvestValue() == 100d);
	}
	
}
