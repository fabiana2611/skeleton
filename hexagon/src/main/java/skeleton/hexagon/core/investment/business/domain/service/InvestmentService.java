package skeleton.hexagon.core.investment.business.domain.service;

import skeleton.hexagon.core.client.business.domain.type.TypeClient;
import skeleton.hexagon.core.investment.business.domain.model.Investment;

public class InvestmentService {

	public void process(Investment investment) {
		
		if(TypeClient.INDIVIDUAL.equals(investment.getContract().getClient().getType()) &&
				investment.getValue()  > 100){
			
			investment.setInvestValue(100d);
			
		} else if(TypeClient.COMPANY.equals(investment.getContract().getClient().getType()) &&
				investment.getValue()  < 100){
			
			investment.setInvestValue(100d);
		} else {
			
			investment.setInvestValue(investment.getValue());
		}
		
	}
}
