import java.util.concurrent.locks.*;
import java.util.concurrent.*;

class MyThread extends Thread
{
  static ReentrantLock reLock=new ReentrantLock();
  MyThread(String name)
  {
	super (name);
  }
  
  public void run()
  { 
    do
    {
      try
      {
        if(reLock.tryLock(5000,TimeUnit.MILLISECONDS))
        {
           System.out.println(Thread.currentThread().getName()+" got luck");
           Thread.sleep(3000);
           reLock.unlock();
           System.out.println(Thread.currentThread().getName()+" release luck");
           break;
        }
        else
        {
          System.out.println(Thread.currentThread().getName()+" unable to got luck & will try again");
        }
      }
      catch(Exception e){}
    }
    while (true);
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