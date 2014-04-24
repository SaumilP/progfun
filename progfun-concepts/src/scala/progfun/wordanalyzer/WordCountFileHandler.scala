package progfun

import scala.io.Source
import java.io.FileNotFoundException

/**
 * Object operating on File and working with File Handlers.<br />
 *
 * Created by saumil on 2014/04/24.
 */
object WordCountFileHandler {
	val format = "utf-8"

  /**
   * Parses and returns word-frequency map
   * @param filename  Input Parse file ( full path )
   * @return  word list
   */
	def parseFile(filename: String): Option[Iterator[String]] = {
	  parseFile(filename, " ")
	}

  /**
   * <p>Method reads and parses the file using provided word separator and returns word-frequency map. <br /></p>
   * @param filename  Input file
   * @param seperator Word Seperator (In String)
   * @return  word List
   */
	def parseFile(filename: String, seperator: String): Option[Iterator[String]] = {
	  try{
	    val words = Source.fromFile(filename).getLines()
	    
	    val wordList = words.reduceLeft(_ + seperator + _ )
	    				    .replaceAll("^[a-zA-Z]", "")
	    				    .split(seperator)
	    wordList.length match {
	      case 0 => return None
	      case _ => return Some(wordList.iterator)
	    }
	  } catch {
	    case _ : FileNotFoundException => println("file[" + filename + "] not found");	return None
	    case e: Exception => println("Unknown exception occurred during file handling, " + e.getStackTrace() );	return None
	  }
	}
}