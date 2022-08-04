import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class GiftCard {

    public static final String NOT_POSSIBLE = "Not possible";

    /**
     * Finds a pair of items in a list that is less than or equal to the total funds available
     *
     * @param filePath The path to your file
     * @param total Total for the gift card
     * @return String of items found.
     */
    public String findPair(String filePath, int total) {
        //construct a map from the items in the text file
        Map<Integer, String> items = getMapFromFile(filePath);

        List<Integer> itemPrices = new ArrayList<>(items.keySet());

        // sort in decreasing order so when we loop through, the first match we get will be the highest valued two items
        itemPrices.sort(Collections.reverseOrder());

        for (int i = 0; i < itemPrices.size(); i++) {
            int current = itemPrices.get(i);
            for (int j = i + 1; j < itemPrices.size(); j++) {
                int next = itemPrices.get(j);
                if (current + next <= total) {
                    return items.get(next) + " " + next + ", " + items.get(current) + " " + current;
                }
            }
        }
        return NOT_POSSIBLE;
    }

    /**
     * Puts the contents of the file in a map
     *
     * @param filePath Path to the file
     * @return Map of items and prices
     */
    public Map<Integer, String> getMapFromFile(String filePath) {
        Map<Integer, String> items = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(Files.newInputStream(Paths.get(filePath)), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null){
                String[] split = line.split(", ");
                items.put(new Integer(split[1]), split[0]);
            }
        } catch (IOException e) {
            throw new RuntimeException("File not found. Please check your file path.", e);
        }
        return items;
    }

    public static void main(String[] args) {
        String filepath = null;
        int total = 0;
        if (args.length == 2) {
            for (int i = 0; i < args.length; i++) {
                switch (i) {
                    case 0:
                        filepath = args[0];
                        break;
                    case 1:
                        total = Integer.parseInt(args[1]);
                }
            }
            GiftCard giftCard = new GiftCard();
            System.out.println(giftCard.findPair(filepath, total));
        } else {
            System.out.println("Provided the incorrect number of arguments. Please provide only a file path and total gift card value.");
        }

    }

}
