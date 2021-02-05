package me.lukasz

import presistance.domain.{Customers, Items, OrderItems, Orders}

import slick.jdbc.MySQLProfile.api._

object Runner {

  def main(args: Array[String]): Unit = {
    val db = Database.forConfig("mysqlDB")
    val customerTable = TableQuery[Customers]
    val itemTable = TableQuery[Items]
    val orderTable = TableQuery[Orders]
    val orderItemTable = TableQuery[OrderItems]
    db.run(DBIO.seq(customerTable.schema.createIfNotExists))
    db.run(DBIO.seq(itemTable.schema.createIfNotExists))
    db.run(DBIO.seq(orderItemTable.schema.createIfNotExists))
    db.run(DBIO.seq(orderTable.schema.createIfNotExists))

    val ims = new IMS
    ims.imsSystem()
  }
}
