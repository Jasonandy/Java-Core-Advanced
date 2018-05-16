package cn.ucaner.core.concurrent;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class CallableDemo {
	
    public static void main(String[] args) {
    	
        ExecutorService exec = Executors.newCachedThreadPool();
        
        ArrayList<Future<String>> results = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            results.add(exec.submit(new TaskWithResult(i)));
        }

        for (Future<String> fs : results) {
            try {
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                System.out.println(e);
                e.printStackTrace();
            } catch (ExecutionException e) {
                System.out.println(e);
                e.printStackTrace();
            } finally {
                exec.shutdown();
            }
        }
    }
}

class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result of TaskWithResult  " + id;
    }
}
//Outputs
//result of TaskWithResult  0
//result of TaskWithResult  1
//result of TaskWithResult  2
//result of TaskWithResult  3
//result of TaskWithResult  4
//result of TaskWithResult  5
//result of TaskWithResult  6
//result of TaskWithResult  7
//result of TaskWithResult  8
//result of TaskWithResult  9