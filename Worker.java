package aleksa;

public class Worker implements Runnable{
	private int a[];
	private int l,r;
	public static volatile Boolean isProgression = true;
	
	
	public Worker(int[] a, int l, int r) {
		super();
		this.a = a;
		this.l = l;
		this.r = r;
	}


	@Override
	public void run() {
		int minus = 0;
		minus = a[1] - a[0];
		for(int i = l + 1; i < r && isProgression; i++) {
			if(a[i + 1] - a[i] != minus) {
				isProgression = false;
			}
		}
	}

}
