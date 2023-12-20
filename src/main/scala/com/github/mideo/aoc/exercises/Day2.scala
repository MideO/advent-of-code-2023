package com.github.mideo.aoc.exercises

class Day2 extends AdventOfCodeExercise {
  private val maxRound: Round = Round(red = 12, green = 13, blue = 14)
  override val url: String = "https://adventofcode.com/2023/day/2"
  override val name: String = "Day 2: Cube Conundrum"

  override def part1(input: String): String = Games(input)
    .filter(_.allRoundsCubesNotExceeding(maxRound))
    .map(_.id).sum.toString

  override def part2(input: String): String = Games(input)
    .maxForEachRound
    .map(_.product)
    .sum
    .toString
}

case class Round(blue: Int = 0, green: Int = 0, red: Int = 0) {
  def cubesIn(maxRound: Round): Boolean = blue <= maxRound.blue && green <= maxRound.green && red <= maxRound.red

  def product: Int = blue * green * red
}

object Round {
  def apply(input: String): Round = input.split(",")
    .foldLeft(Round()) {
      (r, a) =>
        a.split(" ").toList.filter(!_.isBlank) match {
          case x :+ "red" => r.copy(red = x.head.toInt)
          case x :+ "blue" => r.copy(blue = x.head.toInt)
          case x :+ "green" => r.copy(green = x.head.toInt)
          case _ => r
        }
    }
}

case class Game(id: Int, rounds: Round*) {
  def allRoundsCubesNotExceeding(maxRound: Round): Boolean = rounds.forall(_ cubesIn maxRound)

  def maxForEachRound: Round = rounds.foldLeft(Round()) {
    (acc, round) =>
      acc.copy(
        red = if (acc.red > round.red) acc.red else round.red,
        blue = if (acc.blue > round.blue) acc.blue else round.blue,
        green = if (acc.green > round.green) acc.green else round.green
      )
  }
}

case class Games(games: Game*) {
  def maxForEachRound: Seq[Round] = games.map(_.maxForEachRound)

  def filter(func: Game => Boolean): Seq[Game] = games.filter(func)

}

object Games {
  def apply(input: String): Games =
    Games(input.split("\n")
      .filter(!_.isBlank)
      .map {
        line =>
          val split = line.split(":")
          val id = split.head.split(" ").last.toInt
          val rounds = split.last.split(";").map(Round.apply)
          Game(id, rounds: _*)
      }: _*)
}