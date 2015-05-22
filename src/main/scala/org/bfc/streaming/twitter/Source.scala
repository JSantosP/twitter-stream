package org.bfc.streaming.twitter

import org.apache.spark.streaming.dstream.ReceiverInputDStream
import org.apache.spark.streaming.twitter.TwitterUtils
import org.bfc.streaming.core

trait Source extends core.Source with Filters{
  _:core.util.Config =>

  type Content = twitter4j.Status

  lazy val stream: ReceiverInputDStream[Content] = TwitterUtils.createStream(ssc, None, filters)

}
