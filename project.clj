(defproject mombot "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"

  :min-lein-version "2.5.3"

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.170"]]

  :plugins [[lein-cljsbuild "1.1.1"]
            [lein-figwheel "0.5.0-2"]
            [lein-npm "0.6.1"]]

  :clean-targets ["server.js"
                  "target"]
  :npm {:dependencies [[botkit "0.0.5"]
                       [ws "1.0.1"]]}

  :figwheel {:reload-clj-files {:clj true}}

  :cljsbuild {
    :builds [{:id "dev"
              :source-paths ["src"]
              :figwheel true
              :compiler {
                :main mombot.core
                :output-to "target/server_dev/mombot.js"
                :output-dir "target/server_dev"
                :target :nodejs
                :optimizations :none
                :source-map true}}
             {:id "prod"
              :source-paths ["src"]
              :compiler {
                :output-to "server.js"
                :output-dir "target/server_prod"
                :target :nodejs
                :optimizations :simple}}]})
