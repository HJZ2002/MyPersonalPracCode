package MyPracCodeProcess;

public class Algo_stuff {

	public static void main(String[] args) {
		Algo_stuff time = new Algo_stuff();
		System.out.println(time.sumofN(10));
		System.out.println(time.sumofN2(10));
		
		long start =System.nanoTime();
		System.out.println(time.sumofN2(10));
		long end =System.nanoTime();
		System.out.println("Time units\t:"+(end-start));
	}
	public int sumofN(int N) {
		return (N*(N+1))/2;//
	}
	public int sumofN2(int N) {
		long start =System.nanoTime();
		
		int sum =0; //1
		
		for(int i = 1; i<=N; i++) {
			sum+=i;//n1
		long end = System.nanoTime();
		}
		return sum;
	}
}
