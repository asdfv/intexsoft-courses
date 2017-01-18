package controller;

@RestController
public class TestController {
	
	@RequestMapping("/hi")
	String hello() {
		return "Hello man!";
	}

}
