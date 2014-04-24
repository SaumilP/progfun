package progfun

import collection.mutable

/**
 * <p>
 *   Another version of word count analyzer. <br/>
 *
 * Created by saumil on 2014/04/24.
 *</p>
 */
object WordAnalyzer {
  /**
   * Accepts mutable Map and returns number of words
   * @param input Mutable Map ( (String, Int) -> (word, Count) )
   * @return number of words
   */
	def getNumberOfWords(input: mutable.Map[String, Int]): Int = {
	  input.size
	}

  /**
   * Returns Sorted Map with Ordering as most number of word occurrence on top of the map
   * @param input Mutable Map ( (String, Int) -> (word, Count) )
   * @param c Returning Map size
   * @return Sorted Hash Map (DESC)
   */
	def getTopWordsDeclarative(input: mutable.HashMap[String, Int], c: Int): Map[String, Int] = {
	  val sortedHashMap = input.toList.sortWith(_._2 > _._2 )
	  sortedHashMap.take(c).toMap
	}

  /**
   * Returns ascending sorted hash-map
   * @param input Mutable Map ( (String, Int) -> (word, Count) )
   * @param c Returning Map Size
   * @return Sorted Hash Map ( ASC )
   */
	def getTopWordsImprative(input: mutable.HashMap[String, Int], c: Int): mutable.Map[String, Int] = {
	  var lastElement: (String, Int) = ("", 0)
	  val topList = mutable.HashMap[String, Int]()
	  
	  for(x <- input){
	    if(x._2 >= lastElement._2 && topList.size == c ){
	      topList -= (lastElement._1)
	      topList += ( (x._1, x._2 ))
	      lastElement = topList.toList.minBy(_._2)
	    } else if(topList.size < c ) {
	      topList += ( (x._1, x._2 ))
	      lastElement = topList.toList.minBy(_._2)
	    }
	  }
	  
	  topList.asInstanceOf[mutable.Map[String, Int]]
	}
}