package com.presidio

import com.presidio.sales.compute.{SalesManagerDataFrameImpl, SalesManagerRDDImpl}
import com.presidio.sales.read.CSVReaderService
import com.presidio.sales.write.ParquetWriterService
import com.presidio.util.SparkSQLUtility

object SalesEngine {
  def main(args: Array[String]): Unit = {
//    System.setProperty("hadoop.home.dir", "D:\\data\\winutils")
    val sparkSession = new SparkSQLUtility().getSession
    val csvReaderService = new CSVReaderService
//    val salesDF = csvReaderService.readAsDataFrame(sparkSession, "assets/sales.csv")
    val salesRDD = csvReaderService.readAsRDD(sparkSession, "assets/sales.csv")
    val salesManagerImpl = new SalesManagerRDDImpl
//    val productTypes = salesManagerImpl.listProductTypes(salesDF, "Golf Equipment").toDF()
//    val parquetWriter = new ParquetWriterService
//    productTypes.show()
//    println(productTypes.count())
//    parquetWriter.write(productTypes.withColumnRenamed("Product Type", "ProductType"),
//      "assets/output/productTypes")
    val productTypes = salesManagerImpl.listProductTypes(salesRDD, "Golf Equipment")
//    println ( salesManagerImpl.computeRevenue(salesDF, "France") )
    productTypes.foreach(println)

  }
}
