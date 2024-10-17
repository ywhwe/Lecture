package src.Practice;

import java.io.*;
import java.util.*;

public class SortCoord {
    public static void main(String[] args) throws IOException {
        SortCoord main = new SortCoord();
        main.newMain();
    }

    void newMain() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] coordinates = new int[n][2];

        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            coordinates[i][0] = Integer.parseInt(st.nextToken());
            coordinates[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(coordinates, (e1, e2) -> {
            if (e1[0] == e2[0]) {
                return e1[1] - e2[1];
            } else {
                return e1[0] - e2[0];
            }
        });

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(coordinates[i][0]).append(" ").append(coordinates[i][1]).append("\n");
        }

        System.out.println(sb);
    }
}
