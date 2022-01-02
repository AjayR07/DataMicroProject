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




    val salesManagerImpl = new SalesManagerDataFrameImpl
    val salesDF = csvReaderService.readAsDataFrame(sparkSession, "assets/sales.csv")
    //Display Product Types
    val productTypes = salesManagerImpl.listProductTypes(salesDF, "Golf Equipment").toDF()
    println("ProductLine : Golf Equipment has "+productTypes.count()+" Product Types")
    productTypes.show()
    val parquetWriter = new ParquetWriterService
    parquetWriter.write(productTypes.withColumnRenamed("Product Type", "ProductType"), "assets/output/productTypes")
//    Compute Total Revenue
    println ("Total Revenue of France"+ salesManagerImpl.computeRevenue(salesDF, "France") )





//    val salesManagerImpl = new SalesManagerRDDImpl
//    val salesRDD = csvReaderService.readAsRDD(sparkSession, "assets/sales.csv")
//    val productTypes = salesManagerImpl.listProductTypes(salesRDD, "Golf Equipment")
//    productTypes.foreach(println)
//
//    val total = salesManagerImpl.computeRevenue(sparkSession.sparkContext,salesRDD,"France")
//    println(total)


  }
}
