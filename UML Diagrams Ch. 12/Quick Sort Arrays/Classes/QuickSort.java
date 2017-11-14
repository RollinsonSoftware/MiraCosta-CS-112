/**
 Class that realizes the divide and conquer sorting pattern and uses
 the quick sort algorithm, more comments on page 701 of the book.
 */
public class QuickSort
{
	public static void sort(double[] a, int begin, int end)
	{
		if((end - begin) >= 3) //array has 3 or more index's
		{
			int splitPoint = split(a, begin, end);
			sort(a, begin, splitPoint);
			sort(a, splitPoint + 1, end);
			//join(a, begin, splitPoint, end);
		}
		else if(a.length == 2) //array has 2 index's
		{
			double temp;
			
			if(a[begin] <= a[begin + 1])
			{
				//values are already sorted.
			}
			else if(a[begin] > a[begin + 1])
			{
				temp = a[begin];
				a[begin] = a[begin + 1];
				a[begin + 1] = temp;			
			}
		}
		else //array has 1 index
		{
			//array only has one value, so no sorting needed.
		}
	}
	public static int split(double[] a, int begin, int end)
	{
		double[] temp;
		int size = (end - begin + 1);
		temp = new double[size];
		
		double splitValue = (a[begin] + a[end] + a[size/2]) / 3;
		int up = 0;
		int down = size - 1;
		
		for (int i = begin + 1; i <= end; i++)
		{
			if(a[i] <= splitValue)
			{
				temp[up] = a[i];
				up++;
			}
			else
			{
				temp[down] = a[i];
				down--;
			}
		}
		temp[up] = a[begin]; //positions the split value.
		
		for(int i = 0; i < size; i++)
		{
			a[begin + i] = temp[i];
		}
		return (begin + up);
	}
	private static void join(double[] a, int begin, int splitPoint, int end)
	{
		//nothing to do??
	}
}