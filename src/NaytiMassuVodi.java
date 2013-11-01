import java.util.ArrayList;

public class NaytiMassuVodi {
    // Размер массива при получении из входных данных (размер N) будет N/2+1.
    int[] vvod = {2, 5, 1, 2, 3, 4, 7, 7, 6};
    ArrayList<Integer> maxMass = new ArrayList();

    void run() {
        int count=0;
        for (int j = 0; j < vvod.length-1; j++) {
            if (vvod[j] <= vvod[j+1]) {
                count++;
            } else { maxMass.add(0); }
        }

        for (int i = count; i < vvod.length - 1; i++) {
            if (vvod[i - 1] < vvod[i] & vvod[i] <= vvod[i + 1]) {
                maxMass.add(i);
            }
        }

        if (vvod.length > vvod.length - 1) {
            maxMass.add(vvod.length);
        }

        if (maxMass.size() == 0 | maxMass.size() == 1) {
            System.out.println("Массив не имеет максимумов! Вода утекёт!");
        } else {
            int maxValue = vvod[maxMass.get(0)];
            for (int i = 0; i < maxMass.size()-1; i++) {
                if (vvod[maxMass.get(i)] > vvod[maxMass.get(i + 1)]) {
                } else if (vvod[maxMass.get(i + 1)] > maxValue) {
                            deleteGap(i + 1, maxValue);
                            maxValue = vvod[maxMass.get(i + 1)];
                       } else if (vvod[maxMass.get(i + 1)] < maxValue) {
                                    deleteGap(i + 1,maxValue);
                              } else {
                                    maxValue = vvod[maxMass.get(i + 1)];
                              }
            }
        }
    }

    void deleteGap(int position, int max) {
        for (int i =position-1; i > max ; i--) {
            if ((i != max)&(vvod[i] <= vvod[position])) {
                maxMass.remove(i);
                position--;
            } else { break;}
        }
    }

    public static void main(String[] args) {
        new NaytiMassuVodi().run();
    }
}
