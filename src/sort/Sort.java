package sort;

public class Sort {
    public static void main(String[] args) {
        new Sort();
    }

    public Sort() {

        int[] data = {7, 22, 4, 31, 1, 2, 99, 6, 8, 91, 55};

        System.out.println("Selection Sort Print");
        for (int i : select(data)) {
            System.out.print(i + " ");
        }

        System.out.println("\nBubble Sort Print");
        for (int i : bubble(data)) {
            System.out.print(i + " ");
        }

        System.out.println("\nInsert Sort Print");
        for (int i : insert(data)) {
            System.out.print(i + " ");
        }
    }

    private int[] select(int[] data) {
        int temp, min;

        for (int i = 0; i < data.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[min] > data[j]) {
                    min = j;
                }
            }
            temp = data[min];
            data[min] = data[i];
            data[i] = temp;
        }
        return data;
    }

    private int[] bubble(int[] data) {
        int temp;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
        return data;
    }

    private int[] insert(int[] data) {
        int temp, j;
        for (int i = 1; i < data.length; i++) {
            temp = data[i];
            for (j = i - 1; j >= 0 && data[j] > temp; j--) {
                data[j + 1] = data[j];
            }
            data[j + 1] = temp;
        }
        return data;
    }
}