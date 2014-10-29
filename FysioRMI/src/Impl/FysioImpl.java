package Impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;

import shared.Behandelcode;
import shared.Sessie;
import shared.Zorgaanbieder;
import Interface.FysioServiceIF;
import fysioSysteem.dataStorage.AfspraakDAO;
import fysioSysteem.dataStorage.BehandelingDAO;
import fysioSysteem.domain.Afspraak;
import fysioSysteem.domain.BehandelCode;
import fysioSysteem.domain.Praktijk;

public class FysioImpl implements FysioServiceIF {

	public String test() throws RemoteException {
		return "Alive!!!";
	}

	public ArrayList<shared.Behandeling> getBehandelingen(String bsn) {
		ArrayList<fysioSysteem.domain.Behandeling> fysioBehandelingen = BehandelingDAO.getBehandelingen(bsn);
		return fysioBehandelingToShared(fysioBehandelingen);
	}

	public ArrayList<shared.Behandeling> getBehandelingen() {
		ArrayList<fysioSysteem.domain.Behandeling> fysioBehandelingen = BehandelingDAO.getBehandelingen();
		return fysioBehandelingToShared(fysioBehandelingen);
	}

	private ArrayList<shared.Behandeling> fysioBehandelingToShared(
			ArrayList<fysioSysteem.domain.Behandeling> fysioBehandelingen) {
		ArrayList<shared.Behandeling> verzekerBehandelingen = new ArrayList<shared.Behandeling>();

		for (fysioSysteem.domain.Behandeling b : fysioBehandelingen) {
			shared.Behandeling fb = new shared.Behandeling(b.getId(), b.getKlant().getBsn());
			ArrayList<Sessie> sessies = new ArrayList<Sessie>();
			for (Afspraak a : AfspraakDAO.getAfspraken(b)) {
				Praktijk p = a.getFysiotherapeut().getPraktijk();
				Zorgaanbieder z = new Zorgaanbieder(p.getNaam(), p.getAdres(), p.getPostcode(), p.getPlaats(),
						p.getTelNr(), p.getEmail());

				sessies.add(new Sessie(a.getId(), a.getDatumTijd(), z));
			}
			fb.setSessies(sessies);
			BehandelCode bc = b.getBehandelCode();
			fb.setBehandelcodes(new ArrayList<Behandelcode>(Arrays.asList(new Behandelcode(bc.getCode(), bc
					.getBehandelingNaam(), bc.getAantalSessies(), bc.getSessieDuur(), bc.getTariefBehandeling()))));

			verzekerBehandelingen.add(fb);

		}
		return verzekerBehandelingen;
	}
}
