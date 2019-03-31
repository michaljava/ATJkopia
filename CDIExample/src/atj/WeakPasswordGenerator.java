package atj;

import javax.enterprise.context.Dependent;
import atj.QWeakPasswordGenerator;
@Dependent
@QWeakPasswordGenerator

public class WeakPasswordGenerator extends PasswordGenerator {

	@Override
	public String generate() {
		
		return "AlaMaKota"; 
	}

}
