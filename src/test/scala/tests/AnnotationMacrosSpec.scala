package tests

import org.scalatest.FlatSpec
import testutils.ParadisicalToolBox

class AnnotationMacrosSpec extends FlatSpec with ParadisicalToolBox {

  "TestableMacro" should "be expanded without erroring" in {
    val tree = toolbox.parse {
      """
        |import one.TestableMacro
        |
        |@TestableMacro
        |object TestableUselessObject {}
        |""".stripMargin
    }

    toolbox.compile(tree)
  }

  "UntestableMacro" should "be expanded without erroring" in {
    val tree = toolbox.parse {
      """
        |import one.two.UntestableMacro
        |
        |@UntestableMacro
        |object UntestableUselessObject {}
        |""".stripMargin
    }

    toolbox.compile(tree)
  }

}
