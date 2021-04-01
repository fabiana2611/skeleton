package skeleton.hexagon.core.investment.business.usecase;

import skeleton.hexagon.core.investment.business.domain.model.Investment;

public interface IPortInvertmentService {

	Investment getInvestment(Long id);
	
	Investment inset(Investment invetment);
}
