package ca.shuckle.block.custom;

import net.minecraft.block.LichenGrower;
import net.minecraft.block.MultifaceGrowthBlock;

public class ResinBlock extends MultifaceGrowthBlock {

    public ResinBlock(Settings settings) {
        super(settings);
    }

    @Override
    public LichenGrower getGrower() {
        return null;
    }
}
