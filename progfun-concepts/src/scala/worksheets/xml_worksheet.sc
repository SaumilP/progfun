object xml_worksheet{
  val catalog =
    <catalog>
      <book>
        <description>hot dog #5</description>
        <publicationDate>1998-02-01</publicationDate>
        <dateObtained>April 20, 2013</dateObtained>
        <price>81.09</price>
        <currency>ZAR</currency>
        <quantity>10</quantity>
      </book>
      <book>
        <description>Sprite Boy</description>
        <publicationDate>1999-10-10</publicationDate>
        <dateObtained>April 21, 2013</dateObtained>
        <price>99.00</price>
        <currency>ZAR</currency>
        <quantity>7</quantity>
      </book>
    </catalog>

  catalog match {
    case <catalog>{items @ _*}</catalog> =>
      for( item <- items)
        println("processing: " + (item \ "description").text)
  }

}