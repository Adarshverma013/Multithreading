package org.example.Volatile;

/**
 * Example of how instruction reordering can break the
 * Volatile visibility gurantee
 */
public class Exchanger2 {
    private int var1 = 0;
    private int var2 = 0;
    private volatile int var3 = 0;

    // If compiler reorders the instructions in below way then
    public void setValues(Values source){
        this.var1 = source.getVal1();
        this.var3 = source.getVal3();
        /**
         * At this point since var3 is volatile values will be read from the main memory
         * but var2 new value is not visible so compiler will get its old value from the main memory
         */
        this.var2 = source.getVal2();
    }

    public void getVlaues(Values dest){
        dest.setVal1(this.var1);
        /**
         * At this point no volatile value is encountered
         * so var1 value returned cannot be guranteed from main memory
         * it can be a old value
         */
        dest.setVal3(this.var3); // All val1,var2 and var3 are refreshed from main memory at this point of time
        dest.setVal2(this.var2);
    }

    /**
     * To avoid instruction reordering breaking the visibility gurantee of java volatile keyword
     * Volatile keyword comes with Happens Before gurantee
     *
     * 1. All the writes that happens before the write to
     *      volatile variable remains before after instruction reordering
     * 2. All reads of a volatile variables remains before non-volatile
     *      variables after instruction reordering
     */
}
