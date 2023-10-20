package guru.springfamework.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import guru.springfamework.api.v1.mapper.CustomerMapper;
import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	private final CustomerRepository customerRepository;
	private final CustomerMapper customerMapper; 

	public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
		this.customerRepository = customerRepository;
		this.customerMapper = customerMapper;
	}

	@Override
	public List<CustomerDTO> getAllCustomers() {
		return customerRepository.findAll()
				.stream()
				.map(customer ->{
					CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);
					customerDTO.setCustomUrl("/api/v1/customers/"+customer.getId());
				return customerDTO;
				})
				.collect(Collectors.toList());
	}

	@Override
	public CustomerDTO getFindById(Long id) {
		return customerRepository.findById(id).map(customerMapper::customerToCustomerDTO).orElseThrow(RuntimeException::new);
	}

	@Override
	public CustomerDTO saveAndReturnDto(Customer customer) {
		Customer customerSaved = customerRepository.save(customer);
		CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customerSaved);
		customerDTO.setCustomUrl("/api/v1/customers/"+customerSaved.getId());
		return customerDTO;
	}

	@Override
	public CustomerDTO createNewCustomer(CustomerDTO customerDTO) {
		return saveAndReturnDto(customerMapper.customerDtoToCustoer(customerDTO));
	}

	@Override
	public CustomerDTO updateCustomer(CustomerDTO customerDTO,Long id) {
		Customer customer = customerMapper.customerDtoToCustoer(customerDTO);
		customer.setId(id);
		return saveAndReturnDto(customer);
	}

	@Override
	public void deteteCustomerById(Long id) {
		customerRepository.deleteById(id);
	}

	@Override
	public CustomerDTO pathCustomer(CustomerDTO customerDTO, Long id) {
		CustomerDTO customerDTO2 =  this.getFindById(id);
		Customer customer = customerMapper.customerDtoToCustoer(customerDTO2);
		customer.setFirstName(customerDTO.getFirstName());
		return saveAndReturnDto(customer);
	}
	
	public CustomerDTO pathCustomer2(CustomerDTO customerDTO, Long id) {
		return customerRepository.findById(id).map(customer -> {
			
			if(customerDTO.getFirstName() != null) {
				customer.setFirstName(customerDTO.getFirstName());
			}
			
			if(customerDTO.getLastName() != null) {
				customer.setLastName(customerDTO.getLastName());
			}
			
			CustomerDTO retrunDTO = customerMapper.customerToCustomerDTO(customer);
			retrunDTO.setCustomUrl("/api/v1/customers/"+id);
			return retrunDTO;
		}).orElseThrow(RuntimeException::new);
				
	}
}
