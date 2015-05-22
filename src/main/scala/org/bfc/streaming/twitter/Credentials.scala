package org.bfc.streaming.twitter

trait Credentials {_: org.bfc.streaming.core.util.Config =>
  import Credentials._

    System.setProperty(ConsumerKey, config.getString(ConsumerKey))
    System.setProperty(ConsumerSecret, config.getString(ConsumerSecret))
    System.setProperty(AccessToken, config.getString(AccessToken))
    System.setProperty(AccessTokenSecret, config.getString(AccessTokenSecret))

}

object Credentials {

  val ConsumerKey = "twitter4j.oauth.consumerKey"
  val ConsumerSecret = "twitter4j.oauth.consumerSecret"
  val AccessToken = "twitter4j.oauth.accessToken"
  val AccessTokenSecret = "twitter4j.oauth.accessTokenSecret"

}
