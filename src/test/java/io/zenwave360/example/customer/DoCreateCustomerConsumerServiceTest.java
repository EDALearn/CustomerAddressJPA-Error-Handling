package io.zenwave360.example.customer;

import io.zenwave360.example.customer.base.BaseConsumerTest;
import io.zenwave360.example.customer.commands.*;
import io.zenwave360.example.customer.commands.IDoCreateCustomerConsumerService.CustomerHeaders;
import io.zenwave360.example.customer.events.dtos.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/** Integration tests for {@link IDoCreateCustomerConsumerService}. */
public class DoCreateCustomerConsumerServiceTest extends BaseConsumerTest {

	@Autowired
	public IDoCreateCustomerConsumerService consumerService;

	/** Test for doCreateCustomer: */
	@Test
	public void doCreateCustomerTest() {
		Customer payload = new Customer();
		payload.setId(null);
		payload.setUsername(null);
		payload.setEmail(null);
		payload.setAddress(null);

		CustomerHeaders headers = new CustomerHeaders();

		// invoke the method under test
		consumerService.doCreateCustomer(payload, headers);
		// perform your assertions here
	}

}
