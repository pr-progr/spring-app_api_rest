package guru.springfamework.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.api.v1.model.CustomerListDTO;
import guru.springfamework.service.CustomerService;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
	
	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping()
	@ResponseStatus(value = HttpStatus.OK)
	
	public CustomerListDTO getAllCustomers(){
		return new CustomerListDTO(customerService.getAllCustomers());
	}
	
	@GetMapping("{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public CustomerDTO getCustomerById(@PathVariable Long id){
		return customerService.getFindById(id);
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public CustomerDTO creatNewCustomer(@RequestBody CustomerDTO customerDTO){
		return customerService.createNewCustomer(customerDTO);
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@PutMapping("{id}")
	public CustomerDTO updateCustomer(@RequestBody CustomerDTO customerDTO , @PathVariable Long id){
		return customerService.updateCustomer(customerDTO,id);
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@PatchMapping("{id}")
	public CustomerDTO patchCustomer(@RequestBody CustomerDTO customerDTO , @PathVariable Long id) {
		return customerService.pathCustomer2(customerDTO, id);
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@DeleteMapping("{id}")
	public void deleteById(@PathVariable Long id) {
		customerService.deteteCustomerById(id);
	}
	
}