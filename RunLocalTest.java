public class RunLocalTest {
    public static void main(String[] args) {
        // Test constructCharList
        LinkedCharList list = new LinkedCharList();
        char[] chars = {'H', 'e', 'l', 'l', 'o'};
        list.constructCharList(chars);
        System.out.println("After constructCharList: " + listToString(list));  // Expected: Hello

        // Test addChar
        list.addChar('!');
        System.out.println("After addChar: " + listToString(list));  // Expected: Hello!

        // Test insertCharAt
        list.insertCharAt('W', 0);
        list.insertCharAt('r', 3);
        list.insertCharAt('d', 7);
        System.out.println("After insertCharAt: " + listToString(list));  // Expected: WHello!rd

        // Test getCharAt
        try {
            System.out.println("Char at index 0: " + list.getCharAt(0));  // Expected: W
            System.out.println("Char at index 7: " + list.getCharAt(7));  // Expected: d
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        // Test splitLinkedCharList
        LinkedCharList[] splitLists = list.splitLinkedCharList('o');
        for (int i = 0; i < splitLists.length; i++) {
            System.out.println("Split list " + i + ": " + listToString(splitLists[i]));  // Expected: WHell and !rd
        }
    }

    private static String listToString(LinkedCharList list) {
        StringBuilder sb = new StringBuilder();
        try {
            int index = 0;
            while (true) {
                sb.append(list.getCharAt(index));
                index++;
            }
        } catch (IndexOutOfBoundsException e) {
            // Reached the end of the list
        }
        return sb.toString();
    }
}