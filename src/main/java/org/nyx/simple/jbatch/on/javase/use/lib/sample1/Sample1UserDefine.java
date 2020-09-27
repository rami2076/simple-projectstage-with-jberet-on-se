package org.nyx.simple.jbatch.on.javase.use.lib.sample1;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import org.apache.deltaspike.core.api.exclude.Exclude;
import org.apache.deltaspike.core.api.projectstage.ProjectStage;
import org.nyx.simple.jbatch.on.javase.use.lib.common.interceptor.ServiceOperation;
import org.nyx.simple.jbatch.on.javase.use.spi.CustomProjectStageHolder;

/**
 *
 * @author nyx
 */
@Exclude(exceptIfProjectStage = {
    CustomProjectStageHolder.CustomProjectStage.class,})
@RequestScoped
public class Sample1UserDefine extends Sample1Service {

    @Inject
    private ProjectStage projectStage;

    /**
     * UnitTestか判定
     *
     * @return UnitTestの場合trueを返却
     */
    @Override
    @ServiceOperation
    public boolean isUnitTest() {
        System.out.println("#Stage_CUSTOM#" + projectStage.toString());
        return projectStage.equals(CustomProjectStageHolder.CustomProjectStage);
    }

}
