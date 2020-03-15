package com.test;

import com.sun.jna.Native;

public class PcapNative {
    // const char * pcap_lib_version(void)
    static native String pcap_lib_version();

    public static void main(String args[]) {
        Native.register(PcapNative.class, "pcap");
        System.out.println(pcap_lib_version());
    }
}