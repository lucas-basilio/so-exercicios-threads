package controller;

import java.text.DecimalFormat;

public class ThreadLoop extends Thread{

    private int value;
    private int[] vet;

    public ThreadLoop (int value, int[] vet) {
        this.value = value;
        this.vet = vet;
    }

    private void timeVet() {
        double initialTime, finalTime;

        if (this.value % 2 == 0)
        {
            initialTime = System.nanoTime();
            for (int i = 0; i < this.vet.length; i++) {}
            finalTime = System.nanoTime();
        }
        else
        {
            initialTime = System.nanoTime();
            for (int i : this.vet) {}
            finalTime = System.nanoTime();
        }

        String decimal = new DecimalFormat("0.000000000").format(((finalTime - initialTime) / Math.pow(10, 9)));

        System.out.println((this.value % 2 == 0 ? "Tempo percorrido em par: " : "Tempo percorrido em impar: ") + decimal + ".s");
    }

    @Override
    public void run() {
        timeVet();
    }
}
