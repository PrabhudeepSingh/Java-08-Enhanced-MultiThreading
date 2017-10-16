class ThreadGroupDemo2
{
  public static void main(String[] args)
  {
    ThreadGroup g1=new ThreadGroup("first group");
    System.out.println(g1.getParent().getName());

    ThreadGroup g2=new ThreadGroup(g1,"second group");
    System.out.println(g2.getParent().getName());
  }
}

