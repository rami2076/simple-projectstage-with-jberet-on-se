package org.nyx.simple.jbatch.on.javase.use.spi;

import org.apache.deltaspike.core.api.projectstage.ProjectStage;
import org.apache.deltaspike.core.api.projectstage.ProjectStageHolder;

public class CustomProjectStageHolder implements ProjectStageHolder {

    public static final class CustomProjectStage extends ProjectStage {
        private static final long serialVersionUID = 1029094387976167179L;
    }

    public static final CustomProjectStage CustomProjectStage = new CustomProjectStage();

}
