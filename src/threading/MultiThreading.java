package threading;

public class MultiThreading implements Runnable {
	
	int a;
	

	public MultiThreading() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		
		System.out.println("Hi I am thread" + Thread.currentThread().getId() + " Name-->> " + Thread.currentThread().getName());

	}

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		for(int i = 0 ; i< 20 ;  i++){
			MultiThreading multiThreading = new MultiThreading();
			Thread t = new Thread(multiThreading);
			t.start();
		}
		System.out.println("End of main-->> "+  Thread.currentThread().getName());
	}
	
	

}
