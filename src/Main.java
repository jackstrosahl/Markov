import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Markov<String> markov = new Markov<>();

        File data = new File("data.txt");

        Scanner scanner = new Scanner(data);

        while(scanner.hasNextLine())
        {
            markov.add(scanner.nextLine().split(" "));
        }

        List<String> generated = markov.generate();

        for(String s: generated)
        {
            System.out.print(s+" ");
        }
    }
}








