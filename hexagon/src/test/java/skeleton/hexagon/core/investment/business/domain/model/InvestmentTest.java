package skeleton.hexagon.core.investment.business.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;

import skeleton.hexagon.core.client.business.domain.Client;
import skeleton.hexagon.core.client.business.domain.type.TypeClient;
import skeleton.hexagon.core.common.exception.BusinessException;
import skeleton.hexagon.core.contract.business.domain.model.Contract;

@DisplayName("Invest Rule Test")
public class InvestmentTest {

	private Investment investment;

	@Test
	public void createInvestmentClientIdividual() {

		Client client = new Client("A", TypeClient.INDIVIDUAL);
		investment = new Investment(new Contract("Vie", client));

		investment.invest(50d);
	}

	@Test
	public void createInvestmentInvalidClientIdividual() {
		
		Client client = new Client("A", TypeClient.INDIVIDUAL);
		investment = new Investment(new Contract("Vie", client));
		
		try {
			investment.invest(0d);
			fail("Error invest individual");
		} catch (BusinessException e) {
			assertTrue(e.getMessage().contains("more than zero"));
		}
	}

	@Test
	public void createInvestmentClientCompany() {

		Client client = new Client("C", TypeClient.COMPANY);
		investment = new Investment(new Contract("Vie", client));

		investment.invest(150d);
	}
	
	@Test
	public void createInvestmentInvalidClientCompany() {
		
		Client client = new Client("C", TypeClient.COMPANY);
		investment = new Investment(new Contract("Vie", client));
		
		try {
			investment.invest(0);
			fail("Error invest company");
		} catch (BusinessException e) {
			assertTrue(e.getMessage().contains("more than zero"));
		}
	}

}
