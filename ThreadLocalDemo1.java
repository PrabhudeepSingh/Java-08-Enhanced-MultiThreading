class ThreadLocalDemo1
{
  public static void main(String[] args)
  {
     ThreadLocal thread=new ThreadLocal();
     System.out.println(thread.get());
	 
     thread.set("Prabhudeep");
     System.out.println(thread.get());
	 
     thread.remove();
     System.out.println(thread.get());
  }
}