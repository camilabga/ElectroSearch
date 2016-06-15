package business;

import java.util.Date;

public class ManterData {
    private Date data;
    
    private static ManterData instance = null;

    protected ManterData() {

    }

    public static ManterData getInstance() {
        if (instance == null) {
            instance = new ManterData();
        }
        return instance;
    }

    public java.sql.Date getData() {
        data = new Date(System.currentTimeMillis());
        long hora = data.getTime();
        java.sql.Date dataSQL = new java.sql.Date(hora);
        
        return dataSQL;
    }
    
    
}
