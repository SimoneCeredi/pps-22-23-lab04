package u04lab.polyglot.a01a

import u04lab.code.List
import u04lab.code.List.*
import u04lab.polyglot.a01a.Logics.Result

trait Boat:
  def size: Int

  def row: Int

  def col: Int

  def hit(row: Int, col: Int): Result

object Boat:
  def apply(size: Int, row: Int, col: Int): Boat = BoatImpl(size, row, col)

  private class BoatImpl(override val size: Int, override val row: Int, override val col: Int) extends Boat:
    println(s"x = $row, y = $col")
    override def hit(row: Int, col: Int): Result =
      if row == this.row && col >= this.col && col < this.col + this.size
      then Result.HIT
      else Result.MISS
