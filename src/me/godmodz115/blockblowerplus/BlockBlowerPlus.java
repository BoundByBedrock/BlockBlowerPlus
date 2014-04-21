package me.godmodz115.blockblowerplus;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.FallingBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public class BlockBlowerPlus
    extends JavaPlugin
    implements Listener
{

    public void onEnable()
    {
        getServer().getPluginManager().registerEvents( this, this );
        getLogger().info( "Enabled!" );
    }

    public void onDisable()
    {
        saveConfig();
        getLogger().info( "Disabled!" );
    }

    @EventHandler( priority = EventPriority.LOWEST )
    public void onEntityExplode( EntityExplodeEvent event )
    {
        for ( Block b : event.blockList() )
        {
            float x = (float) -0.2 + (float) ( Math.random() * ( ( 0.2 - -0.2 ) + 1 ) );
            float y = (float) -1 + (float) ( Math.random() * ( ( 1 - -1 ) + 1 ) );
            float z = (float) -0.2 + (float) ( Math.random() * ( ( 0.2 - -0.2 ) + 1 ) );

            FallingBlock fallingBlock = b.getWorld().spawnFallingBlock( b.getLocation(), b.getType(), b.getData() );
            fallingBlock.setDropItem( false );
            fallingBlock.setVelocity( new Vector( x, y, z ) );

            b.setType( Material.AIR );

        }
    }
}