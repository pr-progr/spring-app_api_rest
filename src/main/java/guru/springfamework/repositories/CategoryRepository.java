package guru.springfamework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import guru.springfamework.domain.Category;


public interface CategoryRepository extends JpaRepository<Category, Long>  {
	Category findByName(String name);

	default void loadCategory(String... args) throws Exception {
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
		
	save(fruits);
	save(dried);
	save(fresh);
	save(exotic);
	save(nuts);
	
	System.out.println("Data Loaded " + count());
	
	
	
	}
	
}
