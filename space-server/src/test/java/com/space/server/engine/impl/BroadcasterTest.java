package com.space.server.engine.impl;

import static org.mockito.Mockito.*;

import com.space.server.domain.api.Segment;
import com.space.server.domain.api.SpaceWorld;
import com.space.server.domain.impl.SimpleWorldImpl;
import com.space.server.engine.api.GameEngine;
import com.space.server.engine.api.WorldEvent;
import com.space.server.engine.api.WorldEventType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created by superernie77 on 10.02.2017.
 */
public class BroadcasterTest {

    private Broadcaster broadcaster;

    GameEngine engine;

    @Before
    public void setup(){
        broadcaster = new Broadcaster();

        engine = Mockito.mock(GameEngine.class);

        broadcaster.setEngine(engine);

        broadcaster.setPlayerId(1);

        broadcaster.setWorldId(0);

    }

    @Test
    public void testBroadCaster(){

        Assert.assertTrue(broadcaster.getPlayerId() == 1);

        Assert.assertTrue(broadcaster.getWorldId() == 0);

        Assert.assertTrue(broadcaster.getEngine() != null);
    }

    @Test
    public void testCreateWorldEvent(){

        SpaceWorld world = mock(SpaceWorld.class);

        when(world.getSegment(0)).thenReturn(mock(Segment.class));

        when(engine.getWorld(anyInt())).thenReturn(world);

        WorldEvent event = broadcaster.createWorldEvent();

        Assert.assertNotNull(event);

        Assert.assertTrue(event.getPlayerId() == 1);
        Assert.assertTrue(event.getWorldId() == 0);
        Assert.assertTrue(event.getWorld() != null);
        Assert.assertTrue(event.getType() == WorldEventType.UPDATE);

    }


}
