package model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

@MappedSuperclass
public class BasicModel {

	private long id;
	
	public BasicModel() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_geral")
	@SequenceGenerator(name = "sequence_geral", sequenceName = "sequence_geral", allocationSize = 1)
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
