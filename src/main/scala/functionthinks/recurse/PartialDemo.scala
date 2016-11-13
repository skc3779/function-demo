package functionthinks.recurse

/**
  * Created by seokangchun on 2016. 10. 30..
  */
object PartialDemo extends App {

  def price(product: String) : Double =
    product match {
      case "apples" => 140
      case "oranges" => 223
    }

  def withTax(cost: Double, state: String) : Double =
    state match {
      case "NY" => cost * 2
      case "FL" => cost * 3
    }

  val locallyTaxed = withTax(_: Double, "NY");
  val costOfApples = locallyTaxed(price("apples"));

  println (s"cost of applies : ${costOfApples}")

}

