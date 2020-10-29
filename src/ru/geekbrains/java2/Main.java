package ru.geekbrains.java2;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
		String[] words = {
				"яблоко",
				"груша",
				"арбуз",
				"слива",
				"манго",
				"дыня",
				"кокос",
				"ананас",
				"кокос",
				"яблоко",
				"апельсин",
				"груша",
				"яблоко",
				"дыня",
				"арбуз",
				"яблоко",
		};
        System.out.println(checkWords(words));

		Phonebook phonebook = new Phonebook();
		phonebook.add("Ivan" , "11111111");
		phonebook.add("Ivan" , "22222222");
		System.out.println(phonebook.get("Ivan"));
		System.out.println(phonebook.get("qwer"));
    }

    public static Map<String, Integer> checkWords(String[] words){
		Map<String, Integer> wordsCount = new HashMap<String, Integer>();
		for (String word : words) {
			if(!wordsCount.containsKey(word)){
				wordsCount.put(word, 1);
			}else {
				wordsCount.put(word, wordsCount.get(word) + 1);
			}
		}
		return wordsCount;
	}
}


