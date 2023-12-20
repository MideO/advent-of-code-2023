package com.github.mideo.aoc.exercises

class Day2Test extends TestSpec {
  val round: Round = Round(green = 13, blue = 14, red = 12)
  val GamesInput: String =
    """
      |Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
      |Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
      |Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
      |Game 80: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
      |Game 1000: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green
      |""".stripMargin

  "Round" should "build round" in {
    Round("") should equal(Round())
    Round("2 green") should equal(Round(green = 2))
    Round("1 red, 2 green, 6 blue") should equal(Round(green = 2, blue = 6, red = 1))
  }

  "Round" should "return true if all count of cubes is less than given round" in {
    Round("1 red, 2 green, 6 blue") cubesIn round should be(true)
  }

  "Round" should "return false if any count of cubes is greater than given round" in {
    Round("50 red, 2 green, 6 blue") cubesIn round should be(false)
  }

  "Round" should "return product" in {
    Round("6 blue, 4 red").product should equal(0)
    Round("6 blue, 4 red, 2 green").product should equal(48)
    Round("1 red, 3 green, 4 blue").product should equal(12)
    Round("20 red, 13 green, 6 blue").product should equal(1560)
  }

  "Game" should "return true when all rounds less than give max" in {
    Game(1, Round("")).allRoundsCubesNotExceeding(round) should be(true)
    Game(2, Round("3 blue, 4 red")).allRoundsCubesNotExceeding(round) should be(true)
  }

  "Game" should "return false when all rounds less than give max" in {
    Game(3, Round("2 green, 1 blue"),
      Round("3 green, 4 blue, 1 red"),
      Round("100 green, 4 blue, 1 red"),
      Round("1 green, 1 blue")).allRoundsCubesNotExceeding(round) should be(false)
  }

  "Game" should "return max for each round" in {
    Game(1, Round("3 blue, 4 red"), Round("1 red, 2 green, 6 blue"), Round("2 green")).maxForEachRound should equal(
      Round("6 blue, 4 red, 2 green")
    )

    Game(2, Round("1 blue, 2 green"), Round("3 green, 4 blue, 1 red"), Round("1 green, 1 blue")).maxForEachRound should equal(
      Round("1 red, 3 green, 4 blue")
    )

    Game(3, Round("8 green, 6 blue, 20 red"), Round("5 blue, 4 red, 13 green"), Round("5 green, 1 red")).maxForEachRound should equal(
      Round("20 red, 13 green, 6 blue")
    )

    Game(80, Round("1 green, 3 red, 6 blue"), Round("3 green, 6 red"), Round("3 green, 15 blue, 14 red")).maxForEachRound should equal(
      Round("14 red, 3 green, 15 blue")
    )

    Game(1000, Round("6 red, 1 blue, 3 green"), Round(" 2 blue, 1 red, 2 green")).maxForEachRound should equal(
      Round("6 red, 3 green, 2 blue")
    )
  }


  "Games" should "build game collection" in {
    Games(GamesInput) should equal(Games(
      Game(1, Round("3 blue, 4 red"), Round("1 red, 2 green, 6 blue"), Round("2 green")),
      Game(2, Round("1 blue, 2 green"), Round("3 green, 4 blue, 1 red"), Round("1 green, 1 blue")),
      Game(3, Round("8 green, 6 blue, 20 red"), Round("5 blue, 4 red, 13 green"), Round("5 green, 1 red")),
      Game(80, Round("1 green, 3 red, 6 blue"), Round(" 3 green, 6 red"), Round("3 green, 15 blue, 14 red")),
      Game(1000, Round("6 red, 1 blue, 3 green"), Round(" 2 blue, 1 red, 2 green"))
    ))
  }

  "Games" should "return all games where all bag quantity can retrieved from given bag" in {
    Games(GamesInput).filter(_.allRoundsCubesNotExceeding(round)) should contain theSameElementsAs Seq(
      Game(1, Round("3 blue, 4 red"), Round("1 red, 2 green, 6 blue"), Round("2 green")),
      Game(2, Round("1 blue, 2 green"), Round("3 green, 4 blue, 1 red"), Round("1 green, 1 blue")),
      Game(1000, Round("6 red, 1 blue, 3 green"), Round(" 2 blue, 1 red, 2 green"))
    )
  }

  "Games" should "return all maxForEachRound" in {
    Games(GamesInput).maxForEachRound should contain theSameElementsAs Seq(
      Game(1, Round("3 blue, 4 red"), Round("1 red, 2 green, 6 blue"), Round("2 green")).maxForEachRound,
      Game(2, Round("1 blue, 2 green"), Round("3 green, 4 blue, 1 red"), Round("1 green, 1 blue")).maxForEachRound,
      Game(3, Round("8 green, 6 blue, 20 red"), Round("5 blue, 4 red, 13 green"), Round("5 green, 1 red")).maxForEachRound,
      Game(80, Round("1 green, 3 red, 6 blue"), Round("3 green, 6 red"), Round("3 green, 15 blue, 14 red")).maxForEachRound,
      Game(1000, Round("6 red, 1 blue, 3 green"), Round(" 2 blue, 1 red, 2 green")).maxForEachRound
    )
  }

  it should "return sum of ids of all games where all bag quantity can retrieved from given bag" in {
    new Day2().part1(GamesInput) should equal("1003")
  }

  it should "return sum of  all maxForEachRound" in {
    new Day2().part2(GamesInput) should equal("2286")
  }
}
