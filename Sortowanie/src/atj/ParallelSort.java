package atj;

import java.util.Arrays;

public class ParallelSort implements ISort {

	@Override
	public void sort(double [] array) {
		Arrays.parallelSort(array);
		
	}

}
