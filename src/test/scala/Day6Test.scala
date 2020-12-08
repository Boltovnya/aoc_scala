package den.fox.aoc

import org.scalatest._
import flatspec._
import matchers._

class Day6Test extends AnyFlatSpec with should.Matchers{
  "Part 1" should "return correct sum of counts (= 11)" in {
    val test_string = "abc\n\na\nb\nc\n\nab\nac\n\na\na\na\na\n\nb".split("\n\n")
    val p1_counts = test_string map (x => Day6.part1(x))
    val p1_result = p1_counts reduce (_+_)
    assert(p1_result == 11)
  }

  "Part 2" should "return correct sum of unanimous counts (=6)" in {
    val test_string = "abc\n\na\nb\nc\n\nab\nac\n\na\na\na\na\n\nb".split("\n\n")
    val p2_counts = test_string map (x => Day6.part2(x))
    val p2_result = p2_counts reduce (_+_)
    assert(p2_result == 6)
  }

}
