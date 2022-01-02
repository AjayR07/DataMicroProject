package com.presidio.sales.compute
import org.apache.spark.rdd.RDD


class SalesManagerRDDImpl extends SalesManagerRDD {
  override def listProductTypes(data: RDD[Array[String]], productLine: String): RDD[String] = {
    data.filter(_ (1).equals(productLine)).map(_ (2)).distinct()
  }
  override def computeRevenue(data: RDD[Array[String]], state: String): Double = {
    0.1
  }
}
