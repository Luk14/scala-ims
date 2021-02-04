package me.lukasz
package controllers

import presistance.domain.Customer

object CustomerController extends CrudController[Customer] {

  override def read(): Customer = {
    println("read")
    Customer("t", "t", 1)
  }

  override def create(): Customer = {
    println("create")
    Customer("t", "t", 1)
  }

  override def update(): Customer = {
    println("update")
    Customer("t", "t", 1)
  }

  override def delete(): Int = {
    println("delete")
    0
  }
}
