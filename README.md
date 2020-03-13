# clj-pcap

A Clojure library designed to ... well, that part is up to you.

## Usage

Generating the native executable using GraalVM native-image:
```
sh-4.2# lein native-image
Compiling clj-pcap.core
Executing [
/opt/graalvm-ce-java8-20.0.0/jre/bin/java \
-XX:+UnlockExperimentalVMOptions \
-XX:+EnableJVMCI \
-Dtruffle.TrustAllTruffleRuntimeProviders=true \
-Dtruffle.TruffleRuntime=com.oracle.truffle.api.impl.DefaultTruffleRuntime \
-Dgraalvm.ForcePolyglotInvalid=true \
-Dgraalvm.locatorDisabled=true \
-d64 \
-XX:-UseJVMCIClassLoader \
-XX:+UseJVMCINativeLibrary \
-Xss10m \
-Xms1g \
-Xmx13442423192 \
-Duser.country=US \
-Duser.language=en \
-Djava.awt.headless=true \
-Dorg.graalvm.version=20.0.0 \
-Dorg.graalvm.config=CE \
-Dcom.oracle.graalvm.isaot=true \
-Djava.system.class.loader=com.oracle.svm.hosted.NativeImageSystemClassLoader \
-Xshare:off \
-Djvmci.class.path.append=/opt/graalvm-ce-java8-20.0.0/jre/lib/jvmci/graal.jar \
-javaagent:/opt/graalvm-ce-java8-20.0.0/jre/lib/svm/builder/svm.jar \
-Djdk.internal.lambda.disableEagerInitialization=true \
-Djdk.internal.lambda.eagerlyInitialize=false \
-Djava.lang.invoke.InnerClassLambdaMetafactory.initializeLambdas=false \
-Xbootclasspath/a:/opt/graalvm-ce-java8-20.0.0/jre/lib/boot/graal-sdk.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/boot/graaljs-scriptengine.jar \
-cp \
/opt/graalvm-ce-java8-20.0.0/jre/lib/svm/builder/objectfile.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/svm/builder/llvm-wrapper-shadowed.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/svm/builder/svm-llvm.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/svm/builder/svm.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/svm/builder/graal-llvm.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/svm/builder/pointsto.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/svm/builder/llvm-platform-specific-shadowed.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/svm/builder/javacpp-shadowed.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/jvmci/jvmci-hotspot.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/jvmci/graal.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/jvmci/graal-management.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/jvmci/graal-truffle-jfr-impl.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/jvmci/jvmci-api.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/resources.jar \
com.oracle.svm.hosted.NativeImageGeneratorRunner \
-watchpid \
76 \
-imagecp \
/opt/graalvm-ce-java8-20.0.0/jre/lib/boot/graal-sdk.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/boot/graaljs-scriptengine.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/svm/builder/objectfile.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/svm/builder/llvm-wrapper-shadowed.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/svm/builder/svm-llvm.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/svm/builder/svm.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/svm/builder/graal-llvm.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/svm/builder/pointsto.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/svm/builder/llvm-platform-specific-shadowed.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/svm/builder/javacpp-shadowed.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/jvmci/jvmci-hotspot.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/jvmci/graal.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/jvmci/graal-management.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/jvmci/graal-truffle-jfr-impl.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/jvmci/jvmci-api.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/resources.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/svm/library-support.jar:/clj-pcap-native/test:/clj-pcap-native/src:/clj-pcap-native/resources:/clj-pcap-native/target/default+uberjar/classes:/root/.m2/repository/nrepl/nrepl/0.6.0/nrepl-0.6.0.jar:/root/.m2/repository/org/clojure/tools.analyzer.jvm/0.7.3/tools.analyzer.jvm-0.7.3.jar:/root/.m2/repository/clojure-complete/clojure-complete/0.2.5/clojure-complete-0.2.5.jar:/root/.m2/repository/org/clojure/tools.reader/1.3.2/tools.reader-1.3.2.jar:/root/.m2/repository/org/pcap4j/pcap4j-packetfactory-static/1.8.2/pcap4j-packetfactory-static-1.8.2.jar:/root/.m2/repository/org/clojure/clojure/1.10.0/clojure-1.10.0.jar:/root/.m2/repository/org/slf4j/slf4j-api/1.7.25/slf4j-api-1.7.25.jar:/root/.m2/repository/net/java/dev/jna/jna/5.3.1/jna-5.3.1.jar:/root/.m2/repository/org/clojure/tools.logging/1.0.0/tools.logging-1.0.0.jar:/root/.m2/repository/org/ow2/asm/asm/5.2/asm-5.2.jar:/root/.m2/repository/ch/qos/logback/logback-classic/1.2.3/logback-classic-1.2.3.jar:/root/.m2/repository/org/clojure/core.async/1.0.567/core.async-1.0.567.jar:/root/.m2/repository/org/clojure/core.cache/0.8.2/core.cache-0.8.2.jar:/root/.m2/repository/org/clojure/core.memoize/0.8.2/core.memoize-0.8.2.jar:/root/.m2/repository/org/clojure/tools.analyzer/0.7.0/tools.analyzer-0.7.0.jar:/root/.m2/repository/org/clojure/data.priority-map/0.0.7/data.priority-map-0.0.7.jar:/root/.m2/repository/org/clojure/core.specs.alpha/0.2.44/core.specs.alpha-0.2.44.jar:/root/.m2/repository/ch/qos/logback/logback-core/1.2.3/logback-core-1.2.3.jar:/root/.m2/repository/org/pcap4j/pcap4j-core/1.8.2/pcap4j-core-1.8.2.jar:/root/.m2/repository/org/clojure/spec.alpha/0.2.176/spec.alpha-0.2.176.jar \
-H:Path=/clj-pcap-native \
-H:ClassInitialization=:build_time \
-H:+AllowIncompleteClasspath \
-H:ClassInitialization=org.pcap4j.core.NativePacketDllMappings:run_time \
-H:+JNI \
-H:+ReportExceptionStackTraces \
-H:FallbackThreshold=0 \
-H:+EnableAllSecurityServices \
-H:EnableURLProtocols=http,https \
-H:Name=/clj-pcap-native/target/default+uberjar/cljpcap \
-H:CLibraryPath=/opt/graalvm-ce-java8-20.0.0/jre/lib/svm/clibraries/linux-amd64 \
-H:Class=clj_pcap.core
]
[/clj-pcap-native/target/default+uberjar/cljpcap:103]    classlist:  10,602.37 ms,  1.58 GB
[/clj-pcap-native/target/default+uberjar/cljpcap:103]        (cap):     815.55 ms,  1.58 GB
[/clj-pcap-native/target/default+uberjar/cljpcap:103]        setup:   2,996.06 ms,  1.58 GB
18:59:40.049 [ForkJoinPool-2-worker-10] INFO org.pcap4j.core.NativeMappings - Pcap4J successfully loaded a native pcap library: libpcap version 1.5.3
18:59:40.156 [ForkJoinPool-2-worker-2] INFO org.pcap4j.util.PropertiesLoader - [org/pcap4j/pcap4j.properties] Could not get value by org.pcap4j.af.inet, use default value: 2
18:59:40.160 [ForkJoinPool-2-worker-2] INFO org.pcap4j.util.PropertiesLoader - [org/pcap4j/pcap4j.properties] Could not get value by org.pcap4j.af.inet6, use default value: 10
18:59:40.160 [ForkJoinPool-2-worker-2] INFO org.pcap4j.util.PropertiesLoader - [org/pcap4j/pcap4j.properties] Could not get value by org.pcap4j.af.packet, use default value: 17
18:59:40.160 [ForkJoinPool-2-worker-2] INFO org.pcap4j.util.PropertiesLoader - [org/pcap4j/pcap4j.properties] Could not get value by org.pcap4j.af.link, use default value: 18
[/clj-pcap-native/target/default+uberjar/cljpcap:103]   (typeflow):  13,913.37 ms,  2.15 GB
[/clj-pcap-native/target/default+uberjar/cljpcap:103]    (objects):  10,992.73 ms,  2.15 GB
[/clj-pcap-native/target/default+uberjar/cljpcap:103]   (features):   1,351.18 ms,  2.15 GB
[/clj-pcap-native/target/default+uberjar/cljpcap:103]     analysis:  27,000.90 ms,  2.15 GB
[/clj-pcap-native/target/default+uberjar/cljpcap:103]     (clinit):     463.06 ms,  2.15 GB
[/clj-pcap-native/target/default+uberjar/cljpcap:103]     universe:   1,335.20 ms,  2.15 GB
[/clj-pcap-native/target/default+uberjar/cljpcap:103]      (parse):   2,309.03 ms,  2.48 GB
[/clj-pcap-native/target/default+uberjar/cljpcap:103]     (inline):   1,948.84 ms,  2.51 GB
^[[A[/clj-pcap-native/target/default+uberjar/cljpcap:103]    (compile):  17,440.64 ms,  4.31 GB
[/clj-pcap-native/target/default+uberjar/cljpcap:103]      compile:  22,937.98 ms,  4.31 GB
[/clj-pcap-native/target/default+uberjar/cljpcap:103]        image:   1,844.76 ms,  4.71 GB
[/clj-pcap-native/target/default+uberjar/cljpcap:103]        write:   1,277.92 ms,  4.71 GB
[/clj-pcap-native/target/default+uberjar/cljpcap:103]      [total]:  68,586.14 ms,  4.71 GB
Created native image /clj-pcap-native/target/default+uberjar/cljpcap
```

