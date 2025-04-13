package com.mowitnow.domain.model;

import java.util.List;

public record LawnMowingConfig(Lawn lawn, List<Mower> mowers, List<String> instructions ){

    public LawnMowingConfig {
        assert(mowers.size() == instructions.size());
    }
}


