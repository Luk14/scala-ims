package me.lukasz
package controllers

import presistance.dao.ItemDao
import presistance.domain.Item
import utils.Utils

import scala.concurrent.Await
import scala.concurrent.duration.DurationInt

object ItemController extends CrudController[Item] {

  val itemDao = ItemDao
  val utils = new Utils

  override def read(): Item = {
    println("Please enter the ID you wish to read")
    val read = Await.result(itemDao.read(utils.getInt()), 5000 millis)
    println(read.getOrElse("Invalid Item"))
    read.get
  }

  override def create(): String = {
    println("Please Enter the Following in Order | Name, Price [On New Lines]")
    val item =  Item(0, utils.getString(), utils.getDouble())
    val createdItem = Await.result(itemDao.create(item), 5000 millis)
    println(createdItem)
    createdItem
  }

  override def update(): String = {
    println("Please Enter the Following in Order | Item ID, Name, Price [On New Lines]")
    val updateItem = Item(utils.getInt(), utils.getString(), utils.getDouble())
    val updated = Await.result(itemDao.update(updateItem), 5000 millis)
    println(updated)
    updated
  }

  override def delete(): Int = {
    println("Please enter the ID you wish to delete")
    val delete = Await.result(itemDao.delete(utils.getInt()), 5000 millis)
    println("Item was Deleted")
    delete
  }

  override def readAll(): Seq[Item] = {
    val readall = Await.result(itemDao.readAll(), 5000 millis)
    print(readall.mkString("All Items\n", "\n", "\n"))
    readall
  }
}
