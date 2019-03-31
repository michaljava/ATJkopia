package model;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeeCRUD {
	private EntityManagerFactory entityManagerFactory;

	EmployeeCRUD() {
		entityManagerFactory = Persistence.createEntityManagerFactory("FirstJPA");
	}

	public void createEmployee(Employee employee) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Override
	public void finalize() {
		entityManagerFactory.close();
	}

	public void updateSalary() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Employee employee = entityManager.find(Employee.class, new BigDecimal(100));
		employee.setSalary( BigDecimal.valueOf(employee.getSalary().intValue()*1.1) );
		entityManager.getTransaction().commit();
		entityManager.close();

	}
}
