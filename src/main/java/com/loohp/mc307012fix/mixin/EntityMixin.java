package com.loohp.mc307012fix.mixin;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Avatar;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.scores.DisplaySlot;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.scores.Scoreboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@SuppressWarnings("resource")
@Mixin(Entity.class)
public class EntityMixin {

    @Inject(at = @At("HEAD"), method = "belowNameDisplay", cancellable = true)
    public void belowNameDisplay(CallbackInfoReturnable<Component> ci) {
        Entity self = (Entity) (Object) this;
        if (self instanceof Avatar) {
            return;
        }
        Scoreboard scoreboard = self.level().getScoreboard();
        Objective objective = scoreboard.getDisplayObjective(DisplaySlot.BELOW_NAME);
        if (objective != null && scoreboard.getPlayerScoreInfo(self, objective) == null) {
            ci.setReturnValue(null);
            ci.cancel();
        }
    }

}
