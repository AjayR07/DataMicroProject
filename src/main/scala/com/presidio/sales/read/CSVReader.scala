package com.presidio.sales.read

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, SparkSession}

trait CSVReader {
  def readAsDataFrame(sparkSession: SparkSession, path: String): DataFrame

  def readAsRDD(sparkSession: SparkSession, path: String): RDD[Array[String]]
}