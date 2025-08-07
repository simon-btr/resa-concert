package fil.ipint.resaconcert.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fil.ipint.resaconcert.entity.Concert;

@SpringBootTest
class ConcertServiceImplTest {

	@Autowired
	ConcertServiceImpl concertService;
	
	@Test
	void testGetConcertById() throws Exception {
		concertService.createConcert("ConcertTest", 10L);
		Concert res = concertService.getConcertById( 1L );
		assertNotNull(res, "concert found");
		assertEquals(res.getId(), 1L);
	}


}
