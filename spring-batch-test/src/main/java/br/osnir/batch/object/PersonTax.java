package br.osnir.batch.object;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;

/**
 * @author Osnir F CUNHA
 * 
 */
@JsonAutoDetect(fieldVisibility=Visibility.ANY)
public class PersonTax {
    
	private Person person = new Person();
	
	private boolean isFree;
	
	private double tax;
	
	private Date date;

	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * @return the isFree
	 */
	public boolean isFree() {
		return isFree;
	}

	/**
	 * @return the tax
	 */
	public double getTax() {
		return tax;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}

	/**
	 * @param isFree the isFree to set
	 */
	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}

	/**
	 * @param tax the tax to set
	 */
	public void setTax(double tax) {
		this.tax = tax;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
