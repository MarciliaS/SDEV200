
public class TestTwoWayLinkedList {
    public static void main(String[] args) {
        TwoWayLinkedList<String> list = new TwoWayLinkedList<>();
        list.add("America");
        System.out.println("(1) " + list);

        list.add(0, "Canada");
        System.out.println("(2) " + list);

        list.add("Russia");
        System.out.println("(3) " + list);

        list.addLast("France");
        System.out.println("(4) " + list);

        list.addFirst("Germany");
        System.out.println("(5) " + list);

        list.remove(2);
        System.out.println("(6) " + list);

        list.removeFirst();
        System.out.println("(7) " + list);

        list.removeLast();
        System.out.println("(8) " + list);
    }
}
