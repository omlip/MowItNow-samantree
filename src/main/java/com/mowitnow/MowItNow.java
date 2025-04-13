package com.mowitnow;

import com.mowitnow.domain.usecases.MowingService;
import com.mowitnow.infrastructure.adapters.input.FileInputParser;

public class MowItNow {

    public static void main(String[] args) {

        var parser = new FileInputParser("src/main/resources/mowing_input.txt");

        var mowingService = new MowingService();
        mowingService.mowing(parser.parseConfig());
    }
}
