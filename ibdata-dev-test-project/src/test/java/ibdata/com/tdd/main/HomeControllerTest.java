package ibdata.com.tdd.main;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import ibdata.com.tdd.config.web.DispatcherConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = DispatcherConfig.class)
public class HomeControllerTest {
	
	@Autowired
	private WebApplicationContext wac;
	
	MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc =  MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void shouldHomeUrlRequestIsOkAndViewNameIsHome() throws Exception {
		
		mockMvc.perform(get("/{home}.do", "home"))
				.andDo(print())
			.andExpect(view().name("home"))
			.andExpect(status().isOk())
			.andReturn();
		
	}
	
	@Test
	public void shouldLoginUrlRequestIsOkAndViewNameIsLogin() throws Exception {
		
		mockMvc.perform(get("/{login}.do", "login"))
				.andDo(print())
			.andExpect(status().isOk())
			.andExpect(view().name("login"));
	}
	
}
