package ca.shuckle.util;

import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class RaycastContextUtil {
    private static final Unsafe UNSAFE;

    static {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            UNSAFE = (Unsafe) f.get(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static RaycastContext shapeContextRaycast(
            Vec3d start,
            Vec3d end,
            RaycastContext.ShapeType shapeType,
            RaycastContext.FluidHandling fluidHandling,
            ShapeContext shapeContext) {
        try {
            RaycastContext ctx = (RaycastContext) UNSAFE.allocateInstance(RaycastContext.class);
            setField(ctx, "start", start);
            setField(ctx, "end", end);
            setField(ctx, "shapeType", shapeType);
            setField(ctx, "fluid", fluidHandling);
            setField(ctx, "entityPosition", shapeContext);
            return ctx;
        } catch (Exception e) {
            throw new RuntimeException("Failed to set entityPosition on RaycastContext", e);
        }
    }

    private static void setField(Object obj, String name, Object value) throws NoSuchFieldException, IllegalAccessException {
        Field field = RaycastContext.class.getDeclaredField(name);
        field.setAccessible(true);
        field.set(obj, value);
    }
}
