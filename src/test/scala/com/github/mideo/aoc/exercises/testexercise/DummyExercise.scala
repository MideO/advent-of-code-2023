package com.github.mideo.aoc.exercises.testexercise

import com.github.mideo.aoc.exercises.AdventOfCodeExercise

case class DummyExercise() extends AdventOfCodeExercise {
  override val name: String = "Dummy Exercise"

  override def run(): String = "Dummy Output"
}
