package test


import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SQLContext    
import org.apache.spark.sql.SQLContext._

import org.elasticsearch.spark.sql._ 



object Testing {
  def main(args: Array[String]) {
    
    
    
    val conf = new SparkConf().setAppName("jsheo-test").setMaster("local")

    conf.set("spark.driver.allowMultipleContexts", "true")
    conf.set("es.index.auto.create", "true")
    conf.set("es.nodes.discovery", "true")
    conf.set("es.nodes", "158.69.54.141:9200")
    conf.set("pushdown", "true")
    
    val sc = new org.apache.spark.SparkContext(conf);
    
    val sqlContext = new SQLContext(sc)
    
    val df = sqlContext.read.format("org.elasticsearch.spark.sql").load("bank/account")
    val df2 = sqlContext.read.format("org.elasticsearch.spark.sql").load("bank2/account")

    df.registerTempTable("bank1")
    //sqlContext.sql("SELECT COUNT(*) FROM bank1").show()
    
    //sqlContext.sql("SELECT firstname, lastname, email FROM bank1").show()
    
    df2.registerTempTable("bank2")
    val join = sqlContext.sql("SELECT bank1.firstname, bank1.lastname, bank2.email FROM bank1 INNER JOIN bank2 WHERE bank1.email=bank2.email")

    
    join.coalesce(1).write.json("JSON/join.json")
    //join.show()
    
    //join.select("lastname").show()
    
    join.coalesce(1).write.csv("CSV/join.csv")
   
    //join.saveToEs("join/account")
    //join.registerTempTable("join")
    
    //sqlContext.sql("SELECT * FROM bank2").saveToEs("join/account")
    
    println("sql  ikram is working here ")
  }
}