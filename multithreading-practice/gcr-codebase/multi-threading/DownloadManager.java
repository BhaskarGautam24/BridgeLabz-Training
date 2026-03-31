public class DownloadManager{
    static class FileDownloaderThread extends Thread{
        String fileName;
        FileDownloaderThread(String fileName) {
            this.fileName = fileName;
        }
        public void run(){
            for (int progress=0;progress<=100;progress+=25){
                try{
                    Thread.sleep(500 + (int)(Math.random() * 500));
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted");
                }
                System.out.println("[" + Thread.currentThread().getName() +"] Downloading " + fileName + ": " + progress + "%");
            }
        }
    }
    static class FileDownloaderRunnable implements Runnable {
        String fileName;
        FileDownloaderRunnable(String fileName) {
            this.fileName = fileName;
        }
        public void run() {
            for (int progress = 0; progress <= 100; progress += 25) {
                try {
                    Thread.sleep(500 + (int)(Math.random() * 500));
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted");
                }
                System.out.println("[" + Thread.currentThread().getName() +
                        "] Downloading " + fileName + ": " + progress + "%");
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("=== Download using Thread class ===");
        FileDownloaderThread t1 =new FileDownloaderThread("Document.pdf");
        FileDownloaderThread t2 =new FileDownloaderThread("Image.jpg");
        FileDownloaderThread t3 =new FileDownloaderThread("Video.mp4");
        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        System.out.println("All downloads complete!");
        System.out.println("\n=== Download using Runnable interface ===");
        FileDownloaderRunnable r1 =new FileDownloaderRunnable("Document.pdf");
        FileDownloaderRunnable r2 =new FileDownloaderRunnable("Image.jpg");
        FileDownloaderRunnable r3 =new FileDownloaderRunnable("Video.mp4");
        Thread rt1 = new Thread(r1, "Thread-1");
        Thread rt2 = new Thread(r2, "Thread-2");
        Thread rt3 = new Thread(r3, "Thread-3");
        rt1.start();
        rt2.start();
        rt3.start();

        try {
            rt1.join();
            rt2.join();
            rt3.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        System.out.println("All downloads complete!");
    }
}

