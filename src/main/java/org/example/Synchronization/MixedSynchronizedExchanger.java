package org.example.Synchronization;

public class MixedSynchronizedExchanger {
    public Object instanceObj = null;
    public synchronized void setInstanceObj(Object obj){
        this.instanceObj = obj;
    }

    public static Object staticObj = null;
    public static synchronized void setStaticObj(Object obj){
        staticObj = obj;
    }
}
