package com.presidio.sales

import org.apache.spark.rdd.RDD

trait SalesManager {

  def listProductTypes(productLine : String): List[String]

  def computeRevenue(state : String): Float
}
