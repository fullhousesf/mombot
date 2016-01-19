(ns mombot.conversations.pizzatime)

(defn ask-where-to-deliver [response convo]
  (.ask convo "So where do you want it delivered?"
        (fn [response convo]
          (.say convo "Psych!! I'm a mombot, not a pizzabot. Order your own pizza from Escape From New York! (415) 206-0555")
          (.next convo))))

(defn ask-size [response convo]
  (.ask convo "What size do you want?"
        (fn [response convo]
          (.say convo "Ok.")
          (ask-where-to-deliver response convo)
          (.next convo))))

(defn ask-flavor [response convo]
  (.ask convo "What flavor of pizza do you want"
        (fn [response convo]
          (.say convo "Awesomesauce.")
          (ask-size response convo)

          (.next convo))))

(defn order-pizza [bot message]
  (.startConversation bot message ask-flavor))
