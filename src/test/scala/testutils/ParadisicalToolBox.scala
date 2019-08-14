package testutils

import java.net.URL
import java.nio.file.Paths

import scala.reflect.runtime.universe.runtimeMirror
import scala.tools.reflect.ToolBox

trait ParadisicalToolBox {

  private def classPathUrls(cl: ClassLoader): List[String] = cl match {
    case null => Nil
    case u: java.net.URLClassLoader => u.getURLs.toList.map(systemPath) ++ classPathUrls(cl.getParent)
    case _ => classPathUrls(cl.getParent)
  }

  private def systemPath(url: URL): String = {
    Paths.get(url.toURI).toString
  }

  private def paradiseJarLocation: String = {
    val classPath = classPathUrls(getClass.getClassLoader)
    classPath.find(_.contains("paradise")).getOrElse {
      throw new RuntimeException(s"Could not find macro paradise on the classpath: ${classPath.mkString(";")}")
    }
  }

  lazy val toolbox = runtimeMirror(getClass.getClassLoader)
    .mkToolBox(options = s"-Xplugin:$paradiseJarLocation -Xplugin-require:macroparadise")

}
