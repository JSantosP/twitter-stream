package org.bfc.streaming.core.util

import com.typesafe.config.ConfigFactory

trait Config {

  lazy val config = ConfigFactory.load("app.conf")

}

object Config {

  val SparkMaster = "bfc.streaming.spark.master"
  val AppName = "bfc.streaming.spark.app-name"
  val WindowSeconds = "bfc.streaming.window-seconds"

}