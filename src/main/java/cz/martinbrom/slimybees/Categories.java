package cz.martinbrom.slimybees;

import org.bukkit.Material;

import com.github.drakescraft_labs.slimefun4.api.items.ItemGroup;
import com.github.drakescraft_labs.slimefun4.libraries.dough.items.CustomItemStack;

/**
 * This class holds a static reference to every {@link ItemGroup} found in SlimyBees.
 */
public class Categories {

    // prevent instantiation
    private Categories() {}

    public static final ItemGroup ITEMS = new ItemGroup(
            SlimyBeesPlugin.getKey("slimybees_items"),
            new CustomItemStack(Material.HONEYCOMB, "Abeja forestal"));

}
