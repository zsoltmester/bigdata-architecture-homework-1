import scala.collection.mutable.ListBuffer

class Permutations private(start: Int, end: Int) {

	private val length: Int = end - start
	private val permutations: ListBuffer[List[Int]] = ListBuffer()

	def build(permutationPart: List[Int]): Unit = {
		if (permutationPart.size == length)
			permutations += permutationPart
		else
			for(i <- start to (end - 1))
				if (!permutationPart.contains(i))
					build(permutationPart :+ i)
	}

	def print() {
		for(permutation <- permutations) {
			var permutationString: StringBuilder = new StringBuilder
			for(element <- permutation)
				permutationString ++= element.toString
			println(permutationString)
		}
	}
}

object Permutations {
	def apply(size: Int): Permutations = {
		val permutations: Permutations = new Permutations(0, size)
		permutations build(List())
		return permutations
	}
}

object Main {
	def main(args: Array[String]) {
		if (args.size != 1 || args(0).toInt < 1) {
			println("[ERROR] Usage: scala Main size, where size is a >= 1 integer")
			System.exit(1)
		}
		val permutations: Permutations = Permutations(args(0).toInt)
		permutations print()
		System.exit(0)
	}
}
