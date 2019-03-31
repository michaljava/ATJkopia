package atj;
import javax.enterprise.context.Dependent;

@Dependent
@QStrongPasswordGenerator
public class StrongPasswordGenerator extends PasswordGenerator {

	@Override
	public String generate() {
		
		return "A1a+M@-K0ta";
	}

}
