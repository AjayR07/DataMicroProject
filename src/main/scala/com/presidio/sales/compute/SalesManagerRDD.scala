package com.presidio.sales.compute

import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession


trait SalesManagerRDD {
  def listProductTypes(data: RDD[Array[String]], productLine: String): RDD[String]

  def computeRevenue(sparkContext: SparkContext, data: RDD[Array[String]], state: String): Double
}
