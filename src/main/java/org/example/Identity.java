package org.example;

/**
 * clase donde se indetifica el login
 */
public class Identity {
	private String user;
	private String password;

	/**
	 * constructor de la clase identity
	 * @param user nombre de usuario
	 * @param password password de usuario
	 */
	public Identity(String user, String password) {
		super();
		this.user = user;
		this.password = password;
	}

	/**
	 * getter del nombre de usuario
	 * @return User name
	 */
	public String getUser() {
		return user;
	}

	/**
	 * setter del nombre de usuario
	 * @param user nombre de usaurio
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * getter del password
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * setter del password
	 * @param password password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * retorna el nombre y la contraseña del usuario
	 * @return nombre y contraseña del usuario
	 */
	@Override
	public String toString() {
		return "Identity [user=" + user + ", password=" + password + "]";
	}

}
