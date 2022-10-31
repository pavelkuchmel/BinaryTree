import java.util.ArrayList;

public class BinaryTree <S extends Comparable<S>> implements BinaryTreeInterface<S> {
    private Node<S> root;

    public BinaryTree(){
        root = null;
    }

    @Override
    public boolean add(S data) {
        try {
            root = insert(root, data);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }
    private Node<S> insert(Node<S> root, S data) throws Exception{
        if (root == null) return new Node<S>(data);
        else if (root.data.compareTo(data) > 0) root.left = insert(root.left, data);
        else if (root.data.compareTo(data) < 0) root.right = insert(root.right, data);
        else throw new Exception("Can't be added");
        return root;
    }

    @Override
    public S getMax() throws NullPointerException{
        if (isEmpty()) throw new NullPointerException("Tree is empty");
        Node<S> current = root;
        S data = current.data;
        while (current != null){
            data = current.data;
            current = current.right;
        }
        return data;
    }

    @Override
    public S getMin() throws  NullPointerException{
        return getMin(root).data;
        /*if (isEmpty()) throw new NullPointerException("Tree is empty");
        Node<S> current = root;
        while (current.left != null){
            current = current.left;
        }
        return current.data;*/
    }
    private Node<S> getMin(Node<S> root){
        Node<S> current = root;
        while (current.left != null){
            current = current.left;
        }
        return current;
    }

    @Override
    public void delete(S data) {
        try {
            delete(root, data);
        }catch (NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    private Node<S> delete(Node<S> root, S data) throws NullPointerException{
        if (isEmpty()) throw new NullPointerException("Tree is empty");
        if (root == null) return null;
        else if (root.data.compareTo(data) > 0) {
            System.out.println("checkPoint01");
            root.left = delete(root.left, data);
        }
        else if (root.data.compareTo(data) < 0) {
            System.out.println("checkPoint02");
            root.right = delete(root.right, data);
        }
        else {
            System.out.println("checkPoint03");
            if (root.left == null && root.right == null) return null;
            else if (root.right != null && root.left == null) return root.right;
            else if (root.left != null && root.right == null) return root.left;
            else {
                root.data = getMin(root.right).data;
                delete(root.right, root.data);
            }
        }
        return root;
    }

    @Override
    public boolean contains(S data) {

        try {
            return contains(root, data);
        } catch (NullPointerException ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }

    private boolean contains(Node<S> root, S data) throws NullPointerException{
        if (isEmpty()) throw new NullPointerException("Three is empty");
        if (root == null) return false; //пустой узел, совпадение не найдено
        else if (root.data.compareTo(data) > 0) return contains(root.left, data);//введенный параметр меньше
        else if (root.data.compareTo(data) < 0) return contains(root.right, data);//введенный параметр больше
        else return true; //введенный параметр и установленный совпали
    }

    @Override
    public boolean isEmpty() { return root == null; }

    @Override
    public ArrayList<S> toArrayList() {
        ArrayList<S> list = new ArrayList<>();
        toArrayList(root, list);
        return list;
    }
    private void toArrayList(Node<S> root, ArrayList<S> list) {
        if (root == null) return;
        toArrayList(root.left, list);
        list.add(root.data);
        toArrayList(root.right, list);
    }
}
class Node <S>{
    public Node(S data){ this.data = data; }
    S data;
    Node<S> left;
    Node<S> right;
}
