package org.example;

import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        DBConnect dbConnect = new DBConnect();
        var a = dbConnect.getData(2);
        System.out.println(a);
    }
}