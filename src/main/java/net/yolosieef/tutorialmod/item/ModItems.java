package net.yolosieef.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.yolosieef.tutorialmod.TutorialMod;
import net.yolosieef.tutorialmod.item.custom.BeerItem;
import net.yolosieef.tutorialmod.item.custom.ChiselItem;
import net.yolosieef.tutorialmod.item.custom.WineItem;

import java.util.List;

public class ModItems {
    public static final Item PINK_GARNET = registerItem("pink_garnet", new Item(new Item.Settings()));  //name: all small letters and underscores allowed
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet", new Item(new Item.Settings()));

    public static final Item CHISEL = registerItem("chisel", new ChiselItem(new Item.Settings().maxDamage(32)));

    public static final Item CAULIFLOWER = registerItem("cauliflower", new Item(new Item.Settings().food(ModFoodComponents.CAULIFLOWER)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            if (Screen.hasShiftDown()) {
                tooltip.add(Text.translatable("tooltip.cauliflower.shift_down"));
            } else {
                tooltip.add(Text.translatable("tooltip.cauliflower"));
            }

            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item BEER = registerItem("beer", new BeerItem(new Item.Settings().food(ModFoodComponents.BEER)));
    public static final Item WINE = registerItem("wine", new WineItem(new Item.Settings().food(ModFoodComponents.WINE)));

    public static final Item STARLIGHT_ASHES = registerItem("starlight_ashes", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TutorialMod.LOGGER.info("Registering Mod Items for " + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(PINK_GARNET);
            fabricItemGroupEntries.add(RAW_PINK_GARNET);
            fabricItemGroupEntries.add(CHISEL);
            fabricItemGroupEntries.add(CAULIFLOWER);
            fabricItemGroupEntries.add(BEER);
            fabricItemGroupEntries.add(WINE);
            fabricItemGroupEntries.add(STARLIGHT_ASHES);
        });
    }
}
