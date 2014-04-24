package scala.progfun.interoperability

/**
 * Created by saumil on 2014/04/24.
 */

import java.progfun.content.AccountJTest

object AccountSTest {
  def main (args: Array[String]) {
    println("About to call java code...")
    AccountJTest.Main(args)
  }
}
