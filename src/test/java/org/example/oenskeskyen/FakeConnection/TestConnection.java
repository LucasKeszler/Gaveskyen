package org.example.oenskeskyen.FakeConnection;

import org.example.oenskeskyen.Utility.ConnectionManager;

import java.sql.Connection;

public class TestConnection {

    public static void main(String[] args) throws Exception {
        Connection conn = new ConnectionManager().getConnection();
        System.out.println("Forbundet!");
    }
}
