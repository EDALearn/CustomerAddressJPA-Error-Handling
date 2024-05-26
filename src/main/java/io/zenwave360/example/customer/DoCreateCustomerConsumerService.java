package io.zenwave360.example.customer;

import io.zenwave360.example.customer.commands.*;
import io.zenwave360.example.customer.commands.IDoCreateCustomerConsumerService.CustomerHeaders;
import io.zenwave360.example.customer.events.dtos.*;
import io.zenwave360.example.customer.mappers.EventsMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

@Component
@AllArgsConstructor
public class DoCreateCustomerConsumerService implements IDoCreateCustomerConsumerService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	private final EventsMapper mapper = EventsMapper.INSTANCE;

	private final CustomerService service;

	/** */
	public void doCreateCustomer(Customer payload, CustomerHeaders headers) {
		log.debug("Received command request for doCreateCustomer: {} with headers {}", payload, headers);
		service.createCustomer(mapper.asCustomer(payload));
	};
}
