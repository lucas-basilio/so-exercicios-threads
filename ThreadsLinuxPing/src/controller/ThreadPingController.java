package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ThreadPingController extends Thread{
    private String url;
    private String name;

    public ThreadPingController (String url, String name)
    {
        this.url = url;
        this.name = name;
    }

    public void ping () {
        String command = "ping -4 -c 10 " + this.url;
        String line = "";
        StringBuffer media = new StringBuffer();

        try
        {
            InputStream stream = Runtime.getRuntime().exec(command).getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            line = reader.readLine();
            int counter = 1;

            while (line != null)
            {
                String currentLine = reader.readLine();

                if (currentLine != null)
                {
                    line = currentLine;
                    System.out.println(counter + " " + this.name + ": " +  line.split("time=")[1]);
                    counter++;
                }
                else
                {
                    media.append(this.name);
                    media.append(": ");
                    media.append(line.split("/")[4]);
                    media.append("ms");
                }
            }

            stream.close();
            reader.close();
            System.out.println(media);
        }
        catch (Exception ex)
        {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void run () {
        ping();
    }
}