Running it throws this error:
```
sh-4.2# /clj-pcap-native/target/default+uberjar/cljpcap
19:00:45.974 [main] INFO clj-pcap.core - attempting to bind to port 4545
Exception in thread "main" java.lang.UnsatisfiedLinkError: com.sun.jna.Native.malloc(J)J [symbol: Java_com_sun_jna_Native_malloc or Java_com_sun_jna_Native_malloc__J]
	at com.oracle.svm.jni.access.JNINativeLinkage.getOrFindEntryPoint(JNINativeLinkage.java:145)
	at com.oracle.svm.jni.JNIGeneratedMethodSupport.nativeCallAddress(JNIGeneratedMethodSupport.java:57)
	at com.sun.jna.Native.malloc(Native.java)
	at com.sun.jna.Memory.malloc(Memory.java:722)
	at com.sun.jna.Memory.<init>(Memory.java:114)
	at com.sun.jna.ptr.ByReference.<init>(ByReference.java:42)
	at com.sun.jna.ptr.PointerByReference.<init>(PointerByReference.java:40)
	at com.sun.jna.ptr.PointerByReference.<init>(PointerByReference.java:36)
	at org.pcap4j.core.Pcaps.findAllDevs(Pcaps.java:51)
	at org.pcap4j.core.Pcaps.getDevByAddress(Pcaps.java:99)
	at clj_pcap.core$_main.invokeStatic(core.clj:33)
	at clj_pcap.core$_main.invoke(core.clj:23)
	at clojure.lang.AFn.applyToHelper(AFn.java:152)
	at clojure.lang.AFn.applyTo(AFn.java:144)
	at clj_pcap.core.main(Unknown Source)
```

If you don't have Lein you can generate the uberjar and then run native-image:
```
lein uberjar
```
```
native-image -jar target/uberjar/clj-pcap-0.1.0-SNAPSHOT-standalone.jar --initialize-at-build-time --no-server -H:+ReportExceptionStackTraces --no-fallback --initialize-at-run-time=org.pcap4j.core.NativePacketDllMappings,org.pcap4j.core.PcapHandle --report-unsupported-elements-at-runtime --allow-incomplete-classpath -H:+JNI
```

## License

Copyright © 2020 FIXME

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
