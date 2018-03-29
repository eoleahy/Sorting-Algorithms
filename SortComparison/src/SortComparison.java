// -------------------------------------------------------------------------

/**
 * This class contains static methods that implementing sorting of an array of
 * numbers using different sort algorithms.
 *
 * @author Eoin Leahy
 * @version HT 2018
 */

class SortComparison {

	/**
	 * Sorts an array of doubles using InsertionSort. This method is static,
	 * thus it can be called as SortComparison.sort(a)
	 * 
	 * @param a: An unsorted array of doubles.
	 * @return array sorted in ascending order.
	 *
	 */
	static double[] insertionSort(double a[]) {
		int i, j;
		double index;
		for (i = 1; i < a.length; i++) {
			index = a[i];
			j = i;
			while ((j > 0) && (a[j - 1] > index)) {
				a[j] = a[j - 1];
				j = j - 1;
			}
			a[j] = index;
		}
		return a;

	}

	/**
	 * Sorts an array of doubles using Quick Sort. This method is static, thus
	 * it can be called as SortComparison.sort(a)
	 * 
	 * @param a: An unsorted array of doubles.
	 * 
	 * @return array sorted in ascending order
	 *
	 */
	static double[] quickSort(double[] a) {

		qSort(a, 0, a.length - 1);

		return a;
	}

	private static int partition(double a[], int left, int right)

	{

		int i = left;
		int j = right;

		double pivot = a[(left + right) / 2];
		while (i <= j) 
		{
			while (a[i] < pivot)
				i++;

			while (a[j] > pivot)
				j--;

			if (i <= j)
			{
				swap(a, i , j);
				i++;
				j--;
			}

		}

		return i;

	}

	private static void qSort(double a[], int left, int right) {

		int index = partition(a, left, right);

		if (left < index - 1)

			qSort(a, left, index - 1);

		if (index < right)

			qSort(a, index, right);

	}

	/**
	 * Sorts an array of doubles using Merge Sort. This method is static, thus
	 * it can be called as SortComparison.sort(a)
	 * 
	 * @param a: An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	public static double[] mergeSort(double a[]) {

		mSort(a, 0, a.length - 1);

		return a;
	}

	private static void mSort(double a[], int low, int high) {

		if (low < high) {
			int mid = low + (high - low) / 2;
			// Below step sorts the left side of the array
			mSort(a, low, mid);
			// Below step sorts the right side of the array
			mSort(a, mid + 1, high);
			// Now merge both sides
			merge(a, low, mid, high);
		}
	}

	private static void merge(double[] a, int low, int mid, int high) {

		double[] temp = new double[a.length];
		for (int i = low; i <= high; i++) {
			temp[i] = a[i];
		}
		int i = low;
		int j = mid + 1;
		int k = low;
		while (i <= mid && j <= high) {
			if (temp[i] <= temp[j]) {
				a[k] = temp[i];
				i++;
			} else {
				a[k] = temp[j];
				j++;
			}
			k++;
		}
		while (i <= mid) {
			a[k] = temp[i];
			k++;
			i++;
		}

	}

	/**
	 * Sorts an array of doubles using Shell Sort. This method is static, thus
	 * it can be called as SortComparison.sort(a)
	 * 
	 * @param a: An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	static double[] shellSort(double a[]) {
		int N = a.length;

		int h = 1;
		while (h < N / 3)
			h = (3 * h) + 1;

		while (h >= 1) { // h-sort the array
			for (int i = h; i < N; i++) {
				for (int j = i; j >= h && (a[j] < a[j - h]); j -= h)
					swap(a, j, j - h);
			}
			h = h / 3;
		}
		return a;
	} // end shell sort

	private static void swap(double[] a, int i, int j) {
		double swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	/**
	 * Sorts an array of doubles using Selection Sort. This method is static,
	 * thus it can be called as SortComparison.sort(a)
	 * 
	 * @param a: An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	static double[] selectionSort(double a[]) {

		double n = a.length;

		for (int i = 0; i < n - 1; i++) {
			int min_index = i;
			for (int j = i + 1; j < n; j++) {
				if (a[j] < a[min_index])
					min_index = j;
			}
			swap(a, min_index, i);
		}

		return a;
	}

	/**
	 * Sorts an array of doubles using Bubble Sort. This method is static, thus
	 * it can be called as SortComparison.sort(a)
	 * 
	 * @param a: An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	static double[] bubbleSort(double a[]) {

		int n = a.length;
		double temp = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (a[j - 1] > a[j]) {
					swap(a, j - 1, j);
				}
			}
		}
		return a;
	}


}// end class
