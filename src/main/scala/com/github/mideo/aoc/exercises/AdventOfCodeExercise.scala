package com.github.mideo.aoc.exercises

import org.reflections.Reflections
import org.reflections.scanners.Scanners

import scala.jdk.CollectionConverters.CollectionHasAsScala
import scala.reflect.classTag


abstract class AdventOfCodeExercise {
  val name: String

  def run(): String
}

object AdventOfCodeExercise {
  def list(`package`: String): Seq[AdventOfCodeExercise] = new Reflections(`package`, Scanners.SubTypes)
    .getSubTypesOf(classTag[AdventOfCodeExercise].runtimeClass)
    .asScala
    .map(it => it.getDeclaredConstructor().newInstance().asInstanceOf[AdventOfCodeExercise])
    .toList
}