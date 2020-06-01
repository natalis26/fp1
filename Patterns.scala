object PatternMatching extends App {
    sealed trait Hand
    case object Rock    extends Hand
    case object Paper   extends Hand
    case object Scissor extends Hand
    sealed trait Result
    case object Win  extends Result
    case object Lose extends Result
    case object Draw extends Result
    sealed trait Food
    case object Meat       extends Food
    case object Vegetables extends Food
    case object Plants     extends Food
    sealed trait Animal {
    val name: String
    var food: Food
  }
  case class Mammal(name: String, var food: Food, weight: Int) extends Animal
  case class Fish(name: String, var food: Food)                extends Animal
  case class Bird(name: String, var food: Food)                extends Animal
  def intToString(value: Int): String =
    value match {
      case 1 => "it is one"
      case 2 => "it is two"
      case 3 => "it is three"
      case other => "what's that"
    }
  def testIntToString(value: Int): String = intToString(value)
  def isMaxAndMoritz(value: String): Boolean =
    value match {
      case "max" | "Max" | "moritz" | "Moritz"=> true
      case other => false
    }
  def testIsMaxAndMoritz(value: String): Boolean = isMaxAndMoritz(value)
  def isEven(value: Int): Boolean = 
  value % 2 match {
    case 0 => true
    case 1 => false
  }
  def testIsEven(value: Int): Boolean = isEven(value)
  def winsA(a: Hand, b: Hand): Result =
    a match {
      case Rock => b match {
        case Rock => Draw
        case Paper => Lose
        case Scissor => Win
      }
      case Paper => b match {
        case Rock => Win
        case Paper => Draw
        case Scissor => Lose
      }
      case Scissor => b match {
        case Rock => Lose
        case Paper => Win
        case Scissor => Draw
      }
    }
  def testWinsA(a: Hand, b: Hand): Result = winsA(a, b)
  def extractMammalWeight(animal: Animal): Int =
    animal match {
      case mammal: Mammal => mammal.weight
      case other => -1
    }
  def testExtractMammalWeight(animal: Animal): Int = extractMammalWeight(animal)
  def updateFood(animal: Animal): Animal =
    animal match {
      case fish: Fish => fish.food = Plants; fish
      case bird: Bird => bird.food = Plants; bird
      case other => animal
    }
  def testUpdateFood(animal: Animal): Animal = updateFood(animal)
  println("testWinsA:\t\t\t" + testWinsA(Scissor, Scissor))
  println("testIsMaxAndMoritz:\t\t" + testIsMaxAndMoritz("max"))
  println("testIsMaxAndMoritz:\t\t" + testIsMaxAndMoritz("min"))
  println("testIsEven:\t\t\t" + testIsEven(8))
  println("testIsEven:\t\t\t" + testIsEven(9))
  println("testExtractMammalWeight:\t" + testExtractMammalWeight(Mammal("cat", Meat, 20)))
  println("testIntToString:\t\t" + testIntToString(35))
  println("testExtractMammalWeight:\t" + testExtractMammalWeight(Mammal("dog", Meat, 55)))
  println("testUpdeteFood:\t\t\t" +testUpdateFood(Fish("dark", Plants)))
}