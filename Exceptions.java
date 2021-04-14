package Level2_L2;


public class Exceptions {


    public static int fourDimensionArray(String a[][]) throws MyArrayDataException, MyArraySizeException{

        int sum = 0;
        int index1 = 0; // номер элемента массива для вывода в сообщение
        int index2 = 0; // номер элемента массива для вывода в сообщение
        int error = 0; // для принуждения к ошибке при error <> 0

        try {
            for (int i = 0; i < a.length + error; i++) {
                for (int j = 0; j < a.length + error; j++) {
                    a[i][j] = String.valueOf((int) (Math.random() * 100));
                }
            }

            // проверка на неверный элемент, если не закомментирован
            a[1][1] = "one";

        } catch (ArrayIndexOutOfBoundsException e) {
            throw new MyArraySizeException("Неверный формат массива");
        }
        ;
        try {

            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a.length; j++) {
                    index1 = i;
                    index2 = j;
                    sum = sum + Integer.parseInt(a[i][j]);
                }
            }
        } catch (NumberFormatException e) {
            throw new MyArrayDataException("Неверный формат в элементе " + "[" + index1 + "]" + "[" + index2 + "]");
        }
        return sum;
    }

    public static void main(String[] args) {

        String[][] array = new String[4][4];

        try {

            System.out.println("Сумма элементов массива = " + fourDimensionArray(array));

        } catch (MyArraySizeException e) {
            System.out.println("Неверный формат массива");
        } catch (MyArrayDataException e) {
            System.out.println("Неверный элемент в массиве");
        }

    }

}
