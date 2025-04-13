package com.mowitnow.infrastructure.adapters.input;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.mowitnow.domain.port.InputParser;

class FileInputParserTest {

    @Test
    void shouldParseValidInputFileFromResources() {

        InputParser fip = new FileInputParser("src/test/resources/input.txt");
        var config = fip.parseConfig();

        assertNotNull(config);
        assertEquals(2, config.mowers().size());
        assertEquals(2, config.instructions().size());
        assertNotNull(config.lawn());
        assertEquals(5, config.lawn().getMaxX());
        assertEquals(5, config.lawn().getMaxY());

    }
}
