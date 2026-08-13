package cz.martinbrom.slimybees;

import javax.annotation.Nonnull;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import cz.martinbrom.slimybees.utils.SlimyBeesHeadTexture;
import com.github.drakescraft_labs.slimefun4.api.items.SlimefunItemStack;
import com.github.drakescraft_labs.slimefun4.core.attributes.MachineTier;
import com.github.drakescraft_labs.slimefun4.core.attributes.MachineType;
import com.github.drakescraft_labs.slimefun4.libraries.dough.items.CustomItemStack;
import com.github.drakescraft_labs.slimefun4.utils.LoreBuilder;

/**
 * This class holds a static reference to every {@link SlimefunItemStack} found in SlimyBees.
 */
public class ItemStacks {

    // prevent instantiation
    private ItemStacks() {}

    // <editor-fold desc="Bee Products" defaultstate="collapsed">
    public static final SlimefunItemStack BEESWAX = new SlimefunItemStack(
            "BEESWAX",
            Material.GLOWSTONE_DUST,
            "&eaceite de cera de abejas");
    public static final SlimefunItemStack HONEY_DROP = new SlimefunItemStack(
            "HONEY_DROP",
            Material.GOLD_NUGGET,
            "&6legado de abeja");

    public static final SlimefunItemStack HONEY_COMB = createHoneycomb("HONEY", "&6Miel");
    public static final SlimefunItemStack DRY_COMB = createHoneycomb("DRY", "&eSeco");
    public static final SlimefunItemStack SWEET_COMB = createHoneycomb("SWEET", "&fdulce");
    // </editor-fold>

    // <editor-fold desc="Specialty Products" defaultstate="collapsed">
    // TODO: 03.06.21 Prevent coloring
    public static final SlimefunItemStack ROYAL_JELLY = new SlimefunItemStack(
            "ROYAL_JELLY",
            Material.LIGHT_GRAY_DYE,
            "&6&ljalea real",
            meta -> meta.addItemFlags(ItemFlag.HIDE_ENCHANTS));
    // TODO: 03.06.21 Prevent placing
    public static final SlimefunItemStack POLLEN = new SlimefunItemStack(
            "POLLEN",
            Material.PUMPKIN_SEEDS,
            "&6&lpolen",
            meta -> meta.addItemFlags(ItemFlag.HIDE_ENCHANTS));

    static {
        ROYAL_JELLY.addUnsafeEnchantment(Enchantment.MENDING, 1);
        POLLEN.addUnsafeEnchantment(Enchantment.MENDING, 1);
    }
    // </editor-fold>

    // <editor-fold desc="Frames" defaultstate="collapsed">
    public static final SlimefunItemStack BASIC_FRAME = new SlimefunItemStack(
            "BASIC_FRAME",
            Material.BIRCH_SIGN,
            "&fmarco básico",
            "",
            loreProductionModifier(1.25));

    // TODO: 01.07.21 Better name
    public static final SlimefunItemStack ADVANCED_FRAME = new SlimefunItemStack(
            "ADVANCED_FRAME",
            Material.BIRCH_SIGN,
            "&fMarco avanzado",
            "",
            loreProductionModifier(2));

    public static final SlimefunItemStack SWEET_FRAME = new SlimefunItemStack(
            "SWEET_FRAME",
            Material.DARK_OAK_SIGN,
            "&4dulce marco",
            "",
            loreLifespanModifier(0.5));

    public static final SlimefunItemStack DEADLY_FRAME = new SlimefunItemStack(
            "DEADLY_FRAME",
            Material.DARK_OAK_SIGN,
            "&4marco fatal",
            "",
            loreLifespanModifier(0.1));
    // </editor-fold>

    // <editor-fold desc="Machines" defaultstate="collapsed">
    public static final SlimefunItemStack HIVE_CASING_PLANK = new SlimefunItemStack(
            "HIVE_CASING_PLANK",
            Material.SPRUCE_SLAB,
            "&6panel de nido de abeja",
            "",
            "&fSe puede formar en bloques de colmena.");

