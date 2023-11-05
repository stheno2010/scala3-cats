import cats.effect.{IO, IOApp}
import io.circe._, io.circe.generic.auto._, io.circe.parser._, io.circe.syntax._

object HelloWorld extends IOApp.Simple {
  val foo: Foo = Qux(13, Some(14.0))
  val json = foo.asJson.noSpaces
  val run = IO.println(json)
}

sealed trait Foo
case class Bar(xs: Vector[String]) extends Foo

case class Qux(
  i: Int,
  d: Option[Double]
) extends Foo
