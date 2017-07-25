package tr.org.linux.kamp.arrayMinMaxRange;

import java.util.Random;

public class MinMaxRange {

	private static Random rnd = new Random();
	private static int bound = 10;
	private static int[] array = new int[bound];

	public static void main(String[] args) {
		generateArray();
		printArray();
		findMin();
		findMax();
		average();
		System.out.println("min" + findMin());
		System.out.println("max" + findMax());
		System.out.println("ortalama" + average());

	}

	public static void generateArray() { // değer döndürmediği için void

		int item;
		for (int i = 0; i < array.length; i++) {

			item = rnd.nextInt(10);
			array[i] = item;
		}
	}

	public static void printArray() {

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");

		}
		System.out.println("\n");
	}

	public static int findMin() {
		int temp = 100;
		for (int i = 0; i <= array.length; i++) {
			for (int j = 1; j < array.length; j++) {
				if (array[j - 1] > array[j]) {
					temp = array[j];

				}
			}
		}
		return temp;
	}

	public static int findMax() {
		int temp = 0;
		for (int i = 0; i <= array.length; i++) {		//
			for (int j = 1; j <=array.length; j++) {
				if (array[j - 1] <= array[j]) {
					temp = array[j];
					return temp;
				}
			}
		}return temp;
	}
		

	public static double average() {
		double toplam = 0.0;
		double avr=0.0;
		int temp = 0; // büyükle küçüğü değişirken yedekte tutmak için değişken
		for (int i = 0; i < array.length; i++) {
			for (int j = 1; j < array.length; j++) { // birinciden başlıyoruz çünkü karşilaştirirken
														// aynı elemandan başlanmaz.
				if (array[j - 1] < array[j]) { // eğer bir önceki eleman şimdikinden küçükse
					temp = array[j - 1]; // bir önceki yani büyük olan elemanı yedeğe al.
					array[j - 1] = array[j]; // şimdiki elemana küçük olana bir öncekini attık.
					array[j] = temp; // bir önceki elemanı şimdiki elemana attık.

				}

			}
		}
		for (int j = 1; j < array.length - 1; j++) {

			toplam+= array[j];
			avr=toplam/((array.length)-2);
		}
		return avr;
	}
}