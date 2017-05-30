package com.oracle.lab7_juddi;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        SimplePublishPortable spp = new SimplePublishPortable();
        spp.publish();

        SimpleBrowse sb = new SimpleBrowse();
        String[] strs ={"EmployeeService"};
        sb.Browse(strs);
    }

}
