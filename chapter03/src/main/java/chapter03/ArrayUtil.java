package chapter03;

import java.util.Iterator;

public class ArrayUtil {

	public static double[] intToDouble(int[] arr1) {
		double[] doubleArr = new double[arr1.length];
		for (int i = 0; i < arr1.length; i++) {
			doubleArr[i] = arr1[i];
		}

		return doubleArr;
	}

}
