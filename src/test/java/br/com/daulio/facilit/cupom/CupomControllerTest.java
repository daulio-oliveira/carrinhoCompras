package br.com.daulio.facilit.cupom;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class CupomControllerTest {

	@Autowired private MockMvc mockMvc;
	
	@BeforeAll
	private void setUp()  throws ParseException{
		
	}

	@Test
	@Order(1)
	void testCadastro() {

	}

	@Test
	@Order(2)
	void testAlteracao() {

	}
	
	@Test
	@Order(3)
	void testListarPorId() {
	
	}
	
	@Test
	@Order(4)
	void testListarTodos() {
		
	}
	
	@Test
	@Order(5)
	void testExcluir() {
		
	}

}
