package org.example;

import io.github.cdimascio.dotenv.Dotenv;

public class Database {

    private com.dieselpoint.norm.Database connection;

    public Database() {
        Dotenv dotenv = Dotenv.load();
        connection = new com.dieselpoint.norm.Database();
        connection.setJdbcUrl("jdbc:mysql://" + dotenv.get("DB_HOST") + ":" + dotenv.get("DB_PORT") + "/" + dotenv.get("DB_NAME") + "?useSSL=false");
        connection.setUser(dotenv.get("DB_USER"));
        connection.setPassword(dotenv.get("DB_PASSWORD"));
    }
}