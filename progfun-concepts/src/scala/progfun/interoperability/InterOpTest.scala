package scala.progfun.interoperability

import java.io.File
import javax.imageio.ImageIO

/**
 * <p>
 * Scala Object attempts to identify all the JPG image files from
 * user's home directory and copy them to temp directory with extension change as GIF.<br/>
 *
 * It uses Java Library for reading and writing image files from one to another directory.<br/>
 * </p>
 *
 * Created by saumil on 2014/04/24.
 */
object InterOpTest {
  def main ( args: Array[String]){
    val tmp = new File(System.getProperty("java.io.tmpdir"))
    val home = new File(System.getProperty("user.home"))
    val outputDir = new File(tmp, "interop")
    outputDir.mkdir()

    home.listFiles
      .filter(_.isDirectory)
      .map(_.listFiles)
      .filter(_ != null)
      .flatten
      .filter(_.getName.toLowerCase.endsWith(".jpg"))
      .toStream
      .map(file => {
        println(">>>  Reading: " + file.getAbsolutePath )
        (file, ImageIO.read(file))
      }).foreach( imageFile => {
        val (file,image) = imageFile
        val newImgFile = file.getName.splitAt( file.getName.lastIndexOf('.') )._1 + ".gif"
        val opImageFile = new File(outputDir, newImgFile)

        println("<<<  Writing: " + opImageFile.getAbsolutePath )
        ImageIO.write(image, "GIF", opImageFile )
      })
  }
}
