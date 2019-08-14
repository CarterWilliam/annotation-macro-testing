package one

import scala.annotation.{StaticAnnotation, compileTimeOnly}
import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context

@compileTimeOnly("TestableMacro requires the macro paradise plugin")
class TestableMacro extends StaticAnnotation {
  def macroTransform(annottees: Any*): Any = macro TestableMacro.impl
}

object TestableMacro {
  def impl(c: Context)(annottees: c.Expr[Any]*): c.Expr[Any] = {
    println(annottees.head)
    annottees.head
  }
}
