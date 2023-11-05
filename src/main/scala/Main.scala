import cats.effect.{IO, IOApp}
import scala.concurrent.duration._
import io.circe._, io.circe.generic.auto._, io.circe.parser._, io.circe.syntax._

object StupidFizzBuzz extends IOApp.Simple {
  val run =
    for {
      ctr <- IO.ref(0)

      wait = IO.sleep(1.second)
      poll = wait *> ctr.get

      _ <- poll.flatMap(IO.println(_)).foreverM.start
      _ <- poll.map(_ % 3 == 0).ifM(IO.println(Qux(3, "fizz").asJson.noSpaces), IO.unit).foreverM.start
      _ <- poll.map(_ % 5 == 0).ifM(IO.println(Qux(5, "buzz").asJson.noSpaces), IO.unit).foreverM.start

      _ <- (wait *> ctr.update(_ + 1)).foreverM.void
    } yield ()
}

sealed trait Foo

case class Qux(
  i: Int,
  d: String
) extends Foo
