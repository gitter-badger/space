package com.space.server.engine.api;

import com.space.server.core.World;
import com.space.server.domain.api.Item;

import java.util.List;

/**
 * interface for worldEvent to transport event information into the game world.
 * Created by superernie77 on 01.12.2016.
 */
public interface WorldEvent {

    int getWorldId();

    void setWorldId(int worldId);

    int getPlayerId();

    void setPlayerId(int playerId);

    WorldEventType getType();

    void setType(WorldEventType type);

    World getWorld();

    void setWorld(World world);

    void setInventory(List<Item> items);

    List<Item> getInventory();

}
