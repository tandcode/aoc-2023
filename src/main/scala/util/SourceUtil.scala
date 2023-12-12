package util

import scala.io.Source
import scala.util.Using

object SourceUtil {
  def readLinesFrom(fileName: String): Seq[String] = Using(Source.fromResource(fileName))(_.getLines().toSeq)
    .getOrElse(Nil)

  def readStringFrom(fileName: String): String = Using(Source.fromResource(fileName))(_.mkString).getOrElse("")
}
