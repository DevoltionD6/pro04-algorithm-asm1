import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Algorithm {
    Scanner sc = new Scanner(System.in);

    public static void writeFile(String fileName, float arr[]) {
        try {
            // tạo đối tượng và liên kết dữ liệu
            FileOutputStream fos = new FileOutputStream(fileName);
            DataOutputStream dos = new DataOutputStream(fos);

            // ghi dữ liệu
            for (int i = 0; i < arr.length; i++) {
                dos.writeBytes(arr[i] + " ");
            }
            dos.close();
            System.out.println("Array saved!! - New file: " + fileName);
        } catch (Exception e) {
            System.out.println("Error !");
        }
    }

    public static void readFile(String fileName, float[] arr) {
        try {
            // tạo đối tượng và liên kết dữ liệu
            FileInputStream fis = new FileInputStream(fileName);
            DataInputStream dis = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(dis));
            // đọc dữ liệu file và lưu vào arr[]
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] row = line.split(" ");
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = Float.parseFloat(row[i]);

                }
            }
            display(arr);
            dis.close();

        } catch (Exception e) {
            System.out.println("Error !");

        }
    }

    public static float[] bubbleSort(float arr[]) {
        // sao chép dữ liệu mảng a qua b
        int n = arr.length;
        float[] b = new float[n];
        coppyArrToB(arr, n, b);

        // thực hiện sắp xếp
        float temp;
        boolean swapped = false;
        for (int i = 0; i < b.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < b.length - 1; j++) {

                if (b[j] > b[j + 1]) {
                    // đổi chỗ
                    temp = b[j];
                    b[j] = b[j + 1];
                    b[j + 1] = temp;
                    swapped = true;

                }
            }
            if (!swapped) {
                break;
            }
            display(b);
        }
        return b;
    }

    public static float[] selectionSort(float arr[]) {

        // sao chép dữ liệu mảng a qua b
        int n = arr.length;
        float[] b = new float[n];
        coppyArrToB(arr, n, b);

        // lưu dữ liệu mảng a qua b

        // sắp xếp trên mảng b
        int i, j, min_idx;
        // Di chuyển ranh giới của mảng đã sắp xếp và chưa sắp xếp
        for (i = 0; i < n - 1; i++) {
            // Tìm phần tử nhỏ nhất trong mảng chưa sắp xếp
            min_idx = i;
            for (j = i + 1; j < n; j++)
                if (b[j] < b[min_idx])
                    min_idx = j;

            // Đổi chỗ phần tử nhỏ nhất với phần tử đầu tiên

            float temp = b[min_idx];
            b[min_idx] = b[i];
            b[i] = temp;

            display(b);
        }
        return b;
    }

    public static float[] insertionSort(float arr[]) {
        // sao chép dữ liệu mảng a qua b
        int n = arr.length;
        float[] b = new float[n];
        coppyArrToB(arr, n, b);

        // duyệt qua từng phần tử trong mảng
        for (int i = 1; i < b.length; i++) {
            float current = b[i];
            int j = i - 1;

            // duyệt đến khi nào phần tử về đúng vị trí
            while (j >= 0 && b[j] > current) {
                b[j + 1] = b[j];
                j = j - 1;
            }
            b[j + 1] = current;
            display(b);
        }
        return b;
    }

    public static String search(float arr[], float value, Scanner sc) {
        String result = "";
        int i;
        for (i = 0; i < arr.length; i++) {
            if (arr[i] > value) {
                // System.out.println("So " + value + " Nam o vi tri so " + i + " trong mang");
                result += "Index: " + i + " - Value: " + arr[i] + "\n";
            }
        }
        return result;
    }

    public static void writefileLinearSearch(String fileName, String resultLinearSearch) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeBytes(resultLinearSearch);
            dos.close();
        } catch (IOException e) {
            System.out.println("Error !");
        }
    }

    public static int binarySearch(float arr[], int left, int right, float value) {

        int middle = 0;
        int finalvalue = -1;
        while (left <= right) {
            // lấy vị trí ở giữa left và right
            middle = (left + right) / 2;
            // nếu phần tử ở giữa bằng x thì trả về
            // vị trí
            if (arr[middle] == value) {
                return finalvalue = middle;

            }
            // nếu x lớn hơn phần tử ở giữa thì
            // x sẽ nằm bên phải
            // chỉ định left phần từ ở giữa + 1
            if (value > arr[middle]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return finalvalue;

    }

    public static void writeFileBinarySearch(String fileName, String string) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeBytes("Index of first element: " + string);
            dos.close();
        } catch (IOException e) {
            System.out.println("Error !");
        }
    }

    public static float[] coppyArrToB(float arr[], int n, float[] b) {
        // lưu dữ liệu mảng a qua b

        for (int i = 0; i < n; i++) {
            b[i] = arr[i];
        }
        return b;
    }

    public static void display(float[] arr) {
        System.out.println("---------");
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);

        }
        System.out.print("]");
        System.out.println("---------");
    }
}
