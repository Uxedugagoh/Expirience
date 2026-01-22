package com.example.Ttask1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class StringSortTest {
    public static Stream<Arguments> add() {
        return Stream.of(
                Arguments.of("682902", "202689"),
                Arguments.of("01", "10"),
                Arguments.of("6394001", "1003469"),
                Arguments.of("0", "0"),
                Arguments.of("5", "5"),
                Arguments.of("61", "16"),
                Arguments.of("00000000", "0"),
                Arguments.of("9", "9"),
                Arguments.of("1134622222222222222634777134731451347000102345012303014067135901",
                        "1000000000111111111222222222222222233333333344444445556667777779")
        );
    }

    @ParameterizedTest
    @MethodSource("add")
    void testParam(String given, String expected) {
        String res = StringSort.stringSort(given);
        assertThat(expected).isEqualTo(res);
    }
}