public class Area {
    double area(double X[], int N) {
        double S = 0;
        for (int a = 0, b = N - 1; a < b; ) {
            double ha = X[a], hb = X[b];
            if (ha < hb) {
                while (X[++a] < ha) {
                    S += ha - X[a];
                }
            } else {
                while (X[--b] < hb) {
                    S += hb - X[b];
                }
            }

        }
        return S;
    }

    public static void main(String[] args) {
        double[] m = {5, 1, 3, 6, 1, 6, 1, 3, 1, 4};
        System.out.println(new Area().area(m, m.length));
    }
}
