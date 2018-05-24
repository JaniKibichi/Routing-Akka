# Routing for AKKA
This is the 'art and science' of routing messages to multiple actors using routers.
##### We use various routing schemes depending on if:
- We want to send messages to the least busy actor
- We want to send messages in a round robin order
- We want to send the same message to all actors in a group
- We want to dynamically distribute work based on a preconfigured pattern
<br><br>
- Branch out to explore creating SmallestMailBoxPool of Actors
````
git checkout -b create_smallest_mailbox_pool master
````
- Create the file to handle the actor system: <b>com.github.janikibichi.learnakka.monitoring.SmallestMailPool.scala</b>
- Run the App to [see how to manage the mailbox.](https://asciinema.org/a/Teg6OOQ24cPFFq6GwqXNcsYAg)