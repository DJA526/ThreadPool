package thread_pool;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Worker implements Runnable {
	
	private ArrayDeque<Task> taskQueue;
	
	public Worker(ArrayDeque<Task> taskQueue) {
		this.taskQueue = taskQueue;
	}
	
	@Override
	public void run() {
		while (taskQueue.size() > 0) {
			//taskQueue.get(taskQueue.size() - 1).perform();
			taskQueue.remove().perform();
		}
	}


}
