//package com.bootapp.rest.restapp.controller;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.bootapp.rest.restapp.data.AccountRepository;
//import com.bootapp.rest.restapp.exception.ResourceNotFoundException;
//import com.bootapp.rest.restapp.model.Account;
//import com.bootapp.rest.restapp.model.Customer;
//import com.bootapp.rest.restapp.model.Executive;
//import com.bootapp.rest.restapp.service.AccountService;
//import com.bootapp.rest.restapp.service.CustomerService;
//import com.bootapp.rest.restapp.service.ExecutiveService;
//import com.bootapp.rest.restapp.service.TransactionService;
//
//@RestController
//@RequestMapping("/api/account")
//public class AccountController {
//	@Autowired
//	private AccountService accountService;
//	@Autowired
//	private CustomerService customerService;
//	@Autowired
//	private ExecutiveService executiveService;
//	@Autowired
//	private AccountRepository accountRepository;
//	@Autowired
//	private TransactionService transactionService;
//	
//
//	@PostMapping("/add/{cid}/{eid}")
//	public ResponseEntity<String> assignExecutiveToCustomer(@RequestBody Account account, @PathVariable("cid") int cid,
//			@PathVariable("eid") int eid) {
//
//		Optional<Customer> optionalC = customerService.getCustomerById(cid);
//		if (!optionalC.isPresent())
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Customer Id is given");
//
//		Optional<Executive> optionalE = executiveService.getExecutiveById(eid);
//		if (!optionalE.isPresent())
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Executive Id is given");
//
//		Customer customer = optionalC.get();
//		Executive executive = optionalE.get();
//
//		account.setCustomer(customer);
//		account.setExecutive(executive);
//
//		accountService.insert(account);
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Account assigned");
//	}
//
//	@PutMapping("/update/{id}")
//	public ResponseEntity<Account> updateAccount(@PathVariable int id, @RequestBody Account accountDetails)
//			throws ResourceNotFoundException {
//		Account account = accountService.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("Account does not exist with id: " + id));
//
//		account.setAccountBalance(accountDetails.getAccountBalance());
//		account.setAccountType(accountDetails.getAccountType());
//
//		final Account updatedAccount = accountRepository.save(account);
//		return ResponseEntity.ok(updatedAccount);
//	}
//	
//	
//	@GetMapping("/executive/{eid}")
//	 public List<Account> showAccountByExecutiveId(@PathVariable("eid")int eid){
//	 List<Account> list=accountService.getAccountByExecutiveId(eid);
//	 return list;
//	}
//	
//	
//	@DeleteMapping("/delete/{id}")
//	public Map<String, Boolean> deleteAccount(@PathVariable int id) throws ResourceNotFoundException {
//		Account account = accountService.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("Account not found for this id :: " + id));
//
//		accountService.deleteId(id);
//		Map<String, Boolean> response = new HashMap<>();
//		response.put("deleted", Boolean.TRUE);
//		return response;
//	}
//	
//	
//
//}
