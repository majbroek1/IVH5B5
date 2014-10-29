package general;

import com.google.inject.AbstractModule;

import fysioSysteem.businessLogic.behandeling.BehandelCodeManager;
import fysioSysteem.businessLogic.behandeling.BehandelingManager;
import fysioSysteem.businessLogic.behandeling.IBehandelCodeManager;
import fysioSysteem.businessLogic.behandeling.IBehandelingManager;
import fysioSysteem.businessLogic.behandeling.IKlantManager;
import fysioSysteem.businessLogic.behandeling.KlantManager;
import fysioSysteem.businessLogic.login.ILoginManager;
import fysioSysteem.businessLogic.login.LoginManager;

public class AppInjector extends AbstractModule {
	 
    @Override
    protected void configure() {
        //bind the service to implementation class
        //bind(MessageService.class).to(EmailService.class);
         
        //bind MessageService to Facebook Message implementation
        bind(ILoginManager.class).to(LoginManager.class);
        bind(IBehandelCodeManager.class).to(BehandelCodeManager.class);
        bind(IBehandelingManager.class).to(BehandelingManager.class);
        bind(IKlantManager.class).to(KlantManager.class);
    }
 
}