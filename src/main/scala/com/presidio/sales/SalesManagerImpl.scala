package com.presidio.sales

import com.presidio.util.SparkSQLUtility
import org.apache.spark.rdd.RDD

class SalesManagerImpl extends SalesManager {
  override def listProductTypes(productLine: String): List[String] = {
    List()
  }

  override def computeRevenue(state: String): Float = {
    3.5F
  }
}
