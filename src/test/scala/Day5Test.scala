package den.fox.aoc

import org.scalatest._
import flatspec._
import matchers._

class Day5Test extends AnyFlatSpec with should.Matchers{
  "Part 1" should "Return correct ID values" in {
    val input1 = "BFFFBBFRRR"
    val input2 = "FFFBBBFRRR"
    val input3 = "BBFFBBFRLL"

    Day5.part1(input1) should be (567)
    Day5.part1(input2) should be (119)
    Day5.part1(input3) should be (820)
    info("Ok")
  }
}
