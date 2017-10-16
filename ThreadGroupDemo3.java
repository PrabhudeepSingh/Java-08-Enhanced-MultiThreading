class ThreadGroupDemo3
{
  public static void main(String[] args)
  {
    java.lang.ThreadGroup g1=new java.lang.ThreadGroup("tg");
    Thread t1=new Thread(g1,"Thread1");
    Thread t2=new Thread(g1,"Thread2");
    g1.setMaxPriority(3);

    Thread t3=new Thread(g1,"Thread3");
    System.out.println(t1.getPriority());
    System.out.println(t2.getPriority());
    System.out.println(t3.getPriority());
  }
}
  