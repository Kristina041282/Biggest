import java.util.HashMap;

public class SizeCalculator {

    private static char[] sizeMulti = {'B', 'K', 'M', 'G', 'T'};
    private static HashMap<Character, Integer> ch = getMultipliers();

    public static String getHumanReadableSize(long size) {
        for (int i = 0; i < sizeMulti.length; i++) {
            double value = ((double) size) / Math.pow(1024, i);//делим размер на множитель(любое число в степени это 1)//привели к явному double
            if (value < 1024) {
                return Math.round(value * 100) /100 + "" + sizeMulti[i] + (i > 0 ? "b" : "");//чтобы здесь возвращалась строка, сделали"" после value хитрый способ
                //еще плюсуем число "b" если i>0, чтобы кб или мб получались //чтобы было две запятые
            }
        }
        return "Very big";
    }
    public static long getSizeFromHumanReadable(String size) {
        System.out.println(size);
        System.exit(0);
        char sizefactor = size.replaceAll("[0-9\\s+]+", "").charAt(0);
        int mul = ch.get(sizefactor);
        //long length = mul * Long.valueOf(size.replaceAll("[^0-9]", ""));//вместо этой строки можно прописать так, ниже под ней
        long length = mul * Long.parseLong(size.replaceAll("[^0-9]", ""));
        return length;
    }
    public static HashMap<Character, Integer> getMultipliers() {
        HashMap<Character, Integer> ch2 = new HashMap<>();
        for (int i = 0; i < sizeMulti.length; i++) {
            ch2.put(sizeMulti[i], (int) Math.pow(1024, i));
        }
        return ch2;
    }
}
