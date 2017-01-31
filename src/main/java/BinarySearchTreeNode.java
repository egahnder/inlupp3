/**
 * 
 * Detta är den enda av de tre klasserna ni ska göra några ändringar i. (Om ni
 * inte vill lägga till fler testfall.) De ändringar som är tillåtna är dock
 * begränsade av följande:
 * <ul>
 * <li>Ni får INTE lägga till några fler instansvariabler.
 * <li>Ni får INTE lägga till några statiska variabler.
 * <li>Ni får INTE använda några loopar någonstans.
 * <li>Ni FÅR lägga till fler metoder, dessa ska då vara privata.
 * </ul>
 * 
 * @author henrikbe
 * 
 * @param <T>
 */
@SuppressWarnings("unused") // Denna rad ska plockas bort. Den finns här
							// tillfälligt för att vi inte ska tro att det är
							// fel i koden. Varningar ska normalt inte döljas på
							// detta sätt, de är (oftast) fel som ska fixas.
public class BinarySearchTreeNode<T extends Comparable<T>> {

	private T data;
	private BinarySearchTreeNode<T> left;
	private BinarySearchTreeNode<T> right;

	public BinarySearchTreeNode(T data) {
		this.data = data;
	}

	public boolean add(T data) {
		if (!contains(data)) {

			if (data.compareTo(this.data) < 0) {
				if (left == null) {
					left = new BinarySearchTreeNode<>(data);
				} else {
					left.add(data);
				}

			} else if (data.compareTo(this.data) > 0) {
				if (right == null) {
					right = new BinarySearchTreeNode<>(data);
				} else {
					right.add(data);
				}

			}
			return true;
		} else {
			return false;
		}
	}

	private T findMin() {

		if(left == null){
			return data;
		} else{
			return left.findMin();
		}
	}

	public BinarySearchTreeNode<T> remove(T data) {
		return null;
	}

	public boolean contains(T data) {
		if (data.compareTo(this.data) == 0) {
			return true;
		} else if (data.compareTo(this.data) < 0) {
			if (left != null) {
				return left.contains(data);
			}
		} else if (data.compareTo(this.data) > 0) {
			if (right != null) {
				return right.contains(data);
			}
		}
		return false;
	}

	public int size() {

		if (left == null && right == null) {
			return 1;
		}
		if (left != null && right == null) {
			return left.size() + 1;
		}

		if (left == null && right != null) {
			return right.size() + 1;
		}

		return left.size() +right.size() +1;

	}

	public int depth() {

		if (left == null && right == null) {
			return 0;
		}

		if (left != null && right == null) {
			return left.depth() + 1;
		}

		if (left == null && right != null) {
			return right.depth() + 1;
		}

		return Math.max(left.depth(), right.depth()) +1;
	}

	public String toString() {
		if (left == null && right == null) {
			return data.toString();
		}

		if (left != null && right == null) {
			return left.toString() +", " + data.toString();
		}

		if (left == null && right != null) {
			return right.toString() +", "  +data.toString();
		}

		return left.toString() +", " + data.toString() + ", " + right.toString();
	}

}
