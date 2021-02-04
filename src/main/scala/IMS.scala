package me.lukasz

import controllers.CrudController
import presistance.domain.{Action, Domain}
import utils.Utils

import scala.Console.println

class IMS {

  val utils = new Utils

  def imsSystem(): Unit = {
    println("Please type the name of the Domain, you would like to interact with!");
    println(Domain.values.mkString(", "))
    val domChoice = domain(utils.firstLetterCap())
    if (domChoice.id == 3) println("Exiting") else getAction(domChoice, domChoice.crud)
  }

  def getAction(domain: Domain.Value, crudController: CrudController[_]): Unit = {
    println(s"What would you like todo with $domain?")
    println("Please Choose an Action you wish to execute!")
    println(Action.values.mkString(", "))
    val actChoice = action(utils.firstLetterCap())
    actChoice match {
      case Action.CREATE => crudController.create(); getAction(domain, crudController)
      case Action.READ => crudController.read(); getAction(domain, crudController)
      case Action.READALL => crudController.readAll(); getAction(domain, crudController)
      case Action.UPDATE => crudController.update(); getAction(domain, crudController)
      case Action.DELETE => crudController.delete(); getAction(domain, crudController)
      case Action.RETURN => imsSystem()
    }
  }

  def domain(input: String): Domain.Value = {
    if (Domain.values.map(f => f.toString).contains(input)) Domain.withName(input) else domain(utils.firstLetterCap())
  }

  def action(input: String): Action.Value = {
    if (Action.values.map(f => f.toString).contains(input)) Action.withName(input) else action(utils.firstLetterCap())
  }
}