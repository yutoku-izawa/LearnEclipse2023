package example.com.bean;

import java.io.Serializable;
import java.sql.Date;

public class Director implements Serializable {
	private int id;
	private String name;
	private Date birth;

	public Director() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String toString() {
		return id + ":" + name + ":" + birth;
	}
}
