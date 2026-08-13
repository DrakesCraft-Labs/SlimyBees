package cz.martinbrom.slimybees.items.machines;

import javax.annotation.Nullable;

import org.bukkit.inventory.ItemStack;

import com.github.drakescraft_labs.slimefun4.api.items.ItemGroup;
import com.github.drakescraft_labs.slimefun4.api.items.SlimefunItemStack;
import com.github.drakescraft_labs.slimefun4.api.recipes.RecipeType;
import com.github.drakescraft_labs.slimefun4.implementation.items.blocks.UnplaceableBlock;

public class HiveFrame extends UnplaceableBlock {

    public static final int DEFAULT_PRODUCTION_MODIFIER = 1;
    public static final int DEFAULT_LIFESPAN_MODIFIER = 1;

    public HiveFrame(ItemGroup category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }

    public HiveFrame(ItemGroup category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, @Nullable ItemStack recipeOutput) {
        super(category, item, recipeType, recipe, recipeOutput);
    }

    public double getProductionModifier() {
        return DEFAULT_PRODUCTION_MODIFIER;
    }

    public double getLifespanModifier() {
        return DEFAULT_LIFESPAN_MODIFIER;
    }

}
