sealed trait Animal {
val name: String
val food: String
def eats(food: String): Boolean = return this.food.equals(food)
}
case class Mammals(name: String, food: String) extends Animal
case class Birds(name: String, food: String) extends Animal
case class Fishes(name: String, food: String) extends Animal
object Animal {
sealed trait Food
case object Meat extends Food
case object Vegetables extends Food
case object Plants extends Food
val cat = Mammals("cat", "meat")
val parrot = Birds("parrot", "vegetables")
val goldfish = Fishes("goldfish", "seaweed")
def knownAnimal(name: String): Boolean =
name.equals(cat.name) || name.equals(parrot.name) || name.equals(goldfish.name)
def apply(name: String): Option[Animal] = {
name match {
case cat.name => Some(cat)
case parrot.name => Some(parrot)
case goldfish.name => Some(goldfish)
case other => None
}
}
}
object program extends App {
println(Animal("goldfish").get.eats("vegetables"))
println(Animal("goldfish").get.eats("seaweed"))
}