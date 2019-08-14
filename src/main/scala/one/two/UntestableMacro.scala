package one.two

import scala.annotation.{StaticAnnotation, compileTimeOnly}
import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context

@compileTimeOnly("UntestableMacro requires the macro paradise plugin")
class UntestableMacro extends StaticAnnotation {
  def macroTransform(annottees: Any*): Any = macro UntestableMacro.impl
}

object UntestableMacro {
  def impl(c: Context)(annottees: c.Expr[Any]*): c.Expr[Any] = {
    println(annottees.head)
    annottees.head
  }
}
