package business;
public final class SaberLogin {
    private static final SaberLogin saberLogin = new SaberLogin();
    
    private SaberLogin(){
    }    
    public static SaberLogin getInstance(){
        return saberLogin;
    }
    
    private static int tipodeusuario;
    // 0 -> Comum
    // 1 -> TAL
    // 2 -> Professor
    private static String matricula;

    public static int getTipodeusuario() {
        return tipodeusuario;
    }
    public static void setTipodeusuario(int tipodeusuario) {
        SaberLogin.tipodeusuario = tipodeusuario;
    }

    public static String getMatricula() {
        return matricula;
    }
    public static void setMatricula(String matricula) {
        SaberLogin.matricula = matricula;
    }
}
