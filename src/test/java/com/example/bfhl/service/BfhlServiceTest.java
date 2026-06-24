package com.example.bfhl.service;

import com.example.bfhl.dto.RequestDto;
import com.example.bfhl.dto.ResponseDto;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class BfhlServiceTest {

    @Test
    void testProcess() {

        BfhlServiceImpl service = new BfhlServiceImpl();

        RequestDto request = new RequestDto();

        request.setData(
                Arrays.asList(
                        "2",
                        "a",
                        "5",
                        "&"
                )
        );

        ResponseDto response = service.process(request);

        assertEquals(
                "7",
                response.getSum()
        );

        assertEquals(
                1,
                response.getEven_numbers().size()
        );

        assertEquals(
                1,
                response.getOdd_numbers().size()
        );

        assertEquals(
                1,
                response.getSpecial_characters().size()
        );
    }
}