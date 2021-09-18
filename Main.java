import java.util.Arrays;
import java.util.Iterator;

class Main {
  public static void main(String[] args) {
    System.out.println("Interleaving Flattener");
    
    Integer[] arr1 = new Integer[]{1, 2, 3};
    Integer[] arr2 = new Integer[]{4, 5};
    Integer[] arr3 = new Integer[]{6, 7, 8, 9};
    Iterator<Integer> a = Arrays.asList(arr1).iterator();
    Iterator<Integer> b = Arrays.asList(arr2).iterator();
    Iterator<Integer> c = Arrays.asList(arr3).iterator();
    Iterator[] iterlist = new Iterator[]{a, b, c};

    String[] arrR = new String[]{"🧰", "🧲", "🍄"};
    String[] arrG = new String[]{"🫑", "🥒", "🥬", "🥦"};
    String[] arrB = new String[]{"📘", "🔷"};
    Iterator<String> red = Arrays.asList(arrR).iterator();
    Iterator<String> green = Arrays.asList(arrG).iterator();
    Iterator<String> blue = Arrays.asList(arrB).iterator();
    Iterator[] iterlistC = new Iterator[]{red, green, blue};

    printIF(new InterleavingFlattener<Integer>(iterlist));
    printIF(new InterleavingFlattener<String>(iterlistC));

  }

  public static void printIF(InterleavingFlattener itfl) {
    while(itfl.hasNext()){
      System.out.print(itfl.next() + " ");
    }
    System.out.println();
  }
}