package com.anantaya.smartcgolem.mixin;

import com.anantaya.smartcgolem.ai.SmartCopperGolemAi;
import net.minecraft.world.entity.ai.ActivityData;
import net.minecraft.world.entity.animal.golem.CopperGolem;
import net.minecraft.world.entity.animal.golem.CopperGolemAi;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.List;

@Mixin(CopperGolemAi.class)
public class CopperGolemAiMixin {

    /**
     * @author SmartGolem
     * @reason Replace vanilla activities
     */
    @Overwrite
    public static List<ActivityData<CopperGolem>> getActivities() {

        System.out.println("SMART GOLEM MIXIN ACTIVE");

        return SmartCopperGolemAi.getActivities();
    }

    /**
     * @author SmartGolem
     * @reason Replace vanilla activity updater
     */
    @Overwrite
    public static void updateActivity(CopperGolem body) {

        //System.out.println("SMART UPDATE ACTIVITY");

        SmartCopperGolemAi.updateActivity(body);
    }
}