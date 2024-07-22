package FamilyTree;

import FamilyTree.FamilyTree.FamilyTree;
import FamilyTree.Human.Gender;
import FamilyTree.Human.Human;

import java.io.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree familyTree = new FamilyTree();

        Human person1 = new Human("John", "Wick", LocalDate.of(1982, 1, 1),
                Gender.male);
        Human person2 = new Human("Natalie", "Portman", LocalDate.of(1989, 2, 3),
                Gender.female);
        Human person3 = new Human("Johnsson", "Wick Jr.", LocalDate.of(2007, 4, 15),
                Gender.male);
        Human person4 = new Human("Johnsdaughter", "Wick ", LocalDate.of(2012, 5, 23),
                Gender.female);

        familyTree.addMember(person1);
        familyTree.addMember(person2);
        familyTree.addMember(person3);
        familyTree.addMember(person4);

        person1.getChildren().add(person3);
        person2.getChildren().add(person3);
        person1.getChildren().add(person4);
        person2.getChildren().add(person4);

// Поиск по имени или фамилии:
        //FamilyTree.seachPersonByName(sc, familyTree);

        // Сериализация
        familyTree.serializeFamilyMembers();
        // Десериализация
        familyTree.deserializeFamilyMembers();
        System.out.println(familyTree);
    }
}
