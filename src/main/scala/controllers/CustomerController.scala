package me.lukasz
package controllers

import presistance.domain.Customer

object CustomerController extends CrudController[Customer] {

  override def read(): Customer = {
    println("read")
    Customer(1, "t", "t", 1)
  }

  override def create(): Customer = {
    println("create")
    Customer(1, "t", "t", 1)
  }

  override def update(): Customer = {
    println("update")
    Customer(1, "t", "t", 1)
  }

  override def delete(): Int = {
    println("delete")
    0
  }
}
