package me.lukasz
package presistance.dao

import scala.concurrent.Future

trait Dao[A] {

  def read(t: Int): Future[Option[A]]
  def readAll(): Future[Seq[A]]
  def create(t: A): Future[String]
  def update(t: A): Future[String]
  def delete(i: Int): Future[Int]

}
