package view;

import controller.ThreadIds;

public class Main {
    public static void main(String[] args)
    {
        for (int x = 0; x < 5; x++)
        {
            Thread threads = new ThreadIds(x);
            threads.start();
        }
    }
}
