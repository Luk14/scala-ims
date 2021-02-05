package me.lukasz
package controllers

import presistance.dao.{OrderDao, OrderItemDao}

import me.lukasz.controllers.ItemController.{itemDao, utils}
import me.lukasz.presistance.domain.{Order, OrderItem}
import me.lukasz.utils.Utils

import scala.concurrent.Await
import scala.concurrent.duration.DurationInt

object OrderController extends CrudController[Any]{

  val orderDao = OrderDao
  val orderItemDao = OrderItemDao
  val utils = new Utils


  def read(): Any = {
    println("Please enter the ID you wish to read")
    val id: Int = utils.getInt()
    val read = Await.result(orderDao.read(id), 5000 millis)
    val read2 = Await.result(orderItemDao.read(id), 5000 millis)
    println(read.getOrElse("Invalid Item"))
    println(read2.getOrElse("Invalid Item"))
    read.get
  }

  def readAll(): Seq[Any] = {
    val read = Await.result(orderDao.readAll(), 5000 millis)
    val read2 = Await.result(orderItemDao.readAll(), 5000 millis)
    print(read.mkString("Orders\n", "\n", "\n"))
    print(read2.mkString("Order Items\n", "\n", "\n"))
    read
  }

  def create(): String = {
    println("Please Enter the Following in Order | CID, IID [On New Lines]")
    val createOrder = Order(0, utils.getInt())
    val order = Await.result(orderDao.create(createOrder), 5000 millis)
    val createOrderItem = Await.result(orderItemDao.create(OrderItem(order.toInt, utils.getInt())), 5000 millis)
    println(s"Order: $order was created with OrderItem $createOrderItem")
    order
  }

  def update(): String = {
    println("Coming Soon")
    "Coming Soon"
  }

  def delete(): Int = {
    println("Please enter the ID you wish to delete")
    val id: Int = utils.getInt()
    val delete = Await.result(orderDao.delete(id), 5000 millis)
    val delete2 = Await.result(orderItemDao.delete(id), 5000 millis)
    println("Item was Deleted")
    delete
  }
}
