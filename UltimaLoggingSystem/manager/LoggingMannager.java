package de.ultima.UltimaLoggingSystem.manager;


import de.ultima.UltimaLoggingSystem.Thread.LoggingThread;
import de.ultima.UltimaLoggingSystem.logger.Logger;

import java.util.ArrayList;

public class LoggingMannager {
    private ArrayList<LoggingThread> threads;
    private String prefix;
    private Logger logger;
    private boolean started;
    public LoggingMannager(ArrayList<LoggingThread> threads, String prefix){
        this.prefix = prefix;
        this.threads = threads;
        LoggingThread info = new LoggingThread("[Threads/Info]");
        threads.add(info);
        this.logger = new Logger(info, this);
    }

    public Logger getLogger(){
        if(!started){
            System.out.println("Start Logging first");
            System.exit(0);
        }
        return logger;
    }

    public void registerNewThread(LoggingThread thread){
        if(!started){
            threads.add(thread);
        }else{
            System.out.println("Stop Logging First");
            System.exit(0);
        }
    }

    public ArrayList<LoggingThread> getThreads() {
        if(!started){
            System.out.println("Start Logging first");
            System.exit(0);
        }
        return threads;
    }

    public void startLoggingSystem(){
        started = true;
        for(LoggingThread thread : threads){
            thread.start();
        }
    }

    public void shutdownLoggingSystem(){
        if(!started){
            System.out.println("Start Logging first");
            System.exit(0);
        }
        for(LoggingThread thread : threads){
            System.out.println(thread.getPrefix() + " Shutting down");
            thread.stop();
        }
    }
}
