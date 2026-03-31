public class BackgroundJob {
    public static void main(String[] args){
        Runnable job = () ->{
            System.out.println("Background job started");
            System.out.println("Task is running in background");
            System.out.println("Background job finished");
        };
        Thread thread = new Thread(job);
        thread.start();
        System.out.println("Main thread continues execution");
    }
}

