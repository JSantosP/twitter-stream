package org.bfc.twitter.util

import com.typesafe.config.ConfigFactory

trait Config {

  lazy val config = ConfigFactory.load("app.conf")

}

object Config {

  val SparkMaster = "bfc.twitter-stream.spark.master"
  val AppName = "bfc.twitter-stream.spark.app-name"
  val WindowSeconds = "bfc.twitter-stream.window-seconds"

}