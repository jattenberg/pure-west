(defproject pure-west "0.1.0-SNAPSHOT"
  :description "a very simple web service in clojure ya herd"
  :url "https://github.com/jattenberg/pure-west"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [http-kit "2.4.0"]
                 [clj-time "0.15.2"]
                 [compojure "1.6.2"]]
  :main ^:skip-aot pure-west.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
