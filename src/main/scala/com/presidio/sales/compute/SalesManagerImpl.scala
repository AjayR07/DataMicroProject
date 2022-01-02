package com.presidio.sales.compute

import org.apache.spark.sql.{DataFrame, Dataset, Row}

class SalesManagerImpl extends SalesManager {
  override def listProductTypes(dataFrame: DataFrame, productLine: String): Dataset[Row] = {
    dataFrame.select("Product Type").where(dataFrame("Product line") === productLine)
      .na.drop().distinct()
  }

  override def computeRevenue(dataFrame: DataFrame, state: String): Double = {
    3.5F
  }
}
