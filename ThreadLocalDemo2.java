class ThreadLocalDemo2
{
  public static void main(String[] args)
  {
     ThreadLocal thread=new ThreadLocal()
     {
       public Object initialValue()
       {
       return "abc";
       }
     };

     System.out.println(thread.get());
     thread.set("Prabhudeep");
     System.out.println(thread.get());
	 
     thread.remove();
     System.out.println(thread.get());
  }
}