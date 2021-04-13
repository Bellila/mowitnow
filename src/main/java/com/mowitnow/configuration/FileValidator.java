package com.mowitnow.configuration;

import com.mowitnow.configuration.exception.ExceptionConstants;
import com.mowitnow.configuration.exception.MowItNowException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileValidator {

    public static boolean validate(String path) {
        Pattern pattern = Pattern.compile(Constants.FILE_CONTENT_REGEX);
        Matcher matcher = pattern.matcher(extractContent(path));
        return matcher.matches();
    }

    private static String extractContent(String path) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(path)));
            if (content.equals("")) {
                throw new MowItNowException(ExceptionConstants.EMPTY_FILE);
            }
            return content;
        } catch (NoSuchFileException e) {
            throw new MowItNowException(ExceptionConstants.FILE_NOT_EXIST);
        } catch (IOException e) {
            throw new MowItNowException(e.getMessage());
        }
    }
}
