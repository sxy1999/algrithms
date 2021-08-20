import java.util.Stack;

public class Test {


    public int matchGroup(String[] groups, String[] shoppingItems) {
        if (shoppingItems.length == 0) {
            return 1;
        }

        if (groups.length == 0) {
            return 0;
        }

        String[] secretItems = groups[0].split(" ");
        if (secretItems.length > shoppingItems.length) {
            return matchGroup(remainingGroups(groups), shoppingItems);
        }

        int offset = 0;
        for (int i = 0; i < shoppingItems.length - secretItems.length; i++) {
            int m = 0;
            for (int j = 0; j < secretItems.length; j++) {
                if (secretItems[j].equals(shoppingItems[i + j]) || "anything".equals(secretItems[j])) {
                    m++;
                } else {
                    break;
                }
            }
            //find a match at position i
            if (m == secretItems.length) {
                offset = i + m;
                break;
            }
        }

        // The secret items match the first items of the shopping items
        if (offset != 0) {
            return matchGroup(remainingGroups(groups), remainingShoppingItems(shoppingItems, offset));
        }

        return matchGroup(remainingGroups(groups), shoppingItems);
    }

    private String[] remainingGroups(String[] groups) {
        if (groups.length == 1) {
            return new String[0];
        }
        String[] remainingGroups = new String[groups.length - 1];
        for (int i = 1; i < groups.length; i++) {
            remainingGroups[i - 1] = groups[i];
        }
        return remainingGroups;
    }

    private String[] remainingShoppingItems(String[] shoppingItems, int offset) {
        if (shoppingItems.length <= offset) return new String[0];
        String[] remainingItems = new String[shoppingItems.length - offset];
        for (int i = 0; i < shoppingItems.length - offset; i++) {
            remainingItems[i] = shoppingItems[offset + i];
        }
        return remainingItems;
    }

    public void test1() {
        Stack<String> s = new Stack<>();
        s.push("");
        s.pop();
    }
}
