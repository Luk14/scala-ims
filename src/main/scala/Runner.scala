package me.lukasz

import me.lukasz.presistance.domain.Customers
import slick.jdbc.MySQLProfile.api._

object Runner {

  def main(args: Array[String]): Unit = {
    val db = Database.forConfig("mysqlDB")
    val customerTable = TableQuery[Customers]
    db.run(DBIO.seq(customerTable.schema.createIfNotExists))

    val ims = new IMS
    ims.imsSystem()
  }

}
