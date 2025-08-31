package library.utils;

public class BackgroundTask extends Thread {
    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("[Background Task] Running maintenance...");
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            System.out.println("Background task interrupted.");
        }
    }
}
