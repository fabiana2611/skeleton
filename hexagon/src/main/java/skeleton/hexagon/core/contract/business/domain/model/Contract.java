package skeleton.hexagon.core.contract.business.domain.model;

import static java.util.Objects.isNull;
import static skeleton.hexagon.core.common.exception.Error.required;

import skeleton.hexagon.core.client.business.domain.Client;

public class Contract {

	private Long id;
	
	private String label;
	
	private Client client;
	
	public Contract() {
		
	}
	
	public Contract(String label, Client client) {
		this.label = label;
		this.client = client;
	}
	
	public void updateLabel(String label) {
		
		if(isNull(label)) {
			required("contract label");
		}
		
		this.label = label;
		
	}
	
	public void updateClient(Client client) {
		
		if(isNull(client)) {
			required("client");
		}
		
		this.client = client;
		
	}
	
	public Long getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public Client getClient() {
		return client;
	}

}
