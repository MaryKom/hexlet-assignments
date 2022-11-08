package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        //стандартный случай
        List<Integer> numbers1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        assertThat(App.take(numbers1, 5)).isEqualTo(Arrays.asList(1, 2, 3 , 4, 5));

        //0 элементов в списке
        assertThat(App.take(numbers1, 0)).isEqualTo(new ArrayList<>());

        // END
    }
}
