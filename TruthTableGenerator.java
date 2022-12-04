public class TruthTableGenerator {

    public static boolean evalExpression(boolean a, boolean b, boolean c) {
        return (a && !c) && !(b && !c) || !(!a || c);
    }

    public static char printVal(boolean x) {
        return (char) (String.valueOf(x).charAt(0) - 32);
    }

    public static void printDisjuntiveNormalForm(boolean[][] table) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < table.length; i++) {
            if (table[i][3]) {
                boolean a = table[i][0], b = table[i][1], c = table[i][2];
                if (!res.isEmpty()) {
                    res.append("∨ ");
                }
                res.append('(');
                if (a) {
                    res.append("a");
                } else {
                    res.append("¬a");
                }
                res.append(" ∧ ");
                if (b) {
                    res.append("b");
                } else {
                    res.append("¬b");
                }
                res.append(" ∧ ");
                if (c) {
                    res.append("c");
                } else {
                    res.append("¬c");
                }
                res.append(") ");
            }
        }
        System.out.println(res.toString());
    }

    public static void main(String[] args) {
        System.out.println("a b c | d");
        System.out.println("---------");

        boolean a = false, b = false, c = false;
        int count = 0;
        boolean[][] table = new boolean[8][4];
        int j = 0;

        for (int i = 0; i < 8; i++) {
            c = i % 2 == 0;
            a = i == 4;
            if (count == 2) {
                b = !b;
                count = 0;
            }
            count++;

            boolean d = evalExpression(a, b, c);

            System.out.println(printVal(a) + " " + printVal(b) + " " + printVal(c) + " | " + printVal(d));
            table[i][j++] = a;
            table[i][j++] = b;
            table[i][j++] = c;
            table[i][j++] = d;
            j = 0;
        }
        printDisjuntiveNormalForm(table);
    }
}
