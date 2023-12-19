package com.github.mideo.aoc.exercises

import com.github.mideo.aoc.exercises.testexercise.DummyExercise

class AdventOfCodeExerciseTest extends TestSpec {
  "AdventOfCodeExercise" should "find exercise in given package" in {
    val exercises = AdventOfCodeExercise.list("com.github.mideo.aoc.exercises.testexercise")

    exercises should contain theSameElementsAs List(DummyExercise())
  }
}
