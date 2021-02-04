package me.lukasz
package controllers

trait CrudController[A] {

  def read(): A
  def create(): A
  def update(): A
  def delete(): Int

}
