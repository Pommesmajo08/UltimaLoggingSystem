package de.ultima.UltimaLoggingSystem.Thread;

public class LoggingThread extends Thread{
    private String prefix;
    private int uptime = 0;

    public LoggingThread(String prefix){
        this.prefix = prefix;
    }

    @Override
    public void run() {
       System.out.println(prefix + " Starting");
       while (true){
       }
    }

    public String getPrefix() {
        return prefix;
    }

    public void log(String message){
        System.out.println(prefix + " " + message);
    }
}
