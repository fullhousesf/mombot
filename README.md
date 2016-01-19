# Mombot

Mombot runs the house.

# Example

Start here: https://github.com/fullhousesf/mombot/blob/master/src/mombot/core.cljs

and see the conversation implementation here: https://github.com/fullhousesf/mombot/blob/master/src/mombot/conversations/pizzatime.cljs

# Running

Run `lein figwheel` in one terminal. Once that's running, run `BOT_KEY=get-the-bot-key-from-travis node target/server_dev/mombot.js` in another terminal.

You'll need to get the botkey from @travis or slack's admin UI. Never check the bot key in. Code will be reloaded into the running app as you change it (because figwheel is boss).
