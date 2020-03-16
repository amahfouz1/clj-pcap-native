package org.pcap4j.core;

import com.sun.jna.Native;
import org.pcap4j.core.Pcaps;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;

public class PcapNative {

    public static void main(String args[])
            throws ClassNotFoundException, IOException {
        Class<?> myClass = Native.class;
        System.out.printf("my class is Class@%x%n", myClass.hashCode());
        System.out.println("reloading");
        URL[] urls = {myClass.getProtectionDomain().getCodeSource().getLocation()};
        ClassLoader delegateParent = myClass.getClassLoader().getParent();
        Arrays.stream(urls).forEach(u -> System.out.println(u));
        try (URLClassLoader cl = new URLClassLoader(urls, delegateParent)) {
            Class<?> reloaded = cl.loadClass(myClass.getName());
            System.out.printf("reloaded my class: Class@%x%n", reloaded.hashCode());
            System.out.println("Different classes: " + (myClass != reloaded));
        }
        System.out.println(Pcaps.libVersion());
    }
}