package nl.hefty.datagenerator;

import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Generator {
    private static String[] filters = new String[] {"test1", "test2", "test3", "test4", "test5", "test6", "test7"};
    private static String[] headers = new String[] {"header1", "header2", "header3", "header4", "header5"};
    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String... args) {
        mapper.getFactory().setCharacterEscapes(new CharacterEscapes() {
            @Override
            public int[] getEscapeCodesForAscii() {
                int[] esc = CharacterEscapes.standardAsciiEscapesForJSON();
                esc['"'] = CharacterEscapes.ESCAPE_NONE;
                return esc;
            }

            @Override
            public SerializableString getEscapeSequence(int i) {
                return null;
            }
        });
        try {
            FileWriter file = new FileWriter("C:\\Users\\pc\\IdeaProjects\\filters\\src\\assets\\data.json");

            try {
                List<Line> dats = new ArrayList<Line>();
                long rand = Math.round(Math.random() * 40000);
                for (int j = 0; j < rand; j++){
                    System.out.println("Writing value " + j + " of " + rand);
                    List<String> values = new ArrayList<>();
                    for(int i = 0; i < 5; i++) {
                        int index = (int)Math.floor(Math.random()*filters.length);
                        values.add(filters[index]);
                    }
                    dats.add(new Line(values.toArray(new String[values.size()])));
                }
                String out = mapper.writeValueAsString(dats);
                mapper.writeValue(file, out);
                System.out.println("done");
            } catch (Exception e) {

            } finally {
                file.close();
            }

        } catch (Exception e) {

        }
    }
}
