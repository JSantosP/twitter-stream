package org.bfc.streaming.core

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.ReceiverInputDStream
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.bfc.streaming.core.util.Config

/**
 * A Source opens a stream of tweets from set configuration.
 */
trait Source extends Actions {
  _: util.Config =>

  val conf = new SparkConf()
    .setAppName(config.getString(Config.AppName))
    .setMaster(config.getString(Config.SparkMaster))

  val windowTime = Seconds(config.getInt(Config.WindowSeconds))

  val ssc = new StreamingContext(conf, windowTime)

  val stream: ReceiverInputDStream[Content]

}
