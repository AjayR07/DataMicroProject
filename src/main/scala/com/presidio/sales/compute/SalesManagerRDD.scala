package com.presidio.sales.compute

import org.apache.spark.rdd.RDD


trait SalesManagerRDD {
  def listProductTypes(data: RDD[Array[String]], productLine: String): RDD[String]

  def computeRevenue(data: RDD[Array[String]], state: String): Double
}
