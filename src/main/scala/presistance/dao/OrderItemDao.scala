package me.lukasz
package presistance.dao

import me.lukasz.presistance.domain.{Items, OrderItem, OrderItems}
import slick.jdbc.MySQLProfile.api._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object OrderItemDao extends Dao[OrderItem] {

  val db = Database.forConfig("mysqlDB")
  val orderItemDatabase = TableQuery[OrderItems]
  val itemDatabase = ItemDao

  def read(t: Int): Future[Option[OrderItem]] = {
    db.run(orderItemDatabase.filter(_.oid === t).result.headOption)
  }

  def readAll(): Future[Seq[OrderItem]] = {
    db.run(orderItemDatabase.result)
  }

  def create(t: OrderItem): Future[String] = {
    db.run(orderItemDatabase += t).map(f => "OrderItem has been successfully added").recover {
      case exception: Exception => exception.getCause.getMessage
    }
  }

  def update(t: OrderItem): Future[String] = {
    db.run(orderItemDatabase.insertOrUpdate(t)).map(f => "OrderItem has been updated").recover {
      case exception: Exception => exception.getCause.getMessage
    }
  }

  def delete(i: Int): Future[Int] = {
    db.run(orderItemDatabase.filter(_.oid===i).delete)
  }

}
