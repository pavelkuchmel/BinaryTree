import java.util.ArrayList;

interface BinaryTreeInterface<S> {
    boolean add(S data);
    S getMax();
    S getMin();
    void delete(S data);
    boolean contains(S data);
    boolean isEmpty();
    ArrayList<S> toArrayList();
}
