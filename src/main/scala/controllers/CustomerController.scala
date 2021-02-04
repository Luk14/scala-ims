package me.lukasz
package controllers

import presistance.dao.CustomerDao
import presistance.domain.Customer
import utils.Utils

import scala.concurrent.Await
import scala.concurrent.duration.DurationInt

object CustomerController extends CrudController[Customer] {

  val customerDao = CustomerDao
  val utils = new Utils

  override def read(): Customer = {
    println("Please enter the ID you wish to read")
    val read = Await.result(customerDao.read(utils.getInt()), 5000 millis)
    println(read.getOrElse("Invalid Customer"))
    read.get
  }

  override def create(): String = {
    println("Please Enter the Following in Order | First Name, Last Name, Age [On New Lines]")
    val customer =  Customer(0, utils.getString(), utils.getString(), utils.getInt())
    val createdCustomer = Await.result(customerDao.create(customer), 5000 millis)
    println(createdCustomer)
    createdCustomer
  }

  override def update(): String = {
    println("Please Enter the Following in Order | Customer ID, First Name, Last Name, Age [On New Lines]")
    val updateCustomer = Customer(utils.getInt(), utils.getString(), utils.getString(), utils.getInt())
    val updated = Await.result(customerDao.update(updateCustomer), 5000 millis)
    println(updated)
    updated
  }

  override def delete(): Int = {
    println("Please enter the ID you wish to delete")
    val delete = Await.result(customerDao.delete(utils.getInt()), 5000 millis)
    println("Customer was Deleted")
    delete
  }

  override def readAll(): Seq[Customer] = {
    val readall = Await.result(customerDao.readAll(), 5000 millis)
    print(readall.mkString("Everyone\n", "\n", "\n"))
    readall
  }
}
