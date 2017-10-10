package lz78;

import javafx.util.Pair;

import java.util.*;

/**
 * @author Vladislav Cheparin (vladislav.cheparin.gdc@ts.fujitsu.com)
 */
public class LZ78 {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String next = scanner.nextLine();
        final LZ78 lz78 = new LZ78();
        lz78.encoding(next);

    }

    private void encoding(String string) {
        final List<String> list = new ArrayList<>();
        final List<Pair<Integer, String>> pairs = new ArrayList<>();
        list.add("");

        final char[] chars = string.toCharArray();
        final StringBuilder builder = new StringBuilder();
        for (char aChar : chars) {
            builder.append(aChar);
            if (!list.contains(builder.toString())) {
                list.add(builder.toString());
                final int index = list.indexOf(
                        builder.deleteCharAt(
                                builder.length() - 1
                        )
                                .toString()
                );
                pairs.add(new Pair<>(
                        index, String.valueOf(aChar))
                );
                builder.setLength(0);
            }
        }
        write(pairs);
    }

    private void write(List<Pair<Integer, String>> pairs) {
        System.out.println(Arrays.toString(pairs.toArray()));
        decode(pairs);
    }

    private void decode(List<Pair<Integer, String>> pairs) {
        //final List<Pair<Integer, String>> pairs = read(string);
        final List<String> list = new ArrayList<>();
        list.add("");

        final StringBuilder builder = new StringBuilder();
        for (Pair<Integer, String> pair : pairs) {
            builder.append(
                    list.get(pair.getKey())
            )
                    .append(pair.getValue());
            list.add(pair.getValue());
        }
        System.out.println(builder);
    }

    private List<Pair<Integer, String>> read(String string) {
        return new ArrayList<>();
    }


}
