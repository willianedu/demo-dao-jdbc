package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

public class Program2 {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("===teste 1: Department findById ===");
		
		Department department = departmentDao.findById(3);

		System.out.println(department);
		
		 System.out.println("\n===teste 2: Department findByAll ===");
		 List <Department> list = departmentDao.findAll();
		 for(Department dep : list) {
			 System.out.println(dep);
		 }
		  System.out.println("\n===teste 3: Department insert ===");
		 Department newDepartment = new Department(null, "Food");
		 departmentDao.insert(newDepartment);
		 System.out.println("Inserted! New Id = " + newDepartment.getId()); 
		 
		  System.out.println("\n===teste 4: Department update ===");
		 department = departmentDao.findById(1);
		 department.setName("Atletic");
		 departmentDao.update(department);
		 System.out.println("Updated completed!");
		 
		  System.out.println("\n===teste 5: Department delete ===");
		 System.out.println("Enter id for delete test:");
		 int id = sc.nextInt();
		 departmentDao.deleteById(id);
		 System.out.println("Department deleted!");
		 sc.close(); 
	}
}
