(ns mombot.botkit)

(def botkit (js/require "botkit"))

;;; init

(defn controller
  ([options]
   (botkit.slackbot (clj->js options)))
  ([] (controller {})))

(defn spawn-bot [controller config]
  (.spawn controller (clj->js config)))

(defn start-rtm [bot]
  (.startRTM bot (fn [err bot payload]
                   (if err
                     (println "error starting RTM! "err)
                     (println "started RTM.")))))

(defn bot
  ([controller config]
   (-> controller
       (spawn-bot config)
       start-rtm))
  ([config]
   (bot (controller) config)))

;;; wrappers

(defn say [bot message]
  (.say bot (clj->js message)))

;;; hooks

(defn hears [controller phrases events callback]
  (.hears controller (clj->js phrases) (clj->js events) callback))
