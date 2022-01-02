package com.presidio.sales.compute

import org.apache.spark.sql.functions._

import org.apache.spark.sql.{DataFrame, Dataset, Row}

class SalesManagerDataFrameImpl extends SalesManagerDataFrame {
  override def listProductTypes(dataFrame: DataFrame, productLine: String): Dataset[Row] = {
    dataFrame.select("Product Type").where(dataFrame("Product line") === productLine)
      .na.drop().distinct()
  }

  override def computeRevenue(dataFrame: DataFrame, state: String): Double = {
    val countryRevenue = dataFrame.select("Revenue").where(dataFrame("Retailer country") === state).na.drop()
    countryRevenue.agg(sum("Revenue")).first().getDouble(0)
  }
}
