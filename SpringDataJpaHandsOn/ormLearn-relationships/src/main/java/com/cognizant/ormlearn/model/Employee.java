package com.cognizant.ormlearn.model;





import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name = "Employee")
@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	private String name; 
	private double salary; 
	private boolean permanent; 
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	@ManyToOne
	@JoinColumn(name="em_dp_id")
	private Department department;
	@ManyToMany
	@JoinTable(name = "employee_skill",joinColumns = @JoinColumn(name="es_em_id"),inverseJoinColumns = @JoinColumn(name="es_sk_id"))
	private Set<Skill> skillList;
	
	
	public Set<Skill> getSkillList() {
		return skillList;
	}

	public void setSkillList(Set<Skill> skillList) {
		this.skillList = skillList;
	}

	public Employee(int id, String name, double salary, boolean permanent, Date dateOfBirth, Department department) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.permanent = permanent;
		this.dateOfBirth = dateOfBirth;
		this.department = department;
	}
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public boolean isPermanent() {
		return permanent;
	}
	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", permanent=" + permanent
				+ ", dateOfBirth=" + dateOfBirth + "]";
	}

	

	



	
}
