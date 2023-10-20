package guru.springfamework.service;

import java.util.List;

import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.domain.Customer;

public interface CustomerService {
	
	List<CustomerDTO> getAllCustomers();
	CustomerDTO getFindById(Long id);
	CustomerDTO saveAndReturnDto(Customer customer);
	CustomerDTO createNewCustomer(CustomerDTO customerDTO);
	CustomerDTO updateCustomer(CustomerDTO customerDTO,Long id);
	CustomerDTO pathCustomer(CustomerDTO customerDTO, Long id);
	CustomerDTO pathCustomer2(CustomerDTO customerDTO, Long id);
	void deteteCustomerById(Long iSd);

}
