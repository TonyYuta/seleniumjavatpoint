package seleniumjavatpoint;

import java.util.*;

public class HackerRank {
    public static void main(String[] args){
        int num = 9;
        int[] arr = {10,20,20,10,10,30,50,10,20};
        //System.out.println(socks(num, arr));
        //System.out.println(numDuplicates());

        String[] magazine = {"give","me","one","grand","today","night"};
        String[] note = {"give","one","grand","today"};
        //Yes
        System.out.println(checkMagazine(magazine,note));

        String[] magazine2 = {"two","times","three","is","not","four"};
        String[] note2 = {"two","times","two","is","four"};
        //No
        System.out.println(checkMagazine(magazine2,note2));

        String[] magazine3 = {"ive","got","a","lovely","bunch","of","coconuts"};
        String[] note3 = {"ive","got","some","coconuts"};
        //No
        System.out.println(checkMagazine(magazine3,note3));

    }

    public static int socks(int num, int[] arr){
        int pairs=0;
        Map<Integer,Integer> socks = new HashMap<>();
        for(int sock : arr)
            socks.put(sock,socks.containsKey(sock)?socks.get(sock)+1:1);
        for(int sock : socks.keySet())
            pairs+=socks.get(sock)/2;
        return pairs;
    }

    List<String> name;
    List<Integer> price;
    List<Integer> weigh;

    public static int numDuplicates() {
/*        ball
                box
        ball
                ball
        box
        5
        2
        2
        2
        2
        2
        5
        1
        2
        1
        1
        3*/
        // Write your code here

        List<String> name = new LinkedList<>();
        List<Integer> price = new LinkedList<>();
        List<Integer> weight = new LinkedList<>();
        name.add("ball");
        name.add("box");
        name.add("ball");
        name.add("ball");
        name.add("box");

        price.add(5);
        price.add(2);
        price.add(2);
        price.add(2);
        price.add(2);

        weight.add(5);
        weight.add(1);
        weight.add(2);
        weight.add(1);
        weight.add(1);

        int result = 0;
        for(int i = 0; i < name.size(); i++) {
           if (Collections.frequency(name, name.get(i)) > 1)
               for(int j = 0; i < price.size(); j++) {
                   if (Collections.frequency(price, price.get(j)) > 1)
                       if(i==j)
                           for(int k = 0; k < name.size(); k++) {
                               if (Collections.frequency(weight, weight.get(k)) > 1)
                                   if(j==k)
                                       result+=1;
                           }
               }
       }
        return result;
    }


    static String checkMagazine(String[] magazine, String[] note) {
        String result = "No";
        int count = 0;
        Map<String,Integer> magazineMap = new HashMap<>();
        Map<String,Integer> noteMap = new HashMap<>();

        for(String wordMagazine : magazine) {
            magazineMap.put(wordMagazine, magazineMap.containsKey(wordMagazine) ? magazineMap.get(wordMagazine) + 1 : 1);
        //    System.out.println(wordMagazine);
        }

     //   System.out.print('\n');

        for(String wordNote : note) {
            noteMap.put(wordNote, noteMap.containsKey(wordNote) ? noteMap.get(wordNote) + 1 : 1);
        //    System.out.println(wordNote);
        }

     //   System.out.print('\n');

        for(String noteWord : note)
            if(magazineMap.containsKey(noteWord) && noteMap.get(noteWord)>=magazineMap.get(noteWord)) {
           //     System.out.println(noteMap.get(noteWord) + ":" + magazineMap.get(noteWord));
                count++;

            }
        if(count == note.length)
            result = "Yes";
      //  System.out.print('\n');

        return result;
    }


}
