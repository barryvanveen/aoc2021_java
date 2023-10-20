import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Input
{
    public static List<String> ReadLinesFromFile(String filename) throws IOException {
        ArrayList<String> lines = new ArrayList<>();

        InputStream stream = Input.class.getResourceAsStream(filename);

        Scanner sc = new Scanner(stream);
        sc.useDelimiter("\\Z");

        while (sc.hasNextLine())
            lines.add(sc.nextLine());

        return lines;
    }

    public static List<Integer> ConvertStringToInt(List<String> input) {
        return input.stream().map(Integer::parseInt).collect(Collectors.toList());
    }
}
