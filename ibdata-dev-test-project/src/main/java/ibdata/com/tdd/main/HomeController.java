package ibdata.com.tdd.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@GetMapping(value = "/{home}.do")
	public String home(@PathVariable(name="home", required = true) String home) {
		logger.debug("Home Controller 진입");
		return home;
	}
}
