package com.presidio

import com.presidio.sales.SalesManagerImpl
import com.presidio.sales.read.CSVReaderService
import com.presidio.util.SparkSQLUtility

object SalesEngine {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "D:\\data\\winutils")
    val sparkSession = new SparkSQLUtility().getSession
    val csvReaderService = new CSVReaderService
    val salesDF = csvReaderService.readAsDataFrame(sparkSession, "assets/sales.csv")
    salesDF.show()
  }
}
