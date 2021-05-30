package kodlama.io.northwindHmrs.core.concretes;

import java.rmi.RemoteException;

import org.springframework.stereotype.Component;

import kodlama.io.northwindHmrs.core.abstracts.MernisCheckService;
import kodlama.io.northwindHmrs.entities.concretes.Candidates;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;
@Component
public class MernisCheckAdapters implements MernisCheckService {

	@Override
	public boolean checkIfRealPerson(Candidates candidates) {
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
		boolean result = false;
		
		try {
			result = client.TCKimlikNoDogrula(
					
					Long.valueOf(candidates.getNationalIdentity()),
					
					candidates.getFirstName(),
					
					candidates.getLastName(),
					
				 candidates.getDateOfBirth().getYear());
		} catch (NumberFormatException e) {
	
			
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	
		return false;
		
		
	}

}
