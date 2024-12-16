package Modelo;

import Interfaces.UsuarioDAO;
import DAO.UsuarioDAOImpl;
import Entidad.Usuario;
import Interfaces.MonedaDAO;
import DAO.MonedaDAOImpl;
import Entidad.Moneda;

public class LoginModelo {
	
	public Usuario verificarUsuario(String email, String password) {
		UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
		Usuario usuario = usuarioDAO.obtener(email);
		if(usuario !=null) {							//si el usuario es distinto de null
			if(!usuario.getPassword().equals(password)) {
			usuario=null;				//si el usuario existe pero la contraseña esta mal devuelvo null
			}
		}
		return usuario;					//en caso de que no tenga problema con el null va a devolver el usuario completo con los datos correctos.
	}
	
	public void iniciarMonedas() {
		MonedaDAO monedaDAO = new MonedaDAOImpl();
		monedaDAO.crear(new Moneda("C", "Bitcoin", "BTC", 100000, 0.00, 100, "bitcoin.png"));
		monedaDAO.crear(new Moneda("C", "Ethereum", "ETH", 2500, 0.00, 100, "ethereum.png"));
		monedaDAO.crear(new Moneda("C", "Usdc", "USDC", 1, 0.00, 100, "usdc.png"));
		monedaDAO.crear(new Moneda("C", "Usdt", "USDT", 1, 0.00, 100, "usdt.png"));
		monedaDAO.crear(new Moneda("C", "Dogecoin", "DOGE", 0.003, 0.00, 100, "dogecoin.png"));
		monedaDAO.crear(new Moneda("F", "Pesos Argentinos", "ARS", 0.0009, 0.00, 0, "pesosarg.png"));
		monedaDAO.crear(new Moneda("F", "Dolares Estadounidenses", "USD", 1, 0.00, 0, "dolarusa.png"));
	}
}
