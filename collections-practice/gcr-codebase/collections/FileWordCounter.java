import java.util.*;
import java.io.*;
public class FileWordCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<String, Integer> wordMap = new HashMap<String, Integer>();

        System.out.print("Enter text file name: ");
        String name = sc.next();

        try {

            Scanner fs = new Scanner(new File(name));

            while (fs.hasNextLine()) {

                String data = fs.nextLine();

                data = data.toLowerCase();

                data = data.replaceAll("[^a-z ]", " ");

                String arr[] = data.split(" ");

                for (int i = 0; i < arr.length; i++) {

                    String word = arr[i];

                    if (word.equals("")) {
                        continue;
                    }

                    if (wordMap.containsKey(word)) {
                        wordMap.put(word, wordMap.get(word) + 1);
                    } else {
                        wordMap.put(word, 1);
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Some problem in file reading");
        }

        System.out.println("Final Word Count:");
        System.out.println(wordMap);
    }
}

