import java.util.concurrent.locks.*;

class MyThread extends Thread
{
  static ReentrantLock reLock=new ReentrantLock();
  MyThread(String name)
  {super (name);}
  public void run()
  {
    if(reLock.tryLock())
    {
      System.out.println(Thread.currentThread().getName()+" got lock and performing safe operation");
      try
      {
        Thread.sleep(2000);
      }
      catch(InterruptedException e){}
      reLock.unlock();
    }
    else
    {
      System.out.println(Thread.currentThread().getName()+" unable to get lock and hence performing alternative operation");
    }
  }
}

class ReentrantLockDemo3
{
  public static void main(String[] args)
  {
    MyThread thread1=new MyThread("first thread ");
    MyThread thread2=new MyThread("second thread ");
    thread1.start();
    thread2.start();
  }
}