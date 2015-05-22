package org.bfc.streaming.core.util

import org.slf4j.LoggerFactory

trait Logging {

	lazy val logger = LoggerFactory.getLogger(getClass.getName)
	
}