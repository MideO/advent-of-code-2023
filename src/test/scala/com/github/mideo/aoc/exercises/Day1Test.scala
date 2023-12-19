package com.github.mideo.aoc.exercises

class Day1Test extends TestSpec {
  val exercise = new Day1
  it should "calibration value by combining the first digit and the last digit (in that order) to form a single two-digit number " in {
    val input1 =
      """
        |1abc2
        |pqr3stu8vwx
        |a1b2c3d4e5f
        |treb7uchet
        |""".stripMargin
    exercise.part1(input1) should equal("142")
  }

  it should "calibration value by combining the first  and the last digit or spelt number to form a single two-digit number with overlapping words" in {

    exercise.part2("ddgjgcrssevensix37twooneightgt") should equal("78")
  }

  it should "calibration value by combining the first  and the last digit or spelt number to form a single two-digit number" in {
    val input1 =
      """
        |two1nine
        |eightwothree
        |abcone2threexyz
        |xtwone3four
        |4nineeightseven2
        |zoneight234
        |7pqrstsixteen
        |""".stripMargin
    exercise.part2(input1) should equal("281")
  }
}
