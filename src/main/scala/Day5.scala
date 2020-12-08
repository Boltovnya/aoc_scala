package den.fox.aoc

import scala.annotation.tailrec

object Day5 {

  def part1(bpass: String): Int = {
    val vertical = bpass.take(bpass.length - 3)
    val horizontal = bpass.takeRight(3)

    @tailrec
    def recurse(dir: String, locator: List[Int]): Int = {
      if (locator.length <= 1) return locator.head

      val splitter = locator.splitAt(locator.length / 2)
      dir.head match {
        case 'F' => recurse(dir.tail, splitter._1)
        case 'B' => recurse(dir.tail, splitter._2)
        case 'L' => recurse(dir.tail, splitter._1)
        case 'R' => recurse(dir.tail, splitter._2)
      }
    }
    val row = recurse(vertical, (0 to 127).toList)
    val column = recurse(horizontal, (0 to 7).toList)

    (row * 8) + column

  }

  def part2(seats: Array[Int]): Int = {
    val missingNeighbours = seats filterNot(x => seats.contains(x+1) && seats.contains(x-1))
    val filtered = missingNeighbours filter(x => (100 <= x && x <= 900) )

    filtered.sum / filtered.size
  }

  def main(args: Array[String]): Unit = {
    val cki = new java.net.HttpCookie("session", sys.env("AOC_COOKIE"))
    val r = requests.get("https://adventofcode.com/2020/day/5/input", cookies = Map("Cookies" -> cki))
    val r_list = r.text.split("\n")
    val listOfSeats = r_list.map(x => part1(x))
    val missingSeat = part2(listOfSeats)
    println(s"Part 1 result = ${listOfSeats.max}")
    println(s"Part 2 result = ${missingSeat}")
  }
}
