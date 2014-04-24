package fun

object WordCountTest {
	def main(args: Array[String]) {
        val crawler = new WordCounter with LoggingProfiler
         
        println("Sequential run:")
        val start = System.nanoTime
        for (i <- 0 until 25) {
            crawler.methodProfiler { crawler.getWordCountSequencially }
        }
        println("=============> Total Runtime: " + (System.nanoTime - start)/1000000000.0 + " seconds <=============")
        
        println("\n\n\nConcurrent run:")
        val start2 = System.nanoTime
        for (j <- 0 until 25) {
            crawler.methodProfiler { crawler.getWordCountConcurrently }
        }
        
        println("=============> Total Runtime: " + (System.nanoTime - start2)/1000000000.0 + " seconds <=============")
    }
}