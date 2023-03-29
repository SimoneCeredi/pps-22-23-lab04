package u04lab.polyglot.a01a

import u04lab.code.List
import u04lab.code.List.*
import u04lab.polyglot.a01a.Logics.*

import scala.util.Random

/** solution and descriptions at https://bitbucket.org/mviroli/oop2019-esami/src/master/a01a/sol2/ */
class LogicsImpl(private val _size: Int, private val _boat: Int) extends Logics:
  private val random: Random = Random(42)
  private var failures: Int = 5
  private var hit: List[(Int, Int)] = Nil()
  private val boat: Boat = Boat(_boat, random.nextInt(_size), random.nextInt(_size - _boat + 1))

  def hit(row: Int, col: Int): Result =
    if boat.hit(row, col) == Result.HIT
    then {
      hit = Cons((row, col), hit)
      return if length(hit) == _boat then Result.WON else Result.HIT
    }
    failures = failures - 1
    if failures == 0 then Result.LOST else Result.MISS
