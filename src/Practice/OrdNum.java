package src.Practice;

import java.util.*;
import java.io.*;

public class OrdNum {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader/Writer for fast io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            int a = Integer.parseInt(br.readLine());
            arr.add(a);
        }

        // For fast sort use Collections.sort instead of Arrays.sort
        Collections.sort(arr);

        for (int i : arr) {
            bw.write(i + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
