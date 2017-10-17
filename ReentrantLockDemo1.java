import java.util.concurrent.locks.*;

class ReentrantLockDemo1
{
  public static void main(String[] args)
  {
     ReentrantLock reLock= new ReentrantLock();
	 
     reLock.lock();
     reLock.lock();
     System.out.println(reLock.isLocked());
     System.out.println(reLock.isHeldByCurrentThread());
     System.out.println(reLock.getQueueLength());
	 
     reLock.unlock();
     System.out.println(reLock.getHoldCount());
     System.out.println(reLock.isLocked());
	 
     reLock.unlock();
     System.out.println(reLock.isLocked());
     System.out.println(reLock.isFair());
   }
}