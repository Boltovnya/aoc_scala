package den.fox.aoc

object Day7 {

  def main(args: Array[String]): Unit = {
    val cki = new java.net.HttpCookie("session", sys.env("AOC_COOKIE"))
    val r = requests.get("https://adventofcode.com/2020/day/7/input", cookies=Map("cookies" -> cki))


    // Solution not mine, stolen today :'(
    val aoc_input = r.text.split("\n").toIndexedSeq
    val rPrefix = "(.+) bags contain (?:(no other bags)|(.*))\\.".r
    val rSeq = "([0-9]+) (.+) bags?".r
    val ShinyGold = "shiny gold"

    val graph = aoc_input.map {
      case rPrefix(bag1, _, rest) =>
        val children = Option(rest) match {
          case Some(_) =>
            rest.split(", ").map {
              case rSeq(count, bag2) => (bag2, count.toInt)
            }.toSeq
          case None => Seq()
        }
        (bag1, children)
    }.toMap

    def contains(bag: String): Boolean = bag == ShinyGold || (graph(bag) exists { case (other, _) => contains(other)})
    graph.keys.filter(_ != ShinyGold).count(contains)


    def solutionA = graph.keys.filter(_ != ShinyGold).count(contains)

    def countBags(bag: String): Int = graph(bag).map{ case (other, count) => count * countBags(other)}.sum + 1

    def solutionB = countBags(ShinyGold) - 1

    println(s"Part 1: $solutionA")
    println(s"Part 2: $solutionB")

  }



}
