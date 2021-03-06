import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.Stream;
import org.junit.test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
//make by terry

public class PriorityQueueTest  {
    static Stream<Arguments> test_provide(){
        return Stream.of(
                Arguments.of(new int[]{3,1,2}, new int[]{1,2,3}),
                Arguments.of(new int[]{-3,-1,-2,5},new int[]{-3,-2,-1,5} ),
                Arguments.of(new int[]{3,-2,-5,-1,2},new int[]{-5,-2,-1,2,3} ),
                Arguments.of(new int[]{-3,1,11,0,9,3},new int[]{-3,0,1,3,9,11} ),
                Arguments.of(new int[]{3,7,2,-1,-2},new int[]{-2,-1,2,3,7} )
        );
    }

    @MethodSource("test_provide")
    @ParameterizedTest(name="#{index} - Test with Argument={0},{1}")
    public void Priority_run(int[] random_arrary, int[] correct_answer){
        PriorityQueue<Integer> test = new PriorityQueue<Integer>();
        int[] result = new int[random_arrary.length];

        for (int i=0;i < random_arrary.length; i++) {
            test.add(random_arrary[i]);
        }


        for (int i=0;i < random_arrary.length; i++) {
            result[i] = test.poll();
        }

        assertArrayEquals(correct_answer,result);

    }


    @Test
    public void Exception_null_add() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            new PriorityQueue().add(null);
        });

    }

    @Test
    public void Exception_null_poll() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            Priority_run(null,null);
        });

    }


    @Test
    public void Exception_Fake() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new PriorityQueue(0);
        });

    }

}
