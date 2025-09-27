package ca.shuckle.block.entity;

import ca.shuckle.mixin.SignTypeAccessor;
import net.minecraft.block.SignBlock;
import net.minecraft.block.WoodType;
import net.minecraft.util.SignType;

public class ModSignTypes {
    public static final WoodType BAMBOO =
            SignTypeAccessor.registerNew(SignTypeAccessor.newSignType("bamboo"));
    public static final WoodType PALE_OAK =
            SignTypeAccessor.registerNew(SignTypeAccessor.newSignType("pale_oak"));
    public static final WoodType EBONY =
            SignTypeAccessor.registerNew(SignTypeAccessor.newSignType("ebony"));
    public static final WoodType INVIS =
            SignTypeAccessor.registerNew(SignTypeAccessor.newSignType("invisible"));
}
