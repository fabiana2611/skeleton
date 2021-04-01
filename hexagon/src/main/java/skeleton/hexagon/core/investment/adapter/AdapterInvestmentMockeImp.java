package skeleton.hexagon.core.investment.adapter;

import java.util.HashMap;
import java.util.Map;

import skeleton.hexagon.core.client.business.domain.Client;
import skeleton.hexagon.core.client.business.domain.type.TypeClient;
import skeleton.hexagon.core.contract.business.domain.model.Contract;
import skeleton.hexagon.core.investment.business.domain.model.Investment;
import skeleton.hexagon.core.investment.business.port.IInvestmentRepository;

public class AdapterInvestmentMockeImp implements IInvestmentRepository {

	private Map<Long, Investment> database = new HashMap<>();

    public AdapterInvestmentMockeImp() {
    		Client client = new Client("A", TypeClient.INDIVIDUAL);
		Investment investment = new Investment(new Contract("Vie", client));
		investment.setInvestValue(51d);
		
        database.put(10L, investment);
        
        Client client2 = new Client("C", TypeClient.COMPANY);
		Investment investment2 = new Investment(new Contract("Vie", client2));
		investment2.setInvestValue(151d);
        database.put(20L, investment2);
    }
    
	@Override
	public Investment consult(Long id) {
		return database.get(id);
	}

	@Override
	public Investment insert(Investment investment) {
		investment.setId(30L);
		database.put(30L, investment);
		return investment;
	}

}
