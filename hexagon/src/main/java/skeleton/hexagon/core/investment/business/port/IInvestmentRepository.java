package skeleton.hexagon.core.investment.business.port;

import skeleton.hexagon.core.investment.business.domain.model.Investment;

public interface IInvestmentRepository {

	public Investment consult(Long id);
	
	public Investment insert(Investment investment);
}
