package atj;

import java.time.Duration;
import java.time.Instant;

public class TestSort {

	ISort method;

	public long test(double[] array) {
		Instant start = Instant.now();
		method.sort(array);
		return Duration.between(start, Instant.now()).toNanos();
	}

	public void setMethod(BubbleSort bubbleSort) {
		method = bubbleSort;

	}

	public void setMethod(ParallelSort parallelSort) {
		method = parallelSort;

	}

	public void setMethod(ListSort listSort) {
		method = listSort;

	}

}
