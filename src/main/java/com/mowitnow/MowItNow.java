package com.mowitnow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mowitnow.domain.usecases.MowingService;
import com.mowitnow.infrastructure.adapters.input.FileInputParser;

public class MowItNow {

    private static final Logger log = LoggerFactory.getLogger(MowItNow.class);

    public static void main(String[] args) {

        String filePath;

        if (args.length > 0) {
            filePath = args[0]; // paramètre CLI
            log.info("Fichier passé en argument : {}", filePath);
        } else {
            // fallback : fichier par défaut dans les ressources
            filePath = "src/main/resources/mowing_input.txt";
            log.info("Aucun fichier spécifié, utilisation du fichier par défaut : {}", filePath);
        }

        var parser = new FileInputParser(filePath);

        var mowingService = new MowingService();
        mowingService.mowing(parser.parseConfig());
    }
}
