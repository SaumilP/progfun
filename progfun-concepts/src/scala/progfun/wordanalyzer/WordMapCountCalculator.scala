package progfun

import collection.mutable
/**
 * <p>Word Frequency/Count Scala Object<br/>
 *
 * Created by saumil on 2014/04/24.
 *</p>
 */
object WordMapCountCalculator {
	def parseFile(wordList: Iterator[String]): mutable.Map[String, Int] = {
	  wordList.foldLeft(new mutable.HashMap[String, Int])((word, count) => {
	    word get(count) match {
	      case Some(x) => word += (count -> (x+1))
	      case None => word += (count -> 1)
	    }
	  }).asInstanceOf[mutable.Map[String, Int]]
	}
}