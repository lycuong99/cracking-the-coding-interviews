public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        final Thread separateThread = new Thread(new ThreadPrinter());
        separateThread.start(); // Bắt đầu chạy luồng mới
        for (int i = 0; i < 5; i++) {
            System.out.println("Từ luồng chính: " + Thread.currentThread().getName());
            Thread.sleep(1000);
        }
    }
}

class ThreadPrinter implements Runnable{
    @Override
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Từ luồng mới: " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}