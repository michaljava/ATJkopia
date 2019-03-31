package atj.ws;

public class Main {

	public static void main(String[] args) {
		Calc calc = new CalcService().getCalcPort();
		System.out.println("1 + 2 = " + calc.add(1, 2));
		System.out.println("1 -	2 = " + calc.sub(1, -2));
		System.out.println("9 * 7 = " + calc.mul(9, 7));
		System.out.println("3 / 0 = " +	calc.div(3, 0));
	}

}
