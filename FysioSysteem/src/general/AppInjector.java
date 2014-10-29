package general;

import com.google.inject.AbstractModule;

import fysioSysteem.businessLogic.behanding.BehandelCodeManager;
import fysioSysteem.businessLogic.behanding.BehandelingManager;
import fysioSysteem.businessLogic.behanding.IBehandelCodeManager;
import fysioSysteem.businessLogic.behanding.IBehandelingManager;
import fysioSysteem.businessLogic.behanding.IKlantManager;
import fysioSysteem.businessLogic.behanding.KlantManager;
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