object map_worksheet {

  /*Print Map*/
  //Create a English-to-Hindi map for few animals
  val engToHind = Map(("dog","kuttā"), ("cat", "billī"), ("rhinoceros", "gaiṇḍā"))

  //get value from Map
  engToHind("dog")
  /* List to Map conversion*/
  //setup English & Hindi Words
  val engWords = List("dog", "cat", "rhinoceros")
  val hindWords = List("kuttā", "billī", "gaiṇḍā")

  //Convert created List into Map
  engWords.zip(hindWords).toMap

  /*Immutable List creation*/
  val moreAnimals = Map(("hippopotamus","dariyā'ī ghōṛā"),("owl","ullū"), ("horse", "ghōṛā"))
  val extendedEngToHind = engToHind ++ moreAnimals

  /* Read and count words frequency */
  scala.io.Source
    .fromInputStream( getClass.getResourceAsStream("../resources/test.txt"))
    .getLines()
    .flatMap(_.split("\\W+"))
    .foldLeft(Map.empty[String, Int]){
    (count, word) => count + (word -> (count.getOrElse(word, 0)+1) )
  }

  /* Read and count total number of words */
  scala.io.Source
    .fromInputStream( getClass.getResourceAsStream("../resources/test.txt"))
    .getLines()
    .flatMap(_.split("\\W+"))
    .toList
    .length
}