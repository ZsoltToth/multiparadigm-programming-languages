package hu.ekcu.java.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class ArraySplitterImplTest {

    @InjectMocks
    ArraySplitterImpl service;

    @Test
    @DisplayName("Splitting Array Into Two Parts Happy Path")
    void shouldSplitArraysAtIndexSplitTheArrayIntoTwoPartsWhenIndexIsWithinTheArrayLength() {
        // given
        String[] array = new String[]{"a", "b", "c", "d", "e"};
        String[] expectedHead = new String[]{"a", "b"};
        String[] expectedTail = new String[]{"c", "d", "e"};
        final int index = 1;
        // when
        String[][] actual = service.splitArrayAtIndex(array, index);
        // then
        assertThat(actual[0]).usingRecursiveComparison()
                .isEqualTo(expectedHead);
        assertThat(actual[1]).usingRecursiveComparison()
                .isEqualTo(expectedTail);
    }

    @Test
    @DisplayName("Split array at the end")
    void shouldSplitArrayAtIndexSplitIntoTheArrayAndEmptyArrayIfTheIndexIsTheLengthOfTheInput() {
        // given
        String[] array = new String[]{"a", "b", "c", "d", "e"};
        String[] expectedHead = new String[]{"a", "b", "c", "d", "e"};
        String[] expectedTail = new String[]{};
        final int index = array.length - 1;
        // when
        String[][] actual = service.splitArrayAtIndex(array, index);
        // then
        assertThat(actual[0]).usingRecursiveComparison()
                .isEqualTo(expectedHead);
        assertThat(actual[1]).usingRecursiveComparison()
                .isEqualTo(expectedTail);
    }

}