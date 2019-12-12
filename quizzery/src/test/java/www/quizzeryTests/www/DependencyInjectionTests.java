package www.quizzeryTests.www;

import java.sql.SQLException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationcontext.xml")
public class DependencyInjectionTests {
	
	
	@Inject
	String queryTest;
	
	@Inject
	@Named("dataSource")
	DataSource ds;
	
	@Test
	public void DIQueryTest(){
		
		Assert.assertNotNull(queryTest);
		System.out.println("return::"+queryTest);
	}
	
	@Test
	public void DIConnection() throws SQLException {
		
		Assert.assertNotNull(ds);
		System.out.println("DS connection::"+ds.getConnection());
	}

}
