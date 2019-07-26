package org.fakester.designer;

import com.inductiveautomation.ignition.common.BundleUtil;
import com.inductiveautomation.ignition.common.licensing.LicenseState;
import com.inductiveautomation.ignition.common.util.LoggerEx;
import com.inductiveautomation.ignition.designer.model.AbstractDesignerModuleHook;
import com.inductiveautomation.ignition.designer.model.DesignerContext;
import com.inductiveautomation.perspective.designer.api.PerspectiveDesignerInterface;
import com.inductiveautomation.reporting.designer.api.DesignerDataSourceRegistry;
import org.fakester.common.component.display.Image;
import org.fakester.designer.reporting.RestJsonDataConfigPanel;

public class RadDesignerHook extends AbstractDesignerModuleHook {


    public RadDesignerHook() {
        LoggerEx.newBuilder().build("RadComponents").info("Registering Rad Components in Designer!");
    }


    @Override
    public void startup(DesignerContext context, LicenseState activationState) throws Exception {
        super.startup(context, activationState);

        /* add our bundle to centralize strings and allow i18n support */
        BundleUtil.get().addBundle("datasource", RadDesignerHook.class.getClassLoader(), "datasource");

        // register perspective component
        PerspectiveDesignerInterface.get(context).getDesignerComponentRegistry().registerComponent(Image.DESCRIPTOR);

        // register report datasource ui
        DesignerDataSourceRegistry.get(context).register(RestJsonDataConfigPanel.FACTORY);
    }

    @Override
    public void shutdown() {
    }
}
