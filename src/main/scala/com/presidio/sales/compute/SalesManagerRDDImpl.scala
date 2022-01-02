package com.presidio.sales.compute
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession



class SalesManagerRDDImpl extends SalesManagerRDD {
  override def listProductTypes(data: RDD[Array[String]], productLine: String): RDD[String] = {
    data.filter(_ (1).equals(productLine)).map(_ (2)).distinct()
  }
   def computeRevenue(sparkContext : SparkContext, data: RDD[Array[String]], state: String): Double = {
    val totalAcc = sparkContext.doubleAccumulator("TotalRevenue")

    val filteredRDD = data.filter(_(5).equals(state))
                          .filter(_(6).nonEmpty)
     filteredRDD.foreach(each => totalAcc.add(each(6).toDouble))

     totalAcc.value
  }


}
