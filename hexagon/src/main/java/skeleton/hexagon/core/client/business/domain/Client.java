package skeleton.hexagon.core.client.business.domain;

import skeleton.hexagon.core.client.business.domain.type.TypeClient;

public class Client {

	private Long id;
	
	private String name;
	
	private TypeClient type;
	
	public Client () {
		
	}

	public Client (String name, TypeClient type) {
		this.name = name;
		this.type = type;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TypeClient getType() {
		return type;
	}

	public void setType(TypeClient type) {
		this.type = type;
	}
	
}
