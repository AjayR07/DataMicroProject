package com.presidio.sales.read

import com.presidio.util.SparkSQLUtility
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, SparkSession}

class ParquetReaderService  extends  ParquetReader {
  override def readAsDataFrame(sparkSession: SparkSession, path: String): DataFrame = sparkSession.read.parquet(path)
}