import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random(0);
        Scanner kb = new Scanner(System.in);
        System.out.println("Введите размер массива 1");
        int x = kb.nextInt();
        System.out.println("Введите размер массива 2");
        int y = kb.nextInt();
        int [][] arr = new int[x][y];
        double sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                arr [i][j] = (int)(Math.random()*99);
                sum += arr [i][j];
                if (arr [i][j]<min) min = arr [i][j];
                if (arr [i][j]>max) max = arr [i][j];
            }
        }

        System.out.println(Arrays.deepToString(arr));
        System.out.println("Сумма элементов массива: " + sum);
        System.out.println("Среднее значение элемента массива: " + sum/(x*y));
        System.out.println("Минимальное значение массива: " + min);
        System.out.println("Максимальное значение массива: " + max);

        int [][] arr1= new int[x][y];
        for(int i = 0; i < arr1.length; i++)
        {
            for(int j = 0; j < arr1[i].length; j++)
            {
                boolean unique;
                do
                {
                    unique = true;
                    arr1[i][j] = random.nextInt(x*y);
                    for(int k = 0; k <= i; k++)
                    {
                        for(int l = 0; l < (k == i ? j : arr1[k].length); l++)
                        {
                            if(arr1[i][j] == arr1[k][l])
                            {
                                unique = false;
                                break;
                            }
                        }
                        if(!unique)break;
                    }
                }while(!unique);
            }
        }


        for(int i = 0; i < arr1.length; i++)
        {
            for(int j = 0; j < arr1[i].length; j++)
            {
                //arr[i][j] - выбранный элемент
                for(int k = i; k < arr1.length; k++)
                {
                    for(int l = k == i ? j : 0; l < arr1[k].length; l++)
                    {
                        //arr[i][j] - выбранный элемент
                        //arr[k][l] - перебираемый элемент

                        if(arr1[k][l] < arr1[i][j])
                        {
                            int buffer = arr1[i][j];
                            arr1[i][j] = arr1[k][l];
                            arr1[k][l] = buffer;

                        }
                    }
                }
            }
        }

        System.out.println(Arrays.deepToString(arr1));

    }
}