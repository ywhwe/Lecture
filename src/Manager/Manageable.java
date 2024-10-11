package src.Manager;

import java.util.*;

public interface Manageable {
    void read(Scanner scan);
    void print();
    boolean matches(String kwd);
}