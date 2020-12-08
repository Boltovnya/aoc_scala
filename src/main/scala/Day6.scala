package den.fox.aoc

object Day6 {

  def part1(c_group: String): Int = {
    c_group.filter(_ >= ' ').distinct.length
  }

  def part2(c_group: String): Int = {
    val c_array = c_group.split("\n")
    val c_sets = c_array.map(x => x.toSet)
    val c_intersect = c_sets reduce(_ & _)
    c_intersect.size

  }

  def main(args: Array[String]): Unit = {
    val cki = new java.net.HttpCookie("session", sys.env("AOC_COOKIE"))
    val r = requests.get("https://adventofcode.com/2020/day/6/input", cookies = Map("Cookies" -> cki))
    val aoc_input = r.text.split("\n\n")

    val p1_counts = aoc_input map (x => part1(x))
    val p2_counts = aoc_input map (x => part2(x))

    val p1_result = p1_counts reduce (_ + _)
    val p2_result = p2_counts reduce (_ + _)

    println(s"Part 1 = ${p1_result}")
    println(s"Part 2 = ${p2_result}")




  }
}
