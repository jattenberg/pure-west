(ns pure-west.core
  (:require [org.httpkit.server :as server]
            [clj-time.core :as time]
            [compojure.core :refer :all]
            [compojure.route :as route])
  (:gen-class))

(defn time-response [req]
  (let [t (str (time/time-now))]
    (println (str "got a request at: " t))
    {:status  200
     :headers {"Content-Type" "text/html"}
     :body    t})
  )

(defn echo-chamber [message]
  (let [t (str (time/time-now))]
    (println (str "got a message: \"" message " at: "\" t))
    {:status 200
     :headers {"Content-Type" "text/html"}
     :body message}))


(defroutes app-routes
  (GET "/" [] time-response)
  (GET "/echo/:message" [message] (echo-chamber message))
  (route/not-found "You Must Be New Here"))

(defn -main
  [& args]
  (let [port (if (empty? args) 8888 (Integer/parseInt (first args)))]
    (server/run-server #'app-routes {:port port} )
    (println (str "running a server on port: " port)))
  
  )
