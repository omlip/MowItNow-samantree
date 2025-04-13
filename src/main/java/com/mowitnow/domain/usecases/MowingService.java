package com.mowitnow.domain.usecases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mowitnow.domain.model.LawnMowingConfig;
import com.mowitnow.domain.model.Mower;
import com.mowitnow.domain.model.exception.InvalidMowingConfigurationException;

public class MowingService {

    private final static Logger logger = LoggerFactory.getLogger(MowingService.class);

    public void mowing(LawnMowingConfig config) {

        if(config == null) {
            throw new InvalidMowingConfigurationException("Configuration is null");
        }

        var mowers = config.mowers();
        var instructions = config.instructions();

        int i = 0;
        while (i < mowers.size()) {
            Mower mower = mowers.get(i);
            String instruction = instructions.get(i);
            mower.mowing(instruction, config.lawn());

            i++;

            logger.info(mower.getPosition().toString());
        }

    }

}
