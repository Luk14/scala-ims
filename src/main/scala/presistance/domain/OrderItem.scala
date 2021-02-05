package me.lukasz
package presistance.domain

import slick.jdbc.MySQLProfile.api._

case class OrderItem(id: Int, cid: Int)

case class OrderItems(tag: Tag) extends Table[OrderItem](tag, "orders") {

  def oid = column[Int]("OID")

  def iid = column[Int]("IID")

  def * = (oid, iid) <> (OrderItem.tupled, OrderItem.unapply)
}
