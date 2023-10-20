package guru.springfamework.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Customer {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;

	private String firstName;
	private String lastName;
}
