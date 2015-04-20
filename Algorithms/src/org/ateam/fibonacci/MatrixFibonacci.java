
package org.ateam.fibonacci;

/**
 * 
 * @author swapneel.sawant <br>
 *         http://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
 * 
 */
public class MatrixFibonacci
{

	public static int fibonacci(int n)
	{
		if(n < 2)
			return n;
		int[][] f = { {1, 1}, {1, 0}};
		int[][] m = { {1, 1}, {1, 0}};

		for(int i = 2; i < n; i++)
		{
			maxtricMultipication(f, m);
		}
		return f[0][0];

	}

	public static int fibonacciByDivideConquer(int n)
	{
		if(n < 2)
			return n;
		int[][] f = { {1, 1}, {1, 0}};
		power(f, n - 1);
		return f[0][0];

	}

	private static void power(int[][] f, int n)
	{
		if(n == 0 || n == 1)
			return;

		power(f, n / 2);
		maxtricMultipication(f, f);

		int m[][] = { {1, 1}, {1, 0}};
		if(n % 2 != 0)
			maxtricMultipication(f, m);
	}

	private static void maxtricMultipication(int[][] f, int[][] m)
	{
		System.out.println("CALLED");
		int x = f[0][0] * m[0][0] + f[0][1] * m[1][0];
		int y = f[0][0] * m[0][1] + f[0][1] * m[1][1];
		int z = f[1][0] * m[0][0] + f[1][1] * m[1][0];
		int w = f[1][0] * m[0][1] + f[1][1] * m[1][1];

		f[0][0] = x;
		f[0][1] = y;
		f[1][0] = z;
		f[1][1] = w;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		//27 : 196418
		// int 2 raise 31 - 1  2147483647
		// long 2 raises to 63 -1 9223372036854775807L
		System.out.println(fibonacciByDivideConquer(10));
		System.out.println(fibonacci(10));
	}

}
