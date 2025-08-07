package fil.ipint.resaconcert.controller;

import static org.junit.jupiter.api.Assertions.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.assertj.core.api.Assertions.assertThat;


import com.fasterxml.jackson.databind.ObjectMapper;
	
import fil.ipint.resaconcert.service.ConcertServiceImpl;

@SpringBootTest
@AutoConfigureMockMvc
class ConcertControllerTest {

	@Autowired
	ConcertServiceImpl concertService;
	
	private String ctrlUrl = "/concert";
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	
	@Test
	void testGetConcertById() throws Exception {
		
		concertService.createConcert("ConcertTest", 10L);
		
		String url = ctrlUrl + "1";
		
		MvcResult mvcResult = mockMvc
				.perform(get(url))
				.andExpect(status().is2xxSuccessful())
				.andReturn();
		
		String actualResult = mvcResult.getResponse().getContentAsString();
		
		assertThat(actualResult.contains("1"));
	}
	
}
