package com.sinndevelopment.pocketanvil.util;

import net.minecraft.server.v1_8_R2.BlockPosition;
import net.minecraft.server.v1_8_R2.ChatMessage;
import net.minecraft.server.v1_8_R2.ContainerAnvil;
import net.minecraft.server.v1_8_R2.EntityHuman;
import net.minecraft.server.v1_8_R2.EntityPlayer;
import net.minecraft.server.v1_8_R2.PacketPlayOutOpenWindow;

import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Anvil extends ContainerAnvil
{
    public Anvil(EntityHuman entityHuman)
    {
        super(entityHuman.inventory, entityHuman.world, new BlockPosition(0, 0, 0), entityHuman);
    }

    @Override
    public boolean a(EntityHuman entityHuman)
    {
        return true;
    }
    public static void OpenAnvil(final Player player)
    {
        EntityPlayer entityPlayer = ((CraftPlayer) player).getHandle();
        Anvil pocketAnvil = new Anvil(entityPlayer);
        int containerId = entityPlayer.nextContainerCounter();
        entityPlayer.playerConnection.sendPacket(new PacketPlayOutOpenWindow(containerId, "minecraft:anvil", new ChatMessage("Pocket Anvil", new Object[]{}), 0));
        entityPlayer.activeContainer = pocketAnvil;
        entityPlayer.activeContainer.windowId = containerId;
        entityPlayer.activeContainer.addSlotListener(entityPlayer);
        player.playSound(player.getLocation(), Sound.ANVIL_USE, 0.5f, 0.5f);
    }
}
