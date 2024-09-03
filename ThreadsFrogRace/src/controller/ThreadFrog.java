package controller;

public class ThreadFrog extends Thread implements Runnable{

    final int maxLeapDistance;
    public String frogName = Long.toString(this.threadId());
    final int raceDistance;
    private int distance = 0;

    public ThreadFrog (int maxLeapDistance, int raceDistance)
    {
        this.maxLeapDistance = maxLeapDistance;
        this.raceDistance = raceDistance;
    }

    private void race ()
    {
        while (distance < raceDistance)
        {
            int currentLeap = (int)(Math.random() * maxLeapDistance + 1);

            if (currentLeap + distance >= this.raceDistance)
            {
                distance = 100;
                System.out.println("O sapo " + frogName + " saltou " + currentLeap + "m, percorreu " + distance + "m e finalizou a corrida!");
                this.interrupt();
                return;
            }

            distance += currentLeap;
            System.out.println("O sapo " + frogName + " saltou " + currentLeap + "m e já percorreu " + distance + "m");
        }
    }

    @Override
    public void run ()
    {
        race();
    }
}
