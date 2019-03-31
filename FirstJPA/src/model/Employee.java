package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the EMPLOYEES database table.
 * 
 */
@Entity
@Table(name="EMPLOYEES")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	private long employeeId;
	private BigDecimal commissionPct;
	private BigDecimal departmentId;
	private String email;
	private String firstName;
	private Object hireDate;
	private String jobId;
	private String lastName;
	private String phoneNumber;
	private BigDecimal salary;
	private Employee employee;
	private List<Employee> employees;

	public Employee() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="EMPLOYEE_ID", unique=true, nullable=false, precision=6)
	public long getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}


	@Column(name="COMMISSION_PCT", precision=2, scale=2)
	public BigDecimal getCommissionPct() {
		return this.commissionPct;
	}

	public void setCommissionPct(BigDecimal commissionPct) {
		this.commissionPct = commissionPct;
	}


	@Column(name="DEPARTMENT_ID", precision=4)
	public BigDecimal getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(BigDecimal departmentId) {
		this.departmentId = departmentId;
	}


	@Column(nullable=false, length=25)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Column(name="FIRST_NAME", length=20)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
//	@Temporal(TemporalType.DATE) 
////	@Column(name="HIRE_DATE", nullable=false)
//	public Object getHireDate() {
//		return this.hireDate;
//	}
//
//	public void setHireDate(Object hireDate) {
//		this.hireDate = hireDate;
//	}


	@Column(name="JOB_ID", nullable=false, length=10)
	public String getJobId() {
		return this.jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}


	@Column(name="LAST_NAME", nullable=false, length=25)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	@Column(name="PHONE_NUMBER", length=20)
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	@Column(precision=8, scale=2)
	public BigDecimal getSalary() {
		return this.salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}


	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="MANAGER_ID")
	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="employee")
	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setEmployee(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setEmployee(null);

		return employee;
	}

}