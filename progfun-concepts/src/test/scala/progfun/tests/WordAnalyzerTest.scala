package test.scala.progfun.tests

import _root_.progfun.{WordMapCountCalculator, WordCountFileHandler, WordAnalyzer}

/**
 * Word Analyzer Test Class
 * Created by saumil on 2014/04/24.
 */
object WordAnalyzerTest {
  def main(args: Array[String]) {
    val fileName = "/etc/hosts"

    //easiest way to test word count
    val totalWordCount = scala.io.Source.fromFile(fileName)
      .getLines()
      .flatMap(_.split("\\W+"))
      .foldLeft(Map.empty[String, Int]){
        (count, word) => count + (word -> (count.getOrElse(word, 0) + 1))
      }.size

    val totalLineCount = WordAnalyzer.getNumberOfWords( collection.mutable.Map() ++
      scala.io.Source.fromFile(fileName)
        .getLines
        .toSeq
        .map(_.toLowerCase.trim)
        .groupBy(identity)
        .mapValues(_.size)
    )

    println("File["+ fileName +"] LineCount["+totalLineCount+"] WordCount[" + totalWordCount + "]")
  }
}
