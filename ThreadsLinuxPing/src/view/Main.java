package view;

import controller.ThreadPingController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args)
    {
        Map<String, String> list = new HashMap<String, String>();

        list.put("UOL", "www.uol.com.br");
        list.put("Terra", "www.terra.com.br");
        list.put("Google", "www.google.com.br");

        for (Map.Entry<String, String> item  : list.entrySet())
        {
            ThreadPingController thread = new ThreadPingController(item.getValue(), item.getKey());
            thread.start();
        }
    }
}
