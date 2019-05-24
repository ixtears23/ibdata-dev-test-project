package ibdata.com.tdd.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

	@GetMapping(value = "/home")
	public String home() {
		return "home";
	}
}
