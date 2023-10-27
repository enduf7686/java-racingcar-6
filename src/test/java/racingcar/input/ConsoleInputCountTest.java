package racingcar.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ConsoleInputCountTest extends NsTest {

    Input consoleInput = new ConsoleInput();

    @Test
    void 실행_횟수_입력() {
        String input = "42";

        run(input);
        assertThat(output()).contains("42");
    }

    @Test
    void 실행_횟수_입력_예외_문자_입력() {
        String input = "ab";

        assertThatThrownBy(() -> runException(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 실행_횟수_입력_예외_1미만_입력() {
        String input = "0";

        assertThatThrownBy(() -> runException(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 실행_횟수_입력_예외_100초과_입력() {
        String input = "438";

        assertThatThrownBy(() -> runException(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    protected void runMain() {
        int execution = consoleInput.receiveTotalCountOfExecution();
        System.out.println(execution);
    }
}