package me.lukasz
package presistance.domain

import controllers.{CrudController, CustomerController, ItemController, OrderController}

object Domain extends Enumeration {

  val CUSTOMER = CustomDomain(0, "Customer", crud = CustomerController)
  val ITEM = CustomDomain(1, "Item", crud = ItemController)
  val ORDER = CustomDomain(2, "Order", crud = OrderController)
  val STOP = Value(3, "Stop")

  protected case class CustomDomain(i: Int, name: String, crud: CrudController[_]) extends super.Val(i, name)

  implicit def valueOfCustomDomain(x: Value): CustomDomain = x.asInstanceOf[CustomDomain]

}
