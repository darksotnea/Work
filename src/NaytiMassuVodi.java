import java.util.ArrayList;

public class NaytiMassuVodi {
    // Размер массива при получении из входных данных (размер N) будет N/2+1.
//    int[] vvod = {2, 5, 1, 2, 3, 4, 7, 7, 6};                      //= 10
    int[] vvod = {1, 3, 2, 3, 5, 5, 7, 7, 1, 6, 2, 1, 1, 4, 3, 3, 1}; //= 14
//    int[] vvod = {4, 4, 1, 1, 2, 3, 4, 5, 7, 7};                      //= 9
//    int[] vvod = {2, 2, 5, 2, 3, 5, 2, 7, 6, 1, 1, 1};                //= 8
//    int[] vvod = {7, 5, 1, 2, 3, 4, 7, 7, 6};                         //= 20
//    int[] vvod = {7, 5, 1, 2, 3, 4, 7, 7};                            //= 20
//    int[] vvod = {1, 2, 3, 4, 5, 4, 7, 7, 7, 7, 6};                   //= 1
//    int[] vvod = {7, 7, 5, 4, 3, 2, 1, 1, 1};                         //= нет максимумов
//    int[] vvod = {7, 7, 5, 4, 3, 2, 1, 3, 1};                         //= 3
//    int[] vvod = {7, 7, 5, 4, 3, 2, 1, 3, 1, 2};                      //= 4

    ArrayList<Integer> maxMass = new ArrayList();

    void run() {

        for (int i = 0; i < vvod.length - 1; i++) {
            for (int j = i; j < vvod.length-1; j++) {
                if (vvod[j] < vvod[j+1]) {
                    i++;
                } else {
                    if (j == 0) {
                        maxMass.add(j);
                        i++;
                    }
                    break;
                }
            }
            if (i < vvod.length - 2) {
                if (vvod[i - 1] < vvod[i] & vvod[i] >= vvod[i + 1]) {
                    maxMass.add(i);
                }
            }
        }

        if (vvod[vvod.length-1] > vvod[vvod.length - 2]) {
            maxMass.add(vvod.length-1);
        }

        if (maxMass.size() == 0 | maxMass.size() == 1) {
            System.out.println("Массив не имеет максимумов! Вода утекёт!");
        } else {
            System.out.println("Всего накопившейся воды: " + summWater(maxMass));
        }
    }

    int summWater(ArrayList<Integer> massMax) {
        int frontier = 0;
        int sumWater = 0;
        for (int i = 0; i < massMax.size()-1; i++) {
            if (vvod[massMax.get(i)] >= vvod[massMax.get(i + 1)]) {
                frontier = vvod[massMax.get(i + 1)];
            } else {
                frontier = vvod[massMax.get(i)];
            }

            for (int j = massMax.get(i)+1; j != massMax.get(i + 1); j++) {
                if (frontier > vvod[j]) {
                    sumWater += frontier - vvod[j];
                }
//                System.out.println("Промежуточная сумма равна: " + sumWater);
            }
        }
        return sumWater;
    }

    public static void main(String[] args) {
        new NaytiMassuVodi().run();
    }
}
