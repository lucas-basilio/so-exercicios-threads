package controller;

import java.util.Arrays;

public class ThreadsArray extends Thread{

    private int[] array;

    public ThreadsArray(int[] array)
    {
        this.array = array;
    }

    private int sum(int index) {

        try
        {
            return this.array[index] + sum(index + 1);
        }
        catch (ArrayIndexOutOfBoundsException ex)
        {
            return 0;
        }
    }

    @Override
    public void run() {

        System.out.println("Resultado da Thread " + this.threadId() + ": " + sum(0));
    }
}
