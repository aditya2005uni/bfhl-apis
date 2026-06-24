package com.example.bfhl.service;

import com.example.bfhl.dto.RequestDto;
import com.example.bfhl.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BfhlServiceImpl implements BfhlService {

    @Override
    public ResponseDto process(RequestDto request) {

        List<String> oddNumbers = new ArrayList<>();
        List<String> evenNumbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        List<String> specialCharacters = new ArrayList<>();

        long sum = 0;

        StringBuilder allLetters = new StringBuilder();

        for (String item : request.getData()) {

            if (item.matches("\\d+")) {

                int num = Integer.parseInt(item);

                sum += num;

                if (num % 2 == 0) {
                    evenNumbers.add(item);
                } else {
                    oddNumbers.add(item);
                }

            } else if (item.matches("[a-zA-Z]+")) {

                alphabets.add(item.toUpperCase());

                allLetters.append(item);

            } else {

                specialCharacters.add(item);
            }
        }

        String concatString =
                generateAlternatingCaps(
                        allLetters.toString()
                );

        ResponseDto response = new ResponseDto();

        response.setIs_success(true);


        response.setUser_id("aditya_jha_04062005");
        response.setEmail("aditya0182.be23@chitkara.com");
        response.setRoll_number("2310990182");

        response.setOdd_numbers(oddNumbers);
        response.setEven_numbers(evenNumbers);
        response.setAlphabets(alphabets);
        response.setSpecial_characters(specialCharacters);

        response.setSum(String.valueOf(sum));
        response.setConcat_string(concatString);

        return response;
    }

    private String generateAlternatingCaps(String str) {

        String reversed =
                new StringBuilder(str)
                        .reverse()
                        .toString();

        StringBuilder result =
                new StringBuilder();

        for (int i = 0; i < reversed.length(); i++) {

            char ch = reversed.charAt(i);

            if (i % 2 == 0) {
                result.append(
                        Character.toUpperCase(ch)
                );
            } else {
                result.append(
                        Character.toLowerCase(ch)
                );
            }
        }

        return result.toString();
    }
}