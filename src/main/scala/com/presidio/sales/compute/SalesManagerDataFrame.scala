package com.presidio.sales.compute

import org.apache.spark.sql.{DataFrame, Dataset, Row}

trait SalesManagerDataFrame {

  def listProductTypes(dataFrame: DataFrame, productLine: String): Dataset[Row]

  def computeRevenue(dataFrame: DataFrame, state: String): Double
}
