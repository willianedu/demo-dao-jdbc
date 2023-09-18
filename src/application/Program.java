package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("===teste 1: Seller findById ===");
		
		Seller seller = sellerDao.findById(3);

		System.out.println(seller);
		
        System.out.println("\n===teste 2: Seller findByDepartment ===");
        Department department = new Department(2,null);
		
		List<Seller> list = sellerDao.findByDepartment(department);
		
		for(Seller s : list) {
			System.out.println(s);
		}
		 System.out.println("\n===teste 3: Seller findByAll ===");
		 list = sellerDao.findAll();
		 for(Seller s : list) {
			 System.out.println(s);
		 }
		 System.out.println("\n===teste 4: Seller insert ===");
		 Seller newSeller = new Seller(null, "Greg", "greg@hotmail.com", new Date(), 4000.0, department);
		 sellerDao.insert(newSeller);
		 System.out.println("Inserted! New Id = " + newSeller.getId());
		 
		 System.out.println("\n===teste 5: Seller update ===");
		 seller = sellerDao.findById(1);
		 seller.setName("Martha  Waine");
		 sellerDao.update(seller);
		 System.out.println("Updated completed!");
		 
		 System.out.println("\n===teste 6: Seller delete ===");
		 System.out.println("Enter id for delete test:");
		 int id = sc.nextInt();
		 sellerDao.deleteById(id);
		 System.out.println("Seller deleted!");
		 sc.close();
	}
}