package com.presidio.sales.read

import org.apache.spark.sql.{DataFrame, SparkSession}

trait ParquetReader {
  def readAsDataFrame(sparkSession: SparkSession, path: String): DataFrame
}
