import java.util.Scanner;

public class Main_sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        float[] arr = new float[0];
        float[] b = new float[0];
        float value = 0;

        // chức năng của ứng dụng
        do {
            menu();
            System.out.print("Your Choice:");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Your array length: ");
                    int arrlength = sc.nextInt();
                    arr = new float[arrlength];
                    // nhập dữ liệu vào mảng arr
                    inputData(sc, arr);
                    // ghi dữ liệu vào file input.txt
                    Algorithm.writeFile("Input.txt", arr);
                    Algorithm.display(b);

                    break;
                case 2:
                    System.out.println("Read file Input.txt");
                    System.out.println("Array: ");
                    // đọc dữ liệu file lưu vào mảng arr và hiển thị ra
                    Algorithm.readFile("Input.txt", arr);
                    Algorithm.display(b);
                    break;
                case 3:
                    System.out.println("Bubble sort!");
                    // sắp xếp và trả về mảng b
                    b = Algorithm.bubbleSort(arr);
                    // ghi mảng b vào file output
                    Algorithm.writeFile("Output1.txt", b);
                    Algorithm.display(b);

                    break;
                case 4:
                    System.out.println("Selection sort!");
                    // sắp xếp và trả về mảng b
                    b = Algorithm.selectionSort(arr);
                    // ghi mảng b vào file output2
                    Algorithm.writeFile("Output2.txt", b);
                    Algorithm.display(b);

                    break;
                case 5:
                    System.out.println("Insertion sort!");
                    // sắp xép và trả về mảng b
                    b = Algorithm.insertionSort(arr);
                    // ghi mảng b vào file output3
                    Algorithm.writeFile("Output3.txt", b);
                    Algorithm.display(b);

                    break;
                case 6:
                    System.out.println("Linear searching!");
                    System.out.print("Your value: ");
                    value = sc.nextFloat();

                    // trả về kết quả tìm kiếm
                    String resultLinearSearc = Algorithm.search(b, value, sc);
                    if (resultLinearSearc == "") {
                        System.out.println("Cannot found your value!");
                        Algorithm.writefileLinearSearch("Output4.txt", "Value Invalid!");

                    } else {
                        System.out.println(resultLinearSearc);
                        Algorithm.writefileLinearSearch("Output4.txt", resultLinearSearc);
                    }
                    break;
                case 7:
                    System.out.println("Binary searching!");
                    System.out.println("Your value");
                    value = sc.nextFloat();
                    // trả về kết quả tìm kiếm
                    int left = 0;
                    int right = b.length - 1;
                    float resultBinarySearch = Algorithm.binarySearch(b, left, right, value);
                    if (resultBinarySearch == -1) {
                        System.out.println("Cannot found your value(" + value + ")!");
                        Algorithm.writeFileBinarySearch("Output5.txt", "Value Invalid!");
                    } else {
                        System.out.println("Your value(" + value + ") Has been found at " + ((int) resultBinarySearch)
                                + " in array b");
                        Algorithm.writefileLinearSearch("Output5.txt", "Your value(" + value + ") Has been found at "
                                + ((int) resultBinarySearch) + " in this array");
                    }
                    break;
                case 0:

                    break;

                default:
                    System.out.println("Invalid choice ! Try again.");
                    break;
            }
        } while (choice != 0);
        sc.close();
        System.out.println("END!!");
    }

    public static void menu() {
        System.out.println("------Menu------");
        System.out.println("1. Input");
        System.out.println("2. Output");
        System.out.println("3. Bubble Sort");
        System.out.println("4. Selection Sort");
        System.out.println("5. Insertion Sort");
        System.out.println("6. Search > Your Value");
        System.out.println("7. Search = Your value");
        System.out.println("0. End!!!");

    }

    public static void inputData(Scanner sc, float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Your " + i + " Value is: ");
            arr[i] = sc.nextFloat();
        }
    }
}
