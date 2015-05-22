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

Declare an Scala bootable object like this in your project:

```scala

import org.bfc.streaming.core.Analytics

object Boot extends Analytics{

  //  Add filters ...

  filter(
    "dance",
    "music"
  )

  //  ... add actions to perform ...

  when { tweets =>
    tweets.foreach {
      tweet => logger.info(s"\n$tweet")
    }
  }

  when { tweets =>
    logger.info(s"Received tweets [${tweets.count()}}]")
  }

  // ... and begin listening
  
  listen()

}
```

And then:

```
  sbt run
```

License
-------

Twitter(C)-stream is licensed as Apache2.

Credits
-------

(TODO)

