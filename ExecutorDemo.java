import java.util.concurrent.*;
class PrintJob implements Runnable
{
   String name;
   PrintJob(String name)
   {
     this.name=name;
   }
   public void run()
   {
      System.out.println(name+"...job started by thread "+Thread.currentThread().getName());
      try
      {
        Thread.sleep(5000);
      }
      catch(InterruptedException e){}
      System.out.println(name+"...job completed by thread "+Thread.currentThread().getName());
   }
}

class ExecutorDemo
{
  public static void main(String[] args)
  {
    PrintJob[] jobs={new PrintJob("Prabhu"),
                     new PrintJob("Deep"),
                     new PrintJob("Singh"),
                     new PrintJob("Banga"),
                     new PrintJob("Aman"),
                     new PrintJob("Khalsa")};
					 
     ExecutorService service=Executors.newFixedThreadPool(3);
	 
     for(PrintJob job:jobs)
     {
		service.submit(job);
	 }
     service.shutdown();
  }
}