package com.springboot.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.config.domain.ApiLoanApplication;
import com.springboot.config.repo.ApiLoanApplicationRepository;
import com.springboot.model.ApprovalDetails;
import com.springboot.model.CustomerDetails;
import com.springboot.model.HelloWorld;

@RestController
public class HelloWorldController {

	@Autowired
	ApiLoanApplicationRepository apiLoanApplicationRepository;

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/hello")
	public HelloWorld helloworld(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new HelloWorld(counter.incrementAndGet(), String.format(template, name));
	}

	@RequestMapping(value = "/customerApproval", method = RequestMethod.POST)
	public ResponseEntity<ApprovalDetails> update(@RequestBody CustomerDetails customer) {
		//ApiLoanApplication application = apiLoanApplicationRepository.findByApplicationId("0000469751");
		//System.out.println("loan application jpa - " +application.toString());
		ApiLoanApplication application = new ApiLoanApplication();
		application.setCustomerName(customer.getFullName());
		application.setCustomerPostcode(customer.getPostCode());
		application.setAnnualIncome(customer.getAnnualIncome().toString());
		application.setLoanAmount(new BigDecimal(customer.getAmount()));
		application.setCustomerDob(customer.getDob());
		ApprovalDetails appDetails = new ApprovalDetails();
		appDetails.setApplicationRef(RandomStringUtils.randomNumeric(6).concat("80"));
		appDetails.setCustomerNumber("0007458980");
		application.setStatus("AIP");
		if (customer.getAnnualIncome() >= 20000) {
			appDetails.setDecision("Approved");
		} else if (customer.getAnnualIncome() <= 19999 && customer.getAnnualIncome() >= 10000) {
			appDetails.setDecision("Referred");
		} else {
			appDetails.setDecision("Decline");
		}
		
		application.setApplicationNumber(appDetails.getApplicationRef());
		application.setAipDecision(appDetails.getDecision());
		application.setApplicationId(RandomStringUtils.randomNumeric(6));
		
		application.setTimeDateCreated(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
		//String maxid = findMaxId();
		
		
		apiLoanApplicationRepository.save(application);
		return ResponseEntity.accepted().body(appDetails);

	}

	

	/*
	 * @RequestMapping("/hello") public String hello(Model model) {
	 * model.addAttribute("message", "Hello World"); return "hello"; }
	 */

}