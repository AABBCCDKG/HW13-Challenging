public class LinkedCharList implements LinkedCharListInterface {
    private CharNode headNode;

    public LinkedCharList() {
        this.headNode = null;
    }

    @Override
    public void constructCharList(char[] listChars) {
        if (listChars == null || listChars.length == 0) return;
        this.headNode = new CharNode(listChars[0]);
        CharNode currentNode = headNode;
        for (int i = 1; i < listChars.length; i++) {
            CharNode newNode = new CharNode(listChars[i]);
            currentNode.setNextNode(newNode);
            currentNode = newNode;
        }
    }

    @Override
    public void addChar(char c) {
        CharNode newNode = new CharNode(c);
        if (headNode == null) {
            headNode = newNode;
        } else {
            CharNode currentNode = headNode;
            while (currentNode.getNextNode() != null) {
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(newNode);
        }
    }

    @Override
    public void insertCharAt(char c, int index) {
        CharNode newNode = new CharNode(c);
        if (index == 0) {
            newNode.setNextNode(headNode);
            headNode = newNode;
        } else {
            CharNode currentNode = headNode;
            for (int i = 0; i < index - 1 && currentNode != null; i++) {
                currentNode = currentNode.getNextNode();
            }
            if (currentNode == null) {
                addChar(c);
            } else {
                newNode.setNextNode(currentNode.getNextNode());
                currentNode.setNextNode(newNode);
            }
        }
    }

    @Override
    public char getCharAt(int index) {
        CharNode currentNode = headNode;
        for (int i = 0; i < index; i++) {
            if (currentNode == null) {
                throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + i);
            }
            currentNode = currentNode.getNextNode();
        }
        if (currentNode == null) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + index);
        }
        return currentNode.getC();
    }

    @Override
    public LinkedCharList[] splitLinkedCharList(char regex) {
        java.util.ArrayList<LinkedCharList> resultList = new java.util.ArrayList<>();
        CharNode current = headNode, prev = null;
        LinkedCharList currentList = new LinkedCharList();
        while (current != null) {
            if (current.getC() == regex) {
                if (prev != null) {
                    prev.setNextNode(null);
                }
                if (currentList.headNode != null) {
                    resultList.add(currentList);
                }
                currentList = new LinkedCharList();
                prev = null;
            } else {
                if (currentList.headNode == null) {
                    currentList.headNode = new CharNode(current.getC());
                    prev = currentList.headNode;
                } else {
                    prev.setNextNode(new CharNode(current.getC()));
                    prev = prev.getNextNode();
                }
            }
            current = current.getNextNode();
        }
        if (currentList.headNode != null) {
            resultList.add(currentList);
        }
        return resultList.toArray(new LinkedCharList[resultList.size()]);
    }
}
