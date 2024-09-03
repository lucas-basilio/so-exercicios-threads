package view;
import controller.ThreadFrog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException
    {
        int positionInt = 1;
        int raceDistance = 100;
        int maxLeapDistance = (int)(Math.random() * 10 + 1);

        List<String> position = new ArrayList<>();
        ExecutorService exec = Executors.newFixedThreadPool(5);
        CompletionService<Long> completion = new ExecutorCompletionService<>(exec);

        for (int x = 0; x < 5; x++)
        {
            ThreadFrog frog = new ThreadFrog(maxLeapDistance, raceDistance);

            Callable<Long> task = () ->
            {
                frog.start();
                frog.join(1000);
                position.add(frog.frogName);
                return frog.threadId();
            };
            completion.submit(task);
        }

        //TODO: Remover gambiarra
        exec.shutdown();
        while (position.size() < 5) { boolean verify = exec.awaitTermination(1, TimeUnit.MINUTES); }

        System.out.println("\nColocação dos sapos: ");
        for (String item : position)
        {
            System.out.println("Sapo " + item + ": " + positionInt + "º lugar");
            positionInt++;
        }
    }
}
