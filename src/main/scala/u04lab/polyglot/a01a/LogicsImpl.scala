package u04lab.polyglot.a01a

import u04lab.code.List
import u04lab.code.List.*
import u04lab.polyglot.a01a.Logics.*

import scala.util.Random

/** solution and descriptions at https://bitbucket.org/mviroli/oop2019-esami/src/master/a01a/sol2/ */
class LogicsImpl(private val size: Int, private val boat: Int) extends Logics:
  private val random: Random = Random(42)
  private var failures: Int = 5
  private var hit: List[(Int, Int)] = Nil()
  private val boatRow: Int = random.nextInt(size)
  private val boatLeftCol: Int = random.nextInt(size - boat + 1)
  println(s"x = $boatLeftCol y = $boatRow")

  def hit(row: Int, col: Int): Result =
    if row == boatRow && col >= boatLeftCol && col < boatLeftCol + boat
    then {
      hit = Cons((row, col), hit)
      return if length(hit) == boat then Result.WON else Result.HIT
    }
    failures = failures - 1
    if failures == 0 then Result.LOST else Result.MISS
