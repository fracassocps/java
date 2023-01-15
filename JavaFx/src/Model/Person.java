package Model;

import java.io.Serializable;

public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	public Person(String name, Integer id, String email) {
		super();
		this.name = name;
		this.id = id;
		this.email = email;
	}
	private String name;
	private Integer id;
	private String email;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", id=" + id + ", email=" + email + "]";
	}
}
