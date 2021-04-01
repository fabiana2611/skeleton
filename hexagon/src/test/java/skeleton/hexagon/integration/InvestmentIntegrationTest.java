package skeleton.hexagon.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import skeleton.hexagon.core.client.business.domain.Client;
import skeleton.hexagon.core.client.business.domain.type.TypeClient;
import skeleton.hexagon.core.contract.business.domain.model.Contract;
import skeleton.hexagon.core.investment.business.domain.model.Investment;
import skeleton.hexagon.frontend.adapter.AdapterIntegrationTest;

public class InvestmentIntegrationTest {

	AdapterIntegrationTest adapter;
	
	@BeforeEach
	void setup() {
		adapter = new AdapterIntegrationTest();
	}
	
	@Test
	void findInvestment() {
		Investment result = adapter.findInvestment(10L);
		assertEquals(result.getContract().getClient().getType(), TypeClient.INDIVIDUAL);
		assertEquals(result.getContract().getLabel(), "Vie");
	}
	
	@Test
	void insertInvest() {
		Client client = new Client("New Client", TypeClient.INDIVIDUAL);
		Contract contract = new Contract("New Contract", client);
		Investment invest = new Investment(contract);
		invest.invest(100);
		
		Investment result = adapter.insertInvestment(invest);
		
		assertNotNull(result.getId());
	}
	
	@Test
	void invest() {
		Client client = new Client("New Client", TypeClient.INDIVIDUAL);
		Contract contract = new Contract("New Contract", client);
		Investment invest = new Investment(contract);
		invest.invest(100);
		
		adapter.invest(invest);
		
		assertEquals(invest.getInvestValue(), invest.getValue());
	}
	
	
}
