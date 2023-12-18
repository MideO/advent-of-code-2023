package com.github.mideo.aoc.exercises

import com.github.mideo.aoc.exercises.testexercise.DummyExercise
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class AdventOfCodeExerciseTest extends AnyFlatSpec with should.Matchers {
  "AdventOfCodeExercise" should "find exercise in given package" in {
    val exercises =  AdventOfCodeExercise.list("com.github.mideo.aoc.exercises.testexercise")

    exercises should contain theSameElementsAs List(DummyExercise())
  }
}
