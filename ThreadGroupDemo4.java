class MyThread extends Thread
{
  MyThread(ThreadGroup g,String name)
  {super(g,name);}
  public void run()
  {
    System.out.println("child thread");
    try
    {
      Thread.sleep(5000);
    }
    catch(InterruptedException e){}
  }
}

class ThreadGroupDemo4
{
  public static void main(String[] args)throws Exception
  {
    ThreadGroup pg=new ThreadGroup("Parent group");
    ThreadGroup cg=new ThreadGroup(pg,"Child group");
    MyThread thread1=new MyThread(pg,"child thread1");
    MyThread thread2=new MyThread(pg,"child thread2");

    thread1.start();
    thread2.start();

    System.out.println(pg.activeCount());
    System.out.println(pg.activeGroupCount());
    pg.list();
    Thread.sleep(10000);

    System.out.println(pg.activeCount());
    System.out.println(pg.activeGroupCount());
    pg.list();
  }
}
    