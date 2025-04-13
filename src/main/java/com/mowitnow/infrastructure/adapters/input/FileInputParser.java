package com.mowitnow.infrastructure.adapters.input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.mowitnow.domain.model.Lawn;
import com.mowitnow.domain.model.LawnMowingConfig;
import com.mowitnow.domain.model.Mower;
import com.mowitnow.domain.model.Orientation;
import com.mowitnow.domain.port.InputParser;

public class FileInputParser implements InputParser {

    private final String inputFile;

    public FileInputParser(String inputFile) {
        assert(inputFile != null && !inputFile.isEmpty());
        this.inputFile = inputFile;
    }

    @Override
    public LawnMowingConfig parseConfig() {

        //TODO We should add a file validation to be more defensive/secure

        try {
            List<String> lines = Files.readAllLines(Path.of(inputFile));

            String[] lawnCoords = lines.getFirst().trim().split(" ");
            if (lawnCoords.length != 2) throw new IllegalArgumentException("Invalid lawn coordinates");

            int maxX = Integer.parseInt(lawnCoords[0]);
            int maxY = Integer.parseInt(lawnCoords[1]);
            Lawn lawn = new Lawn(maxX, maxY);

            List<Mower> mowers = new ArrayList<>();
            List<String> instructions = new ArrayList<>();

            for (int i = 1; i < lines.size(); i += 2) {
                if (i + 1 >= lines.size()) throw new IllegalArgumentException("Missing instruction line for mower");

                String[] posParts = lines.get(i).trim().split(" ");
                if (posParts.length != 3) throw new IllegalArgumentException("Invalid mower position");

                int x = Integer.parseInt(posParts[0]);
                int y = Integer.parseInt(posParts[1]);
                Orientation orientation = Orientation.valueOf(posParts[2]);

                Mower mower = new Mower(x, y, orientation);
                mowers.add(mower);

                instructions.add(lines.get(i + 1).trim());
            }

            return new LawnMowingConfig(lawn, mowers, instructions);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
