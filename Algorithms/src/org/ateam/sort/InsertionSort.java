
package org.ateam.sort;

public class InsertionSort
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int[] array = {100, 8, 1, 25, 22};
		insertionSort(array);
		for(int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + " ");
		}
		System.out.println();

	}

	public static void insertionSort(int[] array)
	{
		int j = 0;
		int temp = 0;
		for(int i = 1; i < array.length; i++)
		{
			j = i;
			temp = array[j];
			while(j > 0 && temp < array[j - 1])
			{
				array[j] = array[j - 1];
				j--;
			}
			array[j] = temp;
		}
	}

}
