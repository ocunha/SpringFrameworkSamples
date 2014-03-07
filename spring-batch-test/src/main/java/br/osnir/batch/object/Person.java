package br.osnir.batch.object;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;



/**
 * 
 * @author Osnir F CUNHA
 *
 */
@JsonAutoDetect(fieldVisibility=Visibility.ANY)
public class Person {
	
	private String name;
	
	private long id;
	
	private double salary;
	
	private int dependents;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * @return the dependents
	 */
	public int getDependents() {
		return dependents;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

	/**
	 * @param dependents the dependents to set
	 */
	public void setDependents(int dependents) {
		this.dependents = dependents;
	}

}
