package ru.geekbrains.java2;

public class Main {

    public static void main(String[] args) {
        String[][] array = {
                {"1","2","3","2"},
                {"4","5","6","3"},
                {"4","5","6","4"},
                {"7","a","9","5"}
        };
        try {
            System.out.println("Сумма всех ячеек массива " + exceptionMethodTest(array));
        }catch (MyArraySizeException e){
            System.err.println(e.getMessage());
        }catch (MyArrayDataException e){
            System.err.println(e.getMessage());
        }

    }

    public static int exceptionMethodTest(String[][] array) throws MyArraySizeException , MyArrayDataException{
        if (array.length != 4) throw new MyArraySizeException("Ошибка размера массива");
        int sum = 0;
        for (int i = 0; i < array.length ; i++) {
            if (array[i].length != 4) throw new MyArraySizeException();
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                }catch (NumberFormatException e){
                    throw new MyArrayDataException("Проблема с переводом в Int ячейки [" + i + "][" + j + "]", e);
                }
            }
        }
        return sum;
    }
}
