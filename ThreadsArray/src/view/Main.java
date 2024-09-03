package view;

import controller.ThreadsArray;

public class Main {
    public static void main(String[] args)
    {
        int[][] array = new int[3][5];

        for (int x = 0; x < 3; x++)
        {
            for (int y = 0; y < 5; y++)
            {
                array[x][y] = (int)(Math.random() * 100 + 1);
            }
        }

        for (int[] item : array)
        {
            Thread thread = new ThreadsArray(item);
            thread.start();
        }

    }
}
