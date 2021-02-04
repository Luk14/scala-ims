package me.lukasz
package presistance.dao

import slick.jdbc.MySQLProfile.api._
import presistance.domain.{Customer, Customers}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object CustomerDao extends Dao[Customer]{

  val db = Database.forConfig("mysqlDB")
  val customerTable = TableQuery[Customers]

  def readAll(): Future[Seq[Customer]] = {
    db.run(customerTable.result)
  }

  def read(t: Int): Future[Option[Customer]] = {
    db.run(customerTable.filter(_.id === t).result.headOption)
  }

  def create(t: Customer): Future[String] = {
    db.run(customerTable += t).map(f => "User has been successfully added").recover {
      case exception: Exception => exception.getCause.getMessage
    }
  }

  def update(t: Customer): Future[String] = {
    db.run(customerTable.insertOrUpdate(t)).map(f => "User has been updated").recover {
      case exception: Exception => exception.getCause.getMessage
    }
  }

  def delete(i: Int): Future[Int] = {
    db.run(customerTable.filter(_.id === i).delete)
  }
}
