package com.github.mideo.aoc.exercises

import scala.collection.mutable

class Day1 extends AdventOfCodeExercise {

  override val name: String = "Day 1: Trebuchet?!"

  override val url: String = "https://adventofcode.com/2023/day/1"

  val speltDigits = Map(
    "one" -> 1,
    "two" -> 2,
    "three" -> 3,
    "four" -> 4,
    "five" -> 5,
    "six" -> 6,
    "seven" -> 7,
    "eight" -> 8,
    "nine" -> 9
  )

  private def calibrate(input: Array[String]): String = input
    .map(it => it.toCharArray.filter(Character.isDigit).toList)
    .map {
      case x :: Nil => s"$x$x".toInt
      case x :: y => s"$x${y.last}".toInt
      case _ => 0
    }.sum.toString

  override def part1(input: String): String = {
    val transformed = input.split("\n").filter(!_.isBlank)
    calibrate(transformed)
  }

  private def maybeSubstitute(original: String): String = {
    val queue: mutable.Queue[Char] = mutable.Queue.empty
    original.toCharArray.foreach(
      x => {
        queue.addOne(x)
        val joined = queue.mkString
        speltDigits.keys
          .find(it => joined.contains(it))
          .foreach {
            k => queue.removeAll()
              queue.addAll(joined.replace(k.substring(0,2), speltDigits(k).toString).toCharArray)
          }


      }
    )

    queue.mkString
  }

  override def part2(input: String): String = {
    val transformed = input.split("\n").filter(!_.isBlank).map(it => maybeSubstitute(it))
    calibrate(transformed)
  }
}
