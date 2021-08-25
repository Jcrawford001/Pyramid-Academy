
import java.util.Random;
import java.util.Scanner;

public class DragonCave {
    public DragonCave() {
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the DragonCave");
        System.out.println("There are 2 Dragons");
        System.out.println("The nice dragon name is SoulCalibur and the Evil Dragon name is SoulEdge");
        System.out.println("SoulCailbur will bless you and be nice to you and keep you alive, while soulEdge will eat your soul");
        System.out.println("Will you go in SoulCalibur's Cave or SoulEdge's Cave? (1 or 2)");
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        Random r = new Random();
        int rand_cave = r.nextInt(2) + 1;
        if (a == rand_cave) {
            System.out.println("You walk into the Cave");
            System.out.println("there are skull and cross bones everywhere and a whole lot of blood");
            System.out.println("SoulEdge reaches out to you");
            System.out.println("He tears limb from limb and eats your intestines,Just leaving nothing bt your bones in a bloody puddle!");
        }

    }
}