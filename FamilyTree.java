package FamilyTree.FamilyTree;

import FamilyTree.Human.Human;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FamilyTree implements Serializable {
    private List<Human> familyMembers;
    Scanner sc = new Scanner(System.in);

    public void serializeFamilyMembers() throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("family_members.ser"))) {
            out.writeObject(familyMembers);
        }
    }

    public void deserializeFamilyMembers() throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("family_members.ser"))) {
            familyMembers = (List<Human>) in.readObject();
        }
    }

    public FamilyTree() {
        familyMembers = new ArrayList<>();
    }

    public List<Human> getFamilyMember(String name) {
        List<Human> matchingMembers = new ArrayList<>();
        for (Human member : familyMembers) {
            if (member.getName().equals(name) || member.getSecondName().equals(name)) {
                matchingMembers.add(member);
            }
        }
        return matchingMembers;
    }

    public void addMember(Human human) {
        familyMembers.add((human));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("family tree:\n");
        for (Human familyMember : familyMembers) {
            stringBuilder.append(familyMember);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }


    public static void seachPersonByName(Scanner sc, FamilyTree familyTree) {
        System.out.println("Введите имя человека, которого нужно найти: ");
        String name = sc.nextLine();
        boolean found = false;
        for (Human person : familyTree.getFamilyMember(name)) {
            if (person.getName().equals(name) || person.getSecondName().equals(name)) {
                System.out.println(person + System.lineSeparator());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Человек с таким именем не найден.");
        }
    }
}
