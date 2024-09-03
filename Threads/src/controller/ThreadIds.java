package controller;

public class ThreadIds extends Thread{

    private int threadId;

    public ThreadIds(int idThread)
    {
        this.threadId = idThread;
    }

    @Override
    public void run()
    {
        System.out.println(this.threadId());
    }
}
