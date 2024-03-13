package af2b.hibernum;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import br.com.af2b.hibernum.HibernumApplication;

@SpringBootTest(classes = HibernumApplication.class)
class HibernumApplicationTests {
	private ApplicationContext context;

	public HibernumApplicationTests(ApplicationContext context) {
		this.context = context;
	}

	@Test
	void contextLoads() {
		HibernumApplication.main(new String[] {});
		assertNotNull(context);
	}
}
