package com.presidio.sales.read

import com.presidio.util.SparkSQLUtility

abstract class CSVReaderService {
  def read(path: String): Any
}

class DataFrameReaderService extends CSVReaderService {
  def read(path: String): Any = {
    val sparkSession = new SparkSQLUtility().getSession
    val df = sparkSession.read.format("csv").option("header", "true").load(path)
    df
  }
}

class RDDReaderService extends CSVReaderService {
  def read(path: String): Any = {
    val sparkContext = new SparkSQLUtility().getSession.sparkContext
    val textFileRDD = sparkContext.textFile(path)
    val mappedRDD = textFileRDD.map(each => each.split(","))
    mappedRDD
  }
}