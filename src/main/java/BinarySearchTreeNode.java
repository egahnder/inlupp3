/*
Gruppmedlemmar:
Tobias Ahnhem toah5501
Daniel Andersson daan2233
Eric Egan ereg8941
 */

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
        if (data.compareTo(this.data) < 0) {
            if (left == null) {
                left = new BinarySearchTreeNode<>(data);
                return true;
            } else {
                return left.add(data);
            }

        } else if (data.compareTo(this.data) > 0) {
            if (right == null) {
                right = new BinarySearchTreeNode<>(data);
                return true;
            } else {
                return right.add(data);
            }

        }
        return false;
    }


    private T findMin() {

        if(left == null){
            return data;
        } else{
            return left.findMin();
        }
    }

    private T findMax(){
        if(right == null){
            return data;
        } else{
            return right.findMax();
        }
    }

    public BinarySearchTreeNode<T> remove(T data) {
        if (left != null && this.data.compareTo(data) > 0) {
            if (left.data.compareTo(data) == 0) {
                left = remove(left);
            } else {
                left = left.remove(data);
            }
        } else if (right != null && this.data.compareTo(data) < 0){
            if (right.data.compareTo(data) == 0) {
                right = remove(right);
            } else {
                right = right.remove(data);
            }
        } else if (this.data.compareTo(data) == 0){
            return remove(this);
        }

        return this;
    }

    private BinarySearchTreeNode<T> remove(BinarySearchTreeNode<T> subTree) {
        if (subTree.left != null && subTree.right != null) {
            subTree.data = subTree.left.findMax();
            subTree.left = subTree.left.remove(subTree.left.findMax());
            return subTree;
        } else if (subTree.right != null) {
            return subTree.right;
        }
        else if (subTree.left != null){
            return subTree.left;
        }

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
        if (left != null && right != null)
            return left.size() + right.size() + 1;
        else if(left != null)
            return left.size() + 1;
        else if(right != null)
            return right.size() + 1;
        else
            return 1;
    }

    public int depth() {
        if(left != null && right != null)
            return Math.max(left.depth(), right.depth()) +1;
        else if (right != null)
            return right.depth() + 1;
        else if (left != null)
            return left.depth() + 1;
        else
            return 0;
    }

    public String toString() {

        if (left != null && right != null)
            return left.toString() +", " + data.toString() + ", " + right.toString();
        else if(right != null)
            return data.toString() +", " + right.toString();
        else if(left != null)
            return left.toString() +", " + data.toString();
        else
            return data.toString();
    }

}
