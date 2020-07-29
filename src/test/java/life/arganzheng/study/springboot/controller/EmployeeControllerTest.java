package life.arganzheng.study.springboot.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class EmployeeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void testGetAllEmployees() throws Exception {
		this.mockMvc.perform(get("/employees")).andDo(print()) //
				.andExpect(status().isOk()) //
				.andExpect(jsonPath("$.length()", is(3)));

	}

	@Test
	void testGetEmployeeById() throws Exception {
		this.mockMvc.perform(get("/employees/1")).andDo(print()) //
				.andExpect(status().isOk()) //
				.andExpect(jsonPath("$.email").value("abc@gmail.com"));

	}

	@Test
	void testGetEmployeeById_NotFound() throws Exception {
		this.mockMvc.perform(get("/employees/4")).andDo(print()) //
				.andExpect(status().isNotFound());
	}

}
