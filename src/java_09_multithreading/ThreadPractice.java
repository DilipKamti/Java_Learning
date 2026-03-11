package java_09_multithreading;

public class ThreadPractice extends  Thread {

    private final Object lock = new Object();

    void SleepingThread(){
        synchronized (lock){
            try{
                System.out.println(Thread.currentThread().getName()+ "thread is going to sleep...");
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName()+ "thread woke up!");

            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    void WaitedThread(){
        synchronized (lock){
            try{
                System.out.println(Thread.currentThread().getName()+ "thread is waiting...");
                lock.wait();
                System.out.println(Thread.currentThread().getName()+ "thread resumed after wait!");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    void NotifyThread(){
        synchronized (lock){
            System.out.println(Thread.currentThread().getName()+ " acquired lock and calling notify()");
            lock.notify();
            System.out.println(Thread.currentThread().getName()+ " finished notify and releasing lock");
        }
    }


    static void main() throws InterruptedException {

        System.out.println(Thread.currentThread().getName() + " is starting the main method...");

        ThreadPractice obj= new ThreadPractice();

        Thread t1= new Thread(obj::SleepingThread, "SleepingThread");
        Thread t2= new Thread(obj::WaitedThread, "WaitedThread");
        Thread t3= new Thread(obj::NotifyThread, "NotifyThread");

        t1.start();
        sleep(2000);

        t2.start();
        sleep(4000);

        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println(Thread.currentThread().getName() + " is ending the main method...");
    }
}
