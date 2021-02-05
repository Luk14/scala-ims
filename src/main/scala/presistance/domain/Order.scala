package me.lukasz
package presistance.domain


import slick.jdbc.MySQLProfile.api._

case class Order(id: Int = 1, cid: Int)

case class Orders(tag: Tag) extends Table[Order](tag, "orders") {

  def id = column[Int]("ID", O.PrimaryKey, O.AutoInc)

  def cid = column[Int]("CID")

  def * = (id, cid) <> (Order.tupled, Order.unapply)
}
