package interfaces;

public interface iAuthentication {
	void login();
	void register();
	boolean loadUsers();
	boolean saveUsers();
}
