package ca.shuckle.block.entity;

import ca.shuckle.mixin.SignTypeAccessor;
import net.minecraft.util.SignType;

public class ModSignTypes {
    public static final SignType MANGROVE =
            SignTypeAccessor.registerNew(SignTypeAccessor.newSignType("mangrove"));
    public static final SignType BAMBOO =
            SignTypeAccessor.registerNew(SignTypeAccessor.newSignType("bamboo"));
    public static final SignType CHERRY =
            SignTypeAccessor.registerNew(SignTypeAccessor.newSignType("cherry"));
    public static final SignType PALE_OAK =
            SignTypeAccessor.registerNew(SignTypeAccessor.newSignType("pale_oak"));
    public static final SignType EBONY =
            SignTypeAccessor.registerNew(SignTypeAccessor.newSignType("ebony"));
    public static final SignType INVIS =
            SignTypeAccessor.registerNew(SignTypeAccessor.newSignType("invisible"));
}
