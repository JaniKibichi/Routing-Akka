# Routing for AKKA
This is the 'art and science' of routing messages to multiple actors using routers.
##### We use various routing schemes depending on if:
- We want to send messages to the least busy actor
- We want to send messages in a round robin order
- We want to send the same message to all actors in a group
- We want to dynamically distribute work based on a preconfigured pattern
