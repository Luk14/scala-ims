package me.lukasz
package presistance.domain

import slick.jdbc.MySQLProfile.api._


case class Customer(id: Int = 1, firstName: String, lastName: String, age: Int)

case class Customers(tag: Tag) extends Table[Customer](tag, "customers") {

  def id = column[Int]("ID", O.PrimaryKey, O.AutoInc)

  def fName = column[String]("FNAME")

  def lName = column[String]("LNAME")

  def age = column[Int]("AGE")

  def * = (id, fName, lName, age) <> (Customer.tupled, Customer.unapply)
}
