package atj;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		long bubbleTime = 0, parallelTime = 0, quickTime = 0;

		TestSort ts = new TestSort();

		for (int i = 0; i < 1000; ++i) {
			double[] array = randomArray();

			ts.setMethod(new BubbleSort());
			bubbleTime += ts.test(Arrays.copyOf(array, array.length));

			ts.setMethod(new ParallelSort());
			parallelTime += ts.test(Arrays.copyOf(array, array.length));

			ts.setMethod(new ListSort());
			quickTime += ts.test(Arrays.copyOf(array, array.length));
		}
		final double DIV = Math.pow(10, 6);
		System.out.println("Bubble sort time [ms]: " + bubbleTime / DIV);
		System.out.println("Parallel sort time [ms]: " + +parallelTime / DIV);
		System.out.println("List sort time [ms]: " + quickTime / DIV);

	}

	static double[] randomArray() {
		double[] array = new double[1000];
		for (int i = 0; i < 1000; ++i) {
			array[i] = Math.random() * 100;
		}
		return array;
	}
}
