package aleksa;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainClass {
	static int a[];
	public static void F(int a[], int n, int t) {
		ExecutorService executor = Executors.newFixedThreadPool(t);
		Worker[] workers = new Worker[t];
		int d = n/t;
		for(int i = 0; i < t; i++) {
			workers[i] = new Worker(a, i*d, (i == t - 1 ? n - 1 : (i + 1) * d - 1));
		}
		for(int i  = 0; i < t; i++) {
			executor.submit(workers[i]);
		}
		
		executor.shutdown();
		
		try {
			executor.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Is Progression? " + (Worker.isProgression ? "true" : "false"));
	}
	public static void main(String[] args) {
		int n = 8;
		int t = 2;
		int[] a = new int[n];
		a[0] = 2;
		a[1] = 4;
		a[2] = 6;
		a[3] = 8;
		a[4] = 10;
		a[5] = 12;
		a[6] = 14;
		a[7] = 16;
		F(a, n, t);
	}

}
