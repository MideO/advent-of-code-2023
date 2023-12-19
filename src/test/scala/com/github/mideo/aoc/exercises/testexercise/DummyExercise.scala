package com.github.mideo.aoc.exercises.testexercise

import com.github.mideo.aoc.exercises.AdventOfCodeExercise

case class DummyExercise() extends AdventOfCodeExercise {
  override val name: String = "Dummy Exercise"

  override val url: String = "test"
  override def part1(input: String): String = "Dummy Output"
  override def part2(input: String): String = "Dummy Output"
}
