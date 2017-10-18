class ParentThread extends Thread
{
  public static InheritableThreadLocal t=new InheritableThreadLocal()
  {
    public Object childValue(Object b)
    {
      return "CC";
    }
  };
  
  public void run()
  {
    t.set("pp");
    System.out.println("parent thread value  "+ t.get());
    ChildThread c=new ChildThread();
    c.start();
  }
}

class ChildThread extends Thread
{
  public void run()
  {
    System.out.println("child thread value  "+ ParentThread.t.get());
  }
}

class ThreadLocalDemo4
{ 
  public static void main(String[] args)
  {
    ParentThread pThread = new ParentThread();
    pThread.start();
  }
}