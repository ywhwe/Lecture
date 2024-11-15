package src.Lecture5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CardDeal {
    List<List<String>> currentCards = new ArrayList<>();

    void run() {
        System.out.print("인원: ");
        Scanner scan = new Scanner(System.in);
        int numHands = scan.nextInt();
        System.out.print("일인당카드수: ");
        int cardsPerHand = scan.nextInt();
        String[] suit = new String[]{"♤", "♡", "◇", "♧"};
        String[] rank = new String[]{"A", "2", "3", "4", "5",
                "6", "7", "8", "9", "10", "J", "Q", "K"};
        List<String> deck = new ArrayList<>();
        for (String s : suit) {
            for (String r : rank) {
                deck.add(s + r);
            }
        }

        Collections.shuffle(deck);

        for (int i = 0; i < numHands; i++) {
            var hands = dealHand(deck, cardsPerHand);
            currentCards.add(hands);
            System.out.println(hands);
        }

        System.out.println();

        for (Object o : currentCards) {
            System.out.println(o);
        }
    }

    public<E> List<E> dealHand(List<E> deck, int n) {
        int deckSize= deck.size();  // 끝에서 n개 서브리스트
        List<E> handView= deck.subList(deckSize-n, deckSize);
        List<E> hand= new ArrayList<>(handView); // 복제생성
        handView.clear(); // 서브리스트삭제, 원래리스트에서도삭제됨
        return hand;
    }

    public static void main(String[] args) {
        CardDeal cardDeal = new CardDeal();
        cardDeal.run();

        cardDeal.currentCards.clear();
    }
}
