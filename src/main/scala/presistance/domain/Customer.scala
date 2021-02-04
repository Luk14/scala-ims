package me.lukasz
package presistance.domain

import slick.jdbc.MySQLProfile.api._

case class Customer(id: Int, firstName: String, lastName: String, age: Int)

case class Customers(tag: Tag) extends Table[Customer](tag, "customers") {
  def id = column[Int]("PER_ID", O.PrimaryKey, O.AutoInc)
  def fName = column[String]("PER_FNAME")
  def lName = column[String]("PER_LNAME")
  def age = column[Int]("PER_AGE")
  def * = (id, fName, lName, age) <>(Customer.tupled, Customer.unapply)
}
