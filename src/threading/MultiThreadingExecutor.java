package threading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MultiThreadingExecutor {

	public static void main(String[] args) {
		
		/**
		 *  Thread executor class explained thread pool
		 */
		//threadExecutors();
		
		
		/**
		 * invoke all in executor thread pool
		 * this method executes all the threads before executing main thread.
		 */
		invokeAll();
		
		
		
	}

	private static void threadExecutors() {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		Future<Integer> future = executor.submit(()->{
			System.out.println(Thread.currentThread().getName() + " --> " + Thread.currentThread().getId());
			return 123;
		});
		
		try {
			System.out.println(Thread.currentThread().getName() + " --> " + Thread.currentThread().getId());
			System.out.println(future.get());
			System.out.println(Thread.currentThread().getName() + " --> " + Thread.currentThread().getId());
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		} catch (ExecutionException e) {
			
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " --> " + Thread.currentThread().getId());
		
		
	}
	
	
	private static Callable<String> callable(String result, long sleepSeconds) {
	    return () -> {
	    	System.out.println(Thread.currentThread().getName() + " --> " + Thread.currentThread().getId());
	        TimeUnit.SECONDS.sleep(sleepSeconds);
	        return result;
	    };
	}

	private static void invokeAll() {
		ExecutorService executor = Executors.newFixedThreadPool(100);
		List<Callable<String>> callables = Arrays.asList(
				 callable("task1", 0),
				    callable("task2", 0),
				    callable("task3", 0));
		
		
			try {
			List<Future<String>> listOfFuture = 	executor.invokeAll(callables);
			listOfFuture.forEach(item->{
				if(item.isDone()){
				
						try {
							System.out.println(item.get());
						} catch (InterruptedException | ExecutionException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
			}
				});
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		System.out.println(Thread.currentThread().getName() + " --> " + Thread.currentThread().getId());
	

}
}
