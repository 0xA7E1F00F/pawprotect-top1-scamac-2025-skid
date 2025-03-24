package ac.grim.grimac.checks.impl.aim;

import ac.grim.grimac.checks.Check;
import ac.grim.grimac.checks.CheckData;
import ac.grim.grimac.checks.type.RotationCheck;
import ac.grim.grimac.player.GrimPlayer;
import ac.grim.grimac.utils.anticheat.update.RotationUpdate;

@CheckData(name = "Aim")
public class Aim extends Check implements RotationCheck {
    public float denis;

    //im a dumb skid kid who renamed alerts to pawprotect but grimplayer couldnt
    public Aim(GrimPlayer player) {
        super(player);
    }

    @Override
    public void process(final RotationUpdate rotationUpdate) {
        if (player.actionManager.isAttacking()) {
            if (Math.abs(denis) > 30 && (denis > 0) ^ (rotationUpdate.getDeltaXRot() > 0)) {
                flagAndAlert();
            }
        } else {
            denis = rotationUpdate.getDeltaXRot();
        }
    }
}
