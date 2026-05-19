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

            Field[] fields = RaycastContext.class.getDeclaredFields();
            Field startField = null, endField = null, shapeTypeField = null,
                    fluidField = null, shapeContextField = null;

            for (Field field : fields) {
                field.setAccessible(true);
                Class<?> type = field.getType();
                if (type == Vec3d.class) {
                    if (startField == null) {
                        startField = field;
                    } else { endField = field; }
                } else if (type == RaycastContext.ShapeType.class) {
                    shapeTypeField = field;
                } else if (type == RaycastContext.FluidHandling.class) {
                    fluidField = field;
                } else if (type == ShapeContext.class) {
                    shapeContextField = field;
                }
            }

            startField.set(ctx, start);
            endField.set(ctx, end);
            shapeTypeField.set(ctx, shapeType);
            fluidField.set(ctx, fluidHandling);
            shapeContextField.set(ctx, shapeContext);

            return ctx;
        } catch (Exception e) {
            throw new RuntimeException("Failed to override RaycastContext", e);
        }
    }

    private static void setField(Object obj, String name, Object value) throws NoSuchFieldException, IllegalAccessException {
        Field field = RaycastContext.class.getDeclaredField(name);
        field.setAccessible(true);
        field.set(obj, value);
    }
}
