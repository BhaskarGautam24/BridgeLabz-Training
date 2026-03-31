import java.util.*;
class TaskRunner extends Thread{
    TaskRunner(String name) {
        super(name);
    }
    public void run(){
        try {
            for (int i = 0; i < 1000000; i++){
                int x = i * i;
            }
            Thread.sleep(2000);
            for (int i = 0; i < 500000; i++){
                int y = i + 10;
            }

        } catch (InterruptedException e){
            System.out.println(getName() + " interrupted");
        }
    }
}
class StateMonitor extends Thread{
    TaskRunner t1;
    TaskRunner t2;
    int t1States = 0;
    int t2States = 0;
    StateMonitor(TaskRunner t1, TaskRunner t2){
        this.t1 = t1;
        this.t2 = t2;
    }
    public void run() {
        boolean monitoring = true;
        while (monitoring) {
            System.out.println("[Monitor] " + t1.getName() +
                    " is in " + t1.getState() +
                    " state at " + new Date());
            t1States++;
            System.out.println("[Monitor] " + t2.getName() +
                    " is in " + t2.getState() +
                    " state at " + new Date());
            t2States++;
            if (t1.getState() == Thread.State.TERMINATED &&
                t2.getState() == Thread.State.TERMINATED) {
                monitoring = false;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Monitor interrupted");
            }
        }
        System.out.println("\nSummary:");
        System.out.println(t1.getName() + " went through " + t1States + " state checks");
        System.out.println(t2.getName() + " went through " + t2States + " state checks");
    }
}
public class ThreadStateMonitoringSystem {

    public static void main(String[] args) {
        TaskRunner task1 = new TaskRunner("Task-1");
        TaskRunner task2 = new TaskRunner("Task-2");
        System.out.println("[Main] " + task1.getName() + " initial state: " + task1.getState());
        System.out.println("[Main] " + task2.getName() + " initial state: " + task2.getState());
        StateMonitor monitor = new StateMonitor(task1, task2);
        task1.start();
        task2.start();
        monitor.start();
    }
}

