package com.presidio.sales

import com.presidio.util.SparkSQLUtility
import org.apache.spark.rdd.RDD

class SalesManagerImpl extends SalesManager {
  override def readSalesDetails(src: String): RDD[Array[String]] = {
    val sparkContext = new SparkSQLUtility().getSession.sparkContext
    val textfileRDD = sparkContext.textFile(src)
    val mappedRDD = textfileRDD.map(each=>each.split(","))
    println("Reading Sales Details")




//    val filteredRDD = mappedRDD.filter(_(1).equals("Golf Equipment"))
//    filteredRDD.foreach(each=>println(each.mkString(",")))
    mappedRDD
  }

  override def listProductTypes(productLine: String): List[String] = {
    List()
  }

  override def computeRevenue(state: String): Float = {
    3.5F
  }
}
