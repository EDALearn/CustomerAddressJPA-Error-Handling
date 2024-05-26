package io.zenwave360.example.customer.base;

import io.zenwave360.example.customer.config.DockerComposeInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@DockerComposeInitializer.EnableDockerCompose
@ActiveProfiles("test")
@org.springframework.transaction.annotation.Transactional
public abstract class BaseConsumerTest {

	@Autowired
	protected WebApplicationContext context;

}
