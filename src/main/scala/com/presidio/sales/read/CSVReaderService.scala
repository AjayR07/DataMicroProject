package com.presidio.sales.read

import com.presidio.util.SparkSQLUtility
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, SparkSession}

class CSVReaderService extends CSVReader {
  override def readAsDataFrame(sparkSession: SparkSession, path: String): DataFrame = {
    val df = sparkSession.read.format("csv").option("header", "true").load(path)
    df
  }

  override def readAsRDD(sparkSession: SparkSession, path: String): RDD[Array[String]] = {
    val sparkContext = new SparkSQLUtility().getSession.sparkContext
    val textFileRDD = sparkContext.textFile(path)
    val mappedRDD = textFileRDD.map(each => each.split(","))
    mappedRDD
  }
}