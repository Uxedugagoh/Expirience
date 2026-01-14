import com.example.BinarySearch;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestBinarySearch {

    @Test
    void testEmptyArray() {
        int[] arr = {};
        assertEquals(-1, BinarySearch.trueBinarySearch(arr, 5));
    }

    @Test
    void testSingleElementFound() {
        int[] arr = {10};
        assertEquals(0, BinarySearch.trueBinarySearch(arr, 10));
    }

    @Test
    void testSingleElementNotFound() {
        int[] arr = {10};
        assertEquals(-1, BinarySearch.trueBinarySearch(arr, 5));
    }

    @Test
    void testElementAtStart() {
        int[] arr = {1, 2, 3, 4, 5};
        assertEquals(0, BinarySearch.trueBinarySearch(arr, 1));
    }

    @Test
    void testElementAtEnd() {
        int[] arr = {1, 2, 3, 4, 5};
        assertEquals(4, BinarySearch.trueBinarySearch(arr, 5));
    }

    @Test
    void testElementInMiddle() {
        int[] arr = {1, 2, 3, 4, 5};
        assertEquals(2, BinarySearch.trueBinarySearch(arr, 3));
    }

    @Test
    void testElementInLeftHalf() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        assertEquals(1, BinarySearch.trueBinarySearch(arr, 2));
    }

    @Test
    void testElementInRightHalf() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        assertEquals(5, BinarySearch.trueBinarySearch(arr, 6));
    }

    @Test
    void testNegativeNumbers() {
        int[] arr = {-5, -3, 0, 1, 4};
        assertEquals(1, BinarySearch.trueBinarySearch(arr, -3));
    }

    @Test
    void testDuplicateElements() {
        int[] arr = {1, 2, 2, 2, 3};
        int result = BinarySearch.trueBinarySearch(arr, 2);
        // Проверяем, что элемент найден (не гарантирует конкретный индекс)
        assertEquals(2, arr[result]);
    }

    @Test
    void testLargeArray() {
        int[] arr = new int[1000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        assertEquals(123456, BinarySearch.trueBinarySearch(arr, 123456));
    }

    @Test
    void testAllElementsSame() {
        int[] arr = {5, 5, 5, 5, 5};
        int result = BinarySearch.trueBinarySearch(arr, 5);
        assertEquals(5, arr[result]); // Любой из корректных индексов
    }

    @Test
    void testElementBetweenDuplicates() {
        int[] arr = {1, 1, 2, 2, 3, 3};
        int result = BinarySearch.trueBinarySearch(arr, 2);
        assertEquals(2, arr[result]);
    }
}