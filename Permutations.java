import java.util.List;
import java.util.ArrayList;

public final class Permutations {

	private final int start, end, length;
	private List<List<Integer>> permutations = new ArrayList<>();

	private Permutations(final int start, final int end) {
		this.start = start;
		this.end = end;
		length = end - start;

		build(new ArrayList<Integer>());
	}

	private void build(final List<Integer> permutationPart) {
		if (permutationPart.size() == length) {
			permutations.add(permutationPart);
			return;
		}
		for (int i = start; i < end; ++i) {
			if (permutationPart.contains(i)) {
				continue;
			}
			final List<Integer> extendedPermutationPart = new ArrayList<>(permutationPart.size() + 1);
			extendedPermutationPart.addAll(permutationPart);
			extendedPermutationPart.add(i);
			build(extendedPermutationPart);
		}
	}

	public void print() {
		permutations.forEach(permutation -> {
			permutation.forEach(element -> System.out.print(element));
			System.out.println();
		});
	}

	public static Permutations fromRange(final int start, final int end) {
		return new Permutations(start, end);
	}

	public static Permutations fromSize(final int size) {
		return Permutations.fromRange(0, size);
	}

	public static void main (String... args) {
		if (args.length != 1 || Integer.valueOf(args[0]) < 1) {
			System.out.println("[ERROR] Usage: java Permutations size, where size is a >= 1 integer");
			System.exit(1);
		}
		Permutations permutations = Permutations.fromSize(Integer.valueOf(args[0]));
		permutations.print();
		System.exit(0);
	}
}
