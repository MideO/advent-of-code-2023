import com.github.mideo.aoc.exercises.AdventOfCodeExercise

object Main {
  def main(args: Array[String]): Unit = {
    christmasTree()
    AdventOfCodeExercise.list("com.github.mideo.aoc.exercises").foreach(
      exercise => {
        println(s"Running ${exercise.name}")
        exercise.run()
      }
    )
  }

  private def triangle(indent: Int, start: Int, size: Int): Unit = {
    (start until size) foreach {
      row => println(" ".repeat(size - row - 1 + indent) + "*".repeat(1 + 2 * row))
    }
  }

  private def christmasTree(): Unit = {
    println("")
    println("")

    triangle(15, 0, 3)
    triangle(12, 2, 6)
    triangle(10, 4, 8)
    (1 until 3) foreach (_ => println(" ".repeat(15) + "*".repeat(5)))

    println(s"**** Advent Of Code Exercises 2023 ****")
  }


}