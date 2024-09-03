package view;

import controller.ThreadLoop;

public class Main {
    public static void main (String[] args)
    {
        int[] vet = new int[1000];

        for (int i = 0; i < vet.length; i++)
        {
            vet[i] = (int)(Math.random() * 100 + 1);
        }

        Thread firstThread = new ThreadLoop(1, vet);
        Thread secondThread = new ThreadLoop(2, vet);

        firstThread.start();
        secondThread.start();
    }
}
