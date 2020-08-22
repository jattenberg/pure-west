(ns pure-west.core
  (:require [org.httpkit.server :as server]
            [clj-time.core :as time])
  (:gen-class))

(defn app [req]
  (let [t (str (time/time-now))]
    (println (str "got a request at: " t))
    {:status  200
     :headers {"Content-Type" "text/html"}
     :body    t})
  )

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [port (if (empty? args) 8888 (Integer/parseInt (first args)))]
    (server/run-server app {:port port} )
    (println (str "running a server on port: " port)))
  
  )
