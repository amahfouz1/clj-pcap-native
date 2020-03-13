(ns clj-pcap.core
  (:require [clojure.tools.logging :as log])
  (:gen-class)
  (:import (java.net Socket InetSocketAddress InetAddress))
  (:import (org.pcap4j.core Pcaps)))

(def INADDR_ANY "0.0.0.0")
(def DEFAULT_PORT 4545)

(defn socket-addr
  [^String address ^Integer port]
  (InetSocketAddress. address port))

(defn ip
  "This returns the current IP address of the host."
  []
  (.. InetAddress getLocalHost getHostAddress))

(defn bind
  [^Socket socket ^InetSocketAddress address]
  (.bind socket address))

(defn -main
  "main--"
  []
  (let [socket (Socket.)
        address (socket-addr INADDR_ANY DEFAULT_PORT)]
    (log/info (str "attempting to bind to port " DEFAULT_PORT))
    (try
      (do
        (bind socket address)
        (let
          [nif (Pcaps/getDevByAddress (InetAddress/getByName (ip)))]
          (log/info (str "getting native interface to listen to eventually"))))
      (catch Exception e
        (log/debug (str "bind exception: " (.getMessage e)))))))