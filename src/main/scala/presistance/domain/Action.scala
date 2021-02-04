package me.lukasz
package presistance.domain

object Action extends Enumeration {
  val CREATE = Value(0, "Create")
  val READ = Value(1, "Read")
  val READALL = Value(2, "Readall")
  val UPDATE = Value(3, "Update")
  val DELETE = Value(4, "Delete")
  val RETURN = Value(5, "Return")
}
