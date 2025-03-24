package ac.grim.grimac.checks.impl.aim;

import ac.grim.grimac.checks.Check;
import ac.grim.grimac.checks.CheckData;
import ac.grim.grimac.checks.type.RotationCheck;
import ac.grim.grimac.player.GrimPlayer;
import ac.grim.grimac.utils.anticheat.update.RotationUpdate;

@CheckData(name = "AimThunderHackBruteforceInterpolation")
public class AimThunderHackBruteforceInterpolation extends Check implements RotationCheck {

    private float denismatematikaconstant1;
    private float denismatematikaconstant2 = 10F;

    public AimThunderHackBruteforceInterpolation(GrimPlayer playerData) {
        super(playerData);
    }

    @Override
    public void process(final RotationUpdate rotationUpdate) {
        if (player.actionManager.isAttacking()) {
            if (rotationUpdate.getDeltaYRotABS() < 10F && denismatematikaconstant1 > 25F && denismatematikaconstant2 < 10F) {
              flagAndAlert();
            }

            denismatematikaconstant2 = denismatematikaconstant1;
        } else {
            denismatematikaconstant1 = rotationUpdate.getDeltaYRotABS();
        }
    }
}
