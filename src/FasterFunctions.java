
public class FasterFunctions {
	public static void main(String[] args) {
		float totalTime = 0;
		long startTime = System.currentTimeMillis();
		//Your Code Here
		SlowFunctions fast = new SlowFunctions();
		Thread t1 = new Thread(()-> {
			System.out.println("Starting slowSortLargeArray()...");
			SlowFunctions.slowSortLargeArray();
			System.out.println("slowSortLargeArray() Complete.");
			});
		Thread t2 = new Thread(()-> {
			System.out.println("Starting ackermann(3, 14)...");
			System.out.println("ackermann(3, 14): " + SlowFunctions.ackermann(3, 14));
			System.out.println("ackermann(3, 14) Complete.");
		});
		Thread t3 = new Thread (()-> {
			System.out.println("Starting millionsOfSqrts()...");
			SlowFunctions.millionsOfSqrts();
			System.out.println("millionsOfSqrts() Complete.");
		});
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		float endTime = (float)((double)System.currentTimeMillis() - (double)startTime) / 1000.0f;
		totalTime += endTime;
		System.out.println("Total Time: " + totalTime + "\n\n");
	}
}
