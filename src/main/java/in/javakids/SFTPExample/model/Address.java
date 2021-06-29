/**
 * 
 */
package in.javakids.SFTPExample.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author ab68478
 *
 */
@Entity
@Table(name = "address")
@XmlRootElement
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long id;
	@Column(name = "addressline1")
	private String addressline1;
	@Column(name = "city")
	private String city;
	
	@ManyToOne
	@JoinColumn(name = "employee_Id")
	@XmlTransient
	private Employee employee;

	public Address() {
	}

	public Address(String addressline1, String city) {
		super();
		this.addressline1 = addressline1;
		this.city = city;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the addressline1
	 */
	public String getAddressline1() {
		return addressline1;
	}

	/**
	 * @param addressline1 the addressline1 to set
	 */
	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the employee
	 */
	@XmlTransient
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	

}
