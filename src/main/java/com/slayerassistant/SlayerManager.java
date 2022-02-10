package com.slayerassistant;

import com.slayerassistant.data.SlayerDataLoader;
import com.slayerassistant.domain.SlayerTask;

import java.util.*;
import java.util.stream.Collectors;

public class SlayerManager
{
    private final Collection<SlayerTask> slayerTasks;

    public SlayerManager(SlayerDataLoader dataLoader)
    {
        slayerTasks = dataLoader.load();
    }

    public Collection<SlayerTask> getSlayerTasksByPartialName(String monster)
    {
        return slayerTasks.stream()
                          .filter(slayerTask -> slayerTask.monster.contains(monster))
                          .collect(Collectors.toCollection(ArrayList::new));
    }

    public SlayerTask getSlayerTaskByName(String monster)
    {
        return slayerTasks.stream()
                          .filter(slayerTask -> Objects.equals(slayerTask.monster, monster))
                          .findFirst()
                          .orElse(null);
    }
}
