package com.presidio

import com.presidio.sales.SalesManagerImpl

object SalesEngine {
  def main(args: Array[String]): Unit = {
    val sales = new SalesManagerImpl()
    sales.readSalesDetails("assets/sales.csv")
  }
}
