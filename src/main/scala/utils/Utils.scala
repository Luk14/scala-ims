package me.lukasz
package utils

import java.util.Scanner

class Utils {

  val scanner = new Scanner(System.in)

  def getString(): String = scanner.nextLine()

  def getLong(): Long = {
    println("Please Enter a Long")
    getString().toLongOption getOrElse (getLong())
  }

  def getDouble(): Double = {
    println("Please Enter a Double")
    getString().toDoubleOption getOrElse (getDouble())
  }

  def firstLetterCap(): String = {
    getString().toLowerCase.capitalize
  }
}