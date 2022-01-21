package TestSuitExample;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
	@RunWith(Suite.class)
	@Suite.SuiteClasses({
		Testclass.class,
		TestClass2.class
	})
public class TestUnit{
}
