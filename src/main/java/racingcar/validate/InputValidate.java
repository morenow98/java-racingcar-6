package racingcar.validate;

import java.util.Arrays;
import racingcar.domain.constant.ConstNumber;
import racingcar.domain.constant.Delimiter;
import racingcar.enums.ExceptionMessage;

public class InputValidate {
    public void validateNames(String input) {
        String[] carNames = input.split(Delimiter.INPUT_NAME_DELIMITER.getValue());
        validateNull(carNames);
        validateLength(carNames);
    }

    private void validateNull(String[] carNames) {
        if (Arrays.stream(carNames).map(String::trim).anyMatch(String::isEmpty)) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_NULL_EXCEPTION_MESSAGE.getValue());
        }
    }

    private void validateLength(String[] carNames) {
        if (Arrays.stream(carNames).anyMatch(carName -> carName.length() > ConstNumber.CAR_NAME_MAX_LENGTH.getValue())) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_LENGTH_EXCEPTION_MESSAGE.getValue());
        }
    }

    public void validateTrialNum(String input) {
        int inputNum;
        try {
            inputNum = Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_INTEGER_EXCEPTION_MESSAGE.getValue());
        }
        if (inputNum <= 0) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_INTEGER_EXCEPTION_MESSAGE.getValue());
        }
    }
}
