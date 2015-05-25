Twitter-stream
==============

This app opens a stream that will receive periodically a bunch of tweets and allows adding actions to perform every time this bunch of tweets arrive.

Configuration
-------------

First of all, you should have an App created in Twitter.
(https://apps.twitter.com/)

Once created, request in the same page your consumer key and pass, and then an access token.
Add these strings to your project file conf (``` app.conf```).

```
bfc.twitter-stream {
  spark {
    app-name=bfc-twitter-stream #The name of your spark application
    master="local[4]" #Spark master configuration
  }
  window-seconds=5 #Each N seconds you will receive a fresh bunch of tweets
}

twitter4j.oauth {
  consumerKey=your-consumer-key
  consumerSecret=your-consumer-secret
  accessToken=your-access-token
  accessTokenSecret=your-access-token-secret
}
```

How to run
----------

Have a look at ```src/main/scala/org/bfc/streaming/twitter/Boot.scala```.
For declaring filters use :

```scala
filters("music","dance")
```

For declaring actions to perform when a fresh bunch of tweets arrive:

```scala
when{ tweets =>
 logger.info(tweets.count)
}
```

When you're finished, start receiving tweets by

```scala
listen()
```

To execute the provided example just:

```
  sbt run
```

License
-------

Twitter(C)-stream is licensed as Apache2.

Credits
-------

(TODO)

