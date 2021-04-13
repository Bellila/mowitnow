package com.mowitnow;

import com.mowitnow.configuration.Constants;
import com.mowitnow.configuration.FileParser;
import com.mowitnow.configuration.FileValidator;
import com.mowitnow.configuration.Principal;
import com.mowitnow.configuration.exception.ExceptionConstants;
import com.mowitnow.configuration.exception.MowItNowException;
import com.mowitnow.domain.FileContent;

public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            throw new MowItNowException(ExceptionConstants.MISSING_ARGUMENT);
        }
        if (!FileValidator.validate(Constants.PATH + args[0])) {
            throw new MowItNowException(ExceptionConstants.INVALID_FILE);
        } else {
            FileContent fileContent = FileParser.parseFileContent(Constants.PATH + args[0]);
            Principal principal = new Principal();
            principal.run(fileContent);
        }
    }
}
