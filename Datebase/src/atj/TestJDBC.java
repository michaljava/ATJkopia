package atj;

public class TestJDBC {

	public static void main(String[] args) {
		
	    OraConnTest oraJDBC = new OraConnTest();
	    oraJDBC.getConnection("jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf", "mchmura", "mchmura");
	    oraJDBC.testConnection();
	}
}