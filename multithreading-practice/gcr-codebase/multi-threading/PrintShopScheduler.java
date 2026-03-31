class PrintJob implements Runnable{
    String jobName;
    int pages;
    int priority;
    PrintJob(String jobName,int pages,int priority){
        this.jobName=jobName;
        this.pages=pages;
        this.priority=priority;
    }
    String getPriorityLabel(){
        if (priority>=7){
            return "High Priority";
        } else if (priority >= 5){
            return "Medium Priority";
        } else{
            return "Low Priority";
        }
    }
    public void run(){
        for (int i=1;i<=pages;i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Printing interrupted");
            }

            System.out.println("[" + getPriorityLabel() + "] Printing " +
                    jobName + " - Page " + i + " of " + pages);
        }
    }
}
public class PrintShopScheduler{
    public static void main(String[] args){
        long startTime=System.currentTimeMillis();
        System.out.println("Starting print jobs");
        PrintJob j1 = new PrintJob("Job1", 10, 5);
        PrintJob j2 = new PrintJob("Job2", 5, 8);
        PrintJob j3 = new PrintJob("Job3", 15, 3);
        PrintJob j4 = new PrintJob("Job4", 8, 6);
        PrintJob j5 = new PrintJob("Job5", 12, 7);
        Thread t1 = new Thread(j1, "Job1");
        Thread t2 = new Thread(j2, "Job2");
        Thread t3 = new Thread(j3, "Job3");
        Thread t4 = new Thread(j4, "Job4");
        Thread t5 = new Thread(j5, "Job5");
        t1.setPriority(j1.priority);
        t2.setPriority(j2.priority);
        t3.setPriority(j3.priority);
        t4.setPriority(j4.priority);
        t5.setPriority(j5.priority);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        long endTime = System.currentTimeMillis();
        System.out.println("\nAll jobs completed in " +
                (endTime - startTime) + " ms");
    }
}

