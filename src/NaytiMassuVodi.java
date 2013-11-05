import java.util.ArrayList;

public class NaytiMassuVodi {
    ArrayList<Integer> arrayOfMaximums = new ArrayList();
    int [] sourceArray;

    public NaytiMassuVodi(int[] sourceArray) {
        this.sourceArray = sourceArray;
    }

    void run() {
        //получение массива со всеми локальными максимумами
        for (int i = 0; i < sourceArray.length; i++) {
            for (int j = i; j < sourceArray.length-1; j++) {
                if ( sourceArray[j] <  sourceArray[j+1]) {
                    i++;
                } else {
                    if (j == 0) {
                        arrayOfMaximums.add(j);
                        i++;
                    }
                    break;
                }
            }
            if (i <  sourceArray.length - 1) {
                if ( sourceArray[i - 1] <  sourceArray[i] &  sourceArray[i] >=  sourceArray[i + 1]) {
                    arrayOfMaximums.add(i);
                }
            }
        }

        if ( sourceArray[ sourceArray.length-1] >  sourceArray[ sourceArray.length - 2]) {
            arrayOfMaximums.add(sourceArray.length - 1);
        }

        if (arrayOfMaximums.size() == 0 | arrayOfMaximums.size() == 1) {
            System.out.println("Массив не имеет ям! Вода вся утекла после дождя!");
        } else {
            int indexOfMaxValue = 0;
            for (int i = 0; i < arrayOfMaximums.size()-1; i++) {
                if ( sourceArray[arrayOfMaximums.get(i)] >  sourceArray[arrayOfMaximums.get(i + 1)]) {
                } else if ( sourceArray[arrayOfMaximums.get(i + 1)] >  sourceArray[arrayOfMaximums.get(indexOfMaxValue)]) {
                            deleteGap(i + 1, indexOfMaxValue);
                            indexOfMaxValue =  i + 1;
                       } else if ( sourceArray[arrayOfMaximums.get(i + 1)] < sourceArray[arrayOfMaximums.get(indexOfMaxValue)]) {
                                    deleteGap(i + 1, indexOfMaxValue);
                              } else {
                                    indexOfMaxValue = i + 1;
                              }
            }
            System.out.println("Всего накопившейся воды: " + summWater(arrayOfMaximums));
        }
    }

    int summWater(ArrayList<Integer> massMax) {
        int frontier = 0;
        int sumWater = 0;
        for (int i = 0; i < massMax.size()-1; i++) {
            if (sourceArray[massMax.get(i)] >= sourceArray[massMax.get(i + 1)]) {
                frontier = sourceArray[massMax.get(i + 1)];
            } else {
                frontier = sourceArray[massMax.get(i)];
            }

            for (int j = massMax.get(i)+1; j != massMax.get(i + 1); j++) {
                if (frontier > sourceArray[j]) {
                    sumWater += frontier - sourceArray[j];
                }
            }
        }
        return sumWater;
    }

    //удаление промежуточных максимумов, которые ограничены по бокам более большими максимумами.
    void deleteGap(int position, int max) {
        for (int i =position-1; i > max ; i--) {
            if ((i != max)&(sourceArray[i] >= sourceArray[max])) {
                arrayOfMaximums.remove(i);
            } else { break;}
        }
    }

    public static void main(String[] args) {
        //тестовые массивы
        int[][] setOfMassives = {
                            {2, 5, 1, 2, 3, 4, 7, 7, 6},                         //= 10
                            {1, 3, 2, 3, 5, 5, 7, 7, 1, 6, 2, 1, 1, 4, 3, 3, 1}, //= 14
                            {4, 4, 1, 1, 2, 3, 4, 5, 7, 7},                      //= 9
                            {2, 2, 5, 2, 3, 5, 2, 7, 6, 1, 1, 1},                //= 8
                            {7, 5, 1, 2, 3, 4, 7, 7, 6},                         //= 20
                            {7, 5, 1, 2, 3, 4, 7, 7},                            //= 20
                            {1, 2, 3, 4, 5, 4, 7, 7, 7, 7, 6},                   //= 1
                            {7, 7, 5, 4, 3, 2, 1, 1, 1},                         //= нет максимумов
                            {7, 7, 5, 4, 3, 2, 1, 3, 1},                         //= 3
                            {7, 7, 5, 4, 3, 2, 1, 3, 1, 2},                      //= 4
                            {5, 1, 3, 6, 1, 6, 1, 3, 1, 4},                      //= 18
                            {0, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 1},                //= 1
                            {5, 1, 4, 2, 3},                                     //= 4
                            {1, 0, 7, 0, 1},                                     //= 2
                            {2, 7, 1, 1, 6, 2, 4, 1, 1, 2},                      //= 14
                            {2, 1, 3, 2, 3, 1, 2},                               //= 3
                            {5, 4, 3, 2, 1},                                     //= нем воды
                            {5, 1, 3},                                           //= 2
                            {1, 2, 3, 2, 5, 3, 4},                               //= 2
                            {5, 1, 5, 1, 5, 1, 5},                               //= 12
                            {1, 5, 1, 5, 1, 5, 1},                               //= 8
                            {3, 1, 1, 5, 1, 3, 2},                               //= 6
                            {1, 2, 3, 4, 5},                                     //= нет воды
                            {5, 1, 0, 1},                                        //= 1
                            {2, 5, 1, 2, 3, 4, 7, 7, 6, 3, 5}                    //= 12
        };
        for(int[] i : setOfMassives) {
            new NaytiMassuVodi(i).run();
        }
    }
}
