package me.lukasz
package presistance.dao

import slick.jdbc.MySQLProfile.api._
import presistance.domain.{Item, Items}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object ItemDao extends Dao[Item] {

  val db = Database.forConfig("mysqlDB")
  val itemDatabase = TableQuery[Items]

  def read(t: Int): Future[Option[Item]] = {
    db.run(itemDatabase.filter(_.id === t).result.headOption)
  }

  def readAll(): Future[Seq[Item]] = {
    db.run(itemDatabase.result)
  }

  def create(t: Item): Future[String] = {
    db.run(itemDatabase += t).map(f => "Item has been successfully added").recover {
      case exception: Exception => exception.getCause.getMessage
    }
  }

  def update(t: Item): Future[String] = {
    db.run(itemDatabase.insertOrUpdate(t)).map(f => "Item has been updated").recover {
      case exception: Exception => exception.getCause.getMessage
    }
  }

  def delete(i: Int): Future[Int] = {
    db.run(itemDatabase.filter(_.id===i).delete)
  }
}
