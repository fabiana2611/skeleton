package skeleton.hexagon.core.investment.business.usecase.imp;

import static java.util.Objects.isNull;
import static skeleton.hexagon.core.common.exception.Error.required;

import skeleton.hexagon.core.investment.business.domain.model.Investment;
import skeleton.hexagon.core.investment.business.domain.service.InvestmentService;
import skeleton.hexagon.core.investment.business.port.IInvestmentRepository;
import skeleton.hexagon.core.investment.business.usecase.IPortInvertmentService;

public class PortInvestmentServiceImp implements IPortInvertmentService {

	IInvestmentRepository repository;
	InvestmentService investmentService;
	
    // Ioc por construtor
    public PortInvestmentServiceImp(IInvestmentRepository repository, InvestmentService investmentService) {
        this.repository = repository;
        this.investmentService = investmentService;
    }
    
	@Override
	public Investment getInvestment(Long id) {
		return repository.consult(id);
	}

	@Override
	public Investment inset(Investment investment) {
		
		if(isNull(investment.getContract())){
			required("contract"); 
		}
		
		investmentService.process(investment);
		return repository.insert(investment);
	}

}
