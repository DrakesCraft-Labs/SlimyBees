package cz.martinbrom.slimybees;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import com.github.drakescraft_labs.slimefun4.api.recipes.RecipeType;
import com.github.drakescraft_labs.slimefun4.libraries.dough.items.CustomItemStack;

/**
 * This class holds a static reference to every {@link RecipeType} found in SlimyBees.
 */
public class RecipeTypes {

    // prevent instantiation
    private RecipeTypes() {}

    public static final RecipeType WILDERNESS = new RecipeType(
            SlimyBeesPlugin.getKey("wilderness"),
            new ItemStack(Material.SPRUCE_SAPLING));

    public static final RecipeType BREEDING = new RecipeType(
            SlimyBeesPlugin.getKey("breeding"),
            new CustomItemStack(Material.BEE_SPAWN_EGG,
                    "&creproducir",
                    "",
                    "&fen colmena",
                    "&fCría de dos especies específicas de abejas.",
                    "&fconseguir"));

    public static final RecipeType BEE_PRODUCT = new RecipeType(
            SlimyBeesPlugin.getKey("bee_product"),
            new CustomItemStack(Material.HONEYCOMB,
                    "&cproductos de abejas",
                    "",
                    "&fAbejas trabajando en colmena",
                    "&fproductos producidos"));

    public static final RecipeType SBEE_CENTRIFUGE = new RecipeType(
            SlimyBeesPlugin.getKey("sbee_centrifuge"),
            new CustomItemStack(Material.GRINDSTONE,
                    "&fcentrífugo",
                    "",
                    "&7Poner en centrífuga para obtener"));

}
