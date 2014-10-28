package AppInjector;

import com.google.inject.AbstractModule;

import fysioSysteem.businessLogic.login.ILoginManager;
import fysioSysteem.businessLogic.login.LoginManager;

public class AppInjector extends AbstractModule {
	 
    @Override
    protected void configure() {
        //bind the service to implementation class
        //bind(MessageService.class).to(EmailService.class);
         
        //bind MessageService to Facebook Message implementation
        bind(ILoginManager.class).to(LoginManager.class);
         
    }
 
}