    public static final SlimefunItemStack HIVE_CASING = new SlimefunItemStack(
            "HIVE_CASING",
            Material.SPRUCE_PLANKS,
            "&6cáscara de panal",
            "",
            "&fUn componente importante de una colmena.",
            "&fPara colmenas de grado industrial");

    public static final SlimefunItemStack BEE_HIVE = new SlimefunItemStack(
            "BEE_HIVE",
            Material.OAK_PLANKS,
            "&6colmena basica",
            "",
            "&fDale a tus abejas un hogar sencillo",
            "&fRequiere operación manual!",
            "",
            getTieredHiveString(MachineTier.BASIC));

    public static final SlimefunItemStack AUTO_BEE_HIVE = new SlimefunItemStack(
            "AUTO_BEE_HIVE",
            Material.STRIPPED_OAK_LOG,
            "&6Colmena completamente automática",
            "",
            "&fUna colmena automatizada",
            "&fColoque el zángano y las abejas hembra en la ranura de entrada.",
            "&fpuede reproducirse automáticamente",
            "",
            getTieredHiveString(MachineTier.GOOD));

    public static final SlimefunItemStack INDUSTRIAL_BEE_HIVE = new SlimefunItemStack(
            "INDUSTRIAL_BEE_HIVE",
            Material.STRIPPED_CRIMSON_STEM,
            "&6&lcolmena industrial",
            "",
            "&fUna colmena de primer nivel",
            "&feste tipo de colmena",
            "&fEficiencia de producción muy mejorada",
            "",
            getTieredHiveString(MachineTier.END_GAME));

    @Nonnull
    private static String getTieredHiveString(MachineTier basic) {
        return basic + " Hive";
    }

    public static final String EXTRACTS_MATERIALS_FROM_COMBS = "&fExtracts materials from combs";
    public static final SlimefunItemStack SBEE_CENTRIFUGE = new SlimefunItemStack(
            "SBEE_CENTRIFUGE",
            Material.GRINDSTONE,
            "&7centrífugo",
            "",
            EXTRACTS_MATERIALS_FROM_COMBS);

    public static final SlimefunItemStack ELECTRIC_CENTRIFUGE = new SlimefunItemStack(
            "ELECTRIC_CENTRIFUGE",
            Material.IRON_BLOCK,
            "&7Centrífuga eléctrica &eI",
            "",
            EXTRACTS_MATERIALS_FROM_COMBS,
            "",
            LoreBuilder.machine(MachineTier.BASIC, MachineType.MACHINE),
            LoreBuilder.speed(1),
            LoreBuilder.powerPerSecond(12));

    public static final SlimefunItemStack ELECTRIC_CENTRIFUGE_2 = new SlimefunItemStack(
            "ELECTRIC_CENTRIFUGE_2",
            Material.IRON_BLOCK,
            "&7Centrífuga eléctrica &eII",
            "",
            EXTRACTS_MATERIALS_FROM_COMBS,
            "",
            LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
            LoreBuilder.speed(4),
            LoreBuilder.powerPerSecond(36));
    // </editor-fold>

    // <editor-fold desc="Various" defaultstate="collapsed">
    public static final SlimefunItemStack BEEALYZER = new SlimefunItemStack(
            "BEEALYZER",
            Material.ITEM_FRAME,
            "&7analizador de abejas",
            "",
            LoreBuilder.powerCharged(0, 50),
            "",
            "&fLa herramienta más confiable del apicultor",
            "&fEste elemento se utiliza para identificar varios",
            "&fCaracterísticas de las abejas",
            "",
            LoreBuilder.RIGHT_CLICK_TO_USE);

