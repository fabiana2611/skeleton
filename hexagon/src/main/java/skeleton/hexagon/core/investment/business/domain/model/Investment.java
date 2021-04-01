package skeleton.hexagon.core.investment.business.domain.model;

import skeleton.hexagon.core.common.exception.BusinessException;
import skeleton.hexagon.core.contract.business.domain.model.Contract;

public class Investment {

	private Long id;
	
	private Contract contract;
	
	private double value;
	
	private double investValue;
	
	public Investment(Contract contract) {
		this.contract = contract;
	}
	
	public void invest(double value) {
		
		if(value <= 0.0) {
			throw new BusinessException("Investment have to be more than zero.");
		}
		
		this.value = value;
	}

	public Contract getContract() {
		return contract;
	}

	public double getValue() {
		return value;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public double getInvestValue() {
		return investValue;
	}

	public void setInvestValue(double investValue) {
		this.investValue = investValue;
	}
	
	
}
