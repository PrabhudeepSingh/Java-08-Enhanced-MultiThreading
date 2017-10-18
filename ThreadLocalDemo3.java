class CustomerThread extends Thread
{
  static Integer custId=0;
  private static ThreadLocal t=new ThreadLocal()
  {
     protected Integer initialValue()
     {
       return ++custId;
     }
  };
  
  CustomerThread(String name)
  {
	super(name);
  }
  
  public void run()
  {
    System.out.println(Thread.currentThread().getName()+" executing with customer id  "+ t.get());
  }
}

class ThreadLocalDemo3
{
  public static void main(String[] args)
  {
    CustomerThread cThread1=new CustomerThread("customer Thread1");
    CustomerThread cThread2=new CustomerThread("customer Thread2");
    CustomerThread cThread3=new CustomerThread("customer Thread3");     
    CustomerThread cThread4=new CustomerThread("customer Thread4");
    CustomerThread cThread5=new CustomerThread("customer Thread5");
	
    cThread1.start();
    cThread2.start();
    cThread3.start();
    cThread4.start();
    cThread5.start();
  }
}