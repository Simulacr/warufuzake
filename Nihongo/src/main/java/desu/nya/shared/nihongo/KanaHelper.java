package desu.nya.shared.nihongo;

import java.util.*;
import java.util.function.Predicate;

/**
 * Created by Ker on 27/10/2015.
 */
public class KanaHelper {
    private List<String> katakana;
    private final List<String> hiragana;
    private static KanaHelper instance;
    private Random random = new Random();

    public static KanaHelper instance() {
        if(instance == null)
            instance = new KanaHelper();
        return instance;
    }

    public List<String> getHiragana() {
        return hiragana;
    }

    public boolean isHiragana(String ji) {
        return hiragana.stream().anyMatch(Predicate.isEqual(ji));
    }

    public List<String> getRandomHiragana(int count) {
        List<String> randomList = new ArrayList<>(count);
        String randomHiragana = null;
        for(int i=0; i<count; i++) {
            while(randomHiragana == null || randomList.contains(randomHiragana))
                randomHiragana = hiragana.get(random.nextInt(hiragana.size()));
            randomList.add(randomHiragana);
            randomHiragana = null;
        }
        return randomList;
    }

    private KanaHelper() {
        hiragana = Arrays.asList(
                "あ", "い", "う", "え", "お",
                "か", "き", "く", "け", "こ",
                "さ", "し", "す", "せ", "そ",
                "た", "ち", "つ", "て", "と",
                "な", "に", "ぬ", "ね", "の",
                "ま", "み", "む", "め", "も",
                "は", "ひ", "ふ", "へ", "ほ",
                "ら", "り", "る", "れ", "ろ",
                "だ", "ぢ", "づ", "で", "ど",
                "や", "ゆ", "よ", "を", "ん",
                "ざ", "じ", "ず", "ぜ", "ぞ",
                "ば", "び", "ぶ", "べ", "ぼ");
    }
}
