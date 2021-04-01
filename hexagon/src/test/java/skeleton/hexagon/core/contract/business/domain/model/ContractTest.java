package skeleton.hexagon.core.contract.business.domain.model;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import skeleton.hexagon.core.client.business.domain.Client;
import skeleton.hexagon.core.common.exception.BusinessException;

@DisplayName ("Contract Rule Test")
public class ContractTest {

	private Contract contract;

	@BeforeEach
	public void setup() {
		contract = new Contract("Insurrance Vie", new Client());
	}

	@Test
	public void updateLabel() {
		contract.updateLabel("Insurrance Vie 2");
	}
	
	@Test
	public void updateClient() {
		contract.updateClient(new Client());
	}

	@Test 
	public void invalidLabel() {
		try {
			contract.updateLabel(null);
			fail("Label is not empty");
		} catch (BusinessException e) {
			assertTrue(e.getMessage().contains("label"));
		}

	}
	
	@Test 
	public void invalidClient() {
		try {
			contract.updateClient(null);
			fail("Client is not empty");
		} catch (BusinessException e) {
			assertTrue(e.getMessage().contains("client"));
		}

	}
}
