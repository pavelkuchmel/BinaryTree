import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BinaryTree<String> test = new BinaryTree<>();
        System.out.println(test.add(" 5"));
        System.out.println(test.add(" 3"));
        System.out.println(test.add(" 6"));
        System.out.println(test.add(" 4"));
        System.out.println(test.add(" 8"));
        System.out.println(test.add(" 2"));
        System.out.println(test.add(" 7"));
        test.delete(" 7");
        System.out.println("contains: "+test.contains(" 7"));
        System.out.println(test.toArrayList());
        /*test.delete(" 5");
        test.delete(" 2");
        test.delete(" 2");
        test.delete(" 2");
        test.delete(" 2");
        test.delete(" 2");*/
        //System.out.println(test.getMin());
        //System.out.println(test.getMax().charAt(test.getMax().length()-1));
        //System.out.println(test.contains(" 3"));
        //System.out.println(test.getMax());
        //System.out.println(test.getMin());
    }
}