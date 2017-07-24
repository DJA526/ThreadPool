package thread_pool;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class ThreadPool {
	
	private int totalThreads;
	private Thread[] threads;
	private ArrayDeque<Task> taskQueue;
	
	public ThreadPool(int totalThreads) {
		this.totalThreads = totalThreads;
		this.taskQueue = new ArrayDeque<Task>();
		this.threads = new Thread[totalThreads];
		for(int i = 0; i < totalThreads; i++){
			threads[i] = new Thread(new Worker(taskQueue));
		}
	}
	
	public void addTask(Task task) {
		taskQueue.add(task);
	}
	
	public void start() {
		for (Thread t : threads) {
			t.start();
		}
		for (Thread t : threads) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
