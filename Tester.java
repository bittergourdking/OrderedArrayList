public class Tester {
  public static void main(String[] args) {
    NoNullArrayList<String> a = new NoNullArrayList<String>();
    String s1 = null;
    a.add("hello!");
    a.add("goodbye!");
    a.add(1, "break time");
    try {
      a.add(s1);
    } catch(IllegalArgumentException e) {
      System.out.println("No nulls allowed.");
    }
    System.out.println(a);
  }
}
