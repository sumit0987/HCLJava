package com.demo.batchinsertion;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.demo.batchinsertion.entity.Employee;

@SpringBootApplication
public class DemobatchinsertionApplication implements CommandLineRunner{
	
	@Autowired
	ResourceLoader resLoader;
	
	@Autowired
	SessionFactory sessionFactory;
	

	public static void main(String[] args) throws IOException {
		SpringApplication.run(DemobatchinsertionApplication.class, args);
		
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Resource resource = resLoader.getResource("classpath:EmployeeInformation.xlsx");
		
				ExcelReader reader = new ExcelReader();
			    List<Employee> listemployees = reader.readFromEmployeeSheet(resource.getFile().getAbsolutePath());
			    System.out.println(listemployees.size());
			    for (Employee employee : listemployees) {
					System.out.println("Sl no: "+employee.getSlNo()+"--"+"Name : "+employee.getName()+"--"+"Age : "+employee.getAge()+"--"+"Gender : "+employee.getGender()+"--"+"Salary : "+employee.getSalary());
					sessionFactory.getCurrentSession().persist(employee);
				}
			    
	}

}
