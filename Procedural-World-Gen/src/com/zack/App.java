package com.zack;

import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

import com.zack.ui.WorldGUI;

public class App
{

    public static void main(String... args) throws InvocationTargetException, InterruptedException
    {
        SwingUtilities.invokeAndWait(new Runnable()
        {
            
            @Override
            public void run()
            {
                new WorldGUI();
            }
        });
    }

}
