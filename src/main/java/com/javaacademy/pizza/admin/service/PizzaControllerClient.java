package com.javaacademy.pizza.admin.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaacademy.pizza.admin.dto.PizzaDto;
import lombok.SneakyThrows;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.math.BigDecimal;
import java.util.Scanner;

public class PizzaControllerClient {
    private final static String BASE_URL = "http://localhost:8089/pizza";
    private final ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    public void createPizza(Scanner scanner, OkHttpClient client) {
        System.out.println("Введите название пиццы");
        String pizzaName = scanner.nextLine();
        System.out.println("Введите описание пиццы");
        String description = scanner.nextLine();
        System.out.println("Введите цену пиццы");
        BigDecimal price = new BigDecimal(scanner.nextLine());
        System.out.println("Введите url фото пиццы");
        String urlPhoto = scanner.nextLine();
        PizzaDto pizzaDto = new PizzaDto(pizzaName, description, price, urlPhoto);
        byte[] body = objectMapper.writeValueAsBytes(pizzaDto);
//        String jsonBody = """
//                    {
//                    \"name\": \"%s\",
//                    \"description\": \"%s\",
//                    \"price\": \"%s\",
//                    \"img_url\": \"%s\"
//                    }
//                    """.formatted(pizzaName, description, price, urlPhoto);
//        byte[] body = jsonBody.getBytes(StandardCharsets.UTF_8);

        Request request = new Request.Builder()
                .post(RequestBody.create(body))
                .url(BASE_URL)
                .addHeader("Content-Type", "application/json")
                .build();

        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            System.out.println("Ура пицца создана");
        }
    }
}
