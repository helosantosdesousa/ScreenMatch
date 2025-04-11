package com.github.helosantosdesousa.Counter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.helosantosdesousa.Counter.model.Rating;
import com.github.helosantosdesousa.Counter.model.Task;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class CounterApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(CounterApplication.class, args);
		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome to My Counter! \n Choose up a number and I will count until your number!");
		int n = sc.nextInt();

		for(int i=0; i <n;i++){
			System.out.println(i + " ");
		}

		Task task = new Task("See pull request", false,"Ana");
		ObjectMapper mapper = new ObjectMapper();
		String fileName = "task.json";

		mapper.writeValue(new File(fileName), task);
		System.out.println("Data saved on " + fileName);

		mapper.readValue(new File(fileName), Task.class);
		System.out.println("Task read!");
		System.out.println(task);


	}



}
