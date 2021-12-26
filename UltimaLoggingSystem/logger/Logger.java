package de.ultima.UltimaLoggingSystem.logger;

import de.ultima.UltimaLoggingSystem.Thread.LoggingThread;
import de.ultima.UltimaLoggingSystem.manager.LoggingMannager;

import java.util.ArrayList;

public class Logger {
    private LoggingThread info;
    private LoggingMannager mannager;
    public Logger(LoggingThread info, LoggingMannager mannager){
        this.info = info;
        this.mannager = mannager;
    }

    public void info(String message){
        info.log(message);
    }
    public void logThread(String prefix, String message){
        ArrayList<LoggingThread> threads = mannager.getThreads();
        for(LoggingThread thread : threads){
            if(thread.getPrefix() == prefix){
                thread.log(message);
            }
        }
    }
}
