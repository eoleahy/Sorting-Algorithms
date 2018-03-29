import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
//-------------------------------------------------------------------------
/**
 * Test class for SortComparison.java
 *
 * @author Eoin Leahy
 * @version HT 2018
 * 
 * 
 *** Algorithm Comparison *** 
 *  Time is in Milliseconds
 * 
 * 				|  Insert  |  Quick   |  Merge  |  Shell  | Selection | Bubble
 * -------------|----------|----------|---------|---------|-----------|--------
 * 10 random 	|    .599  |   .688	  |	  .599	|	.675  |    .607   |   .701
 * 100 random	|    .780  |   .727	  |	  .672	|	.686  |    .640	  |   .773
 * 1000 random 	|   7.020  |  2.028	  |	 1.771	|  2.086  |	  9.548	  | 12.009 
 * 1000 few uni	|   6.913  |  1.671	  |	 1.826	|  1.730  |	  8.374	  | 15.059
 * 1000 nearly	|   2.655  |  1.672	  |	 1.415	|  2.194  |	  8.798	  | 10.180
 * 1000 reverse |  11.613  |  1.497	  |	 1.461	|  1.583  |	  9.458	  | 15.011
 * 1000 sorted  |	 .998  |  1.446   |  1.472  |  1.112  |	  9.763	  |  7.959
 * 
 *** Questions ***
 * 1) The order of input has the greatest effect on Insertion Sort. We 
 * 	  can see the largest difference in running time between 1000 reverse
 *    and 1000 sorted when sorted with the Insertion algorithm.
 *    
 * 2) Again, with Insertion sort we can see that the running time is 
 *    increased by a factor of 10 when comparing the worst case
 *    (1000 reverse) and best case (1000 sorted).
 *  
 * 3) The algorithm with the best scalability is Merge Sort. Merge's
 *    running time increases by just over a second when used with an
 *    input 10 times larger.
 *    The algorithm with the worse scalabililty is clearly Bubble sort.
 *    
 * 4) The fastest algorithm overall is Merge sort.  
 *    
 */
@RunWith(JUnit4.class)
public class SortComparisonTest {
	// ~ Constructor ........................................................
	@Test
	public void testConstructor() {
		new SortComparison();
	}

	// ~ Public Methods ........................................................

	// ----------------------------------------------------------
	/**
	 * Check that the methods work for empty arrays
	 */
	@Test
	public void testEmpty() {
		
		double []a = new double[0];
		SortComparison.insertionSort(a);
		
	}

	@Test
	public void testInsertionSort() throws IOException{
		
		//Testing with size = 1000
		double []a = createArray("numbers1000.txt",1000);
		double [] correctArray = Arrays.copyOf(a, a.length);
		
		Arrays.sort(correctArray);
	
		
		SortComparison.insertionSort(a);
		assertEquals(Arrays.toString(a), Arrays.toString(correctArray));
			
	}
	
	@Test
	public void testBubbleSort() throws IOException{
		double []a = createArray("numbers1000.txt", 1000);
		double [] correctArray = Arrays.copyOf(a, a.length);						
		Arrays.sort(correctArray);		
		SortComparison.bubbleSort(a);
		assertEquals(Arrays.toString(a), Arrays.toString(correctArray));
		
		
	}
	@Test
	public void testSelection() throws IOException{
		double []a = createArray("numbers1000.txt", 1000);
		double [] correctArray = Arrays.copyOf(a, a.length);		
		Arrays.sort(correctArray);	
		SortComparison.selectionSort(a);
		assertEquals(Arrays.toString(correctArray), Arrays.toString(a));
		
		
	}
	@Test
	public void testQuickSort() throws IOException{
		double []a = createArray("numbers1000.txt", 1000);
		double []correctArray = Arrays.copyOf(a, a.length);
		Arrays.sort(correctArray);
		SortComparison.quickSort(a);
		assertEquals(Arrays.toString(a), Arrays.toString(correctArray));
	}
	@Test
	public void testMergeSort() throws IOException{
		double []a = createArray("numbers1000.txt", 1000);
		double []correctArray = Arrays.copyOf(a, a.length);		
		Arrays.sort(correctArray);
		SortComparison.mergeSort(a);
		assertEquals(Arrays.toString(a),Arrays.toString(correctArray));
		
	}
	@Test
	public void testShellSort() throws IOException{
		double []a = createArray("numbers1000.txt", 1000);
		double []correctArray = Arrays.copyOf(a, a.length);
		Arrays.sort(correctArray);
		SortComparison.shellSort(a);
		assertEquals(Arrays.toString(a), Arrays.toString(correctArray));
		
		
	}

	// TODO: add more tests here. Each line of code and each decision in
	// Collinear.java should
	// be executed at least once from at least one test.

	// ----------------------------------------------------------
	/**
	 * Main Method. Use this main method to create the experiments needed to
	 * answer the experimental performance questions of this assignment.
	 * @throws IOException 
	 *
	 */
	public static void main(String[] args) throws IOException {
		
		
	/*  
	 *  Code used to test the speed of each algorithm. It has
	 *  been commented out as the submission system won't accept
	 *  the custom stopwatch class.
	 * 
		StopWatch stopWatch;
		double[]a = createArray("numbersReverse1000.txt",1000);
		stopWatch = new StopWatch();
		stopWatch.start();
		SortComparison.bubbleSort(a);
		System.out.println("Elapsed time: " + stopWatch.toString());		
	*/	
		
		
	}
	
	static double[] createArray(String filename, int length) throws FileNotFoundException{
		Scanner scanner = new Scanner(new FileInputStream(filename));
		
		double[] a = new double[length];
		int i =0;
		while(scanner.hasNextDouble()){
			a[i++] = scanner.nextDouble();
		}
		scanner.close();
		return a;
		
	}

}
