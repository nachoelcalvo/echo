package io.switchbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/echo")
public class EchoController {

	private static final Logger log = LoggerFactory.getLogger(EchoController.class);

	private RestTemplate restTemplate;

	public EchoController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	//Change for toggles
	@GetMapping(path = "/{message}")
	public String echo(@PathVariable String message) {
		log.info("Sending echo message: {}", message);

		return message + " you !!";
	}


	@PostMapping
	public String echoPost(@RequestBody String message) {
		log.info("Sending echo message: {}", message);

		ResponseEntity<String> response = restTemplate
				.postForEntity("http://chamber:8080/chamber", message, String.class);

		return response.getBody();
	}

}
