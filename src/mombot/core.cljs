(ns mombot.core
  (:require-macros [mombot.botkit :as bk])
  (:require [cljs.nodejs :as nodejs]
            [mombot.botkit :as botkit]
            [mombot.conversations.pizzatime :as pt :refer [order-pizza]]))

(nodejs/enable-util-print!)

(def controller (botkit/controller))


(defn -main []
  (println order-pizza)
  (doto controller
    (botkit/bot {:token js/process.env.BOT_KEY})
    (botkit/hears ["pizzatime"] ["direct_message" "ambient"] order-pizza))

  (println "Mombot started"))

(set! *main-cli-fn* -main)
