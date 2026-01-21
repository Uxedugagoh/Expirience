package com.example.task67;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class BinaryPlusTest {
    public static Stream<Arguments> add() {
        return Stream.of(
                Arguments.of("10", "1", "1"),
                Arguments.of("1", "1", "0"),
                Arguments.of("101", "10", "11"),
                Arguments.of("1000", "111", "1"),
                Arguments.of("100", "10", "10"),
                Arguments.of(
                        "110111101100010011000101110110100000011101000101011001000011011000001100011110011010010011000000000",
                        "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
                        "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"),
                Arguments.of(
                        "110110110100011101100000010100011101011110111001010100101110110011010001101001011010010111",
                        "1000111111101100010001101101100000011100111001010110000010100111010111000101010001",
                        "110110101011011101110100000010101111111110011100011011011000110000101010010010010101000110")
        );
    }

    @ParameterizedTest
    @MethodSource("add")
    void testParam(String expected, String a, String b) {
        String res = BinaryPlus.addBinary(a, b);
        assertThat(res).isEqualTo(expected);
    }
}