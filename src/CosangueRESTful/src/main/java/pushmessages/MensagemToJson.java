package pushmessages;

import java.util.HashMap;
import java.util.Map;

public class MensagemToJson {

	public static Map<String, String> mensagemFormatada(String msg) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("msg", msg);
		return params;
	}

}
