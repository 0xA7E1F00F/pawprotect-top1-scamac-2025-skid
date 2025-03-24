package ac.grim.grimac.checks.impl.aim;

import ac.grim.grimac.checks.Check;
import ac.grim.grimac.checks.CheckData;
import ac.grim.grimac.checks.type.RotationCheck;
import ac.grim.grimac.player.GrimPlayer;
import ac.grim.grimac.utils.anticheat.update.RotationUpdate;

@CheckData(name = "AimSosal")
public class AimSosal extends Check implements RotationCheck {
    private float lastDenisMatematikaBruteforceResultCompared;

    public AimSosal(GrimPlayer player) {
        super(player);
    }

    @Override
    public void process(final RotationUpdate rotationUpdate) {
        final float pitchDelta = rotationUpdate.getDeltaYRot();

        if (player.actionManager.isAttacking()) {
            if (pitchDelta == lastDenisMatematikaBruteforceResultCompared) {
                alert("sosal=?UNKNOWN_SYMBOLUNKNOWN_SYMBOLUNKNOWN_SYMBOLUNKNOWN_SYMBOL");
            } else {
                lastDenisMatematikaBruteforceResultCompared = Math.round(pitchDelta);
                reward(); //wtf
            }
        } else {
            lastDenisMatematikaBruteforceResultCompared = Math.round(pitchDelta);
            reward(); //wtf
        }
    }
}
