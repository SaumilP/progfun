package fun

import io.Source
import java.io.FileNotFoundException

/**
 * Object responsible for analyzing file
 * @author SaumilP
 */
object FileParser {
  
	/**
	 * Returns total number of unique word count
	 * @param file	input file-path
	 * @returns 	Total number of words
	 */
	def getWordCount(file: String): Int = {
	  try {
	    Source.fromFile(file).getLines.flatMap(_.split("\\W+")).toList.length
	  } catch {
	    case e: FileNotFoundException => sys.error("No file named %s found".format(file) )
	  }
	}
	
	/**
	 * Returns unique words with associated occurrence counts
	 * @param file	input file-path
	 * @returns Word Occurrence Map
	 */
	def getWordOccurences(file: String): Map[String, Int] = {
	  val words = try {
	    Source.fromFile(file).getLines.toSeq.map(_.toLowerCase.trim)
	  } catch {
	    case e: FileNotFoundException => sys.error("No file named %s found".format(file) )
	  }
	  
	  /* get number of lines per files and collect map with total word occurrences*/
	  words.groupBy(identity).mapValues(_.size)
	}
}