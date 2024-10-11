package src.Manager;

import src.Lecture3.Department;
import src.Lecture4.BookStore;

import java.util.*;

public interface Factory {
    Manageable create(Scanner scan);
}
