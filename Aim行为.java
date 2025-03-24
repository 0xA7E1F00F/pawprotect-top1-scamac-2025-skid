package ac.grim.grimac.checks.impl.aim;

import ac.grim.grimac.checks.Check;
import ac.grim.grimac.checks.CheckData;
import ac.grim.grimac.checks.type.RotationCheck;
import ac.grim.grimac.player.GrimPlayer;
import ac.grim.grimac.utils.anticheat.update.RotationUpdate;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

@CheckData(name = "Aim行为")
public class Aim行为 extends Check implements RotationCheck {
    private DescriptiveStatistics pitch = new DescriptiveStatistics(240);

    public Aim行为(GrimPlayer player) {
        super(player);
    }

    @Override
    public void process(final RotationUpdate rotationUpdate) {
        //ну тут как бы оно при заходе будет первые 80 пакетов логать но денису похуй ????
        if (player.totalFlyingPacketsSent <= 80) {
           pitch.addValue(rotationUpdate.getDeltaYRot());
        }

        if (pitch.getN() == 240) {
            if (pitch.getKurtosis() > 30 && pitch.getVariance() < 15) {
                flagAndAlert();
                pitch.clear();
            }
            // pitch.clear(); - по идее должно тут стоять но дениске похуй
        }
    }
}
