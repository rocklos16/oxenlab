package test

import scala.collection.JavaConverters.mapAsJavaMapConverter
import scala.collection.Map

import org.apache.commons.logging.LogFactory
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD
import org.elasticsearch.hadoop.cfg.ConfigurationOptions.ES_INPUT_JSON
import org.elasticsearch.hadoop.cfg.ConfigurationOptions.ES_OUTPUT_JSON
import org.elasticsearch.hadoop.cfg.ConfigurationOptions.ES_QUERY
import org.elasticsearch.hadoop.cfg.ConfigurationOptions.ES_RESOURCE_READ
import org.elasticsearch.hadoop.cfg.ConfigurationOptions.ES_RESOURCE_WRITE
import org.elasticsearch.hadoop.cfg.PropertiesSettings
import org.elasticsearch.spark.cfg.SparkSettingsManager
import org.elasticsearch.hadoop.rest.InitializationUtils


object SaveToEs {

}