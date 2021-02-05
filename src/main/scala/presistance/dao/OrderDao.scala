package me.lukasz
package presistance.dao

import me.lukasz.presistance.domain.{Order, Orders}
import slick.jdbc.MySQLProfile.api._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object OrderDao extends Dao[Order]{

  val db = Database.forConfig("mysqlDB")
  val orderDatabase = TableQuery[Orders]

  def read(t: Int): Future[Option[Order]] = {
    db.run(orderDatabase.filter(_.id === t).result.headOption)
  }

  def readAll(): Future[Seq[Order]] = {
    db.run(orderDatabase.result)
  }

  def create(t: Order): Future[String] = {
    db.run(orderDatabase += t).map(f => s"$f").recover {
      case exception: Exception => exception.getCause.getMessage
    }
  }

  def update(t: Order): Future[String] = {
    db.run(orderDatabase.insertOrUpdate(t)).map(f => "Order has been updated").recover {
      case exception: Exception => exception.getCause.getMessage
    }
  }

  def delete(i: Int): Future[Int] = {
    db.run(orderDatabase.filter(_.id===i).delete)
  }
}
