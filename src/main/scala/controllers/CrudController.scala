package me.lukasz
package controllers

trait CrudController[A] {

  def read(): A
  def readAll(): Seq[A]
  def create(): String
  def update(): String
  def delete(): Int

}
