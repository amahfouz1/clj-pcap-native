(defproject clj-pcap "0.1.0-SNAPSHOT"
  :description "clj-pcap-native"
  :url "http://example.com/FIXME"
  :global-vars {*warn-on-reflection* true}
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/core.async "1.0.567"]
                 [org.clojure/tools.logging "1.0.0"]
                 [ch.qos.logback/logback-classic "1.2.3"]
                 [org.pcap4j/pcap4j-core "1.8.2"]
                 [org.pcap4j/pcap4j-packetfactory-static "1.8.2"]]
  :plugins [[io.taylorwood/lein-native-image "0.3.1"]]
  :native-image {:name "cljpcap"
                 :opts ["--initialize-at-build-time"
                        "--allow-incomplete-classpath"
                        "--initialize-at-run-time=org.pcap4j.core.NativePacketDllMappings,com.sun.jna"
                        "-Djna.debug_load=true"
                        "--no-server"
                        "-H:Log=registerResource"
                        "-H:+PrintAnalysisCallTree"
                        "-H:+JNI"
                        "-H:+ReportExceptionStackTraces"
                        "--no-fallback"
                        "--enable-all-security-services"
                        "-H:ResourceConfigurationFiles=conf/resource-config.json"
                        "-H:JNIConfigurationFiles=conf/jni-config.json"
                        "--static"
                        "-H:EnableURLProtocols=http,https"
                        "--verbose"]
                 :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}
  :source-paths ["src"]
  :java-source-paths ["java"]
  :main ^:skip-aot com.test.PcapNative
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})