import java.util.concurrent.locks.*;

class Display
{
  ReentrantLock reLock=new ReentrantLock();
  public void wish(String name)
  {
    reLock.lock();
    for(int i=0;i<10;i++)
    {
      System.out.print("good morning");
      try
      {
        Thread.sleep(2000);
      }
      catch(InterruptedException e){}
      System.out.println(name);
    }
    reLock.unlock();
  }
}

class MyThread extends Thread
{
  Display display;
  String name;
  MyThread(Display display,String name)
  {
    this.display=display;
    this.name=name;
  }
  public void run()
  {
    display.wish(name);
  }
}

class ReentrantLockDemo2
{
  public static void main(String[] args)
  {
    Display display=new Display();
    MyThread thread1=new MyThread(display," Prabhu"); 
    MyThread thread2=new MyThread(display," Deep"); 
    MyThread thread3=new MyThread(display," Singh"); 
    thread1.start();
    thread2.start();
    thread3.start();
  }
}