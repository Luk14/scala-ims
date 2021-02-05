package me.lukasz

import presistance.domain.{Customers, Items}

import slick.jdbc.MySQLProfile.api._

object Runner {

  def main(args: Array[String]): Unit = {
    val db = Database.forConfig("mysqlDB")
    val customerTable = TableQuery[Customers]
    val itemTable = TableQuery[Items]
    db.run(DBIO.seq(customerTable.schema.createIfNotExists))
    db.run(DBIO.seq(itemTable.schema.createIfNotExists))

    val ims = new IMS
    ims.imsSystem()
  }
}
