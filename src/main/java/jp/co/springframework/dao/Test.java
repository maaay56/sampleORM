package jp.co.springframework.dao;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.Table;
import org.springframework.data.annotation.Id;


@Table(appliesTo = "test")
public class Test {

	@Id
	@Generated(value=GenerationTime.ALWAYS)
	private long id;

	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
