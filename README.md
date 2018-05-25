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
- Run the App to [send messages to the smallest mailbox.](https://asciinema.org/a/VPrP6wkSHZjDlb81ZDDoTQdJH)
<br><br>
- Branch out to explore creating BalancingPool of Actors
````
git checkout -b balancing_pool_actors create_smallest_mailbox_pool 
````
- Create the file to handle the actor system: <b>com.github.janikibichi.learnakka.monitoring.BalancingPool.scala</b>
- Run the App to [send messages to the BalancingPool mailbox.](https://asciinema.org/a/QeLY9MasY0jlKr0tSWmH2SRvQ)
<br><br>
- Branch out to explore creating RoundRobinPool of Actors
````
git checkout -b round_robin_pool_actors balancing_pool_actors
````
- Create the file to handle the actor system: <b>com.github.janikibichi.learnakka.monitoring.RoundRobinPool.scala</b>
- Run the App to [send messages to the RoundRobin mailbox.](https://asciinema.org/a/qaPszz6EbZFHeezGqWYX8bI53)
<br><br>
- Branch out to explore creating BroadcastPool of Actors
````
git checkout -b broadcast_pool_actors round_robin_pool_actors 
````
- Create the file to handle the actor system: <b>com.github.janikibichi.learnakka.monitoring.BroadcastPool.scala</b>
- Run the App to [send messages to the BroadcastPool mailbox.](https://asciinema.org/a/qaPszz6EbZFHeezGqWYX8bI53)
<br><br>
- Branch out to explore creating ScatterGatherFirstCompletedPool of Actors
````
git checkout -b scatter_gather_first_completed_pool broadcast_pool_actors
````
- Create the file to handle the actor system: <b>com.github.janikibichi.learnakka.monitoring.ScatterGatherFirstCompletedPool.scala</b>
- Run the App to [send messages to the ScatterGatherFirstComplete mailbox.](https://asciinema.org/a/nYO3fNonqwighBP4Z7robVWll)
<br><br>
- Branch out to explore creating TailChoppingPool of Actors
````
git checkout -b tailchopping_pool_actors scatter_gather_first_completed_pool 
````
- Create the file to handle the actor system: <b>com.github.janikibichi.learnakka.monitoring.TheTailChoppingPool.scala</b>
- Run the App to [send messages to the TailChoppingPool mailbox.](https://asciinema.org/a/muhWIzMLPMvrZrSeFUMHCvQzr)
<br><br>
- Branch out to explore creating ConsistentHashingPool of Actors
````
git checkout -b consistent_hashing_pool_actors tailchopping_pool_actors
````
- Create the file to handle the actor system: <b>com.github.janikibichi.learnakka.monitoring.TheConsistentHashingPool.scala</b>
- Run the App to [send messages to the ConsistentHashingPool mailbox.](https://asciinema.org/a/rg53gUizUL5svHo2Q7WUuE4mz)
<br><br>
- Branch out to explore creating RandomPool of Actors
````
git checkout -b random_pool_actors consistent_hashing_pool_actors
````
- Create the file to handle the actor system: <b>com.github.janikibichi.learnakka.monitoring.TheRandomPool.scala</b>
- Run the App to [send messages to the RandomPool mailbox.](https://asciinema.org/a/rg53gUizUL5svHo2Q7WUuE4mz)
<br><br>
- Branch out to explore creating SpecialHandledMessages 
````
git checkout -b special_handled_messages random_pool_actors
````
- Create the file to handle the actor system: <b>com.github.janikibichi.learnakka.monitoring.SpecialHandledMessages.scala</b>
- Run the App to [send messages to the SpecialHandledMessages.]()