    public static final SlimefunItemStack TOME_OF_DISCOVERY_SHARING = new SlimefunItemStack(
            "TOME_OF_DISCOVERY_SHARING",
            Material.ENCHANTED_BOOK,
            "&6Un tomo sobre el conocimiento de las abejas.",
            loreOwner("None"),
            "",
            "&eclic derecho&7 Vincula tu investigación sobre abejas",
            "",
            "&eclic derecho&7 Obtenga todas las investigaciones del Binder");

    public static final CustomItemStack CONSULT_BEE_ATLAS_RECIPE_ITEM = new CustomItemStack(
            Material.ENCHANTED_BOOK,
            ChatColor.WHITE + "Libro ilustrado de abejas",
            "",
            ChatColor.GRAY + "Consulte la guía ilustrada de abejas owiki",
            ChatColor.GRAY + "para información más relevante");

    public static final ItemStack[] CONSULT_BEE_ATLAS_RECIPE = new ItemStack[] {
            null, null, null,
            null, ItemStacks.CONSULT_BEE_ATLAS_RECIPE_ITEM, null,
            null, null, null };

    public static final CustomItemStack CENTRIFUGE_COMB_RECIPE_ITEM = new CustomItemStack(
            Material.HONEYCOMB,
            ChatColor.YELLOW + "cera de abejas opcional",
            "",
            ChatColor.GRAY + "Por favor, ponga cera de abejas en la centrífuga.");

    public static final ItemStack[] CENTRIFUGE_COMB_RECIPE = new ItemStack[] {
            null, null, null,
            null, ItemStacks.CENTRIFUGE_COMB_RECIPE_ITEM, null,
            null, null, null };

    public static final SlimefunItemStack BEE_BREEDING_STACK = new SlimefunItemStack(
            "_RECIPE_BEE",
            SlimyBeesHeadTexture.PRINCESS.getAsItemStack(),
            "&ecualquier dron+abeja hembra");
    public static final SlimefunItemStack BEE_OFFSPRING_STACK = new SlimefunItemStack(
            "_RECIPE_BEE_OFFSPRING",
            Material.HONEYCOMB,
            "&6crías de abejas");
    public static final SlimefunItemStack BEE_PRODUCT_STACK = new SlimefunItemStack(
            "_RECIPE_BEE_PRODUCT",
            Material.HONEYCOMB,
            "&6productos de abejas");
    // </editor-fold>

    public static SlimefunItemStack createDrone(String id, String name, boolean enchanted, String... lore) {
        return createBee(
                id + "_DRONE",
                SlimyBeesHeadTexture.DRONE.getAsItemStack(),
                name + "Zumbido",
                enchanted,
                lore);
    }

    public static SlimefunItemStack createPrincess(String id, String name, boolean enchanted, String... lore) {
        return createBee(id + "_PRINCESS",
                SlimyBeesHeadTexture.PRINCESS.getAsItemStack(),
                name + "abeja hembra",
                enchanted,
                lore);
    }

    private static SlimefunItemStack createBee(String id, ItemStack itemStack, String name, boolean enchanted, String... lore) {
        SlimefunItemStack item = new SlimefunItemStack(id, itemStack, name, lore);

        if (enchanted) {
            item.addUnsafeEnchantment(Enchantment.MENDING, 1);

            ItemMeta meta = item.getItemMeta();
            if (meta != null) {
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                item.setItemMeta(meta);
            }
        }

        return item;
    }

    public static SlimefunItemStack createHoneycomb(String id, String name) {
        return new SlimefunItemStack(
                id + "_COMB",
                Material.HONEYCOMB,
                name + "cera de abejas");
    }

    public static String loreProductionModifier(double ratio) {
        return "&7Producir: &8&lx" + String.format("%.1f", ratio);
    }

    public static String loreLifespanModifier(double ratio) {
        return "&7vida: &8&lx" + String.format("%.1f", ratio);
    }

    public static String loreOwner(String owner) {
        return "&7Dueño: &b" + owner;
    }

}
