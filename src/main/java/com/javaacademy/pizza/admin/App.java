package com.javaacademy.pizza.admin;

import com.javaacademy.pizza.admin.service.AdminPizzaCommands;
import com.javaacademy.pizza.admin.service.OrderService;
import com.javaacademy.pizza.admin.service.PizzaControllerClient;
import okhttp3.OkHttpClient;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();
        PizzaControllerClient pizzaControllerClient = new PizzaControllerClient();
        OrderService orderService = new OrderService();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите имя команды!\n%s".formatted(Arrays.toString(AdminPizzaCommands.values())));
            switch (AdminPizzaCommands.valueOf(scanner.nextLine())) {
                case CREATE_PIZZA -> pizzaControllerClient.createPizza(scanner, client);
                case GET_ALL_ORDER -> orderService.getAllOrders(client);
            }

        }
    }
}
