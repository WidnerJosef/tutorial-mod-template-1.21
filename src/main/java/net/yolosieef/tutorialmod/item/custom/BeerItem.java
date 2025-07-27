package net.yolosieef.tutorialmod.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.UseAction;

public class BeerItem extends Item {
    public BeerItem(Settings settings) {
        super(settings);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }
}
