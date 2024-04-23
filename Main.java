import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		File file = new File("insurances.txt");

		Scanner input = null;
		Map<String, Integer> numberOfPurchases = new HashMap<>();
		Set<String> cities = new HashSet<>();
		cities.add("Sofia"); cities.add("Plovdiv"); cities.add("Varna");
		Map<String, Set<String>> brandOwners = new HashMap<>();

		try {
			input = new Scanner(file);

			while (input.hasNext()) {
				int year = input.nextInt();
				String brand = input.next();
				int price = input.nextInt();
				String clientCity = input.next();
				String ownerName = input.next();

				if (price >= 2000 || year < 2015 || year > 2020 || !cities.contains(clientCity)) {
					continue;
				}

				brandOwners.computeIfAbsent(brand, k -> new HashSet<>());
				brandOwners.get(brand).add(ownerName);

				if(numberOfPurchases.containsKey(brand)) {
					numberOfPurchases.put(brand, numberOfPurchases.get(brand)+1);
				} else {
					numberOfPurchases.put(brand, 1);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} finally {
			assert input != null;
			input.close();
		}

		numberOfPurchases = sortByValue(numberOfPurchases);

		File file2 = new File("output.txt");
		if (file.exists()) {
			System.out.println("File already exists");
			System.exit(1);
		}
		PrintWriter output = null;

		try {
			output = new PrintWriter(file2);

			int i = 1;
			for(String brand : numberOfPurchases.keySet()) {
				if (i == 3) break;
				i++;
				output.print(brand + ": ");
				for(String el : brandOwners.get(brand)) {
					output.print(el + " ");
				}
				output.println();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			assert output != null;
			output.close();
		}
	}

	private static HashMap<String, Integer> sortByValue(Map<String, Integer> hm)
	{
		List<Map.Entry<String, Integer> > list =
				new LinkedList<>(hm.entrySet());

		list.sort(new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1,
							   Map.Entry<String, Integer> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		HashMap<String, Integer> temp = new LinkedHashMap<>();
		for (Map.Entry<String, Integer> el : list) {
			temp.put(el.getKey(), el.getValue());
		}
		return temp;
	}
}

/*
* Зад2.: Магазин за техника търси 3те най-продавани лаптопи с цена <2000, които са закупени от клиенти от
* градове от следния списък: София, Пловдив, Варна през годините от 2015 до 2020.
Данните четете от файл, който съдържа:
Година_на_закупуване, марка, цена, клиент_град, име_клиент
Пример:
2016 Lenovo 1980 Sofia IvanIvanov

Резултата запишете във файл като за 3те най- продавани лаптопи е нужно да се запише списък на имената на
* клиентите в съответния диапазон години за съответните градове. Например:

Лаптоп: Имена клиенти със запетая
Lenovo: IvanIvano, PetarPetrov

* */
