package general;

import com.google.inject.AbstractModule;

import fysioSysteem.businessLogic.behanding.BehandelCodeManager;
import fysioSysteem.businessLogic.behanding.BehandelingManager;
import fysioSysteem.businessLogic.behanding.IBehandelCodeManager;
import fysioSysteem.businessLogic.behanding.IBehandelingManager;
import fysioSysteem.businessLogic.behanding.IKlantManager;
import fysioSysteem.businessLogic.behanding.KlantManager;
import fysioSysteem.businessLogic.beheer.DiagnoseManager;
import fysioSysteem.businessLogic.beheer.IDiagnoseManager;
import fysioSysteem.businessLogic.beheer.IMedewerkerManager;
import fysioSysteem.businessLogic.beheer.IPraktijkManager;
import fysioSysteem.businessLogic.beheer.MedewerkerManager;
import fysioSysteem.businessLogic.beheer.PraktijkManager;
import fysioSysteem.businessLogic.login.ILoginManager;
import fysioSysteem.businessLogic.login.LoginManager;
import fysioSysteem.businessLogic.planning.AfspraakManager;
import fysioSysteem.businessLogic.planning.IAfspraakManager;
import fysioSysteem.businessLogic.planning.IRoosterManager;
import fysioSysteem.businessLogic.planning.RoosterManager;

public class AppInjector extends AbstractModule {
	 
    @Override
    protected void configure() {
        bind(IBehandelCodeManager.class).to(BehandelCodeManager.class);
        bind(IBehandelingManager.class).to(BehandelingManager.class);
        bind(IKlantManager.class).to(KlantManager.class);
        bind(IDiagnoseManager.class).to(DiagnoseManager.class);
        bind(IMedewerkerManager.class).to(MedewerkerManager.class);
        bind(IPraktijkManager.class).to(PraktijkManager.class);
        bind(ILoginManager.class).to(LoginManager.class);
        bind(IAfspraakManager.class).to(AfspraakManager.class);
        bind(IRoosterManager.class).to(RoosterManager.class);        
    }
 
}