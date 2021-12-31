package com.presidio.util

import org.apache.spark.sql.SparkSession


class SparkSQLUtility {
  def getSession: SparkSession ={

    val sparkSession= SparkSession.builder()
      .appName("CodaDataJOB")
      .master("local[*]")
//      .master("spark://ajay:7077")
      .getOrCreate()

    sparkSession
  }
}
