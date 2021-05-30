package kodlama.io.northwindHmrs.core.concretes;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import kodlama.io.northwindHmrs.core.abstracts.EmailCheckService;


@Component
@Primary
public class FakeEmailCheckManager implements EmailCheckService {

	@Override
	public boolean emailCheck(String email) {
		return true;
	}

}
