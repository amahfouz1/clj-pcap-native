# clj-pcap

A Clojure library designed to ... well, that part is up to you.

## Usage

Generating the native executable using GraalVM native-image:
```
sh-4.2# lein native-image
Compiling 1 source files to /clj-pcap/target/default+uberjar/classes
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
-Djna.debug_load=true \
-Xbootclasspath/a:/opt/graalvm-ce-java8-20.0.0/jre/lib/boot/graal-sdk.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/boot/graaljs-scriptengine.jar \
-cp \
/opt/graalvm-ce-java8-20.0.0/jre/lib/svm/builder/objectfile.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/svm/builder/llvm-wrapper-shadowed.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/svm/builder/svm-llvm.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/svm/builder/svm.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/svm/builder/graal-llvm.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/svm/builder/pointsto.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/svm/builder/llvm-platform-specific-shadowed.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/svm/builder/javacpp-shadowed.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/jvmci/jvmci-hotspot.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/jvmci/graal.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/jvmci/graal-management.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/jvmci/graal-truffle-jfr-impl.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/jvmci/jvmci-api.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/resources.jar \
com.oracle.svm.hosted.NativeImageGeneratorRunner \
-watchpid \
358 \
-imagecp \
/opt/graalvm-ce-java8-20.0.0/jre/lib/boot/graal-sdk.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/boot/graaljs-scriptengine.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/svm/builder/objectfile.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/svm/builder/llvm-wrapper-shadowed.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/svm/builder/svm-llvm.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/svm/builder/svm.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/svm/builder/graal-llvm.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/svm/builder/pointsto.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/svm/builder/llvm-platform-specific-shadowed.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/svm/builder/javacpp-shadowed.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/jvmci/jvmci-hotspot.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/jvmci/graal.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/jvmci/graal-management.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/jvmci/graal-truffle-jfr-impl.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/jvmci/jvmci-api.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/resources.jar:/opt/graalvm-ce-java8-20.0.0/jre/lib/svm/library-support.jar:/clj-pcap/test:/clj-pcap/src:/clj-pcap/target/default+uberjar/classes:/root/.m2/repository/nrepl/nrepl/0.6.0/nrepl-0.6.0.jar:/root/.m2/repository/org/clojure/tools.analyzer.jvm/0.7.3/tools.analyzer.jvm-0.7.3.jar:/root/.m2/repository/clojure-complete/clojure-complete/0.2.5/clojure-complete-0.2.5.jar:/root/.m2/repository/org/clojure/tools.reader/1.3.2/tools.reader-1.3.2.jar:/root/.m2/repository/org/pcap4j/pcap4j-packetfactory-static/1.8.2/pcap4j-packetfactory-static-1.8.2.jar:/root/.m2/repository/org/clojure/clojure/1.10.0/clojure-1.10.0.jar:/root/.m2/repository/org/slf4j/slf4j-api/1.7.25/slf4j-api-1.7.25.jar:/root/.m2/repository/net/java/dev/jna/jna/5.3.1/jna-5.3.1.jar:/root/.m2/repository/org/clojure/tools.logging/1.0.0/tools.logging-1.0.0.jar:/root/.m2/repository/org/ow2/asm/asm/5.2/asm-5.2.jar:/root/.m2/repository/ch/qos/logback/logback-classic/1.2.3/logback-classic-1.2.3.jar:/root/.m2/repository/org/clojure/core.async/1.0.567/core.async-1.0.567.jar:/root/.m2/repository/org/clojure/core.cache/0.8.2/core.cache-0.8.2.jar:/root/.m2/repository/org/clojure/core.memoize/0.8.2/core.memoize-0.8.2.jar:/root/.m2/repository/org/clojure/tools.analyzer/0.7.0/tools.analyzer-0.7.0.jar:/root/.m2/repository/org/clojure/data.priority-map/0.0.7/data.priority-map-0.0.7.jar:/root/.m2/repository/org/clojure/core.specs.alpha/0.2.44/core.specs.alpha-0.2.44.jar:/root/.m2/repository/ch/qos/logback/logback-core/1.2.3/logback-core-1.2.3.jar:/root/.m2/repository/org/pcap4j/pcap4j-core/1.8.2/pcap4j-core-1.8.2.jar:/root/.m2/repository/org/clojure/spec.alpha/0.2.176/spec.alpha-0.2.176.jar \
-H:Path=/clj-pcap \
-H:ClassInitialization=:build_time \
-H:+AllowIncompleteClasspath \
-H:ClassInitialization=org.pcap4j.core.NativePacketDllMappings:run_time,com.sun.jna:run_time \
-H:Log=registerResource \
-H:+PrintAnalysisCallTree \
-H:+JNI \
-H:+ReportExceptionStackTraces \
-H:FallbackThreshold=0 \
-H:+EnableAllSecurityServices \
-H:+StaticExecutable \
-H:EnableURLProtocols=http,https \
-H:Name=/clj-pcap/target/default+uberjar/cljpcap \
-H:CLibraryPath=/opt/graalvm-ce-java8-20.0.0/jre/lib/svm/clibraries/linux-amd64 \
-H:ResourceConfigurationFiles=/clj-pcap/conf/resource-config.json \
-H:Class=com.test.PcapNative
]
[/clj-pcap/target/default+uberjar/cljpcap:385]    classlist:  12,693.28 ms,  1.24 GB
[/clj-pcap/target/default+uberjar/cljpcap:385]        (cap):   1,002.03 ms,  1.24 GB
[/clj-pcap/target/default+uberjar/cljpcap:385]        setup:   3,339.05 ms,  1.24 GB
[Use -Dgraal.LogFile=<path> to redirect Graal log output to a file.]
[thread:31] scope: ForkJoinPool-4-worker-9
  [thread:31] scope: ForkJoinPool-4-worker-9.registerResource
  ServiceLoaderFeature: registerResource: META-INF/services/sun.net.spi.nameservice.NameServiceDescriptor
  [thread:31] scope: ForkJoinPool-4-worker-9.registerResource
  ServiceLoaderFeature: registerResource: META-INF/services/java.nio.file.spi.FileSystemProvider
  [thread:31] scope: ForkJoinPool-4-worker-9.registerResource
  Resources have been added by ServiceLoaderFeature. Automatic registration can be disabled with -H:-UseServiceLoaderFeature
[/clj-pcap/target/default+uberjar/cljpcap:385]   (typeflow):  13,312.72 ms,  4.41 GB
[/clj-pcap/target/default+uberjar/cljpcap:385]    (objects):  12,953.80 ms,  4.41 GB
[/clj-pcap/target/default+uberjar/cljpcap:385]   (features):   2,304.37 ms,  4.41 GB
[/clj-pcap/target/default+uberjar/cljpcap:385]     analysis:  29,115.81 ms,  4.41 GB
Printing call tree to /clj-pcap/reports/call_tree_cljpcap_20200315_202340.txt
Printing list of used methods to /clj-pcap/reports/used_methods_cljpcap_20200315_202343.txt
Printing list of used classes to /clj-pcap/reports/used_classes_cljpcap_20200315_202343.txt
Printing list of used packages to /clj-pcap/reports/used_packages_cljpcap_20200315_202343.txt
[/clj-pcap/target/default+uberjar/cljpcap:385]     (clinit):     406.75 ms,  4.76 GB
[/clj-pcap/target/default+uberjar/cljpcap:385]     universe:   1,113.64 ms,  4.76 GB
[/clj-pcap/target/default+uberjar/cljpcap:385]      (parse):   1,978.15 ms,  4.76 GB
[/clj-pcap/target/default+uberjar/cljpcap:385]     (inline):   1,962.31 ms,  4.81 GB
[/clj-pcap/target/default+uberjar/cljpcap:385]    (compile):  18,475.79 ms,  5.71 GB
[/clj-pcap/target/default+uberjar/cljpcap:385]      compile:  23,848.17 ms,  5.71 GB
[/clj-pcap/target/default+uberjar/cljpcap:385]        image:   1,785.79 ms,  5.71 GB
[/clj-pcap/target/default+uberjar/cljpcap:385]        write:   1,799.02 ms,  5.71 GB
[/clj-pcap/target/default+uberjar/cljpcap:385]      [total]:  79,774.04 ms,  5.71 GB
Created native image /clj-pcap/target/default+uberjar/cljpcap
```

Running it throws this error:
```
sh-4.2# /clj-pcap/target/default+uberjar/cljpcap -Djna.debug_load=true
Mar 15, 2020 8:13:53 PM com.sun.jna.Native extractFromResourcePath
INFO: Looking in classpath from sun.misc.Launcher$AppClassLoader@16c0128 for /com/sun/jna/linux-x86-64/libjnidispatch.so
Mar 15, 2020 8:13:53 PM com.sun.jna.Native extractFromResourcePath
INFO: Found library resource at resource:com/sun/jna/linux-x86-64/libjnidispatch.so
Mar 15, 2020 8:13:53 PM com.sun.jna.Native extractFromResourcePath
INFO: Extracting library to /root/.cache/JNA/temp/jna2847104491610838225.tmp
JNA: Problems loading core IDs: java.lang.Object
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
