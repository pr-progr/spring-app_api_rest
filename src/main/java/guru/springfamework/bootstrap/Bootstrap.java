package guru.springfamework.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springfamework.domain.Category;
import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CategoryRepository;
import guru.springfamework.repositories.CustomerRepository;

@Component
public class Bootstrap implements CommandLineRunner {
	
	private CategoryRepository categoryRepository;
	private CustomerRepository customerRepository;
	
	


	public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
		this.categoryRepository = categoryRepository;
		this.customerRepository = customerRepository;
	}


	@Override
	public void run(String... args) throws Exception {
		loadCategory();
		loadCustomers();
	
	
	}


	private void loadCategory() {
		Category fruits = new Category();
		fruits.setName("Fruits");
		
		Category dried = new Category();
		dried.setName("Dried");
	
		Category fresh = new Category();
		fresh.setName("Fresh");
	
		Category exotic = new Category();
		exotic.setName("Exotic");
	
		Category nuts = new Category();
		nuts.setName("Nuts");
		
	categoryRepository.save(fruits);
	categoryRepository.save(dried);
	categoryRepository.save(fresh);
	categoryRepository.save(exotic);
	categoryRepository.save(nuts);
	
	System.out.println("Data Loaded " + categoryRepository.count());
	}
	

	private void loadCustomers() {
		Customer customer1 = new Customer();
		customer1.setId(1L);
		customer1.setFirstName("Add");
		customer1.setLastName("Dss");
		
		Customer customer2 = new Customer();
		customer2.setId(2L);
		customer2.setFirstName("Add_2");
		customer2.setLastName("Dss_2");
		
		customerRepository.save(customer1);
		customerRepository.save(customer2);
	
	System.out.println("Data Loaded " + customerRepository.count());
	}
}

