package fun

import scala.actors._
import Actor._

class WordCounter {
	 val files  = List[String](
        "C:\\temp\\test.txt",
        "D:\\temp\\custom_prompts.txt",
        "D:\\temp\\brit-a-z.txt",
        "D:\\temp\\acc_specific_active_lines.txt",
        "D:\\temp\\WindowsServiceODPFailure.log",
        "D:\\temp\\Loyiso.txt",
        "C:\\temp\\pg1661.txt",
        "C:\\temp\\SomeFilename.log");
	
	 /**
	  * Counts words in sequencial order
	  */
	def getWordCountSequencially() = {
	  for (f <- files) {
            println("\t" + f + ": " + FileParser.getWordCount(f));
        }
	}
	
	/**
	 * Counts words for list of files concurrently.<br/>
	 * It uses Actor Model for concurrency
	 */
	def getWordCountConcurrently() = {
	  val caller = self
 
        for (f <- files) {
            actor { caller ! (f, FileParser.getWordCount(f)) }
        }
 
        for (i <- 1 to files.size) {
            receive {
                case (f, count) =>
                    println("\t" + f + ": " + count)
                case _ =>
                    println("This Shouldn't happen, Incorrect type received from caller")
            }
        }
	}
}