//package com.bootapp.rest.restapp;
//
//import static org.mockito.Mockito.when;
//
//import java.util.Optional;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.mockito.junit.jupiter.MockitoSettings;
//import org.mockito.quality.Strictness;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.bootapp.rest.restapp.data.CustomerRepository;
//import com.bootapp.rest.restapp.model.Customer;
//import com.bootapp.rest.restapp.service.CustomerService;
//
//
//@SpringBootTest
//@ExtendWith(MockitoExtension.class)
//@MockitoSettings(strictness = Strictness.LENIENT)
//public class CustomerServiceTest {
//
//	@Autowired
//	@InjectMocks
//	private CustomerService customerService;
//	
//	@Mock
//	private CustomerRepository customerRepository; 
//
//	@Test
//	public void getCustomerByIdTest(){
//		Customer customer = new Customer();
//		customer.setName("Vara");;
//		//convert customer object into Optional
//		when(customerRepository.findById(19)).thenReturn(Optional.of(customer));
//		Assertions.assertEquals("Vara", customerService.getCustomerById(19).get().getName());
//	}
//}