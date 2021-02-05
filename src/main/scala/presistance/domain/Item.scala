package me.lukasz
package presistance.domain

import slick.jdbc.MySQLProfile.api._


case class Item(id: Int = 1, name: String, price: Double)

case class Items(tag: Tag) extends Table[Item](tag, "items") {

  def id = column[Int]("ID", O.PrimaryKey, O.AutoInc)

  def name = column[String]("NAME")

  def price = column[Double]("PRICE")

  def * = (id, name, price) <> (Item.tupled, Item.unapply)
}
