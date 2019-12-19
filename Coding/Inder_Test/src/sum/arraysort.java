package sum;

public class arraysort {

	public static void main(String[] b)
	{
	int[] a= {10,70,90,40,50,30,20};
	for (int i=0; i<6;i++)
	{
		if (a[i]< a[i+1])
		{
			int c=a[i+1];
			a[i+1]=a[i];
			a[i]=c;
		}
	}
	System.out.println(a[2]);
	}

}
