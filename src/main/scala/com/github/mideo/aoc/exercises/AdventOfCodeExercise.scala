package com.github.mideo.aoc.exercises

import org.reflections.Reflections
import org.reflections.scanners.Scanners

import scala.jdk.CollectionConverters.CollectionHasAsScala
import scala.reflect.classTag


abstract class AdventOfCodeExercise {
  val url:String
  val name: String
  def part1(input: String): String
  def part2(input: String): String
  def run(input: String): Unit =  {
    println(s"Part 1: ${part1(input)}")
    println(s"Part 2: ${part2(input)}")
  }
}

object AdventOfCodeExercise {
  def list(`package`: String): Seq[AdventOfCodeExercise] = new Reflections(`package`, Scanners.SubTypes)
    .getSubTypesOf(classTag[AdventOfCodeExercise].runtimeClass)
    .asScala
    .map(it => it.getDeclaredConstructor().newInstance().asInstanceOf[AdventOfCodeExercise])
    .toList.reverse
}