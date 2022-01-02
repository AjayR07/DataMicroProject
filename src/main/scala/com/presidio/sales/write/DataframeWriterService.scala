package com.presidio.sales.write

import org.apache.spark.sql.DataFrame

abstract class DataframeWriterService {
  def write(dataFrame : DataFrame,outputPath : String) : Unit
}

class ParquetWriterService extends  DataframeWriterService {
  override def write(dataFrame: DataFrame, outputPath: String): Unit = {
    dataFrame.write.parquet(outputPath)
  }
}