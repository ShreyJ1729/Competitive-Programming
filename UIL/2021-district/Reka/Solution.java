import java.util.*;
import java.io.IOException;

public class reka {
    static long expo(long a, long b) {
        if (b == 0)
            return 1;
        long res = expo(a, b / 2);
        if (b % 2 == 1) {
            res = (res * res) % 1000000000;
            return ((res * a) % 1000000000);
        }
        return (res * res) % 1000000000;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long tr = sc.nextLong();
        for (int ts = 1; ts <= tr; ts++) {
            long ans = 1;
            long n = sc.nextLong();
            long c = sc.nextLong();
            ArrayList<Letter> al = new ArrayList<>();
            HashSet<Long> positions = new HashSet<>(); //positions given as clues
            boolean can = true;
            HashSet<Long> pair = new HashSet<>();
            HashMap<Long, Character> hm = new HashMap<>();
            for (int i = 0; i < c; i++) {
                long p = sc.nextLong() - 1;
                char letter = sc.next().charAt(0);
                if (positions.contains(p)) {
                    if (hm.get(p) != letter)
                        can = false;
//                    System.out.println(al.get(i));
                    break;
                }
                positions.add(p);
                al.add(new Letter(letter, p));
                pair.add(p);
            }
            long less = c; // how many positions less can be anything
            // pairMissing. It's pair must also be a letter
            HashSet<Long> pairMissing = new HashSet<>();
            for (int i = 0; i < c; i++) {
                for (int j = i + 1; j < c; j++) {
                    Letter a = al.get(i);
                    Letter b = al.get(j);
                    if(a.p == n - b.p - 1){
                        if(a.c != b.c){
                            can = false;
                        }
                    }
//                    long a = al.get(i).p;
//                    long b = al.get(j).p;
//                    if (a != n - b - 1) {
//                        if (!pair.contains(n - a - 1))
//                            pairMissing.add(a);
//                        if (!pair.contains(n - b - 1))
//                            pairMissing.add(b);
//                    } else {
//                        if (al.get(i).c != al.get(j).c) {
////                            System.out.println(al.get(i) + " " + al.get(j));
//                            can = false;
//                        }
//                    }
                }
            }
            if (!can) {
                System.out.println("Case #" + ts + ": " + 0);
                continue;
            }
            for (int i = 0; i < c; i++) {
                if(!pair.contains(n - al.get(i).p-1)){
                    pairMissing.add(al.get(i).p);
                }
            }
            less += pairMissing.size();
//            System.out.println(pairMissing);
//            System.out.println(less);
//            System.out.println(Math.pow(26, 100000));
            if (n % 2 == 1) {
                ans = expo(26, (n + 1 - less) / 2);
//                ans = (long) Math.pow(26, (n + 1 - less) / 2);
            } else {
                ans = expo(26, (n - less) / 2);
//                ans = (long) Math.pow(26, (n - less) / 2);

            }
//            for(int i =0; i <= (n-1)/2; i++){
//                char a = ar[i];
//                char b = ar[n-1-i];
//                if(a == '&' && b == '&'){
//                    ans *= 26;
//                }else if(a != '&' && b!= '&'){
//                    if(a != b){
//                        can = false;
//                        break;
//                    }
//                }
//            }
            System.out.println("Case #" + ts + ": " + ans);
        }
    }

    static class Letter {
        char c;
        long p;

        public Letter(char a, long b) {
            c = a;
            p = b;
        }

        public String toString() {
            return c + "," + p;
        }
    }
}

