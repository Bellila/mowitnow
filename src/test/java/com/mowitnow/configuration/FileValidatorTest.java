package com.mowitnow.configuration;

import com.mowitnow.configuration.exception.ExceptionConstants;
import com.mowitnow.configuration.exception.MowItNowException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

@DisplayName("File validator test")
class FileValidatorTest {

    @Test
    @DisplayName("Should be true")
    public void shouldBeTrue() throws IOException {
        Assertions.assertTrue(FileValidator.validate(Constants.PATH + "File"));
    }

    @Test
    @DisplayName("Should be false ")
    public void shouldBeFalse() throws IOException {
        Assertions.assertFalse(FileValidator.validate(Constants.PATH + "WrongFile"));
    }

    @Test
    @DisplayName("Should be true because the file is empty")
    public void shouldFailBecauseEmptyFile() {
        Exception exception = Assertions.assertThrows(MowItNowException.class, () -> {
            FileValidator.validate(Constants.PATH + "EmptyFile");
        });
        Assertions.assertTrue(exception.getMessage().contains(ExceptionConstants.EMPTY_FILE));
    }

    @Test
    @DisplayName("Should be true because the file is non existent")
    public void shouldFailBecauseFileNonExistent() {
        Exception exception = Assertions.assertThrows(MowItNowException.class, () -> {
            FileValidator.validate(Constants.PATH + "FILE_NON_EXISTENT");
        });
        Assertions.assertTrue(exception.getMessage().contains(ExceptionConstants.FILE_NOT_EXIST));
    }
}
