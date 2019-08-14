# annotation-macro-testing

Project demonstrating how only annotation macros with certain packages can be tested using the toolbox scala compiler.

We have two annotation macros identical except for their name and package:
- `one.TestableMacro`
- `one.two.UntestableMacro`

The test uses the Scala compiler provided by ToolBox:
```
  lazy val toolbox = runtimeMirror(getClass.getClassLoader)
    .mkToolBox(options = s"-Xplugin:$paradiseJarLocation -Xplugin-require:macroparadise")
```
This successfully tests `one.TestableMacro` but cannot test `one.two.UntestableMacro`. Why?
